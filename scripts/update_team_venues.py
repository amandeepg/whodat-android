#!/usr/bin/env python3
from __future__ import annotations

import codecs
import json
import re
import time
from dataclasses import dataclass
from pathlib import Path
from urllib.parse import urlencode, urlparse
from urllib.request import Request, urlopen
from urllib.error import HTTPError

ROOT = Path(__file__).resolve().parents[1]

USER_AGENT = "PlayerNumber/1.0 (contact: team@example.com)"
DEFAULT_REQUEST_DELAY_SEC = 0.2
REQUEST_DELAY_SEC_BY_HOST = {
    "www.thesportsdb.com": 2.2,
    "www.wikidata.org": 0.2,
}
HTTP_RETRY_MAX = 3
HTTP_RETRY_BACKOFF_SEC = 5.0
TSDB_API_BASE = "https://www.thesportsdb.com/api/v1/json/123"

LEAGUES = {
    "NBA": {
        "file": ROOT / "app/src/main/java/ca/amandeep/playernumber/data/NbaTeams.kt",
    },
    "NHL": {
        "file": ROOT / "app/src/main/java/ca/amandeep/playernumber/data/NhlTeams.kt",
    },
    "NFL": {
        "file": ROOT / "app/src/main/java/ca/amandeep/playernumber/data/NflTeams.kt",
    },
    "MLB": {
        "file": ROOT / "app/src/main/java/ca/amandeep/playernumber/data/MlbTeams.kt",
    },
    "MLS": {
        "file": ROOT / "app/src/main/java/ca/amandeep/playernumber/data/MlsTeams.kt",
    },
}

VENUE_COORD_OVERRIDES: dict[str, tuple[float, float]] = {
    # Add overrides as needed: "Venue Name|City|State|Country": (lat, long)
}

VENUE_SEARCH_OVERRIDES: dict[str, str] = {
    "EverBank Stadium": "EverBank Field",
    "George M Steinbrenner Field": "George M. Steinbrenner Field",
    "Nissan Stadium Nashville": "Nissan Stadium",
    "Toyota Stadium Dallas": "Toyota Stadium",
}

TEAM_SEARCH_OVERRIDES: dict[str, list[str]] = {
    "Atlanta United FC": ["Atlanta United"],
    "Chicago Fire FC": ["Chicago Fire"],
    "D.C. United": ["DC United", "D.C United"],
    "Houston Dynamo FC": ["Houston Dynamo"],
    "Inter Miami CF": ["Inter Miami", "Inter Miami CF"],
    "Minnesota United FC": ["Minnesota United"],
}

TEAM_VENUE_OVERRIDES: dict[str, dict[str, str | None]] = {
    "Buffalo Sabres": {
        "venue": "KeyBank Center",
        "city": "Buffalo",
        "state": "NY",
        "country": "USA",
    },
}


@dataclass(frozen=True)
class TeamEntry:
    name: str
    abbreviation: str


@dataclass(frozen=True)
class VenueInfo:
    name: str
    city: str | None
    state: str | None
    country: str | None
    lat: float
    long: float


class HttpClient:
    def __init__(self) -> None:
        self._last_request_at: dict[str, float] = {}

    def fetch_json(self, url: str) -> dict:
        attempt = 0
        while True:
            self._rate_limit(url)
            req = Request(url, headers={"User-Agent": USER_AGENT})
            try:
                with urlopen(req) as resp:
                    return json.load(resp)
            except HTTPError as error:
                if error.code != 429 or attempt >= HTTP_RETRY_MAX:
                    raise
                backoff = HTTP_RETRY_BACKOFF_SEC * (attempt + 1)
                time.sleep(backoff)
                attempt += 1

    def _rate_limit(self, url: str) -> None:
        host = urlparse(url).netloc
        delay = REQUEST_DELAY_SEC_BY_HOST.get(host, DEFAULT_REQUEST_DELAY_SEC)
        now = time.time()
        elapsed = now - self._last_request_at.get(host, 0.0)
        if elapsed < delay:
            time.sleep(delay - elapsed)
        self._last_request_at[host] = time.time()


def normalize(text: str) -> str:
    return re.sub(r"[^a-z0-9]+", "", text.lower())


def decode_kotlin_string(value: str) -> str:
    try:
        return codecs.decode(value, "unicode_escape")
    except Exception:
        return value


def escape_kotlin_string(value: str) -> str:
    escaped = []
    for char in value:
        if char == "\\":
            escaped.append("\\\\")
        elif char == "\"":
            escaped.append("\\\"")
        elif ord(char) < 32 or ord(char) > 126:
            escaped.append(f"\\u{ord(char):04X}")
        else:
            escaped.append(char)
    return "".join(escaped)


def build_team_search_variants(team_name: str) -> list[str]:
    variants: list[str] = []
    def add(value: str) -> None:
        value = value.strip()
        if value and value not in variants:
            variants.append(value)

    add(team_name)
    for alt in TEAM_SEARCH_OVERRIDES.get(team_name, []):
        add(alt)
    if team_name.endswith(" FC"):
        add(team_name[:-3].strip())
    if team_name.endswith(" CF"):
        add(team_name[:-3].strip())
    if "D.C." in team_name:
        add(team_name.replace("D.C.", "DC"))
    add(re.sub(r"[.'’]", "", team_name))
    return variants


def select_tsdb_team(teams: list[dict], team_name: str, abbreviation: str) -> dict | None:
    if not teams:
        return None
    target = normalize(team_name)
    for team in teams:
        if normalize(team.get("strTeam", "")) == target:
            return team
    for team in teams:
        if normalize(team.get("strTeamShort", "")) == target:
            return team
    if abbreviation:
        for team in teams:
            if normalize(team.get("strTeamShort", "")) == normalize(abbreviation):
                return team
    for team in teams:
        alt = team.get("strAlternate") or ""
        for part in re.split(r"[,/]|\\s+\\|\\s+", alt):
            if normalize(part) == target:
                return team
    return teams[0]


def fetch_tsdb_team(client: HttpClient, team_name: str, abbreviation: str) -> dict | None:
    for variant in build_team_search_variants(team_name):
        params = urlencode({"t": variant})
        url = f"{TSDB_API_BASE}/searchteams.php?{params}"
        data = client.fetch_json(url)
        teams = data.get("teams") or []
        selected = select_tsdb_team(teams, team_name, abbreviation)
        if selected:
            return selected
    return None


def parse_stadium_location(location: str | None) -> tuple[str | None, str | None, str | None]:
    if not location:
        return None, None, None
    parts = [part.strip() for part in location.split(",") if part.strip()]
    if not parts:
        return None, None, None
    city = parts[0]
    state = parts[1] if len(parts) > 1 else None
    country = parts[2] if len(parts) > 2 else None
    return city or None, state or None, country or None


def sanitize_venue_name(name: str) -> str:
    match = re.match(r"^(.*)\s+\([^)]*\)$", name)
    if match:
        return match.group(1).strip()
    return name


def build_query(venue_name: str, city: str | None, state: str | None, country: str | None) -> str:
    parts: list[str] = [venue_name]
    if city:
        parts.append(city)
    if state and (not city or state not in city):
        parts.append(state)
    if country and (not city or country not in city):
        parts.append(country)
    return " ".join(parts)


def search_wikidata(client: HttpClient, query: str) -> list[dict]:
    params = urlencode({
        "action": "wbsearchentities",
        "search": query,
        "language": "en",
        "format": "json",
        "limit": 5,
    })
    url = f"https://www.wikidata.org/w/api.php?{params}"
    data = client.fetch_json(url)
    return data.get("search", [])


def fetch_wikidata_coords(client: HttpClient, entity_id: str) -> tuple[float, float] | None:
    params = urlencode({
        "action": "wbgetentities",
        "ids": entity_id,
        "props": "claims",
        "format": "json",
    })
    url = f"https://www.wikidata.org/w/api.php?{params}"
    data = client.fetch_json(url)
    entity = data.get("entities", {}).get(entity_id, {})
    claims = entity.get("claims", {})
    coords = claims.get("P625")
    if not coords:
        return None
    value = coords[0].get("mainsnak", {}).get("datavalue", {}).get("value")
    if not value:
        return None
    return value.get("latitude"), value.get("longitude")


def score_wikidata_result(result: dict, venue_name: str, city: str | None) -> int:
    label = result.get("label", "")
    description = result.get("description", "") or ""
    score = 0
    if normalize(venue_name) == normalize(label):
        score += 4
    elif normalize(venue_name) in normalize(label):
        score += 2
    desc_lower = description.lower()
    if any(word in desc_lower for word in ["stadium", "arena", "ballpark", "field", "park", "venue", "rink"]):
        score += 1
    if city:
        city_token = city.split(",")[0].strip().lower()
        label_lower = label.lower()
        if city_token and (city_token in desc_lower or city_token in label_lower):
            score += 5
        elif city.lower() in desc_lower:
            score += 3
    return score


def resolve_coords(
    client: HttpClient,
    venue_name: str,
    city: str | None,
    state: str | None,
    country: str | None,
) -> tuple[float, float] | None:
    queries = [venue_name]
    query_with_city = build_query(venue_name, city, None, None)
    if query_with_city != venue_name:
        queries.append(query_with_city)
    query_with_state = build_query(venue_name, city, state, None)
    if query_with_state not in queries:
        queries.append(query_with_state)
    query_with_country = build_query(venue_name, city, state, country)
    if query_with_country not in queries:
        queries.append(query_with_country)

    for query in queries:
        results = search_wikidata(client, query)
        if not results:
            continue
        ranked = sorted(results, key=lambda r: score_wikidata_result(r, venue_name, city), reverse=True)
        for result in ranked:
            coords = fetch_wikidata_coords(client, result["id"])
            if coords:
                return coords
    return None


def parse_team_entries(path: Path) -> list[TeamEntry]:
    entries: list[TeamEntry] = []
    in_team = False
    current_name: str | None = None
    current_abbr: str | None = None
    for line in path.read_text().splitlines():
        if "Team(" in line:
            in_team = True
            current_name = None
            current_abbr = None
            continue
        if not in_team:
            continue
        name_match = re.search(r"\bname\s*=\s*\"([^\"]+)\"", line)
        if name_match and current_name is None:
            current_name = decode_kotlin_string(name_match.group(1))
        abbr_match = re.search(r"\babbreviation\s*=\s*\"([^\"]+)\"", line)
        if abbr_match:
            current_abbr = abbr_match.group(1)
        if "roster =" in line:
            if current_name and current_abbr:
                entries.append(TeamEntry(name=current_name, abbreviation=current_abbr))
            in_team = False
    return entries


def build_venue_lines(indent: str, info: VenueInfo) -> list[str]:
    name = escape_kotlin_string(info.name)
    lat = f"{info.lat:.6f}"
    long = f"{info.long:.6f}"
    inner = indent + "    "
    inner2 = indent + "        "
    inner3 = indent + "            "
    inner4 = indent + "                "
    return [
        f"{indent}venue =",
        f"{inner}TeamVenue(",
        f"{inner2}name = \"{name}\",",
        f"{inner2}location =",
        f"{inner3}VenueLocation(",
        f"{inner4}lat = {lat},",
        f"{inner4}long = {long},",
        f"{inner3}),",
        f"{inner}),",
    ]


def update_team_file(path: Path, venue_by_abbr: dict[str, VenueInfo]) -> list[str]:
    lines = path.read_text().splitlines()
    output: list[str] = []
    in_team = False
    skipping_venue = False
    current_abbr: str | None = None
    missing: list[str] = []

    for line in lines:
        if "Team(" in line:
            in_team = True
            skipping_venue = False
            current_abbr = None
            output.append(line)
            continue

        if in_team:
            abbr_match = re.search(r"\babbreviation\s*=\s*\"([^\"]+)\"", line)
            if abbr_match:
                current_abbr = abbr_match.group(1)

            if re.match(r"\s*venue\s*=", line):
                skipping_venue = True
                continue

            if skipping_venue:
                if re.match(r"\s*roster\s*=", line):
                    if current_abbr and current_abbr in venue_by_abbr:
                        indent = re.match(r"(\s*)roster", line).group(1)
                        output.extend(build_venue_lines(indent, venue_by_abbr[current_abbr]))
                    else:
                        missing.append(current_abbr or "<unknown>")
                    output.append(line)
                    in_team = False
                    skipping_venue = False
                continue

            if re.match(r"\s*roster\s*=", line):
                if current_abbr and current_abbr in venue_by_abbr:
                    indent = re.match(r"(\s*)roster", line).group(1)
                    output.extend(build_venue_lines(indent, venue_by_abbr[current_abbr]))
                else:
                    missing.append(current_abbr or "<unknown>")
                output.append(line)
                in_team = False
                continue

        output.append(line)

    path.write_text("\n".join(output) + "\n")
    return missing


def main() -> None:
    client = HttpClient()
    overall_missing: dict[str, list[str]] = {}
    venue_cache: dict[str, tuple[float, float]] = {}

    for league_name, info in LEAGUES.items():
        print(f"\n== {league_name} ==")
        team_entries = parse_team_entries(info["file"])

        venue_by_abbr: dict[str, VenueInfo] = {}
        unresolved: list[str] = []

        for entry in team_entries:
            team = fetch_tsdb_team(client, entry.name, entry.abbreviation)
            if not team:
                unresolved.append(f"{entry.name} ({entry.abbreviation})")
                continue

            venue_name = (team.get("strStadium") or "").strip()
            override = TEAM_VENUE_OVERRIDES.get(entry.name)
            if not venue_name:
                if override and override.get("venue"):
                    venue_name = override["venue"] or ""
                else:
                    unresolved.append(f"{entry.name} ({entry.abbreviation}) - venue missing")
                    continue

            city, state, country = parse_stadium_location(team.get("strStadiumLocation"))
            if not country:
                country = team.get("strCountry")
            if override:
                city = override.get("city") or city
                state = override.get("state") or state
                country = override.get("country") or country
            venue_key = "|".join([venue_name, city or "", state or "", country or ""])
            search_name = VENUE_SEARCH_OVERRIDES.get(venue_name) or venue_name
            search_name = sanitize_venue_name(search_name)

            coords = VENUE_COORD_OVERRIDES.get(venue_key)
            if coords is None:
                coords = venue_cache.get(venue_key)
            if coords is None:
                coords = resolve_coords(client, search_name, city, state, country)
                if coords:
                    venue_cache[venue_key] = coords
            if not coords:
                unresolved.append(f"{entry.name} ({entry.abbreviation}) - venue {venue_name}")
                continue

            venue_by_abbr[entry.abbreviation] = VenueInfo(
                name=venue_name,
                city=city,
                state=state,
                country=country,
                lat=coords[0],
                long=coords[1],
            )

        missing = update_team_file(info["file"], venue_by_abbr)
        if unresolved:
            overall_missing[league_name] = unresolved
        if missing:
            overall_missing.setdefault(league_name, []).extend(
                [f"Missing venue data for abbreviation {abbr}" for abbr in missing]
            )

        print(f"Updated {len(venue_by_abbr)} teams in {info['file'].name}.")
        if unresolved:
            print("Unresolved:")
            for item in unresolved:
                print(f" - {item}")

    if overall_missing:
        print("\nMissing data summary:")
        for league, items in overall_missing.items():
            print(f"{league}:")
            for item in items:
                print(f" - {item}")
        raise SystemExit(1)

    print("\nAll teams updated successfully.")


if __name__ == "__main__":
    main()
