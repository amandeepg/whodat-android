# Updating Team Venues

Use this guide whenever a team relocates, changes stadium/arena, or new teams are added. The goal is to keep `Team.venue.name` and `Team.venue.location` accurate in the static team lists.

## What updates the data

We keep venues static in the Kotlin team lists and refresh them with a script:

- Script: `scripts/update_team_venues.py`
- Venue names: TheSportsDB free API (`searchteams.php` with test key `123`)
- Coordinates: Wikidata API (search + coordinate lookup)

## Before you run the script

1. Ensure the team list is correct:
   - Add or update teams in the relevant league file:
     - `app/src/main/java/ca/amandeep/playernumber/data/NbaTeams.kt`
     - `app/src/main/java/ca/amandeep/playernumber/data/NhlTeams.kt`
     - `app/src/main/java/ca/amandeep/playernumber/data/NflTeams.kt`
     - `app/src/main/java/ca/amandeep/playernumber/data/MlbTeams.kt`
     - `app/src/main/java/ca/amandeep/playernumber/data/MlsTeams.kt`
2. Confirm the team abbreviation is correct; the script uses it to update Kotlin blocks after fetching venue data by team name.
3. If you expect a venue rename or special case (temporary stadium, shared stadium, etc.), be ready to add overrides (see below).

## Run the update

From the repo root (the script throttles requests for the free tier):

```
python scripts/update_team_venues.py
```

The script rewrites the Kotlin team files and inserts a `venue = TeamVenue(...)` block for every team.

## Fixing failures or mismatches

If the script exits with missing data, use these tools:

### 1) Venue search override

If TheSportsDB has a venue name that Wikidata cannot resolve (or resolves to the wrong place), add an override:

- File: `scripts/update_team_venues.py`
- Map: `VENUE_SEARCH_OVERRIDES`
- Example:
  - `"EverBank Stadium" -> "EverBank Field"`

This keeps the stored venue name from TheSportsDB, but uses a different search phrase when looking up coordinates.

### 2) Coordinate override

If Wikidata has no coordinates or a bad result, hardcode coordinates:

- File: `scripts/update_team_venues.py`
- Map: `VENUE_COORD_OVERRIDES`
- Key format: `"Venue Name|City|State|Country"`
- Value format: `(lat, long)`

You can find the key string in the script output, or by checking TheSportsDB venue data for that team.

### 3) Team search override

TheSportsDB search expects certain canonical team names. If the script can’t find a team or returns the wrong team, add a search override:

- File: `scripts/update_team_venues.py`
- Map: `TEAM_SEARCH_OVERRIDES`
- Example:
  - `"Atlanta United FC" -> ["Atlanta United"]`
  - `"D.C. United" -> ["DC United"]`

### 4) Team venue override (missing stadiums)

If TheSportsDB returns a team but omits its stadium, provide a manual venue override:

- File: `scripts/update_team_venues.py`
- Map: `TEAM_VENUE_OVERRIDES`
- Example:
  - `"Buffalo Sabres" -> {"venue": "KeyBank Center", "city": "Buffalo", "state": "NY", "country": "USA"}`

## Validate

1. Re-run the script until it prints `All teams updated successfully.`
2. Build the project:

```
./gradlew assembleDebug --quiet --console=plain
```

## Notes

- The script is idempotent: it replaces any existing `venue =` block.
- TheSportsDB free tier can return partial results for league listing endpoints, so the script queries each team by name.
- If a team relocates or renames its venue, update the team list and re-run the script.
- If you add a new team, add it to the appropriate league list first, then run the script to populate venue data.
