package ca.amandeep.playernumber.data

import androidx.compose.ui.graphics.Color

private val nhlTeamAna by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Anaheim Ducks",
        nameWidthPercent = 59.1f,
        abbreviation = "ANA",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFFC4C02),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Honda Center",
            location = VenueLocation(
                lat = 33.807778,
                long = -117.876667,
            ),
        ),
        roster = listOf(
            Player("Lukas", "Dostal", NhlPosition.GOALIE, "1"),
            Player("Jackson", "LaCombe", NhlPosition.DEFENSE, "2"),
            Player("Radko", "Gudas", NhlPosition.DEFENSE, "7"),
            Player("Sam", "Colangelo", NhlPosition.RIGHT_WING, "12"),
            Player("Nikita", "Nesterenko", NhlPosition.CENTER, "13"),
            Player("Drew", "Helleson", NhlPosition.DEFENSE, "14"),
            Player("Ryan", "Strome", NhlPosition.CENTER, "16"),
            Player("Alex", "Killorn", NhlPosition.LEFT_WING, "17"),
            Player("Troy", "Terry", NhlPosition.RIGHT_WING, "19"),
            Player("Chris", "Kreider", NhlPosition.LEFT_WING, "20"),
            Player("Mason", "McTavish", NhlPosition.CENTER, "23"),
            Player("Jansen", "Harkins", NhlPosition.CENTER, "24"),
            Player("Ryan", "Poehling", NhlPosition.CENTER, "25"),
            Player("Petr", "Mrazek", NhlPosition.GOALIE, "34"),
            Player("Ross", "Johnston", NhlPosition.LEFT_WING, "44"),
            Player("Beckett", "Sennecke", NhlPosition.RIGHT_WING, "45"),
            Player("Olen", "Zellweger", NhlPosition.DEFENSE, "51"),
            Player("Cutter", "Gauthier", NhlPosition.LEFT_WING, "61"),
            Player("Mikael", "Granlund", NhlPosition.CENTER, "64"),
            Player("Jacob", "Trouba", NhlPosition.DEFENSE, "65"),
            Player("Ian", "Moore", NhlPosition.DEFENSE, "74"),
            Player("Frank", "Vatrano", NhlPosition.RIGHT_WING, "77"),
            Player("Leo", "Carlsson", NhlPosition.CENTER, "91"),
            Player("Pavel", "Mintyukov", NhlPosition.DEFENSE, "98"),
        ),
    )
}

private val nhlTeamUtah by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Utah Mammoth",
        nameWidthPercent = 59.5f,
        abbreviation = "UTAH",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF000000),
            nameAccent = Color(0xFF7AB2E1),
        ),
        venue = TeamVenue(
            name = "Delta Center",
            location = VenueLocation(
                lat = 40.768333,
                long = -111.901111,
            ),
        ),
        roster = listOf(
            Player("Olli", "Maatta", NhlPosition.DEFENSE, "2"),
            Player("Juuso", "Valimaki", NhlPosition.DEFENSE, "4"),
            Player("John", "Marino", NhlPosition.DEFENSE, "6"),
            Player("Nick", "Schmaltz", NhlPosition.CENTER, "8"),
            Player("Clayton", "Keller", NhlPosition.CENTER, "9"),
            Player("Maveric", "Lamoureux", NhlPosition.DEFENSE, "10"),
            Player("Dylan", "Guenther", NhlPosition.RIGHT_WING, "11"),
            Player("Brandon", "Tanev", NhlPosition.LEFT_WING, "13"),
            Player("Alexander", "Kerfoot", NhlPosition.CENTER, "15"),
            Player("Daniil", "But", NhlPosition.LEFT_WING, "19"),
            Player("Jack", "McBain", NhlPosition.CENTER, "22"),
            Player("Barrett", "Hayton", NhlPosition.CENTER, "27"),
            Player("Ian", "Cole", NhlPosition.DEFENSE, "28"),
            Player("Colten", "McIntyre", NhlPosition.GOALIE, "33"),
            Player("Anson", "Thornton", NhlPosition.GOALIE, "34"),
            Player("Andrew", "Agozzino", NhlPosition.LEFT_WING, "36"),
            Player("Liam", "O'Brien", NhlPosition.CENTER, "38"),
            Player("Vitek", "Vanecek", NhlPosition.GOALIE, "41"),
            Player("Sean", "Durzi", NhlPosition.DEFENSE, "50"),
            Player("Michael", "Carcone", NhlPosition.LEFT_WING, "53"),
            Player("Terrell", "Goldsmith", NhlPosition.DEFENSE, "54"),
            Player("Kailer", "Yamamoto", NhlPosition.RIGHT_WING, "56"),
            Player("Nick", "DeSimone", NhlPosition.DEFENSE, "57"),
            Player("Lawson", "Crouse", NhlPosition.LEFT_WING, "67"),
            Player("Karel", "Vejmelka", NhlPosition.GOALIE, "70"),
            Player("JJ", "Peterka", NhlPosition.RIGHT_WING, "77"),
            Player("Kevin", "Stenlund", NhlPosition.CENTER, "82"),
            Player("Nate", "Schmidt", NhlPosition.DEFENSE, "88"),
            Player("Logan", "Cooley", NhlPosition.CENTER, "92"),
            Player("Mikhail", "Sergachev", NhlPosition.DEFENSE, "98"),
        ),
    )
}

private val nhlTeamBos by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Boston Bruins",
        nameWidthPercent = 53.7f,
        abbreviation = "BOS",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF231F20),
            nameAccent = Color(0xFFFDB71A),
        ),
        venue = TeamVenue(
            name = "TD Garden",
            location = VenueLocation(
                lat = 42.366303,
                long = -71.062228,
            ),
        ),
        roster = listOf(
            Player("Jeremy", "Swayman", NhlPosition.GOALIE, "1"),
            Player("Mason", "Lohrei", NhlPosition.DEFENSE, "6"),
            Player("Casey", "Mittelstadt", NhlPosition.CENTER, "11"),
            Player("Matej", "Blumel", NhlPosition.RIGHT_WING, "13"),
            Player("Pavel", "Zacha", NhlPosition.CENTER, "18"),
            Player("Henri", "Jokiharju", NhlPosition.DEFENSE, "20"),
            Player("Alex", "Steeves", NhlPosition.CENTER, "21"),
            Player("Andrew", "Peeke", NhlPosition.DEFENSE, "26"),
            Player("Hampus", "Lindholm", NhlPosition.DEFENSE, "27"),
            Player("Elias", "Lindholm", NhlPosition.CENTER, "28"),
            Player("Victor", "Soderstrom", NhlPosition.DEFENSE, "29"),
            Player("Morgan", "Geekie", NhlPosition.CENTER, "39"),
            Player("Jordan", "Harris", NhlPosition.DEFENSE, "43"),
            Player("Vladislav", "Kolyachonok", NhlPosition.DEFENSE, "44"),
            Player("Jonathan", "Aspirot", NhlPosition.DEFENSE, "45"),
            Player("Mark", "Kastelic", NhlPosition.CENTER, "47"),
            Player("Jeffrey", "Viel", NhlPosition.LEFT_WING, "48"),
            Player("Sean", "Kuraly", NhlPosition.CENTER, "52"),
            Player("Joonas", "Korpisalo", NhlPosition.GOALIE, "70"),
            Player("Viktor", "Arvidsson", NhlPosition.LEFT_WING, "71"),
            Player("Charlie", "McAvoy", NhlPosition.DEFENSE, "73"),
            Player("Michael", "Callahan", NhlPosition.DEFENSE, "79"),
            Player("Michael", "Eyssimont", NhlPosition.CENTER, "81"),
            Player("Tanner", "Jeannot", NhlPosition.LEFT_WING, "84"),
            Player("David", "Pastrnak", NhlPosition.RIGHT_WING, "88"),
            Player("Nikita", "Zadorov", NhlPosition.DEFENSE, "91"),
            Player("Marat", "Khusnutdinov", NhlPosition.CENTER, "92"),
            Player("Fraser", "Minten", NhlPosition.CENTER, "93"),
        ),
    )
}

private val nhlTeamBuf by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Buffalo Sabres",
        nameWidthPercent = 57.1f,
        abbreviation = "BUF",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF00468B),
            nameAccent = Color(0xFFFDB71A),
        ),
        venue = TeamVenue(
            name = "KeyBank Center",
            location = VenueLocation(
                lat = 42.875000,
                long = -78.876389,
            ),
        ),
        roster = listOf(
            Player("Ukko-Pekka", "Luukkonen", NhlPosition.GOALIE, "1"),
            Player("Bowen", "Byram", NhlPosition.DEFENSE, "4"),
            Player("Zach", "Benson", NhlPosition.LEFT_WING, "6"),
            Player("Michael", "Kesselring", NhlPosition.DEFENSE, "8"),
            Player("Josh", "Norris", NhlPosition.CENTER, "9"),
            Player("Jordan", "Greenway", NhlPosition.LEFT_WING, "12"),
            Player("Justin", "Danforth", NhlPosition.RIGHT_WING, "15"),
            Player("Jason", "Zucker", NhlPosition.LEFT_WING, "17"),
            Player("Peyton", "Krebs", NhlPosition.CENTER, "19"),
            Player("Jiri", "Kulich", NhlPosition.CENTER, "20"),
            Player("Conor", "Timmins", NhlPosition.DEFENSE, "21"),
            Player("Jack", "Quinn", NhlPosition.RIGHT_WING, "22"),
            Player("Mattias", "Samuelsson", NhlPosition.DEFENSE, "23"),
            Player("Owen", "Power", NhlPosition.DEFENSE, "25"),
            Player("Rasmus", "Dahlin", NhlPosition.DEFENSE, "26"),
            Player("Zac", "Jones", NhlPosition.DEFENSE, "28"),
            Player("Beck", "Malenstyn", NhlPosition.LEFT_WING, "29"),
            Player("Alex", "Lyon", NhlPosition.GOALIE, "34"),
            Player("Alexandar", "Georgiev", NhlPosition.GOALIE, "40"),
            Player("Josh", "Dunne", NhlPosition.CENTER, "44"),
            Player("Tyson", "Kozak", NhlPosition.CENTER, "48"),
            Player("Isak", "Rosen", NhlPosition.RIGHT_WING, "63"),
            Player("Ryan", "McLeod", NhlPosition.CENTER, "71"),
            Player("Tage", "Thompson", NhlPosition.CENTER, "72"),
            Player("Zach", "Metsa", NhlPosition.DEFENSE, "73"),
            Player("Jacob", "Bryson", NhlPosition.DEFENSE, "78"),
            Player("Noah", "Ostlund", NhlPosition.CENTER, "86"),
            Player("Alex", "Tuch", NhlPosition.RIGHT_WING, "89"),
            Player("Josh", "Doan", NhlPosition.RIGHT_WING, "91"),
            Player("Colten", "Ellis", NhlPosition.GOALIE, "92"),
        ),
    )
}

private val nhlTeamCgy by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Calgary Flames",
        nameWidthPercent = 58.8f,
        abbreviation = "CGY",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFDD1A32),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Scotiabank Saddledome",
            location = VenueLocation(
                lat = 51.037500,
                long = -114.051944,
            ),
        ),
        roster = listOf(
            Player("Devin", "Cooley", NhlPosition.GOALIE, "1"),
            Player("Rasmus", "Andersson", NhlPosition.DEFENSE, "4"),
            Player("Kevin", "Bahl", NhlPosition.DEFENSE, "7"),
            Player("Jonathan", "Huberdeau", NhlPosition.LEFT_WING, "10"),
            Player("Mikael", "Backlund", NhlPosition.CENTER, "11"),
            Player("Morgan", "Frost", NhlPosition.CENTER, "16"),
            Player("Yegor", "Sharangovich", NhlPosition.CENTER, "17"),
            Player("John", "Beecher", NhlPosition.CENTER, "18"),
            Player("Zayne", "Parekh", NhlPosition.DEFENSE, "19"),
            Player("Blake", "Coleman", NhlPosition.LEFT_WING, "20"),
            Player("Justin", "Kirkland", NhlPosition.CENTER, "23"),
            Player("Jake", "Bean", NhlPosition.DEFENSE, "24"),
            Player("Matt", "Coronato", NhlPosition.RIGHT_WING, "27"),
            Player("Samuel", "Honzek", NhlPosition.LEFT_WING, "29"),
            Player("Dustin", "Wolf", NhlPosition.GOALIE, "32"),
            Player("Yan", "Kuznetsov", NhlPosition.DEFENSE, "37"),
            Player("Adam", "Klapka", NhlPosition.RIGHT_WING, "43"),
            Player("Joel", "Hanley", NhlPosition.DEFENSE, "44"),
            Player("Sam", "Morton", NhlPosition.CENTER, "45"),
            Player("Connor", "Zary", NhlPosition.CENTER, "47"),
            Player("Hunter", "Brzustewicz", NhlPosition.DEFENSE, "48"),
            Player("MacKenzie", "Weegar", NhlPosition.DEFENSE, "52"),
            Player("Ryan", "Lomberg", NhlPosition.LEFT_WING, "70"),
            Player("Martin", "Pospisil", NhlPosition.CENTER, "76"),
            Player("Joel", "Farabee", NhlPosition.LEFT_WING, "86"),
            Player("Nazem", "Kadri", NhlPosition.CENTER, "91"),
            Player("Brayden", "Pachal", NhlPosition.DEFENSE, "94"),
        ),
    )
}

private val nhlTeamCar by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Carolina Hurricanes",
        nameWidthPercent = 76.7f,
        abbreviation = "CAR",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFE30426),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Lenovo Center",
            location = VenueLocation(
                lat = 35.803333,
                long = -78.721944,
            ),
        ),
        roster = listOf(
            Player("Shayne", "Gostisbehere", NhlPosition.DEFENSE, "4"),
            Player("Jalen", "Chatfield", NhlPosition.DEFENSE, "5"),
            Player("Mike", "Reilly", NhlPosition.DEFENSE, "6"),
            Player("Jordan", "Staal", NhlPosition.CENTER, "11"),
            Player("K'Andre", "Miller", NhlPosition.DEFENSE, "19"),
            Player("Sebastian", "Aho", NhlPosition.CENTER, "20"),
            Player("Alexander", "Nikishin", NhlPosition.DEFENSE, "21"),
            Player("Logan", "Stankoven", NhlPosition.CENTER, "22"),
            Player("Josiah", "Slavin", NhlPosition.LEFT_WING, "23"),
            Player("Seth", "Jarvis", NhlPosition.CENTER, "24"),
            Player("Sean", "Walker", NhlPosition.DEFENSE, "26"),
            Player("Nikolaj", "Ehlers", NhlPosition.LEFT_WING, "27"),
            Player("William", "Carrier", NhlPosition.LEFT_WING, "28"),
            Player("Bradly", "Nadeau", NhlPosition.LEFT_WING, "29"),
            Player("Frederik", "Andersen", NhlPosition.GOALIE, "31"),
            Player("Brandon", "Bussi", NhlPosition.GOALIE, "32"),
            Player("Andrei", "Svechnikov", NhlPosition.RIGHT_WING, "37"),
            Player("Jordan", "Martinook", NhlPosition.LEFT_WING, "48"),
            Player("Eric", "Robinson", NhlPosition.LEFT_WING, "50"),
            Player("Pyotr", "Kochetkov", NhlPosition.GOALIE, "52"),
            Player("Jackson", "Blake", NhlPosition.RIGHT_WING, "53"),
            Player("Charles-Alexis", "Legault", NhlPosition.DEFENSE, "62"),
            Player("Joel", "Nystrom", NhlPosition.DEFENSE, "64"),
            Player("Taylor", "Hall", NhlPosition.LEFT_WING, "71"),
            Player("Jaccob", "Slavin", NhlPosition.DEFENSE, "74"),
            Player("Mark", "Jankowski", NhlPosition.CENTER, "77"),
            Player("Jesperi", "Kotkaniemi", NhlPosition.CENTER, "82"),
        ),
    )
}

private val nhlTeamChi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Chicago Blackhawks",
        nameWidthPercent = 79.4f,
        abbreviation = "CHI",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFE31937),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "United Center",
            location = VenueLocation(
                lat = 41.880556,
                long = -87.674167,
            ),
        ),
        roster = listOf(
            Player("Connor", "Murphy", NhlPosition.DEFENSE, "5"),
            Player("Ryan", "Donato", NhlPosition.CENTER, "8"),
            Player("Oliver", "Moore", NhlPosition.CENTER, "11"),
            Player("Jason", "Dickinson", NhlPosition.CENTER, "16"),
            Player("Nick", "Foligno", NhlPosition.LEFT_WING, "17"),
            Player("Ryan", "Greene", NhlPosition.CENTER, "20"),
            Player("Sam", "Lafferty", NhlPosition.CENTER, "24"),
            Player("Dominic", "Toninato", NhlPosition.CENTER, "25"),
            Player("Andre", "Burakovsky", NhlPosition.LEFT_WING, "28"),
            Player("Spencer", "Knight", NhlPosition.GOALIE, "30"),
            Player("Colton", "Dach", NhlPosition.CENTER, "34"),
            Player("Ethan", "Del Mastro", NhlPosition.DEFENSE, "38"),
            Player("Arvid", "Soderblom", NhlPosition.GOALIE, "40"),
            Player("Wyatt", "Kaiser", NhlPosition.DEFENSE, "44"),
            Player("Louis", "Crevier", NhlPosition.DEFENSE, "46"),
            Player("Matt", "Grzelcyk", NhlPosition.DEFENSE, "48"),
            Player("Artyom", "Levshunov", NhlPosition.DEFENSE, "55"),
            Player("Tyler", "Bertuzzi", NhlPosition.LEFT_WING, "59"),
            Player("Brett", "Seney", NhlPosition.LEFT_WING, "62"),
            Player("Alex", "Vlasic", NhlPosition.DEFENSE, "72"),
            Player("Nick", "Lardis", NhlPosition.LEFT_WING, "76"),
            Player("Cavan", "Fitzgerald", NhlPosition.DEFENSE, "79"),
            Player("Teuvo", "Teravainen", NhlPosition.CENTER, "86"),
            Player("Frank", "Nazar", NhlPosition.CENTER, "91"),
            Player("Ilya", "Mikheyev", NhlPosition.RIGHT_WING, "95"),
            Player("Connor", "Bedard", NhlPosition.CENTER, "98"),
        ),
    )
}

private val nhlTeamCol by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Colorado Avalanche",
        nameWidthPercent = 78.4f,
        abbreviation = "COL",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF860038),
            nameAccent = Color(0xFF005EA3),
        ),
        venue = TeamVenue(
            name = "Pepsi Center",
            location = VenueLocation(
                lat = 39.748611,
                long = -105.007500,
            ),
        ),
        roster = listOf(
            Player("Devon", "Toews", NhlPosition.DEFENSE, "7"),
            Player("Cale", "Makar", NhlPosition.DEFENSE, "8"),
            Player("Brock", "Nelson", NhlPosition.CENTER, "11"),
            Player("Valeri", "Nichushkin", NhlPosition.RIGHT_WING, "13"),
            Player("Jason", "Polin", NhlPosition.RIGHT_WING, "14"),
            Player("Jack", "Ahcan", NhlPosition.DEFENSE, "15"),
            Player("Taylor", "Makar", NhlPosition.LEFT_WING, "16"),
            Player("Parker", "Kelly", NhlPosition.CENTER, "17"),
            Player("Jack", "Drury", NhlPosition.CENTER, "18"),
            Player("Ross", "Colton", NhlPosition.CENTER, "20"),
            Player("Ilya", "Solovyov", NhlPosition.DEFENSE, "28"),
            Player("Nathan", "MacKinnon", NhlPosition.CENTER, "29"),
            Player("Mackenzie", "Blackwood", NhlPosition.GOALIE, "39"),
            Player("Scott", "Wedgewood", NhlPosition.GOALIE, "41"),
            Player("Josh", "Manson", NhlPosition.DEFENSE, "42"),
            Player("Samuel", "Girard", NhlPosition.DEFENSE, "49"),
            Player("Trent", "Miner", NhlPosition.GOALIE, "50"),
            Player("Gavin", "Brindley", NhlPosition.CENTER, "54"),
            Player("Artturi", "Lehkonen", NhlPosition.LEFT_WING, "62"),
            Player("Sam", "Malinski", NhlPosition.DEFENSE, "70"),
            Player("Danil", "Gushchin", NhlPosition.LEFT_WING, "75"),
            Player("Brent", "Burns", NhlPosition.DEFENSE, "84"),
            Player("Martin", "Necas", NhlPosition.CENTER, "88"),
            Player("Gabriel", "Landeskog", NhlPosition.LEFT_WING, "92"),
            Player("Zakhar", "Bardakov", NhlPosition.CENTER, "93"),
            Player("Joel", "Kiviranta", NhlPosition.LEFT_WING, "94"),
            Player("Victor", "Olofsson", NhlPosition.LEFT_WING, "95"),
        ),
    )
}

private val nhlTeamCbj by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Columbus Blue Jackets",
        nameWidthPercent = 89.5f,
        abbreviation = "CBJ",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF002D62),
            nameAccent = Color(0xFFE31937),
        ),
        venue = TeamVenue(
            name = "Nationwide Arena",
            location = VenueLocation(
                lat = 39.969283,
                long = -83.006111,
            ),
        ),
        roster = listOf(
            Player("Jake", "Christiansen", NhlPosition.DEFENSE, "2"),
            Player("Charlie", "Coyle", NhlPosition.CENTER, "3"),
            Player("Cole", "Sillinger", NhlPosition.CENTER, "4"),
            Player("Denton", "Mateychuk", NhlPosition.DEFENSE, "5"),
            Player("Brendan", "Smith", NhlPosition.DEFENSE, "7"),
            Player("Zach", "Werenski", NhlPosition.DEFENSE, "8"),
            Player("Ivan", "Provorov", NhlPosition.DEFENSE, "9"),
            Player("Dmitri", "Voronkov", NhlPosition.LEFT_WING, "10"),
            Player("Miles", "Wood", NhlPosition.LEFT_WING, "11"),
            Player("Dante", "Fabbro", NhlPosition.DEFENSE, "15"),
            Player("Brendan", "Gaunce", NhlPosition.CENTER, "16"),
            Player("Mason", "Marchment", NhlPosition.LEFT_WING, "17"),
            Player("Adam", "Fantilli", NhlPosition.CENTER, "19"),
            Player("Isac", "Lundestrom", NhlPosition.CENTER, "21"),
            Player("Sean", "Monahan", NhlPosition.CENTER, "23"),
            Player("Zachary", "Aston-Reese", NhlPosition.CENTER, "27"),
            Player("Dysin", "Mayo", NhlPosition.DEFENSE, "37"),
            Player("Boone", "Jenner", NhlPosition.CENTER, "38"),
            Player("Erik", "Gudbranson", NhlPosition.DEFENSE, "44"),
            Player("Yegor", "Chinakhov", NhlPosition.RIGHT_WING, "59"),
            Player("Jet", "Greaves", NhlPosition.GOALIE, "73"),
            Player("Damon", "Severson", NhlPosition.DEFENSE, "78"),
            Player("Kirill", "Marchenko", NhlPosition.RIGHT_WING, "86"),
            Player("Elvis", "Merzlikins", NhlPosition.GOALIE, "90"),
            Player("Kent", "Johnson", NhlPosition.CENTER, "91"),
        ),
    )
}

private val nhlTeamDal by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Dallas Stars",
        nameWidthPercent = 45.3f,
        abbreviation = "DAL",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF20864C),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "American Airlines Center",
            location = VenueLocation(
                lat = 32.790556,
                long = -96.810278,
            ),
        ),
        roster = listOf(
            Player("Casey", "DeSmith", NhlPosition.GOALIE, "1"),
            Player("Miro", "Heiskanen", NhlPosition.DEFENSE, "4"),
            Player("Nils", "Lundkvist", NhlPosition.DEFENSE, "5"),
            Player("Oskar", "Back", NhlPosition.CENTER, "10"),
            Player("Nathan", "Bastian", NhlPosition.RIGHT_WING, "11"),
            Player("Radek", "Faksa", NhlPosition.CENTER, "12"),
            Player("Jamie", "Benn", NhlPosition.LEFT_WING, "14"),
            Player("Colin", "Blackwell", NhlPosition.CENTER, "15"),
            Player("Sam", "Steel", NhlPosition.CENTER, "18"),
            Player("Kyle", "Capobianco", NhlPosition.DEFENSE, "20"),
            Player("Jason", "Robertson", NhlPosition.LEFT_WING, "21"),
            Player("Mavrik", "Bourque", NhlPosition.CENTER, "22"),
            Player("Esa", "Lindell", NhlPosition.DEFENSE, "23"),
            Player("Roope", "Hintz", NhlPosition.CENTER, "24"),
            Player("Trey", "Taylor", NhlPosition.DEFENSE, "27"),
            Player("Alexander", "Petrovic", NhlPosition.DEFENSE, "28"),
            Player("Jake", "Oettinger", NhlPosition.GOALIE, "29"),
            Player("Luke", "Krys", NhlPosition.DEFENSE, "36"),
            Player("Harrison", "Scott", NhlPosition.CENTER, "37"),
            Player("Kyle", "McDonald", NhlPosition.RIGHT_WING, "40"),
            Player("Ilya", "Lyubushkin", NhlPosition.DEFENSE, "46"),
            Player("Chase", "Wheatcroft", NhlPosition.CENTER, "48"),
            Player("Justin", "Hryckowian", NhlPosition.CENTER, "49"),
            Player("Wyatt", "Johnston", NhlPosition.CENTER, "53"),
            Player("Thomas", "Harley", NhlPosition.DEFENSE, "55"),
            Player("Adam", "Erne", NhlPosition.LEFT_WING, "73"),
            Player("Tyler", "Seguin", NhlPosition.CENTER, "91"),
            Player("Matt", "Duchene", NhlPosition.CENTER, "95"),
            Player("Mikko", "Rantanen", NhlPosition.RIGHT_WING, "96"),
        ),
    )
}

private val nhlTeamDet by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Detroit Red Wings",
        nameWidthPercent = 69.9f,
        abbreviation = "DET",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFE30526),
            nameAccent = Color(0xFFFFFFFF),
        ),
        venue = TeamVenue(
            name = "Little Caesars Arena",
            location = VenueLocation(
                lat = 42.341200,
                long = -83.054900,
            ),
        ),
        roster = listOf(
            Player("Justin", "Holl", NhlPosition.DEFENSE, "3"),
            Player("Ben", "Chiarot", NhlPosition.DEFENSE, "8"),
            Player("Andrew", "Copp", NhlPosition.CENTER, "18"),
            Player("Albert", "Johansson", NhlPosition.DEFENSE, "20"),
            Player("James", "van Riemsdyk", NhlPosition.LEFT_WING, "21"),
            Player("Mason", "Appleton", NhlPosition.CENTER, "22"),
            Player("Lucas", "Raymond", NhlPosition.LEFT_WING, "23"),
            Player("Jacob", "Bernard-Docker", NhlPosition.DEFENSE, "25"),
            Player("Michael", "Rasmussen", NhlPosition.CENTER, "27"),
            Player("Nate", "Danielson", NhlPosition.CENTER, "29"),
            Player("John", "Gibson", NhlPosition.GOALIE, "36"),
            Player("J.T.", "Compher", NhlPosition.LEFT_WING, "37"),
            Player("Cam", "Talbot", NhlPosition.GOALIE, "39"),
            Player("Axel", "Sandin-Pellikka", NhlPosition.DEFENSE, "44"),
            Player("Travis", "Hamonic", NhlPosition.DEFENSE, "52"),
            Player("Moritz", "Seider", NhlPosition.DEFENSE, "53"),
            Player("Emmitt", "Finnie", NhlPosition.CENTER, "58"),
            Player("Dylan", "Larkin", NhlPosition.CENTER, "71"),
            Player("John", "Leonard", NhlPosition.LEFT_WING, "71"),
            Player("Simon", "Edvinsson", NhlPosition.DEFENSE, "77"),
            Player("Elmer", "Soderblom", NhlPosition.LEFT_WING, "85"),
            Player("Patrick", "Kane", NhlPosition.RIGHT_WING, "88"),
            Player("Marco", "Kasper", NhlPosition.CENTER, "92"),
            Player("Alex", "DeBrincat", NhlPosition.RIGHT_WING, "93"),
        ),
    )
}

private val nhlTeamEdm by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Edmonton Oilers",
        nameWidthPercent = 64.5f,
        abbreviation = "EDM",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF00205B),
            nameAccent = Color(0xFFFF4C00),
        ),
        venue = TeamVenue(
            name = "Rogers Place",
            location = VenueLocation(
                lat = 53.546944,
                long = -113.497778,
            ),
        ),
        roster = listOf(
            Player("Evan", "Bouchard", NhlPosition.DEFENSE, "2"),
            Player("Trent", "Frederic", NhlPosition.CENTER, "10"),
            Player("Mattias", "Janmark", NhlPosition.CENTER, "13"),
            Player("Mattias", "Ekholm", NhlPosition.DEFENSE, "14"),
            Player("Zach", "Hyman", NhlPosition.LEFT_WING, "18"),
            Player("Adam", "Henrique", NhlPosition.CENTER, "19"),
            Player("Curtis", "Lazar", NhlPosition.CENTER, "20"),
            Player("Sam", "Poulin", NhlPosition.RIGHT_WING, "22"),
            Player("Matt", "Savoie", NhlPosition.CENTER, "22"),
            Player("Spencer", "Stastney", NhlPosition.DEFENSE, "24"),
            Player("Darnell", "Nurse", NhlPosition.DEFENSE, "25"),
            Player("Jack", "Roslovic", NhlPosition.CENTER, "28"),
            Player("Leon", "Draisaitl", NhlPosition.CENTER, "29"),
            Player("Calvin", "Pickard", NhlPosition.GOALIE, "30"),
            Player("Tristan", "Jarry", NhlPosition.GOALIE, "35"),
            Player("Connor", "Ingram", NhlPosition.GOALIE, "39"),
            Player("Max", "Jones", NhlPosition.LEFT_WING, "46"),
            Player("Noah", "Philp", NhlPosition.CENTER, "48"),
            Player("Ty", "Emberson", NhlPosition.DEFENSE, "49"),
            Player("James", "Hamblin", NhlPosition.LEFT_WING, "52"),
            Player("Isaac", "Howard", NhlPosition.LEFT_WING, "53"),
            Player("Riley", "Stillman", NhlPosition.DEFENSE, "61"),
            Player("Connor", "Clattenburg", NhlPosition.CENTER, "64"),
            Player("Alec", "Regula", NhlPosition.DEFENSE, "75"),
            Player("David", "Tomasek", NhlPosition.RIGHT_WING, "86"),
            Player("Andrew", "Mangiapane", NhlPosition.LEFT_WING, "88"),
            Player("Vasily", "Podkolzin", NhlPosition.RIGHT_WING, "92"),
            Player("Ryan", "Nugent-Hopkins", NhlPosition.CENTER, "93"),
            Player("Jake", "Walman", NhlPosition.DEFENSE, "96"),
            Player("Connor", "McDavid", NhlPosition.CENTER, "97"),
        ),
    )
}

private val nhlTeamFla by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Florida Panthers",
        nameWidthPercent = 63.2f,
        abbreviation = "FLA",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFE51937),
            nameAccent = Color(0xFF002D62),
        ),
        venue = TeamVenue(
            name = "BB&T Center",
            location = VenueLocation(
                lat = 26.158333,
                long = -80.325556,
            ),
        ),
        roster = listOf(
            Player("Jeff", "Petry", NhlPosition.DEFENSE, "2"),
            Player("Seth", "Jones", NhlPosition.DEFENSE, "3"),
            Player("Aaron", "Ekblad", NhlPosition.DEFENSE, "5"),
            Player("Donovan", "Sebrango", NhlPosition.DEFENSE, "6"),
            Player("Dmitry", "Kulikov", NhlPosition.DEFENSE, "7"),
            Player("Sam", "Bennett", NhlPosition.CENTER, "9"),
            Player("A.J.", "Greer", NhlPosition.LEFT_WING, "10"),
            Player("Mackie", "Samoskevich", NhlPosition.RIGHT_WING, "11"),
            Player("Jonah", "Gadjovich", NhlPosition.LEFT_WING, "12"),
            Player("Sam", "Reinhart", NhlPosition.CENTER, "13"),
            Player("Anton", "Lundell", NhlPosition.CENTER, "15"),
            Player("Aleksander", "Barkov", NhlPosition.CENTER, "16"),
            Player("Evan", "Rodrigues", NhlPosition.CENTER, "17"),
            Player("Noah", "Gregor", NhlPosition.LEFT_WING, "18"),
            Player("Matthew", "Tkachuk", NhlPosition.LEFT_WING, "19"),
            Player("Carter", "Verhaeghe", NhlPosition.CENTER, "23"),
            Player("Uvis", "Balinskis", NhlPosition.DEFENSE, "26"),
            Player("Eetu", "Luostarinen", NhlPosition.CENTER, "27"),
            Player("Daniil", "Tarasov", NhlPosition.GOALIE, "40"),
            Player("Gustav", "Forsling", NhlPosition.DEFENSE, "42"),
            Player("Jack", "Studnicka", NhlPosition.CENTER, "53"),
            Player("Brad", "Marchand", NhlPosition.LEFT_WING, "63"),
            Player("Jesper", "Boqvist", NhlPosition.CENTER, "70"),
            Player("Luke", "Kunin", NhlPosition.CENTER, "71"),
            Player("Sergei", "Bobrovsky", NhlPosition.GOALIE, "72"),
            Player("Niko", "Mikkola", NhlPosition.DEFENSE, "77"),
        ),
    )
}

private val nhlTeamLa by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Los Angeles Kings",
        nameWidthPercent = 69.3f,
        abbreviation = "LA",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF121212),
            nameAccent = Color(0xFFA2AAAD),
        ),
        venue = TeamVenue(
            name = "Crypto.com Arena",
            location = VenueLocation(
                lat = 34.043056,
                long = -118.267222,
            ),
        ),
        roster = listOf(
            Player("Erik", "Portillo", NhlPosition.GOALIE, "1"),
            Player("Brian", "Dumoulin", NhlPosition.DEFENSE, "2"),
            Player("Cody", "Ceci", NhlPosition.DEFENSE, "5"),
            Player("Joel", "Edmundson", NhlPosition.DEFENSE, "6"),
            Player("Drew", "Doughty", NhlPosition.DEFENSE, "8"),
            Player("Adrian", "Kempe", NhlPosition.RIGHT_WING, "9"),
            Player("Corey", "Perry", NhlPosition.RIGHT_WING, "10"),
            Player("Anze", "Kopitar", NhlPosition.CENTER, "11"),
            Player("Trevor", "Moore", NhlPosition.LEFT_WING, "12"),
            Player("Alex", "Laferriere", NhlPosition.RIGHT_WING, "14"),
            Player("Alex", "Turcotte", NhlPosition.CENTER, "15"),
            Player("Kevin", "Fiala", NhlPosition.LEFT_WING, "22"),
            Player("Anton", "Forsberg", NhlPosition.GOALIE, "31"),
            Player("Darcy", "Kuemper", NhlPosition.GOALIE, "35"),
            Player("Warren", "Foegele", NhlPosition.LEFT_WING, "37"),
            Player("Pheonix", "Copley", NhlPosition.GOALIE, "39"),
            Player("Jeff", "Malott", NhlPosition.LEFT_WING, "39"),
            Player("Joel", "Armia", NhlPosition.RIGHT_WING, "40"),
            Player("Jacob", "Moverare", NhlPosition.DEFENSE, "43"),
            Player("Mikey", "Anderson", NhlPosition.DEFENSE, "44"),
            Player("Quinton", "Byfield", NhlPosition.RIGHT_WING, "55"),
            Player("Samuel", "Helenius", NhlPosition.CENTER, "79"),
            Player("Brandt", "Clarke", NhlPosition.DEFENSE, "92"),
            Player("Andrei", "Kuzmenko", NhlPosition.LEFT_WING, "96"),
        ),
    )
}

private val nhlTeamMin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Minnesota Wild",
        nameWidthPercent = 59.8f,
        abbreviation = "MIN",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF124734),
            nameAccent = Color(0xFFAE122A),
        ),
        venue = TeamVenue(
            name = "Grand Casino Arena",
            location = VenueLocation(
                lat = 44.944722,
                long = -93.101111,
            ),
        ),
        roster = listOf(
            Player("Jake", "Middleton", NhlPosition.DEFENSE, "5"),
            Player("Brock", "Faber", NhlPosition.DEFENSE, "7"),
            Player("Matt", "Boldy", NhlPosition.LEFT_WING, "12"),
            Player("Yakov", "Trenin", NhlPosition.CENTER, "13"),
            Player("Joel", "Eriksson Ek", NhlPosition.CENTER, "14"),
            Player("Marcus", "Foligno", NhlPosition.LEFT_WING, "17"),
            Player("Vinnie", "Hinostroza", NhlPosition.CENTER, "18"),
            Player("Tyler", "Pitlick", NhlPosition.CENTER, "19"),
            Player("Danila", "Yurov", NhlPosition.RIGHT_WING, "22"),
            Player("Zach", "Bogosian", NhlPosition.DEFENSE, "24"),
            Player("Jonas", "Brodin", NhlPosition.DEFENSE, "25"),
            Player("Matt", "Kiersted", NhlPosition.DEFENSE, "26"),
            Player("Jesper", "Wallstedt", NhlPosition.GOALIE, "30"),
            Player("Filip", "Gustavsson", NhlPosition.GOALIE, "32"),
            Player("Mats", "Zuccarello", NhlPosition.RIGHT_WING, "36"),
            Player("Ryan", "Hartman", NhlPosition.RIGHT_WING, "38"),
            Player("Quinn", "Hughes", NhlPosition.DEFENSE, "43"),
            Player("Jared", "Spurgeon", NhlPosition.DEFENSE, "46"),
            Player("Daemon", "Hunt", NhlPosition.DEFENSE, "48"),
            Player("David", "Jiricek", NhlPosition.DEFENSE, "55"),
            Player("Carson", "Lambos", NhlPosition.DEFENSE, "71"),
            Player("Nico", "Sturm", NhlPosition.CENTER, "78"),
            Player("Marcus", "Johansson", NhlPosition.LEFT_WING, "90"),
            Player("Vladimir", "Tarasenko", NhlPosition.RIGHT_WING, "91"),
            Player("Kirill", "Kaprizov", NhlPosition.LEFT_WING, "97"),
        ),
    )
}

private val nhlTeamMtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Montreal Canadiens",
        nameWidthPercent = 77.7f,
        abbreviation = "MTL",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFC41230),
            nameAccent = Color(0xFF013A81),
        ),
        venue = TeamVenue(
            name = "Centre Bell",
            location = VenueLocation(
                lat = 46.418131,
                long = -63.808561,
            ),
        ),
        roster = listOf(
            Player("Mike", "Matheson", NhlPosition.DEFENSE, "8"),
            Player("Brendan", "Gallagher", NhlPosition.RIGHT_WING, "11"),
            Player("Cole", "Caufield", NhlPosition.RIGHT_WING, "13"),
            Player("Nick", "Suzuki", NhlPosition.CENTER, "14"),
            Player("Alex", "Newhook", NhlPosition.CENTER, "15"),
            Player("Josh", "Anderson", NhlPosition.RIGHT_WING, "17"),
            Player("Juraj", "Slafkovsky", NhlPosition.LEFT_WING, "20"),
            Player("Kaiden", "Guhle", NhlPosition.DEFENSE, "21"),
            Player("Phillip", "Danault", NhlPosition.CENTER, "24"),
            Player("Sammy", "Blais", NhlPosition.LEFT_WING, "27"),
            Player("Jacob", "Fowler", NhlPosition.GOALIE, "32"),
            Player("Kaapo", "Kahkonen", NhlPosition.GOALIE, "34"),
            Player("Adam", "Engstrom", NhlPosition.DEFENSE, "42"),
            Player("Alexandre", "Carrier", NhlPosition.DEFENSE, "45"),
            Player("Jayden", "Struble", NhlPosition.DEFENSE, "47"),
            Player("Lane", "Hutson", NhlPosition.DEFENSE, "48"),
            Player("Noah", "Dobson", NhlPosition.DEFENSE, "53"),
            Player("Owen", "Beck", NhlPosition.CENTER, "62"),
            Player("Florian", "Xhekaj", NhlPosition.LEFT_WING, "63"),
            Player("Jake", "Evans", NhlPosition.CENTER, "71"),
            Player("Arber", "Xhekaj", NhlPosition.DEFENSE, "72"),
            Player("Jakub", "Dobes", NhlPosition.GOALIE, "75"),
            Player("Zack", "Bolduc", NhlPosition.CENTER, "76"),
            Player("Kirby", "Dach", NhlPosition.CENTER, "77"),
            Player("Alexandre", "Texier", NhlPosition.LEFT_WING, "85"),
            Player("Joe", "Veleno", NhlPosition.CENTER, "90"),
            Player("Oliver", "Kapanen", NhlPosition.CENTER, "91"),
            Player("Patrik", "Laine", NhlPosition.RIGHT_WING, "92"),
            Player("Ivan", "Demidov", NhlPosition.RIGHT_WING, "93"),
        ),
    )
}

private val nhlTeamNsh by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Nashville Predators",
        nameWidthPercent = 75.3f,
        abbreviation = "NSH",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFFDBA31),
            nameAccent = Color(0xFF002D62),
        ),
        venue = TeamVenue(
            name = "Bridgestone Arena",
            location = VenueLocation(
                lat = 36.159167,
                long = -86.778611,
            ),
        ),
        roster = listOf(
            Player("Filip", "Forsberg", NhlPosition.LEFT_WING, "9"),
            Player("Tyson", "Jost", NhlPosition.CENTER, "17"),
            Player("Justin", "Barron", NhlPosition.DEFENSE, "20"),
            Player("Justus", "Annunen", NhlPosition.GOALIE, "29"),
            Player("Cole", "Smith", NhlPosition.RIGHT_WING, "36"),
            Player("Nick", "Blankenburg", NhlPosition.DEFENSE, "37"),
            Player("Fedor", "Svechkov", NhlPosition.CENTER, "40"),
            Player("Nicolas", "Hague", NhlPosition.DEFENSE, "41"),
            Player("Brady", "Martin", NhlPosition.CENTER, "44"),
            Player("Michael", "McCarron", NhlPosition.RIGHT_WING, "47"),
            Player("Nick", "Perbix", NhlPosition.DEFENSE, "48"),
            Player("Reid", "Schaefer", NhlPosition.LEFT_WING, "49"),
            Player("Erik", "Haula", NhlPosition.LEFT_WING, "56"),
            Player("Michael", "Bunting", NhlPosition.LEFT_WING, "58"),
            Player("Roman", "Josi", NhlPosition.DEFENSE, "59"),
            Player("Matthew", "Wood", NhlPosition.RIGHT_WING, "71"),
            Player("Juuse", "Saros", NhlPosition.GOALIE, "74"),
            Player("Isaac", "Ratcliffe", NhlPosition.LEFT_WING, "76"),
            Player("Brady", "Skjei", NhlPosition.DEFENSE, "76"),
            Player("Luke", "Evangelista", NhlPosition.RIGHT_WING, "77"),
            Player("Jonathan", "Marchessault", NhlPosition.RIGHT_WING, "81"),
            Player("Adam", "Wilsby", NhlPosition.DEFENSE, "83"),
            Player("Ozzy", "Wiesblatt", NhlPosition.CENTER, "89"),
            Player("Ryan", "O'Reilly", NhlPosition.CENTER, "90"),
            Player("Steven", "Stamkos", NhlPosition.CENTER, "91"),
            Player("Oasiz", "Wiesblatt", NhlPosition.CENTER, "97"),
        ),
    )
}

private val nhlTeamNj by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New Jersey Devils",
        nameWidthPercent = 69.6f,
        abbreviation = "NJ",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFE30B2B),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Prudential Center",
            location = VenueLocation(
                lat = 40.733611,
                long = -74.171111,
            ),
        ),
        roster = listOf(
            Player("Brenden", "Dillon", NhlPosition.DEFENSE, "5"),
            Player("Dougie", "Hamilton", NhlPosition.DEFENSE, "7"),
            Player("Johnathan", "Kovacevic", NhlPosition.DEFENSE, "8"),
            Player("Stefan", "Noesen", NhlPosition.RIGHT_WING, "11"),
            Player("Cody", "Glass", NhlPosition.CENTER, "12"),
            Player("Nico", "Hischier", NhlPosition.CENTER, "13"),
            Player("Luke", "Glendening", NhlPosition.CENTER, "14"),
            Player("Zack", "MacEwen", NhlPosition.RIGHT_WING, "15"),
            Player("Connor", "Brown", NhlPosition.RIGHT_WING, "16"),
            Player("Simon", "Nemec", NhlPosition.DEFENSE, "17"),
            Player("Ondrej", "Palat", NhlPosition.LEFT_WING, "18"),
            Player("Marc", "McLaughlin", NhlPosition.CENTER, "21"),
            Player("Brett", "Pesce", NhlPosition.DEFENSE, "22"),
            Player("Jacob", "Markstrom", NhlPosition.GOALIE, "25"),
            Player("Timo", "Meier", NhlPosition.RIGHT_WING, "28"),
            Player("Lenni", "Hameenaho", NhlPosition.RIGHT_WING, "29"),
            Player("Evgenii", "Dadonov", NhlPosition.RIGHT_WING, "33"),
            Player("Jake", "Allen", NhlPosition.GOALIE, "34"),
            Player("Angus", "Crookshank", NhlPosition.LEFT_WING, "36"),
            Player("Luke", "Hughes", NhlPosition.DEFENSE, "43"),
            Player("Dennis", "Cholowski", NhlPosition.DEFENSE, "44"),
            Player("Colton", "White", NhlPosition.DEFENSE, "45"),
            Player("Paul", "Cotter", NhlPosition.CENTER, "47"),
            Player("Jesper", "Bratt", NhlPosition.LEFT_WING, "63"),
            Player("Jonas", "Siegenthaler", NhlPosition.DEFENSE, "71"),
            Player("Arseny", "Gritsyuk", NhlPosition.RIGHT_WING, "81"),
            Player("Juho", "Lammikko", NhlPosition.LEFT_WING, "83"),
            Player("Jack", "Hughes", NhlPosition.CENTER, "86"),
            Player("Dawson", "Mercer", NhlPosition.CENTER, "91"),
        ),
    )
}

private val nhlTeamNyi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Islanders",
        nameWidthPercent = 73.6f,
        abbreviation = "NYI",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF00529B),
            nameAccent = Color(0xFFF47D31),
        ),
        venue = TeamVenue(
            name = "Nassau Coliseum",
            location = VenueLocation(
                lat = 40.722778,
                long = -73.590556,
            ),
        ),
        roster = listOf(
            Player("Adam", "Pelech", NhlPosition.DEFENSE, "3"),
            Player("Ryan", "Pulock", NhlPosition.DEFENSE, "6"),
            Player("Maxim", "Tsyplakov", NhlPosition.RIGHT_WING, "7"),
            Player("Simon", "Holmstrom", NhlPosition.RIGHT_WING, "10"),
            Player("Anthony", "Duclair", NhlPosition.LEFT_WING, "11"),
            Player("Mathew", "Barzal", NhlPosition.CENTER, "13"),
            Player("Bo", "Horvat", NhlPosition.CENTER, "14"),
            Player("Marc", "Gatcomb", NhlPosition.CENTER, "16"),
            Player("Kyle", "Palmieri", NhlPosition.CENTER, "21"),
            Player("Scott", "Mayfield", NhlPosition.DEFENSE, "24"),
            Player("Anders", "Lee", NhlPosition.LEFT_WING, "27"),
            Player("Alexander", "Romanov", NhlPosition.DEFENSE, "28"),
            Player("Jonathan", "Drouin", NhlPosition.LEFT_WING, "29"),
            Player("Ilya", "Sorokin", NhlPosition.GOALIE, "30"),
            Player("Kyle", "MacLean", NhlPosition.CENTER, "32"),
            Player("David", "Rittich", NhlPosition.GOALIE, "33"),
            Player("Adam", "Boqvist", NhlPosition.DEFENSE, "34"),
            Player("Semyon", "Varlamov", NhlPosition.GOALIE, "40"),
            Player("Marshall", "Warren", NhlPosition.DEFENSE, "41"),
            Player("Jean-Gabriel", "Pageau", NhlPosition.CENTER, "44"),
            Player("Matthew", "Schaefer", NhlPosition.DEFENSE, "48"),
            Player("Maxim", "Shabanov", NhlPosition.RIGHT_WING, "49"),
            Player("Marcus", "Hogberg", NhlPosition.GOALIE, "50"),
            Player("Emil", "Heineman", NhlPosition.LEFT_WING, "51"),
            Player("Casey", "Cizikas", NhlPosition.CENTER, "53"),
            Player("Calum", "Ritchie", NhlPosition.CENTER, "64"),
            Player("Ethan", "Bear", NhlPosition.DEFENSE, "74"),
            Player("Tony", "DeAngelo", NhlPosition.DEFENSE, "77"),
        ),
    )
}

private val nhlTeamNyr by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Rangers",
        nameWidthPercent = 70.3f,
        abbreviation = "NYR",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF0056AE),
            nameAccent = Color(0xFFE51937),
        ),
        venue = TeamVenue(
            name = "Madison Square Garden",
            location = VenueLocation(
                lat = 40.750556,
                long = -73.993611,
            ),
        ),
        roster = listOf(
            Player("Braden", "Schneider", NhlPosition.DEFENSE, "4"),
            Player("J.T.", "Miller", NhlPosition.LEFT_WING, "8"),
            Player("Artemi", "Panarin", NhlPosition.LEFT_WING, "10"),
            Player("Connor", "Mackey", NhlPosition.DEFENSE, "12"),
            Player("Alexis", "Lafreniere", NhlPosition.LEFT_WING, "13"),
            Player("Taylor", "Raddysh", NhlPosition.RIGHT_WING, "14"),
            Player("Vincent", "Trocheck", NhlPosition.CENTER, "16"),
            Player("Will", "Borgen", NhlPosition.DEFENSE, "17"),
            Player("Urho", "Vaakanainen", NhlPosition.DEFENSE, "18"),
            Player("Jonny", "Brodzinski", NhlPosition.CENTER, "22"),
            Player("Adam", "Fox", NhlPosition.DEFENSE, "23"),
            Player("Carson", "Soucy", NhlPosition.DEFENSE, "24"),
            Player("Matthew", "Robertson", NhlPosition.DEFENSE, "29"),
            Player("Igor", "Shesterkin", NhlPosition.GOALIE, "31"),
            Player("Jonathan", "Quick", NhlPosition.GOALIE, "32"),
            Player("Sam", "Carrick", NhlPosition.CENTER, "39"),
            Player("Noah", "Laba", NhlPosition.CENTER, "42"),
            Player("Conor", "Sheary", NhlPosition.LEFT_WING, "43"),
            Player("Vladislav", "Gavrikov", NhlPosition.DEFENSE, "44"),
            Player("Will", "Cuylle", NhlPosition.LEFT_WING, "50"),
            Player("Scott", "Morrow", NhlPosition.DEFENSE, "60"),
            Player("Brett", "Berard", NhlPosition.LEFT_WING, "65"),
            Player("Juuso", "Parssinen", NhlPosition.CENTER, "71"),
            Player("Matt", "Rempe", NhlPosition.CENTER, "73"),
            Player("Brennan", "Othmann", NhlPosition.LEFT_WING, "78"),
            Player("Adam", "Edstrom", NhlPosition.CENTER, "84"),
            Player("Mika", "Zibanejad", NhlPosition.CENTER, "93"),
            Player("Gabe", "Perreault", NhlPosition.RIGHT_WING, "94"),
        ),
    )
}

private val nhlTeamOtt by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Ottawa Senators",
        nameWidthPercent = 65.9f,
        abbreviation = "OTT",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFDD1A32),
            nameAccent = Color(0xFFB79257),
        ),
        venue = TeamVenue(
            name = "Canadian Tire Centre",
            location = VenueLocation(
                lat = 45.296944,
                long = -75.927222,
            ),
        ),
        roster = listOf(
            Player("Leevi", "Merilainen", NhlPosition.GOALIE, "1"),
            Player("Artem", "Zub", NhlPosition.DEFENSE, "2"),
            Player("Nick", "Jensen", NhlPosition.DEFENSE, "3"),
            Player("Brady", "Tkachuk", NhlPosition.LEFT_WING, "7"),
            Player("Jordan", "Spence", NhlPosition.DEFENSE, "10"),
            Player("Shane", "Pinto", NhlPosition.CENTER, "12"),
            Player("Jan", "Jenik", NhlPosition.CENTER, "14"),
            Player("Olle", "Lycksell", NhlPosition.RIGHT_WING, "15"),
            Player("Tim", "Stutzle", NhlPosition.CENTER, "18"),
            Player("Drake", "Batherson", NhlPosition.RIGHT_WING, "19"),
            Player("Fabian", "Zetterlund", NhlPosition.LEFT_WING, "20"),
            Player("Nick", "Cousins", NhlPosition.CENTER, "21"),
            Player("Michael", "Amadio", NhlPosition.RIGHT_WING, "22"),
            Player("Kurtis", "MacDermid", NhlPosition.LEFT_WING, "23"),
            Player("Dylan", "Cozens", NhlPosition.CENTER, "24"),
            Player("Claude", "Giroux", NhlPosition.RIGHT_WING, "28"),
            Player("Nikolas", "Matinpalo", NhlPosition.DEFENSE, "33"),
            Player("Linus", "Ullmark", NhlPosition.GOALIE, "35"),
            Player("Tyler", "Kleven", NhlPosition.DEFENSE, "43"),
            Player("David", "Perron", NhlPosition.LEFT_WING, "57"),
            Player("Carter", "Yakemchuk", NhlPosition.DEFENSE, "58"),
            Player("Ridly", "Greig", NhlPosition.CENTER, "71"),
            Player("Thomas", "Chabot", NhlPosition.DEFENSE, "72"),
            Player("Stephen", "Halliday", NhlPosition.CENTER, "83"),
            Player("Jake", "Sanderson", NhlPosition.DEFENSE, "85"),
            Player("Lars", "Eller", NhlPosition.CENTER, "89"),
        ),
    )
}

private val nhlTeamPhi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Philadelphia Flyers",
        nameWidthPercent = 71.6f,
        abbreviation = "PHI",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFFE5823),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Xfinity Mobile Arena",
            location = VenueLocation(
                lat = 39.901150,
                long = -75.171970,
            ),
        ),
        roster = listOf(
            Player("Travis", "Sanheim", NhlPosition.DEFENSE, "6"),
            Player("Cam", "York", NhlPosition.DEFENSE, "8"),
            Player("Jamie", "Drysdale", NhlPosition.DEFENSE, "9"),
            Player("Bobby", "Brink", NhlPosition.RIGHT_WING, "10"),
            Player("Travis", "Konecny", NhlPosition.RIGHT_WING, "11"),
            Player("Sean", "Couturier", NhlPosition.CENTER, "14"),
            Player("Jett", "Luchanko", NhlPosition.CENTER, "17"),
            Player("Rodrigo", "Abols", NhlPosition.CENTER, "18"),
            Player("Garnet", "Hathaway", NhlPosition.RIGHT_WING, "19"),
            Player("Christian", "Dvorak", NhlPosition.CENTER, "22"),
            Player("Nick", "Seeler", NhlPosition.DEFENSE, "24"),
            Player("Noah", "Cates", NhlPosition.LEFT_WING, "27"),
            Player("Nikita", "Grebenkin", NhlPosition.RIGHT_WING, "29"),
            Player("Samuel", "Ersson", NhlPosition.GOALIE, "33"),
            Player("Emil", "Andrae", NhlPosition.DEFENSE, "36"),
            Player("Matvei", "Michkov", NhlPosition.RIGHT_WING, "39"),
            Player("Nicolas", "Deslauriers", NhlPosition.LEFT_WING, "44"),
            Player("Trevor", "Zegras", NhlPosition.CENTER, "46"),
            Player("Noah", "Juulsen", NhlPosition.DEFENSE, "47"),
            Player("Denver", "Barkey", NhlPosition.CENTER, "52"),
            Player("Rasmus", "Ristolainen", NhlPosition.DEFENSE, "55"),
            Player("Tyson", "Foerster", NhlPosition.RIGHT_WING, "71"),
            Player("Owen", "Tippett", NhlPosition.RIGHT_WING, "74"),
            Player("Roman", "Schmidt", NhlPosition.DEFENSE, "76"),
            Player("Jacob", "Gaucher", NhlPosition.CENTER, "78"),
            Player("Dan", "Vladar", NhlPosition.GOALIE, "80"),
        ),
    )
}

private val nhlTeamPit by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Pittsburgh Penguins",
        nameWidthPercent = 77.7f,
        abbreviation = "PIT",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF000000),
            nameAccent = Color(0xFFFDB71A),
        ),
        venue = TeamVenue(
            name = "PPG Paints Arena",
            location = VenueLocation(
                lat = 40.439400,
                long = -79.989200,
            ),
        ),
        roster = listOf(
            Player("Rutger", "McGroarty", NhlPosition.RIGHT_WING, "2"),
            Player("Jack", "St. Ivany", NhlPosition.DEFENSE, "3"),
            Player("Ryan", "Shea", NhlPosition.DEFENSE, "5"),
            Player("Filip", "Hallander", NhlPosition.CENTER, "11"),
            Player("Kevin", "Hayes", NhlPosition.RIGHT_WING, "13"),
            Player("Bokondji", "Imama", NhlPosition.LEFT_WING, "14"),
            Player("Justin", "Brazeau", NhlPosition.RIGHT_WING, "16"),
            Player("Bryan", "Rust", NhlPosition.RIGHT_WING, "17"),
            Player("Tommy", "Novak", NhlPosition.CENTER, "18"),
            Player("Connor", "Dewar", NhlPosition.CENTER, "19"),
            Player("Tristan", "Broz", NhlPosition.CENTER, "26"),
            Player("Ryan", "Graves", NhlPosition.DEFENSE, "27"),
            Player("Brett", "Kulak", NhlPosition.DEFENSE, "27"),
            Player("Parker", "Wotherspoon", NhlPosition.DEFENSE, "28"),
            Player("Arturs", "Silovs", NhlPosition.GOALIE, "37"),
            Player("Owen", "Pickering", NhlPosition.DEFENSE, "38"),
            Player("Anthony", "Mantha", NhlPosition.RIGHT_WING, "39"),
            Player("Ville", "Koivunen", NhlPosition.RIGHT_WING, "41"),
            Player("Danton", "Heinen", NhlPosition.LEFT_WING, "43"),
            Player("Harrison", "Brunicke", NhlPosition.DEFENSE, "45"),
            Player("Blake", "Lizotte", NhlPosition.CENTER, "46"),
            Player("Philip", "Tomasino", NhlPosition.RIGHT_WING, "53"),
            Player("Noel", "Acciari", NhlPosition.CENTER, "55"),
            Player("Kris", "Letang", NhlPosition.DEFENSE, "58"),
            Player("Erik", "Karlsson", NhlPosition.DEFENSE, "65"),
            Player("Rickard", "Rakell", NhlPosition.RIGHT_WING, "67"),
            Player("Evgeni", "Malkin", NhlPosition.CENTER, "71"),
            Player("Stuart", "Skinner", NhlPosition.GOALIE, "74"),
            Player("Connor", "Clifton", NhlPosition.DEFENSE, "75"),
            Player("Ben", "Kindel", NhlPosition.CENTER, "81"),
            Player("Caleb", "Jones", NhlPosition.DEFENSE, "82"),
            Player("Sidney", "Crosby", NhlPosition.CENTER, "87"),
        ),
    )
}

private val nhlTeamSj by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Jose Sharks",
        nameWidthPercent = 62.2f,
        abbreviation = "SJ",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF00788A),
            nameAccent = Color(0xFF070707),
        ),
        venue = TeamVenue(
            name = "SAP Center at San Jose",
            location = VenueLocation(
                lat = 37.332778,
                long = -121.901111,
            ),
        ),
        roster = listOf(
            Player("Justin", "Kowalkoski", NhlPosition.GOALIE, "1"),
            Player("Will", "Smith", NhlPosition.CENTER, "2"),
            Player("John", "Klingberg", NhlPosition.DEFENSE, "3"),
            Player("Nick", "Leddy", NhlPosition.DEFENSE, "4"),
            Player("Vincent", "Desharnais", NhlPosition.DEFENSE, "5"),
            Player("Sam", "Dickinson", NhlPosition.DEFENSE, "6"),
            Player("Dmitry", "Orlov", NhlPosition.DEFENSE, "9"),
            Player("Ty", "Dellandrea", NhlPosition.CENTER, "10"),
            Player("Alexander", "Wennberg", NhlPosition.CENTER, "21"),
            Player("Vincent", "Iorio", NhlPosition.DEFENSE, "22"),
            Player("Barclay", "Goodrow", NhlPosition.CENTER, "23"),
            Player("Yaroslav", "Askarov", NhlPosition.GOALIE, "30"),
            Player("Carey", "Price", NhlPosition.GOALIE, "31"),
            Player("Alex", "Nedeljkovic", NhlPosition.GOALIE, "33"),
            Player("Timothy", "Liljegren", NhlPosition.DEFENSE, "37"),
            Player("Mario", "Ferraro", NhlPosition.DEFENSE, "38"),
            Player("Logan", "Couture", NhlPosition.CENTER, "39"),
            Player("Collin", "Graf", NhlPosition.RIGHT_WING, "51"),
            Player("Jeff", "Skinner", NhlPosition.LEFT_WING, "53"),
            Player("Ethan", "Cardwell", NhlPosition.RIGHT_WING, "56"),
            Player("Zack", "Ostapchuk", NhlPosition.CENTER, "63"),
            Player("Lucas", "Vanroboys", NhlPosition.CENTER, "67"),
            Player("Macklin", "Celebrini", NhlPosition.CENTER, "71"),
            Player("William", "Eklund", NhlPosition.LEFT_WING, "72"),
            Player("Tyler", "Toffoli", NhlPosition.CENTER, "73"),
            Player("Ryan", "Reaves", NhlPosition.RIGHT_WING, "75"),
            Player("Adam", "Gaudette", NhlPosition.RIGHT_WING, "81"),
            Player("Shakir", "Mukhamadullin", NhlPosition.DEFENSE, "85"),
            Player("Igor", "Chernyshov", NhlPosition.LEFT_WING, "92"),
            Player("Ryan", "Ellis", NhlPosition.DEFENSE, "94"),
            Player("Philipp", "Kurashev", NhlPosition.CENTER, "96"),
        ),
    )
}

private val nhlTeamSea by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Seattle Kraken",
        nameWidthPercent = 56.8f,
        abbreviation = "SEA",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF000D33),
            nameAccent = Color(0xFFA3DCE4),
        ),
        venue = TeamVenue(
            name = "Climate Pledge Arena",
            location = VenueLocation(
                lat = 47.622222,
                long = -122.354167,
            ),
        ),
        roster = listOf(
            Player("Adam", "Larsson", NhlPosition.DEFENSE, "6"),
            Player("Jordan", "Eberle", NhlPosition.RIGHT_WING, "7"),
            Player("Cale", "Fleury", NhlPosition.DEFENSE, "8"),
            Player("Chandler", "Stephenson", NhlPosition.CENTER, "9"),
            Player("Matty", "Beniers", NhlPosition.CENTER, "10"),
            Player("Tye", "Kartye", NhlPosition.LEFT_WING, "12"),
            Player("Jaden", "Schwartz", NhlPosition.CENTER, "17"),
            Player("Jared", "McCann", NhlPosition.LEFT_WING, "19"),
            Player("Eeli", "Tolvanen", NhlPosition.RIGHT_WING, "20"),
            Player("Jamie", "Oleksiak", NhlPosition.DEFENSE, "24"),
            Player("Ryan", "Winterton", NhlPosition.CENTER, "26"),
            Player("Joshua", "Mahura", NhlPosition.DEFENSE, "28"),
            Player("Vince", "Dunn", NhlPosition.DEFENSE, "29"),
            Player("Matt", "Murray", NhlPosition.GOALIE, "30"),
            Player("Philipp", "Grubauer", NhlPosition.GOALIE, "31"),
            Player("Joey", "Daccord", NhlPosition.GOALIE, "35"),
            Player("Jani", "Nyman", NhlPosition.RIGHT_WING, "38"),
            Player("Ryker", "Evans", NhlPosition.DEFENSE, "41"),
            Player("Shane", "Wright", NhlPosition.CENTER, "51"),
            Player("Ryan", "Lindgren", NhlPosition.DEFENSE, "55"),
            Player("Ben", "Meyers", NhlPosition.CENTER, "59"),
            Player("Brandon", "Montour", NhlPosition.DEFENSE, "62"),
            Player("Jacob", "Melanson", NhlPosition.RIGHT_WING, "63"),
            Player("Berkly", "Catton", NhlPosition.CENTER, "77"),
            Player("Oscar", "Fisker Molgaard", NhlPosition.CENTER, "78"),
            Player("Kaapo", "Kakko", NhlPosition.RIGHT_WING, "84"),
            Player("Frederick", "Gaudreau", NhlPosition.CENTER, "89"),
        ),
    )
}

private val nhlTeamStl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "St. Louis Blues",
        nameWidthPercent = 54.7f,
        abbreviation = "STL",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF0070B9),
            nameAccent = Color(0xFFFDB71A),
        ),
        venue = TeamVenue(
            name = "Enterprise Center",
            location = VenueLocation(
                lat = 38.626667,
                long = -90.202500,
            ),
        ),
        roster = listOf(
            Player("Philip", "Broberg", NhlPosition.DEFENSE, "6"),
            Player("Robby", "Fabbri", NhlPosition.CENTER, "9"),
            Player("Brayden", "Schenn", NhlPosition.CENTER, "10"),
            Player("Alexey", "Toropchenko", NhlPosition.RIGHT_WING, "13"),
            Player("Cam", "Fowler", NhlPosition.DEFENSE, "17"),
            Player("Robert", "Thomas", NhlPosition.CENTER, "18"),
            Player("Jimmy", "Snuggerud", NhlPosition.RIGHT_WING, "21"),
            Player("Pius", "Suter", NhlPosition.CENTER, "22"),
            Player("Logan", "Mailloux", NhlPosition.DEFENSE, "23"),
            Player("Jordan", "Kyrou", NhlPosition.RIGHT_WING, "25"),
            Player("Nathan", "Walker", NhlPosition.LEFT_WING, "26"),
            Player("Otto", "Stenberg", NhlPosition.CENTER, "28"),
            Player("Jonatan", "Berggren", NhlPosition.RIGHT_WING, "29"),
            Player("Joel", "Hofer", NhlPosition.GOALIE, "30"),
            Player("Calle", "Rosen", NhlPosition.DEFENSE, "43"),
            Player("Jordan", "Binnington", NhlPosition.GOALIE, "50"),
            Player("Matthew", "Kessel", NhlPosition.DEFENSE, "51"),
            Player("Dalibor", "Dvorsky", NhlPosition.RIGHT_WING, "54"),
            Player("Colton", "Parayko", NhlPosition.DEFENSE, "55"),
            Player("Jake", "Neighbours", NhlPosition.LEFT_WING, "63"),
            Player("Oskar", "Sundqvist", NhlPosition.CENTER, "70"),
            Player("Mathieu", "Joseph", NhlPosition.RIGHT_WING, "71"),
            Player("Justin", "Faulk", NhlPosition.DEFENSE, "72"),
            Player("Tyler", "Tucker", NhlPosition.DEFENSE, "75"),
            Player("Nick", "Bjugstad", NhlPosition.CENTER, "77"),
            Player("Dylan", "Holloway", NhlPosition.LEFT_WING, "81"),
            Player("Pavel", "Buchnevich", NhlPosition.LEFT_WING, "89"),
        ),
    )
}

private val nhlTeamTb by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Tampa Bay Lightning",
        nameWidthPercent = 80.4f,
        abbreviation = "TB",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF003E7E),
            nameAccent = Color(0xFFFFFFFF),
        ),
        venue = TeamVenue(
            name = "Amalie Arena",
            location = VenueLocation(
                lat = 27.942778,
                long = -82.451944,
            ),
        ),
        roster = listOf(
            Player("Dominic", "James", NhlPosition.CENTER, "17"),
            Player("Nick", "Paul", NhlPosition.LEFT_WING, "20"),
            Player("Brayden", "Point", NhlPosition.CENTER, "21"),
            Player("Oliver", "Bjorkstrand", NhlPosition.RIGHT_WING, "22"),
            Player("Maxwell", "Crozier", NhlPosition.DEFENSE, "24"),
            Player("Ryan", "McDonagh", NhlPosition.DEFENSE, "27"),
            Player("Zemgus", "Girgensons", NhlPosition.CENTER, "28"),
            Player("Pontus", "Holmberg", NhlPosition.RIGHT_WING, "29"),
            Player("Jonas", "Johansson", NhlPosition.GOALIE, "31"),
            Player("Yanni", "Gourde", NhlPosition.CENTER, "37"),
            Player("Brandon", "Hagel", NhlPosition.LEFT_WING, "38"),
            Player("Curtis", "Douglas", NhlPosition.CENTER, "42"),
            Player("Darren", "Raddysh", NhlPosition.DEFENSE, "43"),
            Player("Charle-Edouard", "D'Astous", NhlPosition.DEFENSE, "51"),
            Player("Jake", "Guentzel", NhlPosition.CENTER, "59"),
            Player("Jack", "Finley", NhlPosition.CENTER, "62"),
            Player("Declan", "Carlile", NhlPosition.DEFENSE, "67"),
            Player("Anthony", "Cirelli", NhlPosition.CENTER, "71"),
            Player("Ethan", "Samson", NhlPosition.DEFENSE, "75"),
            Player("Victor", "Hedman", NhlPosition.DEFENSE, "77"),
            Player("Emil", "Lilleberg", NhlPosition.DEFENSE, "78"),
            Player("Erik", "Cernak", NhlPosition.DEFENSE, "81"),
            Player("Nikita", "Kucherov", NhlPosition.RIGHT_WING, "86"),
            Player("Andrei", "Vasilevskiy", NhlPosition.GOALIE, "88"),
            Player("J.J.", "Moser", NhlPosition.DEFENSE, "90"),
            Player("Gage", "Goncalves", NhlPosition.CENTER, "93"),
        ),
    )
}

private val nhlTeamTor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Toronto Maple Leafs",
        nameWidthPercent = 80.1f,
        abbreviation = "TOR",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF003E7E),
            nameAccent = Color(0xFFFFFFFF),
        ),
        venue = TeamVenue(
            name = "Scotiabank Arena",
            location = VenueLocation(
                lat = 43.643333,
                long = -79.379167,
            ),
        ),
        roster = listOf(
            Player("Simon", "Benoit", NhlPosition.DEFENSE, "2"),
            Player("Dakota", "Mermis", NhlPosition.DEFENSE, "3"),
            Player("Henry", "Thrun", NhlPosition.DEFENSE, "3"),
            Player("Chris", "Tanev", NhlPosition.DEFENSE, "8"),
            Player("Max", "Domi", NhlPosition.CENTER, "11"),
            Player("Steven", "Lorentz", NhlPosition.CENTER, "18"),
            Player("Calle", "Jarnkrok", NhlPosition.CENTER, "19"),
            Player("Jake", "McCabe", NhlPosition.DEFENSE, "22"),
            Player("Matthew", "Knies", NhlPosition.LEFT_WING, "23"),
            Player("Scott", "Laughton", NhlPosition.CENTER, "24"),
            Player("Brandon", "Carlo", NhlPosition.DEFENSE, "25"),
            Player("Jacob", "Quillan", NhlPosition.CENTER, "26"),
            Player("Troy", "Stecher", NhlPosition.DEFENSE, "28"),
            Player("Auston", "Matthews", NhlPosition.CENTER, "34"),
            Player("Dennis", "Hildeby", NhlPosition.GOALIE, "35"),
            Player("Anthony", "Stolarz", NhlPosition.GOALIE, "41"),
            Player("Morgan", "Rielly", NhlPosition.DEFENSE, "44"),
            Player("Philippe", "Myers", NhlPosition.DEFENSE, "51"),
            Player("Easton", "Cowan", NhlPosition.RIGHT_WING, "53"),
            Player("Nicolas", "Roy", NhlPosition.CENTER, "55"),
            Player("Joseph", "Woll", NhlPosition.GOALIE, "60"),
            Player("Matias", "Maccelli", NhlPosition.LEFT_WING, "63"),
            Player("Bobby", "McMann", NhlPosition.CENTER, "74"),
            Player("Dakota", "Joshua", NhlPosition.CENTER, "81"),
            Player("William", "Nylander", NhlPosition.RIGHT_WING, "88"),
            Player("Nicholas", "Robertson", NhlPosition.LEFT_WING, "89"),
            Player("John", "Tavares", NhlPosition.CENTER, "91"),
            Player("Oliver", "Ekman-Larsson", NhlPosition.DEFENSE, "95"),
        ),
    )
}

private val nhlTeamVan by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Vancouver Canucks",
        nameWidthPercent = 76.7f,
        abbreviation = "VAN",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF003E7E),
            nameAccent = Color(0xFF008752),
        ),
        venue = TeamVenue(
            name = "Rogers Arena",
            location = VenueLocation(
                lat = 49.277778,
                long = -123.108889,
            ),
        ),
        roster = listOf(
            Player("Tom", "Willander", NhlPosition.DEFENSE, "5"),
            Player("Brock", "Boeser", NhlPosition.RIGHT_WING, "6"),
            Player("Pierre-Olivier", "Joseph", NhlPosition.DEFENSE, "7"),
            Player("Conor", "Garland", NhlPosition.RIGHT_WING, "8"),
            Player("Filip", "Hronek", NhlPosition.DEFENSE, "17"),
            Player("Drew", "O'Connor", NhlPosition.LEFT_WING, "18"),
            Player("Nils", "Hoglander", NhlPosition.LEFT_WING, "21"),
            Player("Zeev", "Buium", NhlPosition.DEFENSE, "24"),
            Player("Elias N.", "Pettersson", NhlPosition.DEFENSE, "25"),
            Player("Derek", "Forbort", NhlPosition.DEFENSE, "27"),
            Player("Marcus", "Pettersson", NhlPosition.DEFENSE, "29"),
            Player("Kevin", "Lankinen", NhlPosition.GOALIE, "32"),
            Player("Thatcher", "Demko", NhlPosition.GOALIE, "35"),
            Player("Elias", "Pettersson", NhlPosition.CENTER, "40"),
            Player("Kiefer", "Sherwood", NhlPosition.LEFT_WING, "44"),
            Player("Teddy", "Blueger", NhlPosition.CENTER, "53"),
            Player("Aatu", "Raty", NhlPosition.CENTER, "54"),
            Player("Tyler", "Myers", NhlPosition.DEFENSE, "57"),
            Player("Nikita", "Tolopilo", NhlPosition.GOALIE, "60"),
            Player("Max", "Sasson", NhlPosition.CENTER, "63"),
            Player("David", "Kampf", NhlPosition.CENTER, "64"),
            Player("Filip", "Chytil", NhlPosition.CENTER, "72"),
            Player("Jake", "DeBrusk", NhlPosition.LEFT_WING, "74"),
            Player("Braeden", "Cootes", NhlPosition.CENTER, "80"),
            Player("Nils", "Aman", NhlPosition.CENTER, "88"),
            Player("Evander", "Kane", NhlPosition.LEFT_WING, "91"),
            Player("Liam", "Ohgren", NhlPosition.LEFT_WING, "92"),
            Player("Marco", "Rossi", NhlPosition.CENTER, "93"),
            Player("Linus", "Karlsson", NhlPosition.CENTER, "94"),
        ),
    )
}

private val nhlTeamVgk by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Vegas Golden Knights",
        nameWidthPercent = 85.1f,
        abbreviation = "VGK",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF344043),
            nameAccent = Color(0xFFB4975A),
        ),
        venue = TeamVenue(
            name = "T-Mobile Arena",
            location = VenueLocation(
                lat = 36.102917,
                long = -115.178361,
            ),
        ),
        roster = listOf(
            Player("Zach", "Whitecloud", NhlPosition.DEFENSE, "2"),
            Player("Brayden", "McNabb", NhlPosition.DEFENSE, "3"),
            Player("Jeremy", "Lauzon", NhlPosition.DEFENSE, "5"),
            Player("Kaedan", "Korczak", NhlPosition.DEFENSE, "6"),
            Player("Jack", "Eichel", NhlPosition.CENTER, "9"),
            Player("Colton", "Sissons", NhlPosition.CENTER, "10"),
            Player("Jakub", "Demek", NhlPosition.CENTER, "13"),
            Player("Noah", "Hanifin", NhlPosition.DEFENSE, "15"),
            Player("Pavel", "Dorofeyev", NhlPosition.RIGHT_WING, "16"),
            Player("Ben", "Hutton", NhlPosition.DEFENSE, "17"),
            Player("Reilly", "Smith", NhlPosition.RIGHT_WING, "19"),
            Player("Brandon", "Saad", NhlPosition.LEFT_WING, "20"),
            Player("Brett", "Howden", NhlPosition.CENTER, "21"),
            Player("Cole", "Reinhardt", NhlPosition.LEFT_WING, "23"),
            Player("Trevor", "Connelly", NhlPosition.LEFT_WING, "24"),
            Player("Alexander", "Holtz", NhlPosition.RIGHT_WING, "26"),
            Player("Shea", "Theodore", NhlPosition.DEFENSE, "27"),
            Player("Jesper", "Vikman", NhlPosition.GOALIE, "32"),
            Player("Adin", "Hill", NhlPosition.GOALIE, "33"),
            Player("Akira", "Schmid", NhlPosition.GOALIE, "40"),
            Player("Braeden", "Bowman", NhlPosition.RIGHT_WING, "42"),
            Player("Jonas", "Rondbjerg", NhlPosition.RIGHT_WING, "46"),
            Player("Tomas", "Hertl", NhlPosition.CENTER, "48"),
            Player("Ivan", "Barbashev", NhlPosition.LEFT_WING, "49"),
            Player("Dylan", "Coghlan", NhlPosition.DEFENSE, "52"),
            Player("Keegan", "Kolesar", NhlPosition.RIGHT_WING, "55"),
            Player("Mark", "Stone", NhlPosition.RIGHT_WING, "61"),
            Player("William", "Karlsson", NhlPosition.CENTER, "71"),
            Player("Carter", "Hart", NhlPosition.GOALIE, "79"),
            Player("Jeremy", "Davies", NhlPosition.DEFENSE, "84"),
            Player("Mitch", "Marner", NhlPosition.RIGHT_WING, "93"),
        ),
    )
}

private val nhlTeamWsh by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Washington Capitals",
        nameWidthPercent = 80.1f,
        abbreviation = "WSH",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFFD71830),
            nameAccent = Color(0xFF0B1F41),
        ),
        venue = TeamVenue(
            name = "Capital One Arena",
            location = VenueLocation(
                lat = 38.898056,
                long = -77.020833,
            ),
        ),
        roster = listOf(
            Player("Matt", "Roy", NhlPosition.DEFENSE, "3"),
            Player("Jakob", "Chychrun", NhlPosition.DEFENSE, "6"),
            Player("Alex", "Ovechkin", NhlPosition.LEFT_WING, "8"),
            Player("Ryan", "Leonard", NhlPosition.RIGHT_WING, "9"),
            Player("Sonny", "Milano", NhlPosition.LEFT_WING, "15"),
            Player("Dylan", "Strome", NhlPosition.CENTER, "17"),
            Player("Aliaksei", "Protas", NhlPosition.CENTER, "21"),
            Player("Brandon", "Duhaime", NhlPosition.RIGHT_WING, "22"),
            Player("Connor", "McMichael", NhlPosition.CENTER, "24"),
            Player("Nic", "Dowd", NhlPosition.CENTER, "26"),
            Player("Hendrix", "Lapierre", NhlPosition.CENTER, "29"),
            Player("Justin", "Sourdif", NhlPosition.RIGHT_WING, "34"),
            Player("Rasmus", "Sandin", NhlPosition.DEFENSE, "38"),
            Player("Martin", "Fehervary", NhlPosition.DEFENSE, "42"),
            Player("Tom", "Wilson", NhlPosition.RIGHT_WING, "43"),
            Player("Declan", "Chisholm", NhlPosition.DEFENSE, "47"),
            Player("Logan", "Thompson", NhlPosition.GOALIE, "48"),
            Player("Dylan", "McIlrath", NhlPosition.DEFENSE, "52"),
            Player("Ethen", "Frank", NhlPosition.CENTER, "53"),
            Player("Trevor", "van Riemsdyk", NhlPosition.DEFENSE, "57"),
            Player("Corey", "Schueneman", NhlPosition.DEFENSE, "64"),
            Player("Anthony", "Beauvillier", NhlPosition.LEFT_WING, "72"),
            Player("John", "Carlson", NhlPosition.DEFENSE, "74"),
            Player("Charlie", "Lindgren", NhlPosition.GOALIE, "79"),
            Player("Pierre-Luc", "Dubois", NhlPosition.LEFT_WING, "80"),
        ),
    )
}

private val nhlTeamWpg by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Winnipeg Jets",
        nameWidthPercent = 55.1f,
        abbreviation = "WPG",
        league = LeagueId.NHL,
        colors = TeamColors(
            primary = Color(0xFF002D62),
            nameAccent = Color(0xFFC41230),
        ),
        venue = TeamVenue(
            name = "Canada Life Centre",
            location = VenueLocation(
                lat = 49.892778,
                long = -97.143611,
            ),
        ),
        roster = listOf(
            Player("Eric", "Comrie", NhlPosition.GOALIE, "1"),
            Player("Dylan", "DeMelo", NhlPosition.DEFENSE, "2"),
            Player("Neal", "Pionk", NhlPosition.DEFENSE, "4"),
            Player("Luke", "Schenn", NhlPosition.DEFENSE, "5"),
            Player("Colin", "Miller", NhlPosition.DEFENSE, "6"),
            Player("Vladislav", "Namestnikov", NhlPosition.CENTER, "7"),
            Player("Alex", "Iafallo", NhlPosition.LEFT_WING, "9"),
            Player("Gabriel", "Vilardi", NhlPosition.CENTER, "13"),
            Player("Gustav", "Nyquist", NhlPosition.RIGHT_WING, "14"),
            Player("Adam", "Lowry", NhlPosition.CENTER, "17"),
            Player("Jonathan", "Toews", NhlPosition.CENTER, "19"),
            Player("Haydn", "Fleury", NhlPosition.DEFENSE, "24"),
            Player("Morgan", "Barron", NhlPosition.CENTER, "36"),
            Player("Connor", "Hellebuyck", NhlPosition.GOALIE, "37"),
            Player("Josh", "Morrissey", NhlPosition.DEFENSE, "44"),
            Player("Cole", "Koepke", NhlPosition.LEFT_WING, "45"),
            Player("Dylan", "Samberg", NhlPosition.DEFENSE, "54"),
            Player("Mark", "Scheifele", NhlPosition.CENTER, "55"),
            Player("Nino", "Niederreiter", NhlPosition.RIGHT_WING, "62"),
            Player("Logan", "Stanley", NhlPosition.DEFENSE, "64"),
            Player("Tanner", "Pearson", NhlPosition.LEFT_WING, "70"),
            Player("Kyle", "Connor", NhlPosition.LEFT_WING, "81"),
            Player("Cole", "Perfetti", NhlPosition.CENTER, "91"),
        ),
    )
}

val NhlTeams: List<Team<NhlPosition>> by lazy(LazyThreadSafetyMode.NONE) {
    listOf(
        nhlTeamAna,
        nhlTeamUtah,
        nhlTeamBos,
        nhlTeamBuf,
        nhlTeamCgy,
        nhlTeamCar,
        nhlTeamChi,
        nhlTeamCol,
        nhlTeamCbj,
        nhlTeamDal,
        nhlTeamDet,
        nhlTeamEdm,
        nhlTeamFla,
        nhlTeamLa,
        nhlTeamMin,
        nhlTeamMtl,
        nhlTeamNsh,
        nhlTeamNj,
        nhlTeamNyi,
        nhlTeamNyr,
        nhlTeamOtt,
        nhlTeamPhi,
        nhlTeamPit,
        nhlTeamSj,
        nhlTeamSea,
        nhlTeamStl,
        nhlTeamTb,
        nhlTeamTor,
        nhlTeamVan,
        nhlTeamVgk,
        nhlTeamWsh,
        nhlTeamWpg,
    )
}

internal object NhlTeamRefs {
    val ANA = nhlTeamAna
    val UTAH = nhlTeamUtah
    val BOS = nhlTeamBos
    val BUF = nhlTeamBuf
    val CGY = nhlTeamCgy
    val CAR = nhlTeamCar
    val CHI = nhlTeamChi
    val COL = nhlTeamCol
    val CBJ = nhlTeamCbj
    val DAL = nhlTeamDal
    val DET = nhlTeamDet
    val EDM = nhlTeamEdm
    val FLA = nhlTeamFla
    val LA = nhlTeamLa
    val MIN = nhlTeamMin
    val MTL = nhlTeamMtl
    val NSH = nhlTeamNsh
    val NJ = nhlTeamNj
    val NYI = nhlTeamNyi
    val NYR = nhlTeamNyr
    val OTT = nhlTeamOtt
    val PHI = nhlTeamPhi
    val PIT = nhlTeamPit
    val SJ = nhlTeamSj
    val SEA = nhlTeamSea
    val STL = nhlTeamStl
    val TB = nhlTeamTb
    val TOR = nhlTeamTor
    val VAN = nhlTeamVan
    val VGK = nhlTeamVgk
    val WSH = nhlTeamWsh
    val WPG = nhlTeamWpg
}
