package ca.amandeep.playernumber.data

import androidx.compose.ui.graphics.Color

private val nbaTeamAtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Atlanta Hawks",
        nameWidthPercent = 56.1f,
        abbreviation = "ATL",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFC8102E),
                nameAccent = Color(0xFFFDB927),
            ),
        venue =
            TeamVenue(
                name = "State Farm Arena",
                location =
                    VenueLocation(
                        lat = 33.757222,
                        long = -84.396389,
                    ),
            ),
        roster =
            listOf(
                Player("Jalen", "Johnson", NbaPosition.FORWARD, "1"),
                Player("Keaton", "Wallace", NbaPosition.GUARD, "2"),
                Player("Luke", "Kennard", NbaPosition.GUARD, "3"),
                Player("Dyson", "Daniels", NbaPosition.GUARD, "5"),
                Player("Nickeil", "Alexander-Walker", NbaPosition.GUARD, "7"),
                Player("Kristaps", "Porzingis", NbaPosition.CENTER, "8"),
                Player("Zaccharie", "Risacher", NbaPosition.FORWARD, "10"),
                Player("Trae", "Young", NbaPosition.GUARD, "11"),
                Player("N'Faly", "Dante", NbaPosition.CENTER, "12"),
                Player("Asa", "Newell", NbaPosition.FORWARD, "14"),
                Player("Onyeka", "Okongwu", NbaPosition.FORWARD, "17"),
                Player("Mouhamed", "Gueye", NbaPosition.FORWARD, "18"),
                Player("Nikola", "Durisic", NbaPosition.FORWARD, "22"),
                Player("Vit", "Krejci", NbaPosition.GUARD, "27"),
                Player("Eli John", "Ndiaye", NbaPosition.CENTER, "30"),
                Player("Caleb", "Houstan", NbaPosition.GUARD, "33"),
            ),
    )
}

private val nbaTeamBos by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Boston Celtics",
        nameWidthPercent = 56.1f,
        abbreviation = "BOS",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF008348),
                nameAccent = Color(0xFFFFFFFF),
            ),
        venue =
            TeamVenue(
                name = "TD Garden",
                location =
                    VenueLocation(
                        lat = 42.366303,
                        long = -71.062228,
                    ),
            ),
        roster =
            listOf(
                Player("Jayson", "Tatum", NbaPosition.FORWARD, "0"),
                Player("Anfernee", "Simons", NbaPosition.GUARD, "4"),
                Player("Jaylen", "Brown", NbaPosition.GUARD, "7"),
                Player("Josh", "Minott", NbaPosition.FORWARD, "8"),
                Player("Derrick", "White", NbaPosition.GUARD, "9"),
                Player("Payton", "Pritchard", NbaPosition.GUARD, "11"),
                Player("Ron", "Harper", NbaPosition.GUARD, "13", "Jr."),
                Player("Xavier", "Tillman", NbaPosition.FORWARD, "26"),
                Player("Jordan", "Walsh", NbaPosition.GUARD, "27"),
                Player("Hugo", "Gonzalez", NbaPosition.GUARD, "28"),
                Player("Sam", "Hauser", NbaPosition.FORWARD, "30"),
                Player("Max", "Shulga", NbaPosition.GUARD, "44"),
                Player("Luka", "Garza", NbaPosition.CENTER, "52"),
                Player("Baylor", "Scheierman", NbaPosition.GUARD, "55"),
                Player("Amari", "Williams", NbaPosition.FORWARD, "77"),
                Player("Neemias", "Queta", NbaPosition.CENTER, "88"),
                Player("Chris", "Boucher", NbaPosition.FORWARD, "99"),
            ),
    )
}

private val nbaTeamBkn by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Brooklyn Nets",
        nameWidthPercent = 54.4f,
        abbreviation = "BKN",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFFFFFFF),
            ),
        venue =
            TeamVenue(
                name = "Barclays Center",
                location =
                    VenueLocation(
                        lat = 40.682650,
                        long = -73.974689,
                    ),
            ),
        roster =
            listOf(
                Player("Ziaire", "Williams", NbaPosition.FORWARD, "1"),
                Player("Danny", "Wolf", NbaPosition.FORWARD, "2"),
                Player("Drake", "Powell", NbaPosition.GUARD, "4"),
                Player("Haywood", "Highsmith", NbaPosition.FORWARD, "7"),
                Player("Egor", "Demin", NbaPosition.GUARD, "8"),
                Player("E.J.", "Liddell", NbaPosition.FORWARD, "9"),
                Player("Tyson", "Etienne", NbaPosition.GUARD, "10"),
                Player("Tyrese", "Martin", NbaPosition.GUARD, "13"),
                Player("Terance", "Mann", NbaPosition.GUARD, "14"),
                Player("Michael", "Porter", NbaPosition.FORWARD, "17", "Jr."),
                Player("Day'Ron", "Sharpe", NbaPosition.CENTER, "20"),
                Player("Noah", "Clowney", NbaPosition.FORWARD, "21"),
                Player("Jalen", "Wilson", NbaPosition.FORWARD, "22"),
                Player("Cam", "Thomas", NbaPosition.GUARD, "24"),
                Player("Nic", "Claxton", NbaPosition.CENTER, "33"),
                Player("Ben", "Saraf", NbaPosition.GUARD, "77"),
                Player("Nolan", "Traore", NbaPosition.GUARD, "88"),
            ),
    )
}

private val nbaTeamCha by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Charlotte Hornets",
        nameWidthPercent = 70.3f,
        abbreviation = "CHA",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF008CA8),
                nameAccent = Color(0xFF1D1060),
            ),
        venue =
            TeamVenue(
                name = "Spectrum Center",
                location =
                    VenueLocation(
                        lat = 35.225000,
                        long = -80.839167,
                    ),
            ),
        roster =
            listOf(
                Player("Miles", "Bridges", NbaPosition.FORWARD, "0"),
                Player("LaMelo", "Ball", NbaPosition.GUARD, "1"),
                Player("Grant", "Williams", NbaPosition.FORWARD, "2"),
                Player("Sion", "James", NbaPosition.GUARD, "4"),
                Player("PJ", "Hall", NbaPosition.CENTER, "5"),
                Player("Kon", "Knueppel", NbaPosition.GUARD, "7"),
                Player("Collin", "Sexton", NbaPosition.GUARD, "8"),
                Player("Josh", "Green", NbaPosition.GUARD, "10"),
                Player("Ryan", "Kalkbrenner", NbaPosition.CENTER, "11"),
                Player("Antonio", "Reeves", NbaPosition.GUARD, "12"),
                Player("Moussa", "Diabate", NbaPosition.FORWARD, "14"),
                Player("Pat", "Connaughton", NbaPosition.GUARD, "21"),
                Player("Mason", "Plumlee", NbaPosition.CENTER, "22"),
                Player("Tre", "Mann", NbaPosition.GUARD, "23"),
                Player("Brandon", "Miller", NbaPosition.FORWARD, "24"),
                Player("KJ", "Simpson", NbaPosition.GUARD, "25"),
                Player("Tidjane", "Salaun", NbaPosition.FORWARD, "31"),
                Player("Liam", "McNeeley", NbaPosition.GUARD, "33"),
            ),
    )
}

private val nbaTeamChi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Chicago Bulls",
        nameWidthPercent = 52.0f,
        abbreviation = "CHI",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFCE1141),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "United Center",
                location =
                    VenueLocation(
                        lat = 41.880556,
                        long = -87.674167,
                    ),
            ),
        roster =
            listOf(
                Player("Trentyn", "Flowers", NbaPosition.FORWARD, "0"),
                Player("Coby", "White", NbaPosition.GUARD, "0"),
                Player("Emanuel", "Miller", NbaPosition.FORWARD, "2"),
                Player("Josh", "Giddey", NbaPosition.GUARD, "3"),
                Player("Jevon", "Carter", NbaPosition.GUARD, "5"),
                Player("Dalen", "Terry", NbaPosition.FORWARD, "7"),
                Player("Nikola", "Vucevic", NbaPosition.CENTER, "9"),
                Player("Ayo", "Dosunmu", NbaPosition.GUARD, "11"),
                Player("Zach", "Collins", NbaPosition.FORWARD, "12"),
                Player("Kevin", "Huerter", NbaPosition.GUARD, "13"),
                Player("Matas", "Buzelis", NbaPosition.FORWARD, "14"),
                Player("Julian", "Phillips", NbaPosition.FORWARD, "15"),
                Player("Noa", "Essengue", NbaPosition.FORWARD, "24"),
                Player("Jalen", "Smith", NbaPosition.FORWARD, "25"),
                Player("Tre", "Jones", NbaPosition.GUARD, "30"),
                Player("Isaac", "Okoro", NbaPosition.FORWARD, "35"),
                Player("Patrick", "Williams", NbaPosition.FORWARD, "44"),
                Player("Lachlan", "Olbrich", NbaPosition.CENTER, "47"),
            ),
    )
}

private val nbaTeamCle by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Cleveland Cavaliers",
        nameWidthPercent = 75.7f,
        abbreviation = "CLE",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF860038),
                nameAccent = Color(0xFFBC945C),
            ),
        venue =
            TeamVenue(
                name = "Rocket Arena",
                location =
                    VenueLocation(
                        lat = 41.496389,
                        long = -81.688056,
                    ),
            ),
        roster =
            listOf(
                Player("Max", "Strus", NbaPosition.GUARD, "1"),
                Player("Lonzo", "Ball", NbaPosition.GUARD, "2"),
                Player("Thomas", "Bryant", NbaPosition.CENTER, "3"),
                Player("Evan", "Mobley", NbaPosition.CENTER, "4"),
                Player("Sam", "Merrill", NbaPosition.GUARD, "5"),
                Player("Chris", "Livingston", NbaPosition.FORWARD, "8"),
                Player("Craig", "Porter", NbaPosition.GUARD, "9", "Jr."),
                Player("Darius", "Garland", NbaPosition.GUARD, "10"),
                Player("De'Andre", "Hunter", NbaPosition.FORWARD, "12"),
                Player("Jaylon", "Tyson", NbaPosition.GUARD, "20"),
                Player("Larry", "Nance", NbaPosition.FORWARD, "22", "Jr."),
                Player("Tyrese", "Proctor", NbaPosition.GUARD, "24"),
                Player("Jarrett", "Allen", NbaPosition.CENTER, "31"),
                Player("Dean", "Wade", NbaPosition.FORWARD, "32"),
                Player("Luke", "Travers", NbaPosition.FORWARD, "33"),
                Player("Nae'Qwan", "Tomlin", NbaPosition.FORWARD, "35"),
                Player("Donovan", "Mitchell", NbaPosition.GUARD, "45"),
            ),
    )
}

private val nbaTeamDal by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Dallas Mavericks",
        nameWidthPercent = 64.9f,
        abbreviation = "DAL",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF0064B1),
                nameAccent = Color(0xFFBBC4CA),
            ),
        venue =
            TeamVenue(
                name = "American Airlines Center",
                location =
                    VenueLocation(
                        lat = 32.790556,
                        long = -96.810278,
                    ),
            ),
        roster =
            listOf(
                Player("Max", "Christie", NbaPosition.GUARD, "0"),
                Player("Dante", "Exum", NbaPosition.GUARD, "0"),
                Player("Jaden", "Hardy", NbaPosition.GUARD, "1"),
                Player("Dereck", "Lively", NbaPosition.CENTER, "2", "II"),
                Player("Anthony", "Davis", NbaPosition.FORWARD, "3"),
                Player("D'Angelo", "Russell", NbaPosition.GUARD, "5"),
                Player("Dwight", "Powell", NbaPosition.FORWARD, "7"),
                Player("Ryan", "Nembhard", NbaPosition.GUARD, "9"),
                Player("Brandon", "Williams", NbaPosition.GUARD, "10"),
                Player("Kyrie", "Irving", NbaPosition.GUARD, "11"),
                Player("Naji", "Marshall", NbaPosition.FORWARD, "13"),
                Player("Miles", "Kelly", NbaPosition.GUARD, "14"),
                Player("Caleb", "Martin", NbaPosition.FORWARD, "16"),
                Player("Daniel", "Gafford", NbaPosition.FORWARD, "21"),
                Player("P.J.", "Washington", NbaPosition.FORWARD, "25"),
                Player("Moussa", "Cisse", NbaPosition.CENTER, "30"),
                Player("Klay", "Thompson", NbaPosition.GUARD, "31"),
                Player("Cooper", "Flagg", NbaPosition.FORWARD, "32"),
            ),
    )
}

private val nbaTeamDen by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Denver Nuggets",
        nameWidthPercent = 62.5f,
        abbreviation = "DEN",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF0E2240),
                nameAccent = Color(0xFFFEC524),
            ),
        venue =
            TeamVenue(
                name = "Ball Arena",
                location =
                    VenueLocation(
                        lat = 39.748611,
                        long = -105.007500,
                    ),
            ),
        roster =
            listOf(
                Player("Christian", "Braun", NbaPosition.GUARD, "0"),
                Player("Curtis", "Jones", NbaPosition.GUARD, "1"),
                Player("Julian", "Strawther", NbaPosition.GUARD, "3"),
                Player("Hunter", "Tyson", NbaPosition.FORWARD, "5"),
                Player("Tamar", "Bates", NbaPosition.GUARD, "7"),
                Player("Peyton", "Watson", NbaPosition.GUARD, "8"),
                Player("Tim", "Hardaway", NbaPosition.GUARD, "10", "Jr."),
                Player("Bruce", "Brown", NbaPosition.GUARD, "11"),
                Player("DaRon", "Holmes", NbaPosition.FORWARD, "14", "II"),
                Player("Nikola", "Jokic", NbaPosition.CENTER, "15"),
                Player("Jonas", "Valanciunas", NbaPosition.CENTER, "17"),
                Player("Spencer", "Jones", NbaPosition.FORWARD, "21"),
                Player("Zeke", "Nnaji", NbaPosition.FORWARD, "22"),
                Player("Cameron", "Johnson", NbaPosition.FORWARD, "23"),
                Player("Jalen", "Pickett", NbaPosition.GUARD, "24"),
                Player("Jamal", "Murray", NbaPosition.GUARD, "27"),
                Player("Aaron", "Gordon", NbaPosition.FORWARD, "32"),
            ),
    )
}

private val nbaTeamDet by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Detroit Pistons",
        nameWidthPercent = 57.8f,
        abbreviation = "DET",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF1D428A),
                nameAccent = Color(0xFFC8102E),
            ),
        venue =
            TeamVenue(
                name = "Little Caesars Arena",
                location =
                    VenueLocation(
                        lat = 42.341200,
                        long = -83.054900,
                    ),
            ),
        roster =
            listOf(
                Player("Jalen", "Duren", NbaPosition.CENTER, "0"),
                Player("Cade", "Cunningham", NbaPosition.GUARD, "2"),
                Player("Isaac", "Jones", NbaPosition.CENTER, "3"),
                Player("Ronald", "Holland", NbaPosition.FORWARD, "5", "II"),
                Player("Paul", "Reed", NbaPosition.FORWARD, "7"),
                Player("Caris", "LeVert", NbaPosition.GUARD, "8"),
                Player("Ausar", "Thompson", NbaPosition.GUARD, "9"),
                Player("Tobias", "Harris", NbaPosition.FORWARD, "12"),
                Player("Wendell", "Moore", NbaPosition.FORWARD, "14", "Jr."),
                Player("Chaz", "Lanier", NbaPosition.GUARD, "20"),
                Player("Jaden", "Ivey", NbaPosition.GUARD, "23"),
                Player("Daniss", "Jenkins", NbaPosition.GUARD, "24"),
                Player("Marcus", "Sasser", NbaPosition.GUARD, "25"),
                Player("Isaiah", "Stewart", NbaPosition.FORWARD, "28"),
                Player("Javonte", "Green", NbaPosition.GUARD, "31"),
                Player("Bobi", "Klintman", NbaPosition.FORWARD, "34"),
                Player("Tolu", "Smith", NbaPosition.FORWARD, "35"),
                Player("Duncan", "Robinson", NbaPosition.FORWARD, "55"),
            ),
    )
}

private val nbaTeamGs by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Golden State Warriors",
        nameWidthPercent = 86.8f,
        abbreviation = "GS",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFFDB927),
                nameAccent = Color(0xFF1D428A),
            ),
        venue =
            TeamVenue(
                name = "Chase Center",
                location =
                    VenueLocation(
                        lat = 37.767833,
                        long = -122.387389,
                    ),
            ),
        roster =
            listOf(
                Player("Gary", "Payton", NbaPosition.GUARD, "0", "II"),
                Player("Jonathan", "Kuminga", NbaPosition.FORWARD, "1"),
                Player("Brandin", "Podziemski", NbaPosition.GUARD, "2"),
                Player("Will", "Richard", NbaPosition.GUARD, "3"),
                Player("Moses", "Moody", NbaPosition.GUARD, "4"),
                Player("Buddy", "Hield", NbaPosition.GUARD, "7"),
                Player("De'Anthony", "Melton", NbaPosition.GUARD, "8"),
                Player("Jimmy", "Butler", NbaPosition.FORWARD, "10", "III"),
                Player("Gui", "Santos", NbaPosition.FORWARD, "15"),
                Player("L.J.", "Cryer", NbaPosition.GUARD, "18"),
                Player("Al", "Horford", NbaPosition.CENTER, "20"),
                Player("Quinten", "Post", NbaPosition.CENTER, "21"),
                Player("Draymond", "Green", NbaPosition.FORWARD, "23"),
                Player("Stephen", "Curry", NbaPosition.GUARD, "30"),
                Player("Seth", "Curry", NbaPosition.SHOOTING_GUARD, "31"),
                Player("Trayce", "Jackson-Davis", NbaPosition.FORWARD, "32"),
                Player("Malevy", "Leons", NbaPosition.FORWARD, "33"),
                Player("Pat", "Spencer", NbaPosition.GUARD, "61"),
            ),
    )
}

private val nbaTeamHou by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Houston Rockets",
        nameWidthPercent = 66.2f,
        abbreviation = "HOU",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFCE1141),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Toyota Center",
                location =
                    VenueLocation(
                        lat = 29.750833,
                        long = -95.362222,
                    ),
            ),
        roster =
            listOf(
                Player("Aaron", "Holiday", NbaPosition.GUARD, "0"),
                Player("Amen", "Thompson", NbaPosition.GUARD, "1"),
                Player("Dorian", "Finney-Smith", NbaPosition.FORWARD, "2"),
                Player("JD", "Davison", NbaPosition.GUARD, "4"),
                Player("Fred", "VanVleet", NbaPosition.GUARD, "5"),
                Player("Kevin", "Durant", NbaPosition.FORWARD, "7"),
                Player("Jae'Sean", "Tate", NbaPosition.FORWARD, "8"),
                Player("Jabari", "Smith", NbaPosition.FORWARD, "10", "Jr."),
                Player("Steven", "Adams", NbaPosition.CENTER, "12"),
                Player("Reed", "Sheppard", NbaPosition.GUARD, "15"),
                Player("Tari", "Eason", NbaPosition.FORWARD, "17"),
                Player("Josh", "Okogie", NbaPosition.GUARD, "20"),
                Player("Tyler", "Smith", NbaPosition.FORWARD, "21"),
                Player("Isaiah", "Crawford", NbaPosition.FORWARD, "27"),
                Player("Alperen", "Sengun", NbaPosition.CENTER, "28"),
                Player("Clint", "Capela", NbaPosition.CENTER, "30"),
                Player("Jeff", "Green", NbaPosition.FORWARD, "32"),
            ),
    )
}

private val nbaTeamInd by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Indiana Pacers",
        nameWidthPercent = 56.8f,
        abbreviation = "IND",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF0C2340),
                nameAccent = Color(0xFFFFD520),
            ),
        venue =
            TeamVenue(
                name = "Gainbridge Fieldhouse",
                location =
                    VenueLocation(
                        lat = 39.763889,
                        long = -86.155556,
                    ),
            ),
        roster =
            listOf(
                Player("Tyrese", "Haliburton", NbaPosition.GUARD, "0"),
                Player("Bennedict", "Mathurin", NbaPosition.GUARD, "0"),
                Player("Obi", "Toppin", NbaPosition.FORWARD, "1"),
                Player("Andrew", "Nembhard", NbaPosition.GUARD, "2"),
                Player("Taelon", "Peter", NbaPosition.GUARD, "4"),
                Player("Jarace", "Walker", NbaPosition.FORWARD, "5"),
                Player("Kam", "Jones", NbaPosition.GUARD, "7"),
                Player("T.J.", "McConnell", NbaPosition.GUARD, "9"),
                Player("James", "Wiseman", NbaPosition.CENTER, "11"),
                Player("Johnny", "Furphy", NbaPosition.GUARD, "12"),
                Player("Tony", "Bradley", NbaPosition.CENTER, "13"),
                Player("Isaiah", "Jackson", NbaPosition.FORWARD, "22"),
                Player("Aaron", "Nesmith", NbaPosition.GUARD, "23"),
                Player("Garrison", "Mathews", NbaPosition.GUARD, "24"),
                Player("Ben", "Sheppard", NbaPosition.GUARD, "26"),
                Player("Quenton", "Jackson", NbaPosition.GUARD, "29"),
                Player("Jay", "Huff", NbaPosition.CENTER, "32"),
                Player("Pascal", "Siakam", NbaPosition.FORWARD, "43"),
                Player("Ethan", "Thompson", NbaPosition.GUARD, "55"),
            ),
    )
}

private val nbaTeamLac by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Los Angeles Clippers",
        nameWidthPercent = 80.1f,
        abbreviation = "LAC",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF12173F),
                nameAccent = Color(0xFFC8102E),
            ),
        venue =
            TeamVenue(
                name = "Intuit Dome",
                location =
                    VenueLocation(
                        lat = 33.945127,
                        long = -118.343102,
                    ),
            ),
        roster =
            listOf(
                Player("Bradley", "Beal", NbaPosition.GUARD, "0"),
                Player("James", "Harden", NbaPosition.GUARD, "1"),
                Player("Kawhi", "Leonard", NbaPosition.FORWARD, "2"),
                Player("Kobe", "Sanders", NbaPosition.GUARD, "4"),
                Player("Derrick", "Jones", NbaPosition.FORWARD, "5", "Jr."),
                Player("Kris", "Dunn", NbaPosition.GUARD, "8"),
                Player("Bogdan", "Bogdanovic", NbaPosition.GUARD, "10"),
                Player("Brook", "Lopez", NbaPosition.CENTER, "11"),
                Player("Cam", "Christie", NbaPosition.GUARD, "12"),
                Player("Yanic Konan", "Niederhauser", NbaPosition.CENTER, "14"),
                Player("John", "Collins", NbaPosition.FORWARD, "20"),
                Player("Jordan", "Miller", NbaPosition.GUARD, "22"),
                Player("Kobe", "Brown", NbaPosition.GUARD, "24"),
                Player("Nicolas", "Batum", NbaPosition.FORWARD, "33"),
                Player("Ivica", "Zubac", NbaPosition.CENTER, "40"),
            ),
    )
}

private val nbaTeamLal by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Los Angeles Lakers",
        nameWidthPercent = 73.6f,
        abbreviation = "LAL",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF552583),
                nameAccent = Color(0xFFFDB927),
            ),
        venue =
            TeamVenue(
                name = "Crypto.com Arena",
                location =
                    VenueLocation(
                        lat = 34.043056,
                        long = -118.267222,
                    ),
            ),
        roster =
            listOf(
                Player("Adou", "Thiero", NbaPosition.FORWARD, "1"),
                Player("Jarred", "Vanderbilt", NbaPosition.FORWARD, "2"),
                Player("Dalton", "Knecht", NbaPosition.FORWARD, "4"),
                Player("Deandre", "Ayton", NbaPosition.CENTER, "5"),
                Player("Gabe", "Vincent", NbaPosition.GUARD, "7"),
                Player("Bronny", "James", NbaPosition.GUARD, "9"),
                Player("Jaxson", "Hayes", NbaPosition.CENTER, "11"),
                Player("Jake", "LaRavia", NbaPosition.FORWARD, "12"),
                Player("Maxi", "Kleber", NbaPosition.FORWARD, "14"),
                Player("Austin", "Reaves", NbaPosition.GUARD, "15"),
                Player("Nick", "Smith", NbaPosition.GUARD, "20", "Jr."),
                Player("LeBron", "James", NbaPosition.FORWARD, "23"),
                Player("Drew", "Timme", NbaPosition.FORWARD, "26"),
                Player("Rui", "Hachimura", NbaPosition.FORWARD, "28"),
                Player("Chris", "Manon", NbaPosition.GUARD, "30"),
                Player("Marcus", "Smart", NbaPosition.GUARD, "36"),
                Player("Luka", "Doncic", NbaPosition.GUARD, "77"),
            ),
    )
}

private val nbaTeamMem by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Memphis Grizzlies",
        nameWidthPercent = 69.9f,
        abbreviation = "MEM",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF5D76A9),
                nameAccent = Color(0xFF12173F),
            ),
        venue =
            TeamVenue(
                name = "FedExForum",
                location =
                    VenueLocation(
                        lat = 35.138333,
                        long = -90.050556,
                    ),
            ),
        roster =
            listOf(
                Player("Jaylen", "Wells", NbaPosition.FORWARD, "0"),
                Player("Scotty", "Pippen", NbaPosition.GUARD, "1", "Jr."),
                Player("Ty", "Jerome", NbaPosition.GUARD, "2"),
                Player("Kentavious", "Caldwell-Pope", NbaPosition.GUARD, "3"),
                Player("Vince", "Williams", NbaPosition.GUARD, "5", "Jr."),
                Player("Santi", "Aldama", NbaPosition.FORWARD, "7"),
                Player("Jaren", "Jackson", NbaPosition.FORWARD, "8", "Jr."),
                Player("Javon", "Small", NbaPosition.GUARD, "10"),
                Player("Ja", "Morant", NbaPosition.GUARD, "12"),
                Player("Zach", "Edey", NbaPosition.CENTER, "14"),
                Player("Brandon", "Clarke", NbaPosition.FORWARD, "15"),
                Player("Olivier-Maxence", "Prosper", NbaPosition.FORWARD, "18"),
                Player("Jahmai", "Mashack", NbaPosition.GUARD, "21"),
                Player("Cedric", "Coward", NbaPosition.FORWARD, "23"),
                Player("Cam", "Spencer", NbaPosition.GUARD, "24"),
                Player("Jock", "Landale", NbaPosition.CENTER, "31"),
                Player("Christian", "Koloko", NbaPosition.CENTER, "35"),
                Player("GG", "Jackson", NbaPosition.FORWARD, "45"),
                Player("John", "Konchar", NbaPosition.GUARD, "46"),
            ),
    )
}

private val nbaTeamMia by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Miami Heat",
        nameWidthPercent = 43.9f,
        abbreviation = "MIA",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF98002E),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Kaseya Center",
                location =
                    VenueLocation(
                        lat = 25.781389,
                        long = -80.188056,
                    ),
            ),
        roster =
            listOf(
                Player("Simone", "Fontecchio", NbaPosition.FORWARD, "0"),
                Player("Terry", "Rozier", NbaPosition.GUARD, "2"),
                Player("Nikola", "Jovic", NbaPosition.FORWARD, "5"),
                Player("Kel'el", "Ware", NbaPosition.CENTER, "7"),
                Player("Pelle", "Larsson", NbaPosition.GUARD, "9"),
                Player("Jaime", "Jaquez", NbaPosition.FORWARD, "11", "Jr."),
                Player("Dru", "Smith", NbaPosition.GUARD, "12"),
                Player("Bam", "Adebayo", NbaPosition.CENTER, "13"),
                Player("Tyler", "Herro", NbaPosition.GUARD, "14"),
                Player("Myron", "Gardner", NbaPosition.FORWARD, "15"),
                Player("Keshad", "Johnson", NbaPosition.FORWARD, "16"),
                Player("Jahmir", "Young", NbaPosition.GUARD, "17"),
                Player("Andrew", "Wiggins", NbaPosition.FORWARD, "22"),
                Player("Norman", "Powell", NbaPosition.GUARD, "24"),
                Player("Kasparas", "Jakucionis", NbaPosition.GUARD, "25"),
                Player("Davion", "Mitchell", NbaPosition.GUARD, "45"),
                Player("Vladislav", "Goldin", NbaPosition.CENTER, "50"),
            ),
    )
}

private val nbaTeamMil by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Milwaukee Bucks",
        nameWidthPercent = 66.2f,
        abbreviation = "MIL",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF00471B),
                nameAccent = Color(0xFFEEE1C6),
            ),
        venue =
            TeamVenue(
                name = "Fiserv Forum",
                location =
                    VenueLocation(
                        lat = 43.045100,
                        long = -87.918200,
                    ),
            ),
        roster =
            listOf(
                Player("Jericho", "Sims", NbaPosition.CENTER, "0"),
                Player("Myles", "Turner", NbaPosition.CENTER, "3"),
                Player("Gary", "Trent", NbaPosition.GUARD, "5", "Jr."),
                Player("Kevin", "Porter", NbaPosition.GUARD, "7", "Jr."),
                Player("Bobby", "Portis", NbaPosition.FORWARD, "9"),
                Player("Gary", "Harris", NbaPosition.GUARD, "11"),
                Player("Taurean", "Prince", NbaPosition.FORWARD, "12"),
                Player("Ryan", "Rollins", NbaPosition.GUARD, "13"),
                Player("Amir", "Coffey", NbaPosition.GUARD, "17"),
                Player("Kyle", "Kuzma", NbaPosition.FORWARD, "18"),
                Player("Mark", "Sears", NbaPosition.GUARD, "19"),
                Player("AJ", "Green", NbaPosition.GUARD, "20"),
                Player("Alex", "Antetokounmpo", NbaPosition.FORWARD, "29"),
                Player("Giannis", "Antetokounmpo", NbaPosition.FORWARD, "34"),
                Player("Pete", "Nance", NbaPosition.FORWARD, "35"),
                Player("Thanasis", "Antetokounmpo", NbaPosition.FORWARD, "43"),
                Player("Andre", "Jackson", NbaPosition.GUARD, "44", "Jr."),
                Player("Cole", "Anthony", NbaPosition.GUARD, "50"),
            ),
    )
}

private val nbaTeamMin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Minnesota Timberwolves",
        nameWidthPercent = 96.3f,
        abbreviation = "MIN",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF266092),
                nameAccent = Color(0xFF79BC43),
            ),
        venue =
            TeamVenue(
                name = "Target Center",
                location =
                    VenueLocation(
                        lat = 44.979444,
                        long = -93.276111,
                    ),
            ),
        roster =
            listOf(
                Player("Donte", "DiVincenzo", NbaPosition.GUARD, "0"),
                Player("Terrence", "Shannon", NbaPosition.GUARD, "1", "Jr."),
                Player("Jaden", "McDaniels", NbaPosition.FORWARD, "3"),
                Player("Rob", "Dillingham", NbaPosition.GUARD, "4"),
                Player("Anthony", "Edwards", NbaPosition.GUARD, "5"),
                Player("Joe", "Ingles", NbaPosition.FORWARD, "7"),
                Player("Bones", "Hyland", NbaPosition.GUARD, "8"),
                Player("Johnny", "Juzang", NbaPosition.GUARD, "9"),
                Player("Mike", "Conley", NbaPosition.GUARD, "10"),
                Player("Naz", "Reid", NbaPosition.CENTER, "11"),
                Player("Joan", "Beringer", NbaPosition.FORWARD, "19"),
                Player("Jaylen", "Clark", NbaPosition.GUARD, "22"),
                Player("Enrique", "Freeman", NbaPosition.FORWARD, "25"),
                Player("Rudy", "Gobert", NbaPosition.CENTER, "27"),
                Player("Julius", "Randle", NbaPosition.FORWARD, "30"),
                Player("Leonard", "Miller", NbaPosition.FORWARD, "33"),
                Player("Rocco", "Zikarsky", NbaPosition.CENTER, "44"),
            ),
    )
}

private val nbaTeamNo by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New Orleans Pelicans",
        nameWidthPercent = 83.1f,
        abbreviation = "NO",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF0A2240),
                nameAccent = Color(0xFFB4975A),
            ),
        venue =
            TeamVenue(
                name = "Smoothie King Center",
                location =
                    VenueLocation(
                        lat = 29.948889,
                        long = -90.081944,
                    ),
            ),
        roster =
            listOf(
                Player("Jeremiah", "Fears", NbaPosition.GUARD, "0"),
                Player("Zion", "Williamson", NbaPosition.FORWARD, "1"),
                Player("Herbert", "Jones", NbaPosition.FORWARD, "2"),
                Player("Jordan", "Poole", NbaPosition.GUARD, "3"),
                Player("Hunter", "Dickinson", NbaPosition.CENTER, "4"),
                Player("Dejounte", "Murray", NbaPosition.GUARD, "5"),
                Player("DeAndre", "Jordan", NbaPosition.CENTER, "9"),
                Player("Bryce", "McGowens", NbaPosition.GUARD, "11"),
                Player("Micah", "Peavy", NbaPosition.GUARD, "14"),
                Player("Jose", "Alvarado", NbaPosition.GUARD, "15"),
                Player("Karlo", "Matkovic", NbaPosition.FORWARD, "17"),
                Player("Yves", "Missi", NbaPosition.CENTER, "21"),
                Player("Derik", "Queen", NbaPosition.CENTER, "22"),
                Player("Trey", "Alexander", NbaPosition.GUARD, "23"),
                Player("Jordan", "Hawkins", NbaPosition.GUARD, "24"),
                Player("Trey", "Murphy", NbaPosition.FORWARD, "25", "III"),
                Player("Saddiq", "Bey", NbaPosition.GUARD, "41"),
                Player("Kevon", "Looney", NbaPosition.FORWARD, "55"),
            ),
    )
}

private val nbaTeamNy by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Knicks",
        nameWidthPercent = 63.9f,
        abbreviation = "NY",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF1D428A),
                nameAccent = Color(0xFFF58426),
            ),
        venue =
            TeamVenue(
                name = "Madison Square Garden",
                location =
                    VenueLocation(
                        lat = 40.750556,
                        long = -73.993611,
                    ),
            ),
        roster =
            listOf(
                Player("Jordan", "Clarkson", NbaPosition.GUARD, "0"),
                Player("Miles", "McBride", NbaPosition.GUARD, "2"),
                Player("Josh", "Hart", NbaPosition.GUARD, "3"),
                Player("Pacome", "Dadiet", NbaPosition.FORWARD, "4"),
                Player("OG", "Anunoby", NbaPosition.FORWARD, "8"),
                Player("Kevin", "McCullar", NbaPosition.GUARD, "9", "Jr."),
                Player("Jalen", "Brunson", NbaPosition.GUARD, "11"),
                Player("Tyler", "Kolek", NbaPosition.GUARD, "13"),
                Player("Tosan", "Evbuomwan", NbaPosition.FORWARD, "20"),
                Player("Mitchell", "Robinson", NbaPosition.CENTER, "23"),
                Player("Mikal", "Bridges", NbaPosition.GUARD, "25"),
                Player("Guerschon", "Yabusele", NbaPosition.FORWARD, "28"),
                Player("Karl-Anthony", "Towns", NbaPosition.CENTER, "32"),
                Player("Landry", "Shamet", NbaPosition.GUARD, "44"),
                Player("Trey", "Jemison", NbaPosition.FORWARD, "50", "III"),
                Player("Mohamed", "Diawara", NbaPosition.FORWARD, "51"),
                Player("Ariel", "Hukporti", NbaPosition.CENTER, "55"),
            ),
    )
}

private val nbaTeamOkc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Oklahoma City Thunder",
        nameWidthPercent = 90.5f,
        abbreviation = "OKC",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF007AC1),
                nameAccent = Color(0xFFEF3B24),
            ),
        venue =
            TeamVenue(
                name = "Paycom Center",
                location =
                    VenueLocation(
                        lat = 35.463333,
                        long = -97.515000,
                    ),
            ),
        roster =
            listOf(
                Player("Shai", "Gilgeous-Alexander", NbaPosition.GUARD, "2"),
                Player("Chris", "Youngblood", NbaPosition.GUARD, "3"),
                Player("Luguentz", "Dort", NbaPosition.GUARD, "5"),
                Player("Jaylin", "Williams", NbaPosition.FORWARD, "6"),
                Player("Chet", "Holmgren", NbaPosition.CENTER, "7"),
                Player("Jalen", "Williams", NbaPosition.GUARD, "8"),
                Player("Alex", "Caruso", NbaPosition.GUARD, "9"),
                Player("Isaiah", "Joe", NbaPosition.GUARD, "11"),
                Player("Thomas", "Sorber", NbaPosition.CENTER, "12"),
                Player("Ousmane", "Dieng", NbaPosition.FORWARD, "13"),
                Player("Branden", "Carlson", NbaPosition.CENTER, "15"),
                Player("Aaron", "Wiggins", NbaPosition.GUARD, "21"),
                Player("Cason", "Wallace", NbaPosition.GUARD, "22"),
                Player("Brooks", "Barnhizer", NbaPosition.FORWARD, "23"),
                Player("Ajay", "Mitchell", NbaPosition.GUARD, "25"),
                Player("Kenrich", "Williams", NbaPosition.GUARD, "34"),
                Player("Nikola", "Topic", NbaPosition.GUARD, "44"),
                Player("Isaiah", "Hartenstein", NbaPosition.CENTER, "55"),
            ),
    )
}

private val nbaTeamOrl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Orlando Magic",
        nameWidthPercent = 57.4f,
        abbreviation = "ORL",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF0150B5),
                nameAccent = Color(0xFF9CA0A3),
            ),
        venue =
            TeamVenue(
                name = "Kia Center",
                location =
                    VenueLocation(
                        lat = 28.539167,
                        long = -81.383611,
                    ),
            ),
        roster =
            listOf(
                Player("Anthony", "Black", NbaPosition.GUARD, "0"),
                Player("Jonathan", "Isaac", NbaPosition.FORWARD, "1"),
                Player("Tyus", "Jones", NbaPosition.GUARD, "2"),
                Player("Desmond", "Bane", NbaPosition.GUARD, "3"),
                Player("Jalen", "Suggs", NbaPosition.GUARD, "4"),
                Player("Paolo", "Banchero", NbaPosition.FORWARD, "5"),
                Player("Orlando", "Robinson", NbaPosition.CENTER, "7"),
                Player("Jamal", "Cain", NbaPosition.FORWARD, "8"),
                Player("Jase", "Richardson", NbaPosition.GUARD, "11"),
                Player("Jett", "Howard", NbaPosition.GUARD, "13"),
                Player("Colin", "Castleton", NbaPosition.CENTER, "14"),
                Player("Moritz", "Wagner", NbaPosition.FORWARD, "21"),
                Player("Franz", "Wagner", NbaPosition.FORWARD, "22"),
                Player("Tristan", "da Silva", NbaPosition.FORWARD, "23"),
                Player("Wendell", "Carter", NbaPosition.CENTER, "34", "Jr."),
                Player("Goga", "Bitadze", NbaPosition.CENTER, "35"),
                Player("Noah", "Penda", NbaPosition.FORWARD, "93"),
            ),
    )
}

private val nbaTeamPhi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Philadelphia 76ers",
        nameWidthPercent = 69.9f,
        abbreviation = "PHI",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF1D428A),
                nameAccent = Color(0xFFE01234),
            ),
        venue =
            TeamVenue(
                name = "Wells Fargo Center",
                location =
                    VenueLocation(
                        lat = 39.744600,
                        long = -104.985000,
                    ),
            ),
        roster =
            listOf(
                Player("Tyrese", "Maxey", NbaPosition.GUARD, "0"),
                Player("Andre", "Drummond", NbaPosition.CENTER, "1"),
                Player("Quentin", "Grimes", NbaPosition.GUARD, "5"),
                Player("Kyle", "Lowry", NbaPosition.GUARD, "7"),
                Player("Paul", "George", NbaPosition.FORWARD, "8"),
                Player("Kelly", "Oubre", NbaPosition.GUARD, "9", "Jr."),
                Player("Justin", "Edwards", NbaPosition.FORWARD, "11"),
                Player("Trendon", "Watford", NbaPosition.FORWARD, "12"),
                Player("Jared", "McCain", NbaPosition.GUARD, "20"),
                Player("Joel", "Embiid", NbaPosition.CENTER, "21"),
                Player("Johni", "Broome", NbaPosition.FORWARD, "22"),
                Player("Eric", "Gordon", NbaPosition.GUARD, "23"),
                Player("Dominick", "Barlow", NbaPosition.FORWARD, "25"),
                Player("Adem", "Bona", NbaPosition.CENTER, "30"),
                Player("Jabari", "Walker", NbaPosition.FORWARD, "33"),
                Player("VJ", "Edgecombe", NbaPosition.GUARD, "77"),
            ),
    )
}

private val nbaTeamPhx by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Phoenix Suns",
        nameWidthPercent = 50.7f,
        abbreviation = "PHX",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF29127A),
                nameAccent = Color(0xFFE56020),
            ),
        venue =
            TeamVenue(
                name = "PHX Arena",
                location =
                    VenueLocation(
                        lat = 33.445833,
                        long = -112.071389,
                    ),
            ),
        roster =
            listOf(
                Player("Ryan", "Dunn", NbaPosition.FORWARD, "0"),
                Player("Royce", "O'Neale", NbaPosition.FORWARD, "0"),
                Player("Devin", "Booker", NbaPosition.GUARD, "1"),
                Player("Nick", "Richards", NbaPosition.CENTER, "2"),
                Player("Dillon", "Brooks", NbaPosition.FORWARD, "3"),
                Player("Jalen", "Green", NbaPosition.GUARD, "4"),
                Player("Grayson", "Allen", NbaPosition.GUARD, "8"),
                Player("Khaman", "Maluach", NbaPosition.CENTER, "10"),
                Player("Oso", "Ighodaro", NbaPosition.FORWARD, "11"),
                Player("Collin", "Gillespie", NbaPosition.GUARD, "12"),
                Player("Koby", "Brea", NbaPosition.GUARD, "14"),
                Player("Mark", "Williams", NbaPosition.CENTER, "15"),
                Player("Jamaree", "Bouyea", NbaPosition.GUARD, "17"),
                Player("Isaiah", "Livers", NbaPosition.FORWARD, "18"),
                Player("Rasheer", "Fleming", NbaPosition.FORWARD, "20"),
                Player("Nigel", "Hayes-Davis", NbaPosition.FORWARD, "21"),
                Player("Jordan", "Goodwin", NbaPosition.GUARD, "23"),
            ),
    )
}

private val nbaTeamPor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Portland Trail Blazers",
        nameWidthPercent = 82.1f,
        abbreviation = "POR",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFE03A3E),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Moda Center",
                location =
                    VenueLocation(
                        lat = 45.531667,
                        long = -122.666667,
                    ),
            ),
        roster =
            listOf(
                Player("Scoot", "Henderson", NbaPosition.GUARD, "0"),
                Player("Damian", "Lillard", NbaPosition.GUARD, "0"),
                Player("Blake", "Wesley", NbaPosition.GUARD, "1"),
                Player("Caleb", "Love", NbaPosition.GUARD, "2"),
                Player("Matisse", "Thybulle", NbaPosition.GUARD, "4"),
                Player("Jrue", "Holiday", NbaPosition.GUARD, "5"),
                Player("Deni", "Avdija", NbaPosition.FORWARD, "8"),
                Player("Jerami", "Grant", NbaPosition.FORWARD, "9"),
                Player("Yang", "Hansen", NbaPosition.CENTER, "16"),
                Player("Shaedon", "Sharpe", NbaPosition.GUARD, "17"),
                Player("Javonte", "Cooke", NbaPosition.GUARD, "18"),
                Player("Rayan", "Rupert", NbaPosition.GUARD, "21"),
                Player("Donovan", "Clingan", NbaPosition.CENTER, "23"),
                Player("Kris", "Murray", NbaPosition.FORWARD, "24"),
                Player("Duop", "Reath", NbaPosition.CENTER, "26"),
                Player("Toumani", "Camara", NbaPosition.FORWARD, "33"),
                Player("Robert", "Williams", NbaPosition.CENTER, "35", "III"),
                Player("Sidy", "Cissoko", NbaPosition.GUARD, "91"),
            ),
    )
}

private val nbaTeamSac by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Sacramento Kings",
        nameWidthPercent = 70.3f,
        abbreviation = "SAC",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF5A2D81),
                nameAccent = Color(0xFF6A7A82),
            ),
        venue =
            TeamVenue(
                name = "Golden 1 Center",
                location =
                    VenueLocation(
                        lat = 38.580000,
                        long = -121.500000,
                    ),
            ),
        roster =
            listOf(
                Player("Malik", "Monk", NbaPosition.GUARD, "0"),
                Player("Nique", "Clifford", NbaPosition.GUARD, "5"),
                Player("Doug", "McDermott", NbaPosition.FORWARD, "7"),
                Player("Zach", "LaVine", NbaPosition.GUARD, "8"),
                Player("Precious", "Achiuwa", NbaPosition.POWER_FORWARD, "9"),
                Player("DeMar", "DeRozan", NbaPosition.GUARD, "10"),
                Player("Domantas", "Sabonis", NbaPosition.FORWARD, "11"),
                Player("Keegan", "Murray", NbaPosition.FORWARD, "13"),
                Player("Dennis", "Schroder", NbaPosition.GUARD, "17"),
                Player("Russell", "Westbrook", NbaPosition.GUARD, "18"),
                Player("Drew", "Eubanks", NbaPosition.FORWARD, "19"),
                Player("Dario", "Saric", NbaPosition.FORWARD, "20"),
                Player("Devin", "Carter", NbaPosition.GUARD, "22"),
                Player("Keon", "Ellis", NbaPosition.GUARD, "23"),
                Player("Isaiah", "Stevens", NbaPosition.GUARD, "24"),
                Player("Daeqwon", "Plowden", NbaPosition.GUARD, "29"),
                Player("Dylan", "Cardwell", NbaPosition.CENTER, "32"),
                Player("Maxime", "Raynaud", NbaPosition.CENTER, "42"),
            ),
    )
}

private val nbaTeamSa by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Antonio Spurs",
        nameWidthPercent = 70.3f,
        abbreviation = "SA",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFC4CED4),
            ),
        venue =
            TeamVenue(
                name = "Frost Bank Center",
                location =
                    VenueLocation(
                        lat = 29.426944,
                        long = -98.437500,
                    ),
            ),
        roster =
            listOf(
                Player("Jordan", "McLaughlin", NbaPosition.GUARD, "0"),
                Player("Victor", "Wembanyama", NbaPosition.FORWARD, "1"),
                Player("Dylan", "Harper", NbaPosition.GUARD, "2"),
                Player("Keldon", "Johnson", NbaPosition.FORWARD, "3"),
                Player("De'Aaron", "Fox", NbaPosition.GUARD, "4"),
                Player("Stephon", "Castle", NbaPosition.GUARD, "5"),
                Player("Luke", "Kornet", NbaPosition.CENTER, "7"),
                Player("Kelly", "Olynyk", NbaPosition.FORWARD, "8"),
                Player("Jeremy", "Sochan", NbaPosition.FORWARD, "10"),
                Player("Carter", "Bryant", NbaPosition.FORWARD, "11"),
                Player("Stanley", "Umude", NbaPosition.GUARD, "17"),
                Player("Bismack", "Biyombo", NbaPosition.CENTER, "18"),
                Player("Devin", "Vassell", NbaPosition.GUARD, "24"),
                Player("David", "Jones Garcia", NbaPosition.FORWARD, "25"),
                Player("Julian", "Champagnie", NbaPosition.FORWARD, "30"),
                Player("Harrison", "Barnes", NbaPosition.FORWARD, "40"),
                Player("Lindy", "Waters", NbaPosition.FORWARD, "43", "III"),
                Player("Harrison", "Ingram", NbaPosition.FORWARD, "55"),
            ),
    )
}

private val nbaTeamTor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Toronto Raptors",
        nameWidthPercent = 63.9f,
        abbreviation = "TOR",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFD91244),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Scotiabank Arena",
                location =
                    VenueLocation(
                        lat = 43.643333,
                        long = -79.379167,
                    ),
            ),
        roster =
            listOf(
                Player("A.J.", "Lawson", NbaPosition.GUARD, "0"),
                Player("Gradey", "Dick", NbaPosition.GUARD, "1"),
                Player("Jonathan", "Mogbo", NbaPosition.FORWARD, "2"),
                Player("Brandon", "Ingram", NbaPosition.FORWARD, "3"),
                Player("Scottie", "Barnes", NbaPosition.FORWARD, "4"),
                Player("Immanuel", "Quickley", NbaPosition.GUARD, "5"),
                Player("RJ", "Barrett", NbaPosition.FORWARD, "9"),
                Player("Collin", "Murray-Boyles", NbaPosition.FORWARD, "12"),
                Player("Ja'Kobe", "Walter", NbaPosition.GUARD, "14"),
                Player("Garrett", "Temple", NbaPosition.GUARD, "17"),
                Player("Jakob", "Poeltl", NbaPosition.CENTER, "19"),
                Player("Jamal", "Shead", NbaPosition.GUARD, "23"),
                Player("Chucky", "Hepburn", NbaPosition.GUARD, "24"),
                Player("Ochai", "Agbaji", NbaPosition.GUARD, "30"),
                Player("Sandro", "Mamukelashvili", NbaPosition.FORWARD, "54"),
                Player("Alijah", "Martin", NbaPosition.GUARD, "55"),
                Player("Jamison", "Battle", NbaPosition.FORWARD, "77"),
            ),
    )
}

private val nbaTeamUtah by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Utah Jazz",
        nameWidthPercent = 37.5f,
        abbreviation = "UTAH",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFF4E008E),
                nameAccent = Color(0xFF79A3DC),
            ),
        venue =
            TeamVenue(
                name = "Delta Center",
                location =
                    VenueLocation(
                        lat = 40.768333,
                        long = -111.901111,
                    ),
            ),
        roster =
            listOf(
                Player("Taylor", "Hendricks", NbaPosition.FORWARD, "0"),
                Player("Kyle", "Anderson", NbaPosition.FORWARD, "2"),
                Player("Keyonte", "George", NbaPosition.GUARD, "3"),
                Player("Cody", "Williams", NbaPosition.FORWARD, "5"),
                Player("Isaiah", "Collier", NbaPosition.GUARD, "8"),
                Player("Svi", "Mykhailiuk", NbaPosition.GUARD, "10"),
                Player("Walter", "Clayton", NbaPosition.GUARD, "13", "Jr."),
                Player("Elijah", "Harkless", NbaPosition.GUARD, "16"),
                Player("John", "Tonje", NbaPosition.FORWARD, "17"),
                Player("Ace", "Bailey", NbaPosition.GUARD, "19"),
                Player("Kyle", "Filipowski", NbaPosition.FORWARD, "22"),
                Player("Lauri", "Markkanen", NbaPosition.FORWARD, "23"),
                Player("Walker", "Kessler", NbaPosition.CENTER, "24"),
                Player("Brice", "Sensabaugh", NbaPosition.FORWARD, "28"),
                Player("Jusuf", "Nurkic", NbaPosition.CENTER, "30"),
                Player("Georges", "Niang", NbaPosition.FORWARD, "31"),
                Player("Oscar", "Tshiebwe", NbaPosition.CENTER, "34"),
                Player("Kevin", "Love", NbaPosition.FORWARD, "42"),
            ),
    )
}

private val nbaTeamWsh by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Washington Wizards",
        nameWidthPercent = 79.7f,
        abbreviation = "WSH",
        league = LeagueId.NBA,
        colors =
            TeamColors(
                primary = Color(0xFFE31837),
                nameAccent = Color(0xFF002B5C),
            ),
        venue =
            TeamVenue(
                name = "Capital One Arena",
                location =
                    VenueLocation(
                        lat = 38.898056,
                        long = -77.020833,
                    ),
            ),
        roster =
            listOf(
                Player("Bilal", "Coulibaly", NbaPosition.GUARD, "0"),
                Player("Tristan", "Vukcevic", NbaPosition.FORWARD, "0"),
                Player("Cam", "Whitmore", NbaPosition.FORWARD, "1"),
                Player("CJ", "McCollum", NbaPosition.GUARD, "3"),
                Player("AJ", "Johnson", NbaPosition.GUARD, "4"),
                Player("Jamir", "Watkins", NbaPosition.GUARD, "5"),
                Player("Bub", "Carrington", NbaPosition.GUARD, "7"),
                Player("Malaki", "Branham", NbaPosition.GUARD, "8"),
                Player("Justin", "Champagnie", NbaPosition.FORWARD, "9"),
                Player("Tre", "Johnson", NbaPosition.GUARD, "12"),
                Player("Sharife", "Cooper", NbaPosition.GUARD, "13"),
                Player("Anthony", "Gill", NbaPosition.FORWARD, "16"),
                Player("Kyshawn", "George", NbaPosition.FORWARD, "18"),
                Player("Alex", "Sarr", NbaPosition.CENTER, "20"),
                Player("Khris", "Middleton", NbaPosition.FORWARD, "22"),
                Player("Corey", "Kispert", NbaPosition.FORWARD, "24"),
                Player("Will", "Riley", NbaPosition.GUARD, "27"),
                Player("Marvin", "Bagley", NbaPosition.FORWARD, "35", "III"),
            ),
    )
}

val NbaTeams: List<Team<NbaPosition>> by lazy(LazyThreadSafetyMode.NONE) {
    listOf(
        nbaTeamAtl,
        nbaTeamBos,
        nbaTeamBkn,
        nbaTeamCha,
        nbaTeamChi,
        nbaTeamCle,
        nbaTeamDal,
        nbaTeamDen,
        nbaTeamDet,
        nbaTeamGs,
        nbaTeamHou,
        nbaTeamInd,
        nbaTeamLac,
        nbaTeamLal,
        nbaTeamMem,
        nbaTeamMia,
        nbaTeamMil,
        nbaTeamMin,
        nbaTeamNo,
        nbaTeamNy,
        nbaTeamOkc,
        nbaTeamOrl,
        nbaTeamPhi,
        nbaTeamPhx,
        nbaTeamPor,
        nbaTeamSac,
        nbaTeamSa,
        nbaTeamTor,
        nbaTeamUtah,
        nbaTeamWsh,
    )
}

internal object NbaTeamRefs {
    val ATL = nbaTeamAtl
    val BOS = nbaTeamBos
    val BKN = nbaTeamBkn
    val CHA = nbaTeamCha
    val CHI = nbaTeamChi
    val CLE = nbaTeamCle
    val DAL = nbaTeamDal
    val DEN = nbaTeamDen
    val DET = nbaTeamDet
    val GS = nbaTeamGs
    val HOU = nbaTeamHou
    val IND = nbaTeamInd
    val LAC = nbaTeamLac
    val LAL = nbaTeamLal
    val MEM = nbaTeamMem
    val MIA = nbaTeamMia
    val MIL = nbaTeamMil
    val MIN = nbaTeamMin
    val NO = nbaTeamNo
    val NY = nbaTeamNy
    val OKC = nbaTeamOkc
    val ORL = nbaTeamOrl
    val PHI = nbaTeamPhi
    val PHX = nbaTeamPhx
    val POR = nbaTeamPor
    val SAC = nbaTeamSac
    val SA = nbaTeamSa
    val TOR = nbaTeamTor
    val UTAH = nbaTeamUtah
    val WSH = nbaTeamWsh
}
