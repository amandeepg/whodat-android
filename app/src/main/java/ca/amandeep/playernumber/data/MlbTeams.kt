package ca.amandeep.playernumber.data

import androidx.compose.ui.graphics.Color

private val mlbTeamAri by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Arizona Diamondbacks",
        nameWidthPercent = 88.9f,
        abbreviation = "ARI",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFAA182C),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Chase Field",
                location =
                    VenueLocation(
                        lat = 33.445278,
                        long = -112.066944,
                    ),
            ),
        roster =
            listOf(
                Player("Jorge", "Barrosa", MlbPosition.LEFT_FIELD, "1"),
                Player("Geraldo", "Perdomo", MlbPosition.SHORTSTOP, "2"),
                Player("Ketel", "Marte", MlbPosition.SECOND_BASE, "4"),
                Player("Alek", "Thomas", MlbPosition.CENTER_FIELD, "5"),
                Player("Corbin", "Carroll", MlbPosition.RIGHT_FIELD, "7"),
                Player("Blaze", "Alexander", MlbPosition.SHORTSTOP, "9"),
                Player("Jordan", "Lawlar", MlbPosition.SHORTSTOP, "10"),
                Player("Lourdes", "Gurriel", MlbPosition.LEFT_FIELD, "12", "Jr."),
                Player("Tim", "Tawa", MlbPosition.SECOND_BASE, "13"),
                Player("Gabriel", "Moreno", MlbPosition.CATCHER, "14"),
                Player("Ryne", "Nelson", MlbPosition.STARTING_PITCHER, "19"),
                Player("Merrill", "Kelly", MlbPosition.STARTING_PITCHER, "23"),
                Player("Adrian", "Del Castillo", MlbPosition.CATCHER, "25"),
                Player("Pavin", "Smith", MlbPosition.FIRST_BASE, "26"),
                Player("Andrew", "Saalfrank", MlbPosition.RELIEF_PITCHER, "27"),
                Player("Tyler", "Locklear", MlbPosition.FIRST_BASE, "28"),
                Player("Jake", "McCarthy", MlbPosition.CENTER_FIELD, "31"),
                Player("Brandon", "Pfaadt", MlbPosition.STARTING_PITCHER, "32"),
                Player("A.J.", "Puk", MlbPosition.RELIEF_PITCHER, "33"),
                Player("Michael", "Soroka", MlbPosition.STARTING_PITCHER, "34"),
                Player("Kevin", "Ginkel", MlbPosition.RELIEF_PITCHER, "37"),
                Player("Corbin", "Burnes", MlbPosition.STARTING_PITCHER, "39"),
                Player("Yilber", "Diaz", MlbPosition.STARTING_PITCHER, "45"),
                Player("Gus", "Varland", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Blake", "Walston", MlbPosition.STARTING_PITCHER, "48"),
                Player("Philip", "Abner", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Juan", "Burgos", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Brandyn", "Garcia", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Andrew", "Hoffmann", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Eduardo", "Rodriguez", MlbPosition.STARTING_PITCHER, "57"),
                Player("Kohl", "Drake", MlbPosition.STARTING_PITCHER, "58"),
                Player("Mitch", "Bratt", MlbPosition.STARTING_PITCHER, "60"),
                Player("Dylan", "Ray", MlbPosition.STARTING_PITCHER, "61"),
                Player("Justin", "Martinez", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Cristian", "Mena", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Juan", "Morillo", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Jose", "Fernandez", MlbPosition.SHORTSTOP, "79"),
                Player("Ryan", "Thompson", MlbPosition.RELIEF_PITCHER, "81"),
                Player("Drey", "Jameson", MlbPosition.RELIEF_PITCHER, "99"),
            ),
    )
}

private val mlbTeamAtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Atlanta Braves",
        nameWidthPercent = 57.1f,
        abbreviation = "ATL",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF0C2340),
                nameAccent = Color(0xFFBA0C2F),
            ),
        venue =
            TeamVenue(
                name = "Truist Park",
                location =
                    VenueLocation(
                        lat = 33.891200,
                        long = -84.468300,
                    ),
            ),
        roster =
            listOf(
                Player("Brett", "Wisely", MlbPosition.SECOND_BASE, "0"),
                Player("Ozzie", "Albies", MlbPosition.SECOND_BASE, "1"),
                Player("Vidal", "Brujan", MlbPosition.THIRD_BASE, "2"),
                Player("Ha-Seong", "Kim", MlbPosition.SHORTSTOP, "7"),
                Player("Sean", "Murphy", MlbPosition.CATCHER, "12"),
                Player("Ronald", "Acuna", MlbPosition.RIGHT_FIELD, "13", "Jr."),
                Player("Mauricio", "Dubon", MlbPosition.SECOND_BASE, "14"),
                Player("Jurickson", "Profar", MlbPosition.LEFT_FIELD, "17"),
                Player("Mike", "Yastrzemski", MlbPosition.RIGHT_FIELD, "18"),
                Player("Michael", "Harris", MlbPosition.CENTER_FIELD, "23", "II"),
                Player("Nacho", "Alvarez", MlbPosition.SHORTSTOP, "24", "Jr."),
                Player("Austin", "Riley", MlbPosition.THIRD_BASE, "27"),
                Player("Matt", "Olson", MlbPosition.FIRST_BASE, "28"),
                Player("Drake", "Baldwin", MlbPosition.CATCHER, "30"),
                Player("AJ", "Smith-Shawver", MlbPosition.STARTING_PITCHER, "32"),
                Player("Joey", "Wentz", MlbPosition.RELIEF_PITCHER, "33"),
                Player("Eli", "White", MlbPosition.RIGHT_FIELD, "36"),
                Player("Reynaldo", "Lopez", MlbPosition.STARTING_PITCHER, "40"),
                Player("Anthony", "Molina", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Dylan", "Dodd", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Aaron", "Bummer", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Chris", "Sale", MlbPosition.STARTING_PITCHER, "51"),
                Player("Dylan", "Lee", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Joel", "Payamps", MlbPosition.RELIEF_PITCHER, "53"),
                Player("Jose", "Suarez", MlbPosition.RELIEF_PITCHER, "54"),
                Player("Bryce", "Elder", MlbPosition.STARTING_PITCHER, "55"),
                Player("Spencer", "Schwellenbach", MlbPosition.STARTING_PITCHER, "56"),
                Player("Daysbel", "Hernandez", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Hurston", "Waldrep", MlbPosition.STARTING_PITCHER, "64"),
                Player("Hunter", "Stratton", MlbPosition.RELIEF_PITCHER, "65"),
                Player("Grant", "Holmes", MlbPosition.STARTING_PITCHER, "66"),
                Player("Rolddy", "Munoz", MlbPosition.RELIEF_PITCHER, "70"),
                Player("Didier", "Fuentes", MlbPosition.STARTING_PITCHER, "75"),
                Player("Robert", "Suarez", MlbPosition.RELIEF_PITCHER, "75"),
                Player("Joe", "Jimenez", MlbPosition.RELIEF_PITCHER, "77"),
                Player("Hayden", "Harris", MlbPosition.STARTING_PITCHER, "79"),
                Player("Jhancarlos", "Lara", MlbPosition.RELIEF_PITCHER, "81"),
                Player("Spencer", "Strider", MlbPosition.STARTING_PITCHER, "99"),
            ),
    )
}

private val mlbTeamBal by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Baltimore Orioles",
        nameWidthPercent = 67.6f,
        abbreviation = "BAL",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFDF4601),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Oriole Park at Camden Yards",
                location =
                    VenueLocation(
                        lat = 39.283889,
                        long = -76.621667,
                    ),
            ),
        roster =
            listOf(
                Player("Gunnar", "Henderson", MlbPosition.SHORTSTOP, "2"),
                Player("Taylor", "Ward", MlbPosition.LEFT_FIELD, "3"),
                Player("Leody", "Taveras", MlbPosition.OUTFIELD, "4"),
                Player("Ryan", "Mountcastle", MlbPosition.FIRST_BASE, "6"),
                Player("Jackson", "Holliday", MlbPosition.SECOND_BASE, "7"),
                Player("Tyler", "O'Neill", MlbPosition.RIGHT_FIELD, "9"),
                Player("Shane", "Baz", MlbPosition.STARTING_PITCHER, "11"),
                Player("Jordan", "Westburg", MlbPosition.THIRD_BASE, "11"),
                Player("Dylan", "Beavers", MlbPosition.RIGHT_FIELD, "12"),
                Player("Heston", "Kjerstad", MlbPosition.LEFT_FIELD, "13"),
                Player("Coby", "Mayo", MlbPosition.FIRST_BASE, "16"),
                Player("Colton", "Cowser", MlbPosition.LEFT_FIELD, "17"),
                Player("Pete", "Alonso", MlbPosition.FIRST_BASE, "25"),
                Player("Trevor", "Rogers", MlbPosition.STARTING_PITCHER, "28"),
                Player("Samuel", "Basallo", MlbPosition.CATCHER, "29"),
                Player("Adley", "Rutschman", MlbPosition.CATCHER, "35"),
                Player("Cade", "Povich", MlbPosition.STARTING_PITCHER, "37"),
                Player("Will", "Robertson", MlbPosition.LEFT_FIELD, "37"),
                Player("Kyle", "Bradish", MlbPosition.STARTING_PITCHER, "38"),
                Player("Keegan", "Akin", MlbPosition.RELIEF_PITCHER, "45"),
                Player("Rico", "Garcia", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Ryan", "Helsley", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Kade", "Strowd", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Andrew", "Kittredge", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Chayce", "McDermott", MlbPosition.STARTING_PITCHER, "59"),
                Player("Colin", "Selby", MlbPosition.RELIEF_PITCHER, "60"),
                Player("George", "Soriano", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Brandon", "Young", MlbPosition.STARTING_PITCHER, "63"),
                Player("Dean", "Kremer", MlbPosition.STARTING_PITCHER, "64"),
                Player("Tyler", "Wells", MlbPosition.STARTING_PITCHER, "68"),
                Player("Dietrich", "Enns", MlbPosition.RELIEF_PITCHER, "71"),
                Player("Jose", "Espada", MlbPosition.RELIEF_PITCHER, "72"),
                Player("Felix", "Bautista", MlbPosition.RELIEF_PITCHER, "74"),
                Player("Yaramil", "Hiraldo", MlbPosition.RELIEF_PITCHER, "76"),
                Player("Yennier", "Cano", MlbPosition.RELIEF_PITCHER, "78"),
                Player("Jeremiah", "Jackson", MlbPosition.SECOND_BASE, "82"),
                Player("Grant", "Wolfram", MlbPosition.RELIEF_PITCHER, "86"),
                Player("Reed", "Trimble", MlbPosition.LEFT_FIELD, "93"),
                Player("Anthony", "Nunez", MlbPosition.STARTING_PITCHER, "96"),
                Player("Cameron", "Foster", MlbPosition.RELIEF_PITCHER, "99"),
            ),
    )
}

private val mlbTeamBos by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Boston Red Sox",
        nameWidthPercent = 60.1f,
        abbreviation = "BOS",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF0D2B56),
                nameAccent = Color(0xFFBD3039),
            ),
        venue =
            TeamVenue(
                name = "Fenway Park",
                location =
                    VenueLocation(
                        lat = 42.346389,
                        long = -71.097500,
                    ),
            ),
        roster =
            listOf(
                Player("Ceddanne", "Rafaela", MlbPosition.CENTER_FIELD, "3"),
                Player("Masataka", "Yoshida", MlbPosition.LEFT_FIELD, "7"),
                Player("Tristan", "Gray", MlbPosition.THIRD_BASE, "10"),
                Player("Trevor", "Story", MlbPosition.SHORTSTOP, "10"),
                Player("Connor", "Wong", MlbPosition.CATCHER, "12"),
                Player("Jarren", "Duran", MlbPosition.LEFT_FIELD, "16"),
                Player("David", "Hamilton", MlbPosition.SECOND_BASE, "17"),
                Player("Roman", "Anthony", MlbPosition.RIGHT_FIELD, "19"),
                Player("Nick", "Sogard", MlbPosition.FIRST_BASE, "20"),
                Player("Garrett", "Whitlock", MlbPosition.RELIEF_PITCHER, "22"),
                Player("Romy", "Gonzalez", MlbPosition.FIRST_BASE, "23"),
                Player("Johan", "Oviedo", MlbPosition.STARTING_PITCHER, "24"),
                Player("Kristian", "Campbell", MlbPosition.SECOND_BASE, "28"),
                Player("Garrett", "Crochet", MlbPosition.STARTING_PITCHER, "35"),
                Player("Triston", "Casas", MlbPosition.FIRST_BASE, "36"),
                Player("Kyle", "Harrison", MlbPosition.RELIEF_PITCHER, "38"),
                Player("Marcelo", "Mayer", MlbPosition.THIRD_BASE, "39"),
                Player("Willson", "Contreras", MlbPosition.FIRST_BASE, "40"),
                Player("Nate", "Eaton", MlbPosition.THIRD_BASE, "40"),
                Player("Patrick", "Sandoval", MlbPosition.STARTING_PITCHER, "43"),
                Player("Aroldis", "Chapman", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Jordan", "Hicks", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Jovani", "Moran", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Kutter", "Crawford", MlbPosition.STARTING_PITCHER, "50"),
                Player("Wilyer", "Abreu", MlbPosition.RIGHT_FIELD, "52"),
                Player("Sonny", "Gray", MlbPosition.STARTING_PITCHER, "54"),
                Player("Greg", "Weissert", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Justin", "Slaten", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Brayan", "Bello", MlbPosition.STARTING_PITCHER, "66"),
                Player("Payton", "Tolle", MlbPosition.STARTING_PITCHER, "70"),
                Player("Connelly", "Early", MlbPosition.STARTING_PITCHER, "71"),
                Player("Carlos", "Narvaez", MlbPosition.CATCHER, "75"),
                Player("Zack", "Kelly", MlbPosition.RELIEF_PITCHER, "76"),
                Player("Shane", "Drohan", MlbPosition.STARTING_PITCHER, "88"),
                Player("Tanner", "Houck", MlbPosition.STARTING_PITCHER, "89"),
                Player("Ryan", "Watson", MlbPosition.RELIEF_PITCHER, "89"),
                Player("Tyler", "Samaniego", MlbPosition.RELIEF_PITCHER, "98"),
            ),
    )
}

private val mlbTeamChc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Chicago Cubs",
        nameWidthPercent = 53.4f,
        abbreviation = "CHC",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF0E3386),
                nameAccent = Color(0xFFCC3433),
            ),
        venue =
            TeamVenue(
                name = "Wrigley Field",
                location =
                    VenueLocation(
                        lat = 41.948056,
                        long = -87.655556,
                    ),
            ),
        roster =
            listOf(
                Player("Nico", "Hoerner", MlbPosition.SECOND_BASE, "2"),
                Player("Pete", "Crow-Armstrong", MlbPosition.CENTER_FIELD, "4"),
                Player("Matt", "Shaw", MlbPosition.THIRD_BASE, "6"),
                Player("Dansby", "Swanson", MlbPosition.SHORTSTOP, "7"),
                Player("Ian", "Happ", MlbPosition.LEFT_FIELD, "8"),
                Player("Miguel", "Amaya", MlbPosition.CATCHER, "9"),
                Player("Kevin", "Alcantara", MlbPosition.RIGHT_FIELD, "13"),
                Player("Carson", "Kelly", MlbPosition.CATCHER, "15"),
                Player("Matthew", "Boyd", MlbPosition.STARTING_PITCHER, "16"),
                Player("Pedro", "Ramirez", MlbPosition.SECOND_BASE, "18"),
                Player("James", "Triantos", MlbPosition.SECOND_BASE, "18"),
                Player("Owen", "Caissie", MlbPosition.RIGHT_FIELD, "19"),
                Player("Cade", "Horton", MlbPosition.STARTING_PITCHER, "22"),
                Player("Tyler", "Austin", MlbPosition.FIRST_BASE, "23"),
                Player("Caleb", "Thielbar", MlbPosition.RELIEF_PITCHER, "24"),
                Player("Moises", "Ballesteros", MlbPosition.CATCHER, "25"),
                Player("Seiya", "Suzuki", MlbPosition.RIGHT_FIELD, "27"),
                Player("Michael", "Busch", MlbPosition.FIRST_BASE, "29"),
                Player("Ben", "Brown", MlbPosition.STARTING_PITCHER, "32"),
                Player("Justin", "Steele", MlbPosition.STARTING_PITCHER, "35"),
                Player("Jordan", "Wicks", MlbPosition.RELIEF_PITCHER, "36"),
                Player("Porter", "Hodge", MlbPosition.RELIEF_PITCHER, "37"),
                Player("Jack", "Neely", MlbPosition.RELIEF_PITCHER, "37"),
                Player("Ethan", "Roberts", MlbPosition.RELIEF_PITCHER, "39"),
                Player("Hoby", "Milner", MlbPosition.RELIEF_PITCHER, "41"),
                Player("Luke", "Little", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Gavin", "Hollowell", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Daniel", "Palencia", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Jameson", "Taillon", MlbPosition.STARTING_PITCHER, "50"),
                Player("Colin", "Rea", MlbPosition.STARTING_PITCHER, "53"),
                Player("Jacob", "Webb", MlbPosition.RELIEF_PITCHER, "71"),
                Player("Javier", "Assad", MlbPosition.STARTING_PITCHER, "72"),
                Player("Riley", "Martin", MlbPosition.RELIEF_PITCHER, "94"),
            ),
    )
}

private val mlbTeamChw by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Chicago White Sox",
        nameWidthPercent = 72.6f,
        abbreviation = "CHW",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFC4CED4),
            ),
        venue =
            TeamVenue(
                name = "Guaranteed Rate Field",
                location =
                    VenueLocation(
                        lat = 41.830000,
                        long = -87.633889,
                    ),
            ),
        roster =
            listOf(
                Player("Ben", "Cowles", MlbPosition.THIRD_BASE, "2"),
                Player("Munetaka", "Murakami", MlbPosition.FIRST_BASE, "5"),
                Player("Edgar", "Quero", MlbPosition.CATCHER, "7"),
                Player("Kyle", "Teel", MlbPosition.CATCHER, "8"),
                Player("Chase", "Meidroth", MlbPosition.SHORTSTOP, "10"),
                Player("Colson", "Montgomery", MlbPosition.SHORTSTOP, "12"),
                Player("Miguel", "Vargas", MlbPosition.THIRD_BASE, "20"),
                Player("Andrew", "Benintendi", MlbPosition.LEFT_FIELD, "23"),
                Player("Tristan", "Peters", MlbPosition.LEFT_FIELD, "25"),
                Player("Korey", "Lee", MlbPosition.CATCHER, "26"),
                Player("Curtis", "Mead", MlbPosition.FIRST_BASE, "29"),
                Player("Sean", "Newcomb", MlbPosition.RELIEF_PITCHER, "31"),
                Player("Grant", "Taylor", MlbPosition.RELIEF_PITCHER, "31"),
                Player("Drew", "Thorpe", MlbPosition.STARTING_PITCHER, "33"),
                Player("Tyler", "Gilbert", MlbPosition.RELIEF_PITCHER, "40"),
                Player("Bryan", "Ramos", MlbPosition.THIRD_BASE, "44"),
                Player("Everson", "Pereira", MlbPosition.CENTER_FIELD, "45"),
                Player("Alexander", "Alberto", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Derek", "Hill", MlbPosition.CENTER_FIELD, "47"),
                Player("Jonathan", "Cannon", MlbPosition.STARTING_PITCHER, "48"),
                Player("Jordan", "Leasure", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Lenyn", "Sosa", MlbPosition.SECOND_BASE, "50"),
                Player("Brandon", "Eisert", MlbPosition.RELIEF_PITCHER, "53"),
                Player("Fraser", "Ellard", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Ky", "Bush", MlbPosition.STARTING_PITCHER, "57"),
                Player("Jairo", "Iriarte", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Sean", "Burke", MlbPosition.STARTING_PITCHER, "59"),
                Player("Bryan", "Hudson", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Mike", "Vasil", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Shane", "Smith", MlbPosition.STARTING_PITCHER, "64"),
                Player("Davis", "Martin", MlbPosition.STARTING_PITCHER, "65"),
                Player("Prelander", "Berroa", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Wikelman", "Gonzalez", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Chris", "Murphy", MlbPosition.RELIEF_PITCHER, "72"),
                Player("Duncan", "Davitt", MlbPosition.RELIEF_PITCHER, "80"),
                Player("Tanner", "Murray", MlbPosition.SECOND_BASE, "84"),
                Player("Luis", "Robert", MlbPosition.CENTER_FIELD, "88", "Jr."),
            ),
    )
}

private val mlbTeamCin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Cincinnati Reds",
        nameWidthPercent = 59.5f,
        abbreviation = "CIN",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFC6011F),
                nameAccent = Color(0xFFFFFFFF),
            ),
        venue =
            TeamVenue(
                name = "Great American Ball Park",
                location =
                    VenueLocation(
                        lat = 39.097222,
                        long = -84.506944,
                    ),
            ),
        roster =
            listOf(
                Player("Gavin", "Lux", MlbPosition.LEFT_FIELD, "2"),
                Player("Ke'Bryan", "Hayes", MlbPosition.THIRD_BASE, "3"),
                Player("Noelvi", "Marte", MlbPosition.THIRD_BASE, "4"),
                Player("Spencer", "Steer", MlbPosition.FIRST_BASE, "7"),
                Player("Matt", "McLain", MlbPosition.SECOND_BASE, "9"),
                Player("Emilio", "Pagan", MlbPosition.RELIEF_PITCHER, "15"),
                Player("Hunter", "Greene", MlbPosition.STARTING_PITCHER, "21"),
                Player("Graham", "Ashcraft", MlbPosition.RELIEF_PITCHER, "23"),
                Player("Rhett", "Lowder", MlbPosition.STARTING_PITCHER, "25"),
                Player("Chase", "Burns", MlbPosition.STARTING_PITCHER, "26"),
                Player("Sal", "Stewart", MlbPosition.THIRD_BASE, "27"),
                Player("TJ", "Friedl", MlbPosition.CENTER_FIELD, "29"),
                Player("Will", "Benson", MlbPosition.LEFT_FIELD, "30"),
                Player("Tyler", "Callihan", MlbPosition.LEFT_FIELD, "32"),
                Player("Christian", "Encarnacion-Strand", MlbPosition.FIRST_BASE, "33"),
                Player("Connor", "Phillips", MlbPosition.RELIEF_PITCHER, "34"),
                Player("Jose", "Trevino", MlbPosition.CATCHER, "35"),
                Player("Tyler", "Stephenson", MlbPosition.CATCHER, "37"),
                Player("Ben", "Rortvedt", MlbPosition.CATCHER, "38"),
                Player("Julian", "Aguiar", MlbPosition.STARTING_PITCHER, "39"),
                Player("Nick", "Lodolo", MlbPosition.STARTING_PITCHER, "40"),
                Player("Andrew", "Abbott", MlbPosition.STARTING_PITCHER, "41"),
                Player("Hector", "Rodriguez", MlbPosition.LEFT_FIELD, "43"),
                Player("Elly", "De La Cruz", MlbPosition.SHORTSTOP, "44"),
                Player("Caleb", "Ferguson", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Luis", "Mey", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Sam", "Moll", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Brady", "Singer", MlbPosition.STARTING_PITCHER, "51"),
                Player("Edwin", "Arroyo", MlbPosition.SHORTSTOP, "56"),
                Player("Rece", "Hinds", MlbPosition.RIGHT_FIELD, "57"),
                Player("Blake", "Dunn", MlbPosition.LEFT_FIELD, "59"),
                Player("Chase", "Petty", MlbPosition.STARTING_PITCHER, "61"),
                Player("Tony", "Santillan", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Brandon", "Williamson", MlbPosition.STARTING_PITCHER, "65"),
                Player("Yosver", "Zulueta", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Carson", "Spiers", MlbPosition.STARTING_PITCHER, "68"),
                Player("Keegan", "Thompson", MlbPosition.RELIEF_PITCHER, "71"),
                Player("Lyon", "Richardson", MlbPosition.RELIEF_PITCHER, "72"),
                Player("Leonado", "Balcazar", MlbPosition.SHORTSTOP, "85"),
            ),
    )
}

private val mlbTeamCle by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Cleveland Guardians",
        nameWidthPercent = 80.1f,
        abbreviation = "CLE",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF002B5C),
                nameAccent = Color(0xFFE31937),
            ),
        venue =
            TeamVenue(
                name = "Progressive Field",
                location =
                    VenueLocation(
                        lat = 41.495833,
                        long = -81.685278,
                    ),
            ),
        roster =
            listOf(
                Player("Petey", "Halpin", MlbPosition.CENTER_FIELD, "0"),
                Player("Angel", "Martinez", MlbPosition.CENTER_FIELD, "1"),
                Player("CJ", "Kayfus", MlbPosition.FIRST_BASE, "2"),
                Player("Brayan", "Rocchio", MlbPosition.SHORTSTOP, "4"),
                Player("David", "Fry", MlbPosition.FIRST_BASE, "6"),
                Player("George", "Valera", MlbPosition.RIGHT_FIELD, "7"),
                Player("Kyle", "Manzardo", MlbPosition.FIRST_BASE, "9"),
                Player("Daniel", "Schneemann", MlbPosition.SECOND_BASE, "10"),
                Player("Jose", "Ramirez", MlbPosition.THIRD_BASE, "11"),
                Player("Gabriel", "Arias", MlbPosition.SHORTSTOP, "13"),
                Player("Angel", "Genao", MlbPosition.THIRD_BASE, "16"),
                Player("Nolan", "Jones", MlbPosition.RIGHT_FIELD, "22"),
                Player("Bo", "Naylor", MlbPosition.CATCHER, "23"),
                Player("Chase", "DeLauter", MlbPosition.RIGHT_FIELD, "24"),
                Player("Logan", "Allen", MlbPosition.STARTING_PITCHER, "26"),
                Player("Austin", "Hedges", MlbPosition.CATCHER, "27"),
                Player("Tanner", "Bibee", MlbPosition.STARTING_PITCHER, "28"),
                Player("Tim", "Herrin", MlbPosition.RELIEF_PITCHER, "29"),
                Player("Johnathan", "Rodriguez", MlbPosition.RIGHT_FIELD, "30"),
                Player("Gavin", "Williams", MlbPosition.STARTING_PITCHER, "32"),
                Player("Hunter", "Gaddis", MlbPosition.RELIEF_PITCHER, "33"),
                Player("Colin", "Holderman", MlbPosition.RELIEF_PITCHER, "35"),
                Player("Cade", "Smith", MlbPosition.RELIEF_PITCHER, "36"),
                Player("Steven", "Kwan", MlbPosition.LEFT_FIELD, "38"),
                Player("Shawn", "Armstrong", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Slade", "Cecconi", MlbPosition.STARTING_PITCHER, "44"),
                Player("Matt", "Festa", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Joey", "Cantillo", MlbPosition.RELIEF_PITCHER, "54"),
                Player("Justin", "Bruihl", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Erik", "Sabrowski", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Doug", "Nikhazy", MlbPosition.STARTING_PITCHER, "65"),
                Player("Daniel", "Espino", MlbPosition.STARTING_PITCHER, "66"),
                Player("Kahlil", "Watson", MlbPosition.LEFT_FIELD, "71"),
                Player("Juan", "Brito", MlbPosition.SHORTSTOP, "74"),
                Player("Parker", "Messick", MlbPosition.STARTING_PITCHER, "77"),
                Player("Peyton", "Pallette", MlbPosition.RELIEF_PITCHER, "80"),
                Player("Andrew", "Walters", MlbPosition.RELIEF_PITCHER, "91"),
                Player("Franco", "Aleman", MlbPosition.RELIEF_PITCHER, "92"),
            ),
    )
}

private val mlbTeamCol by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Colorado Rockies",
        nameWidthPercent = 67.9f,
        abbreviation = "COL",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF33006F),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Coors Field",
                location =
                    VenueLocation(
                        lat = 39.756111,
                        long = -104.994167,
                    ),
            ),
        roster =
            listOf(
                Player("Jaden", "Hill", MlbPosition.RELIEF_PITCHER, "0"),
                Player("Adael", "Amador", MlbPosition.SECOND_BASE, "1"),
                Player("Tyler", "Freeman", MlbPosition.RIGHT_FIELD, "2"),
                Player("Ryan", "Ritter", MlbPosition.SHORTSTOP, "8"),
                Player("Brenton", "Doyle", MlbPosition.CENTER_FIELD, "9"),
                Player("Kyle", "Karros", MlbPosition.THIRD_BASE, "12"),
                Player("Zac", "Veen", MlbPosition.LEFT_FIELD, "13"),
                Player("Ezequiel", "Tovar", MlbPosition.SHORTSTOP, "14"),
                Player("Hunter", "Goodman", MlbPosition.CATCHER, "15"),
                Player("Blaine", "Crim", MlbPosition.FIRST_BASE, "16"),
                Player("Ryan", "Feltner", MlbPosition.STARTING_PITCHER, "18"),
                Player("Troy", "Johnston", MlbPosition.OUTFIELD, "20"),
                Player("Kyle", "Freeland", MlbPosition.STARTING_PITCHER, "21"),
                Player("Mickey", "Moniak", MlbPosition.RIGHT_FIELD, "22"),
                Player("Kris", "Bryant", MlbPosition.DESIGNATED_HITTER, "23"),
                Player("Jordan", "Beck", MlbPosition.LEFT_FIELD, "27"),
                Player("Tanner", "Gordon", MlbPosition.STARTING_PITCHER, "29"),
                Player("Sterlin", "Thompson", MlbPosition.OUTFIELD, "30"),
                Player("Chase", "Dollander", MlbPosition.STARTING_PITCHER, "32"),
                Player("Yanquiel", "Fernandez", MlbPosition.RIGHT_FIELD, "35"),
                Player("Zach", "Agnos", MlbPosition.RELIEF_PITCHER, "36"),
                Player("Braxton", "Fulford", MlbPosition.CATCHER, "37"),
                Player("Victor", "Vodnik", MlbPosition.RELIEF_PITCHER, "38"),
                Player("Luis", "Peralta", MlbPosition.RELIEF_PITCHER, "41"),
                Player("Jimmy", "Herget", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Carson", "Palmquist", MlbPosition.STARTING_PITCHER, "45"),
                Player("Jeff", "Criswell", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Juan", "Mejia", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Antonio", "Senzatela", MlbPosition.STARTING_PITCHER, "49"),
                Player("McCade", "Brown", MlbPosition.STARTING_PITCHER, "51"),
                Player("Garrett", "Acton", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Seth", "Halvorsen", MlbPosition.RELIEF_PITCHER, "54"),
                Player("Angel", "Chivilli", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Roansy", "Contreras", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Bradley", "Blalock", MlbPosition.STARTING_PITCHER, "64"),
                Player("Gabriel", "Hughes", MlbPosition.STARTING_PITCHER, "79"),
                Player("Brennan", "Bernardino", MlbPosition.RELIEF_PITCHER, "83"),
            ),
    )
}

private val mlbTeamDet by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Detroit Tigers",
        nameWidthPercent = 53.4f,
        abbreviation = "DET",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF0A2240),
                nameAccent = Color(0xFFFF4713),
            ),
        venue =
            TeamVenue(
                name = "Comerica Park",
                location =
                    VenueLocation(
                        lat = 42.339167,
                        long = -83.048611,
                    ),
            ),
        roster =
            listOf(
                Player("Beau", "Brieske", MlbPosition.RELIEF_PITCHER, "4"),
                Player("Matt", "Vierling", MlbPosition.CENTER_FIELD, "8"),
                Player("Jack", "Flaherty", MlbPosition.STARTING_PITCHER, "9"),
                Player("Casey", "Mize", MlbPosition.STARTING_PITCHER, "12"),
                Player("Dillon", "Dingler", MlbPosition.CATCHER, "13"),
                Player("Jace", "Jung", MlbPosition.THIRD_BASE, "17"),
                Player("Jahmai", "Jones", MlbPosition.RIGHT_FIELD, "18"),
                Player("Will", "Vest", MlbPosition.RELIEF_PITCHER, "19"),
                Player("Spencer", "Torkelson", MlbPosition.FIRST_BASE, "20"),
                Player("Jackson", "Jobe", MlbPosition.STARTING_PITCHER, "21"),
                Player("Parker", "Meadows", MlbPosition.CENTER_FIELD, "22"),
                Player("Gleyber", "Torres", MlbPosition.SECOND_BASE, "25"),
                Player("Trey", "Sweeney", MlbPosition.SHORTSTOP, "27"),
                Player("Javier", "Baez", MlbPosition.CENTER_FIELD, "28"),
                Player("Tarik", "Skubal", MlbPosition.STARTING_PITCHER, "29"),
                Player("Kerry", "Carpenter", MlbPosition.RIGHT_FIELD, "30"),
                Player("Riley", "Greene", MlbPosition.LEFT_FIELD, "31"),
                Player("Eduardo", "Valencia", MlbPosition.CATCHER, "32"),
                Player("Colt", "Keith", MlbPosition.SECOND_BASE, "33"),
                Player("Jake", "Rogers", MlbPosition.CATCHER, "34"),
                Player("Ty", "Madden", MlbPosition.STARTING_PITCHER, "36"),
                Player("Drew", "Anderson", MlbPosition.RELIEF_PITCHER, "38"),
                Player("Zach", "McKinstry", MlbPosition.THIRD_BASE, "39"),
                Player("Trei", "Cruz", MlbPosition.CENTER_FIELD, "40"),
                Player("Justyn-Henry", "Malloy", MlbPosition.RIGHT_FIELD, "44"),
                Player("Reese", "Olson", MlbPosition.STARTING_PITCHER, "45"),
                Player("Wenceel", "Perez", MlbPosition.RIGHT_FIELD, "46"),
                Player("Brant", "Hurter", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Thayron", "Liranzo", MlbPosition.CATCHER, "49"),
                Player("Hao-Yu", "Lee", MlbPosition.SECOND_BASE, "50"),
                Player("Drew", "Sommers", MlbPosition.RELIEF_PITCHER, "51"),
                Player("Troy", "Melton", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Keider", "Montero", MlbPosition.STARTING_PITCHER, "54"),
                Player("Bailey", "Horn", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Dylan", "Smith", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Sawyer", "Gipson-Long", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Kyle", "Finnegan", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Sean", "Guenther", MlbPosition.RELIEF_PITCHER, "73"),
                Player("Kenley", "Jansen", MlbPosition.RELIEF_PITCHER, "74"),
                Player("Brenan", "Hanifee", MlbPosition.RELIEF_PITCHER, "75"),
                Player("Tyler", "Holton", MlbPosition.RELIEF_PITCHER, "87"),
            ),
    )
}

private val mlbTeamHou by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Houston Astros",
        nameWidthPercent = 60.5f,
        abbreviation = "HOU",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF002D62),
                nameAccent = Color(0xFFEB6E1F),
            ),
        venue =
            TeamVenue(
                name = "Minute Maid Park",
                location =
                    VenueLocation(
                        lat = 29.756944,
                        long = -95.355556,
                    ),
            ),
        roster =
            listOf(
                Player("Carlos", "Correa", MlbPosition.SHORTSTOP, "1"),
                Player("Nick", "Allen", MlbPosition.SHORTSTOP, "2"),
                Player("Jeremy", "Pena", MlbPosition.SHORTSTOP, "3"),
                Player("Jesus", "Sanchez", MlbPosition.RIGHT_FIELD, "4"),
                Player("Jake", "Meyers", MlbPosition.CENTER_FIELD, "6"),
                Player("Christian", "Walker", MlbPosition.FIRST_BASE, "8"),
                Player("Zach", "Dezenzo", MlbPosition.LEFT_FIELD, "9"),
                Player("Shay", "Whitcomb", MlbPosition.LEFT_FIELD, "10"),
                Player("Cam", "Smith", MlbPosition.RIGHT_FIELD, "11"),
                Player("Isaac", "Paredes", MlbPosition.THIRD_BASE, "15"),
                Player("Zach", "Cole", MlbPosition.CENTER_FIELD, "16"),
                Player("Cesar", "Salazar", MlbPosition.CATCHER, "18"),
                Player("Yainer", "Diaz", MlbPosition.CATCHER, "21"),
                Player("Jose", "Altuve", MlbPosition.LEFT_FIELD, "27"),
                Player("Brice", "Matthews", MlbPosition.SHORTSTOP, "28"),
                Player("Roddery", "Munoz", MlbPosition.RELIEF_PITCHER, "35"),
                Player("Hayden", "Wesneski", MlbPosition.STARTING_PITCHER, "39"),
                Player("Spencer", "Arrighetti", MlbPosition.STARTING_PITCHER, "41"),
                Player("Lance", "McCullers", MlbPosition.STARTING_PITCHER, "43", "Jr."),
                Player("Yordan", "Alvarez", MlbPosition.LEFT_FIELD, "44"),
                Player("Steven", "Okert", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Bryan", "Abreu", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Mike", "Burrows", MlbPosition.STARTING_PITCHER, "53"),
                Player("Cristian", "Javier", MlbPosition.STARTING_PITCHER, "53"),
                Player("Jason", "Alexander", MlbPosition.STARTING_PITCHER, "54"),
                Player("Ronel", "Blanco", MlbPosition.STARTING_PITCHER, "56"),
                Player("Nate", "Pearson", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Hunter", "Brown", MlbPosition.STARTING_PITCHER, "58"),
                Player("Brandon", "Walter", MlbPosition.STARTING_PITCHER, "60"),
                Player("Colton", "Gordon", MlbPosition.STARTING_PITCHER, "61"),
                Player("Bennett", "Sousa", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Kaleb", "Ort", MlbPosition.RELIEF_PITCHER, "63"),
                Player("J.P.", "France", MlbPosition.STARTING_PITCHER, "68"),
                Player("AJ", "Blubaugh", MlbPosition.RELIEF_PITCHER, "69"),
                Player("Ryan", "Weiss", MlbPosition.RELIEF_PITCHER, "69"),
                Player("Jayden", "Murray", MlbPosition.RELIEF_PITCHER, "70"),
                Player("Josh", "Hader", MlbPosition.RELIEF_PITCHER, "71"),
                Player("Bryan", "King", MlbPosition.RELIEF_PITCHER, "74"),
                Player("Miguel", "Ullola", MlbPosition.STARTING_PITCHER, "78"),
            ),
    )
}

private val mlbTeamKc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Kansas City Royals",
        nameWidthPercent = 72.0f,
        abbreviation = "KC",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF004687),
                nameAccent = Color(0xFF7AB2DD),
            ),
        venue =
            TeamVenue(
                name = "Kauffman Stadium",
                location =
                    VenueLocation(
                        lat = 39.051389,
                        long = -94.480556,
                    ),
            ),
        roster =
            listOf(
                Player("Isaac", "Collins", MlbPosition.LEFT_FIELD, "1"),
                Player("Tyler", "Tolbert", MlbPosition.SECOND_BASE, "2"),
                Player("Jonathan", "India", MlbPosition.SECOND_BASE, "6"),
                Player("Bobby", "Witt", MlbPosition.SHORTSTOP, "7", "Jr."),
                Player("Drew", "Waters", MlbPosition.LEFT_FIELD, "8"),
                Player("Vinnie", "Pasquantino", MlbPosition.FIRST_BASE, "9"),
                Player("Maikel", "Garcia", MlbPosition.THIRD_BASE, "11"),
                Player("Nick", "Loftin", MlbPosition.LEFT_FIELD, "12"),
                Player("Salvador", "Perez", MlbPosition.CATCHER, "13"),
                Player("Jac", "Caglianone", MlbPosition.RIGHT_FIELD, "14"),
                Player("Lane", "Thomas", MlbPosition.CENTER_FIELD, "15"),
                Player("John", "Rave", MlbPosition.RIGHT_FIELD, "16"),
                Player("Michael", "Massey", MlbPosition.SECOND_BASE, "19"),
                Player("Carter", "Jensen", MlbPosition.CATCHER, "22"),
                Player("Matt", "Strahm", MlbPosition.RELIEF_PITCHER, "25"),
                Player("Kameron", "Misner", MlbPosition.CENTER_FIELD, "26"),
                Player("Kyle", "Isbel", MlbPosition.CENTER_FIELD, "28"),
                Player("Kyle", "Wright", MlbPosition.STARTING_PITCHER, "30"),
                Player("Nick", "Mears", MlbPosition.RELIEF_PITCHER, "31"),
                Player("Stephen", "Kolek", MlbPosition.STARTING_PITCHER, "32"),
                Player("Bailey", "Falter", MlbPosition.STARTING_PITCHER, "36"),
                Player("Ryan", "Bergert", MlbPosition.STARTING_PITCHER, "38"),
                Player("Daniel", "Lynch", MlbPosition.RELIEF_PITCHER, "41", "IV"),
                Player("Dairon", "Blanco", MlbPosition.CENTER_FIELD, "44"),
                Player("John", "Schreiber", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Mason", "Black", MlbPosition.STARTING_PITCHER, "47"),
                Player("Alec", "Marsh", MlbPosition.STARTING_PITCHER, "48"),
                Player("Kris", "Bubic", MlbPosition.STARTING_PITCHER, "50"),
                Player("Michael", "Wacha", MlbPosition.STARTING_PITCHER, "52"),
                Player("Carlos", "Estevez", MlbPosition.RELIEF_PITCHER, "53"),
                Player("Alex", "Lange", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Cole", "Ragans", MlbPosition.STARTING_PITCHER, "55"),
                Player("Luinder", "Avila", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Ben", "Kudrna", MlbPosition.STARTING_PITCHER, "59"),
                Player("Lucas", "Erceg", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Steven", "Zobac", MlbPosition.STARTING_PITCHER, "63"),
                Player("Steven", "Cruz", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Noah", "Cameron", MlbPosition.STARTING_PITCHER, "65"),
                Player("James", "McArthur", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Seth", "Lugo", MlbPosition.STARTING_PITCHER, "67"),
                Player("Eric", "Cerantola", MlbPosition.RELIEF_PITCHER, "87"),
            ),
    )
}

private val mlbTeamLaa by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Los Angeles Angels",
        nameWidthPercent = 74.3f,
        abbreviation = "LAA",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFBA0021),
                nameAccent = Color(0xFFC4CED4),
            ),
        venue =
            TeamVenue(
                name = "Angel Stadium of Anaheim",
                location =
                    VenueLocation(
                        lat = 33.800278,
                        long = -117.882778,
                    ),
            ),
        roster =
            listOf(
                Player("Christian", "Moore", MlbPosition.SECOND_BASE, "4"),
                Player("Vaughn", "Grissom", MlbPosition.SECOND_BASE, "5"),
                Player("Anthony", "Rendon", MlbPosition.THIRD_BASE, "6"),
                Player("Jo", "Adell", MlbPosition.CENTER_FIELD, "7"),
                Player("Zach", "Neto", MlbPosition.SHORTSTOP, "9"),
                Player("Oswald", "Peraza", MlbPosition.THIRD_BASE, "10"),
                Player("Jorge", "Soler", MlbPosition.RIGHT_FIELD, "12"),
                Player("Denzer", "Guzman", MlbPosition.SHORTSTOP, "13"),
                Player("Drew", "Pomeranz", MlbPosition.RELIEF_PITCHER, "13"),
                Player("Logan", "O'Hoppe", MlbPosition.CATCHER, "14"),
                Player("Matthew", "Lugo", MlbPosition.LEFT_FIELD, "15"),
                Player("Yusei", "Kikuchi", MlbPosition.STARTING_PITCHER, "16"),
                Player("Nolan", "Schanuel", MlbPosition.FIRST_BASE, "18"),
                Player("Kyren", "Paris", MlbPosition.SECOND_BASE, "19"),
                Player("Bryce", "Teodosio", MlbPosition.CENTER_FIELD, "22"),
                Player("Robert", "Stephenson", MlbPosition.RELIEF_PITCHER, "24"),
                Player("Travis", "d'Arnaud", MlbPosition.CATCHER, "25"),
                Player("Mike", "Trout", MlbPosition.RIGHT_FIELD, "27"),
                Player("Grayson", "Rodriguez", MlbPosition.STARTING_PITCHER, "30"),
                Player("Ryan", "Johnson", MlbPosition.RELIEF_PITCHER, "32"),
                Player("Caden", "Dana", MlbPosition.STARTING_PITCHER, "36"),
                Player("Sam", "Bachman", MlbPosition.RELIEF_PITCHER, "40"),
                Player("Jack", "Kochanowicz", MlbPosition.STARTING_PITCHER, "41"),
                Player("Ben", "Joyce", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Brock", "Burke", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Alek", "Manoah", MlbPosition.STARTING_PITCHER, "47"),
                Player("Reid", "Detmers", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Ryan", "Zeferjahn", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Victor", "Mederos", MlbPosition.STARTING_PITCHER, "58"),
                Player("Jose", "Soriano", MlbPosition.STARTING_PITCHER, "59"),
                Player("Sam", "Aldegheri", MlbPosition.STARTING_PITCHER, "61"),
                Player("Chase", "Silseth", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Cody", "Laweryson", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Walbert", "Urena", MlbPosition.STARTING_PITCHER, "66"),
                Player("Jose", "Fermin", MlbPosition.RELIEF_PITCHER, "68"),
                Player("Jordan", "Romano", MlbPosition.RELIEF_PITCHER, "68"),
                Player("Mitch", "Farris", MlbPosition.STARTING_PITCHER, "70"),
            ),
    )
}

private val mlbTeamLad by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Los Angeles Dodgers",
        nameWidthPercent = 81.1f,
        abbreviation = "LAD",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF005A9C),
                nameAccent = Color(0xFFFFFFFF),
            ),
        venue =
            TeamVenue(
                name = "Dodger Stadium",
                location =
                    VenueLocation(
                        lat = 34.073611,
                        long = -118.240000,
                    ),
            ),
        roster =
            listOf(
                Player("Freddie", "Freeman", MlbPosition.FIRST_BASE, "5"),
                Player("Hyeseong", "Kim", MlbPosition.SECOND_BASE, "6"),
                Player("Blake", "Snell", MlbPosition.STARTING_PITCHER, "7"),
                Player("Roki", "Sasaki", MlbPosition.STARTING_PITCHER, "11"),
                Player("Alex", "Call", MlbPosition.RIGHT_FIELD, "12"),
                Player("Max", "Muncy", MlbPosition.THIRD_BASE, "13"),
                Player("Will", "Smith", MlbPosition.CATCHER, "16"),
                Player("Shohei", "Ohtani", MlbPosition.DESIGNATED_HITTER, "17"),
                Player("Yoshinobu", "Yamamoto", MlbPosition.STARTING_PITCHER, "18"),
                Player("Michael", "Siani", MlbPosition.CENTER_FIELD, "22"),
                Player("Tommy", "Edman", MlbPosition.SECOND_BASE, "25"),
                Player("Esteury", "Ruiz", MlbPosition.LEFT_FIELD, "27"),
                Player("Bobby", "Miller", MlbPosition.STARTING_PITCHER, "28"),
                Player("Tyler", "Glasnow", MlbPosition.STARTING_PITCHER, "31"),
                Player("Gavin", "Stone", MlbPosition.STARTING_PITCHER, "35"),
                Player("Teoscar", "Hernandez", MlbPosition.RIGHT_FIELD, "37"),
                Player("Edwin", "Diaz", MlbPosition.RELIEF_PITCHER, "39"),
                Player("Brock", "Stewart", MlbPosition.RELIEF_PITCHER, "41"),
                Player("Anthony", "Banda", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Andy", "Pages", MlbPosition.CENTER_FIELD, "44"),
                Player("Brusdar", "Graterol", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Blake", "Treinen", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Mookie", "Betts", MlbPosition.SHORTSTOP, "50"),
                Player("Alex", "Vesia", MlbPosition.RELIEF_PITCHER, "51"),
                Player("Ryan", "Ward", MlbPosition.LEFT_FIELD, "56"),
                Player("Edgardo", "Henriquez", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Will", "Klein", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Kyle", "Hurt", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Paul", "Gervase", MlbPosition.RELIEF_PITCHER, "65"),
                Player("Tanner", "Scott", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Dalton", "Rushing", MlbPosition.CATCHER, "68"),
                Player("Justin", "Wrobleski", MlbPosition.RELIEF_PITCHER, "70"),
                Player("Miguel", "Rojas", MlbPosition.SECOND_BASE, "72"),
                Player("Alex", "Freeland", MlbPosition.SHORTSTOP, "76"),
                Player("River", "Ryan", MlbPosition.STARTING_PITCHER, "77"),
                Player("Ben", "Casparius", MlbPosition.RELIEF_PITCHER, "78"),
                Player("Emmet", "Sheehan", MlbPosition.STARTING_PITCHER, "80"),
                Player("Jack", "Dreyer", MlbPosition.RELIEF_PITCHER, "86"),
                Player("Ronan", "Kopp", MlbPosition.RELIEF_PITCHER, "94"),
                Player("Landon", "Knack", MlbPosition.STARTING_PITCHER, "96"),
            ),
    )
}

private val mlbTeamMia by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Miami Marlins",
        nameWidthPercent = 53.4f,
        abbreviation = "MIA",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF00A3E0),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "LoanDepot Park",
                location =
                    VenueLocation(
                        lat = 25.778056,
                        long = -80.219722,
                    ),
            ),
        roster =
            listOf(
                Player("Connor", "Norby", MlbPosition.THIRD_BASE, "1"),
                Player("Otto", "Lopez", MlbPosition.SECOND_BASE, "6"),
                Player("Xavier", "Edwards", MlbPosition.SHORTSTOP, "9"),
                Player("Victor", "Mesa", MlbPosition.CENTER_FIELD, "10", "Jr."),
                Player("Griffin", "Conine", MlbPosition.LEFT_FIELD, "18"),
                Player("Graham", "Pauley", MlbPosition.THIRD_BASE, "21"),
                Player("Sandy", "Alcantara", MlbPosition.STARTING_PITCHER, "22"),
                Player("Max", "Meyer", MlbPosition.STARTING_PITCHER, "23"),
                Player("Maximo", "Acosta", MlbPosition.SHORTSTOP, "24"),
                Player("Christopher", "Morel", MlbPosition.LEFT_FIELD, "24"),
                Player("Janson", "Junk", MlbPosition.STARTING_PITCHER, "26"),
                Player("Edward", "Cabrera", MlbPosition.STARTING_PITCHER, "27"),
                Player("Kyle", "Stowers", MlbPosition.LEFT_FIELD, "28"),
                Player("Braxton", "Garrett", MlbPosition.STARTING_PITCHER, "29"),
                Player("Tyler", "Phillips", MlbPosition.RELIEF_PITCHER, "30"),
                Player("Ronny", "Henriquez", MlbPosition.RELIEF_PITCHER, "32"),
                Player("Eric", "Wagaman", MlbPosition.FIRST_BASE, "33"),
                Player("Liam", "Hicks", MlbPosition.CATCHER, "34"),
                Player("Ryan", "Weathers", MlbPosition.STARTING_PITCHER, "35"),
                Player("Anthony", "Bender", MlbPosition.RELIEF_PITCHER, "37"),
                Player("Eury", "Perez", MlbPosition.STARTING_PITCHER, "39"),
                Player("Andrew", "Nardi", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Javier", "Sanoja", MlbPosition.SECOND_BASE, "46"),
                Player("Michael", "Petersen", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Agustin", "Ramirez", MlbPosition.CATCHER, "50"),
                Player("Calvin", "Faucher", MlbPosition.RELIEF_PITCHER, "53"),
                Player("William", "Kempner", MlbPosition.RELIEF_PITCHER, "53"),
                Player("Dane", "Myers", MlbPosition.CENTER_FIELD, "54"),
                Player("Cade", "Gibson", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Adam", "Mazur", MlbPosition.STARTING_PITCHER, "60"),
                Player("Heriberto", "Hernandez", MlbPosition.LEFT_FIELD, "64"),
                Player("Deyvison", "De Los Santos", MlbPosition.THIRD_BASE, "65"),
                Player("Ryan", "Gusto", MlbPosition.STARTING_PITCHER, "65"),
                Player("Josh", "Simpson", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Jared", "Serna", MlbPosition.SHORTSTOP, "68"),
                Player("Joe", "Mack", MlbPosition.CATCHER, "80"),
                Player("Lake", "Bachar", MlbPosition.RELIEF_PITCHER, "84"),
                Player("Jakob", "Marsee", MlbPosition.CENTER_FIELD, "87"),
                Player("Dax", "Fulton", MlbPosition.STARTING_PITCHER, "90"),
                Player("Joshua", "White", MlbPosition.RELIEF_PITCHER, "92"),
            ),
    )
}

private val mlbTeamMil by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Milwaukee Brewers",
        nameWidthPercent = 75.0f,
        abbreviation = "MIL",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF13294B),
                nameAccent = Color(0xFFFFC72C),
            ),
        venue =
            TeamVenue(
                name = "American Family Field",
                location =
                    VenueLocation(
                        lat = 43.028333,
                        long = -87.971111,
                    ),
            ),
        roster =
            listOf(
                Player("Carlos", "Rodriguez", MlbPosition.RELIEF_PITCHER, "0"),
                Player("Brice", "Turang", MlbPosition.SECOND_BASE, "2"),
                Player("Joey", "Ortiz", MlbPosition.SHORTSTOP, "3"),
                Player("Garrett", "Mitchell", MlbPosition.CENTER_FIELD, "5"),
                Player("Tyler", "Black", MlbPosition.THIRD_BASE, "7"),
                Player("Jake", "Bauers", MlbPosition.FIRST_BASE, "9"),
                Player("Sal", "Frelick", MlbPosition.RIGHT_FIELD, "10"),
                Player("Jackson", "Chourio", MlbPosition.CENTER_FIELD, "11"),
                Player("Andruw", "Monasterio", MlbPosition.SHORTSTOP, "14"),
                Player("Blake", "Perkins", MlbPosition.CENTER_FIELD, "16"),
                Player("Anthony", "Seigler", MlbPosition.SECOND_BASE, "18"),
                Player("Brandon", "Lockridge", MlbPosition.LEFT_FIELD, "20"),
                Player("Caleb", "Durbin", MlbPosition.THIRD_BASE, "21"),
                Player("Christian", "Yelich", MlbPosition.LEFT_FIELD, "22"),
                Player("William", "Contreras", MlbPosition.CATCHER, "24"),
                Player("Aaron", "Ashby", MlbPosition.RELIEF_PITCHER, "26"),
                Player("Andrew", "Vaughn", MlbPosition.FIRST_BASE, "28"),
                Player("Trevor", "Megill", MlbPosition.RELIEF_PITCHER, "29"),
                Player("Jacob", "Misiorowski", MlbPosition.STARTING_PITCHER, "32"),
                Player("Steward", "Berroa", MlbPosition.RIGHT_FIELD, "35"),
                Player("Tobias", "Myers", MlbPosition.RELIEF_PITCHER, "36"),
                Player("DL", "Hall", MlbPosition.RELIEF_PITCHER, "37"),
                Player("Chad", "Patrick", MlbPosition.STARTING_PITCHER, "39"),
                Player("Logan", "Henderson", MlbPosition.STARTING_PITCHER, "43"),
                Player("Abner", "Uribe", MlbPosition.RELIEF_PITCHER, "45"),
                Player("Quinn", "Priester", MlbPosition.STARTING_PITCHER, "46"),
                Player("Jared", "Koenig", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Craig", "Yoho", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Easton", "McGee", MlbPosition.STARTING_PITCHER, "50"),
                Player("Freddy", "Peralta", MlbPosition.STARTING_PITCHER, "51"),
                Player("Robert", "Gasser", MlbPosition.STARTING_PITCHER, "54"),
                Player("Grant", "Anderson", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Sammy", "Peralta", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Rob", "Zastryzny", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Akil", "Baddoo", MlbPosition.LEFT_FIELD, "60"),
                Player("Angel", "Zerpa", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Jeferson", "Quero", MlbPosition.CATCHER, "76"),
                Player("Coleman", "Crow", MlbPosition.STARTING_PITCHER, "91"),
            ),
    )
}

private val mlbTeamMin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Minnesota Twins",
        nameWidthPercent = 64.5f,
        abbreviation = "MIN",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF031F40),
                nameAccent = Color(0xFFE20E32),
            ),
        venue =
            TeamVenue(
                name = "Target Field",
                location =
                    VenueLocation(
                        lat = 44.981667,
                        long = -93.278333,
                    ),
            ),
        roster =
            listOf(
                Player("Kody", "Clemens", MlbPosition.SECOND_BASE, "2"),
                Player("Ryan", "Kreidler", MlbPosition.CENTER_FIELD, "6"),
                Player("Trevor", "Larnach", MlbPosition.RIGHT_FIELD, "9"),
                Player("Mickey", "Gasper", MlbPosition.SECOND_BASE, "11"),
                Player("Luke", "Keaschall", MlbPosition.SECOND_BASE, "15"),
                Player("Austin", "Martin", MlbPosition.CENTER_FIELD, "16"),
                Player("Bailey", "Ober", MlbPosition.STARTING_PITCHER, "17"),
                Player("Eric", "Orze", MlbPosition.RELIEF_PITCHER, "17"),
                Player("Alan", "Roden", MlbPosition.LEFT_FIELD, "18"),
                Player("Mick", "Abel", MlbPosition.STARTING_PITCHER, "20"),
                Player("Brooks", "Lee", MlbPosition.THIRD_BASE, "22"),
                Player("Royce", "Lewis", MlbPosition.THIRD_BASE, "23"),
                Player("Simeon", "Woods Richardson", MlbPosition.STARTING_PITCHER, "24"),
                Player("Byron", "Buxton", MlbPosition.CENTER_FIELD, "25"),
                Player("Taj", "Bradley", MlbPosition.STARTING_PITCHER, "26"),
                Player("Ryan", "Jeffers", MlbPosition.CATCHER, "27"),
                Player("Emmanuel", "Rodriguez", MlbPosition.CENTER_FIELD, "32"),
                Player("Gabriel", "Gonzalez", MlbPosition.RIGHT_FIELD, "37"),
                Player("Matt", "Wallner", MlbPosition.RIGHT_FIELD, "38"),
                Player("Joe", "Ryan", MlbPosition.STARTING_PITCHER, "41"),
                Player("James", "Outman", MlbPosition.CENTER_FIELD, "43"),
                Player("Cole", "Sands", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Travis", "Adams", MlbPosition.RELIEF_PITCHER, "45"),
                Player("Edouard", "Julien", MlbPosition.SECOND_BASE, "47"),
                Player("Justin", "Topa", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Pablo", "Lopez", MlbPosition.STARTING_PITCHER, "49"),
                Player("Ryan", "Fitzgerald", MlbPosition.THIRD_BASE, "53"),
                Player("Kody", "Funderburk", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Josh", "Bell", MlbPosition.FIRST_BASE, "56"),
                Player("David", "Festa", MlbPosition.STARTING_PITCHER, "58"),
                Player("Pierson", "Ohl", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Jhonny", "Pereda", MlbPosition.CATCHER, "65"),
                Player("Alex", "Jackson", MlbPosition.CATCHER, "70"),
                Player("Andrew", "Morris", MlbPosition.STARTING_PITCHER, "78"),
                Player("Marco", "Raya", MlbPosition.STARTING_PITCHER, "85"),
                Player("Hendry", "Mendez", MlbPosition.OUTFIELD, "90"),
            ),
    )
}

private val mlbTeamNym by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Mets",
        nameWidthPercent = 58.1f,
        abbreviation = "NYM",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF002D72),
                nameAccent = Color(0xFFFF5910),
            ),
        venue =
            TeamVenue(
                name = "Citi Field",
                location =
                    VenueLocation(
                        lat = 40.756986,
                        long = -73.845783,
                    ),
            ),
        roster =
            listOf(
                Player("Ronny", "Mauricio", MlbPosition.THIRD_BASE, "0"),
                Player("Nick", "Morabito", MlbPosition.CENTER_FIELD, "1"),
                Player("Luisangel", "Acuna", MlbPosition.SECOND_BASE, "2"),
                Player("Ji Hwan", "Bae", MlbPosition.CENTER_FIELD, "3"),
                Player("Francisco", "Alvarez", MlbPosition.CATCHER, "4"),
                Player("Brett", "Baty", MlbPosition.THIRD_BASE, "7"),
                Player("Marcus", "Semien", MlbPosition.SECOND_BASE, "10"),
                Player("Jorge", "Polanco", MlbPosition.SECOND_BASE, "11"),
                Player("Francisco", "Lindor", MlbPosition.SHORTSTOP, "12"),
                Player("Luis", "Torrens", MlbPosition.CATCHER, "13"),
                Player("Tyrone", "Taylor", MlbPosition.CENTER_FIELD, "15"),
                Player("Jonah", "Tong", MlbPosition.STARTING_PITCHER, "21"),
                Player("Juan", "Soto", MlbPosition.RIGHT_FIELD, "22"),
                Player("David", "Peterson", MlbPosition.STARTING_PITCHER, "23"),
                Player("Brooks", "Raley", MlbPosition.RELIEF_PITCHER, "25"),
                Player("Nolan", "McLean", MlbPosition.STARTING_PITCHER, "26"),
                Player("Mark", "Vientos", MlbPosition.THIRD_BASE, "27"),
                Player("Jared", "Young", MlbPosition.LEFT_FIELD, "29"),
                Player("Hayden", "Senger", MlbPosition.CATCHER, "30"),
                Player("Luke", "Weaver", MlbPosition.RELIEF_PITCHER, "30"),
                Player("A.J.", "Minter", MlbPosition.RELIEF_PITCHER, "33"),
                Player("Kodai", "Senga", MlbPosition.STARTING_PITCHER, "34"),
                Player("Clay", "Holmes", MlbPosition.STARTING_PITCHER, "35"),
                Player("Tylor", "Megill", MlbPosition.STARTING_PITCHER, "38"),
                Player("Devin", "Williams", MlbPosition.RELIEF_PITCHER, "38"),
                Player("Brandon", "Sproat", MlbPosition.STARTING_PITCHER, "40"),
                Player("Huascar", "Brazoban", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Austin", "Warren", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Christian", "Scott", MlbPosition.STARTING_PITCHER, "45"),
                Player("Dylan", "Ross", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Justin", "Hagenman", MlbPosition.RELIEF_PITCHER, "51"),
                Player("Joey", "Gerber", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Richard", "Lovelady", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Sean", "Manaea", MlbPosition.STARTING_PITCHER, "59"),
                Player("Cooper", "Criswell", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Dedniel", "Nunez", MlbPosition.RELIEF_PITCHER, "72"),
                Player("Reed", "Garrett", MlbPosition.RELIEF_PITCHER, "75"),
                Player("Alejandro", "Carrillo", MlbPosition.RELIEF_PITCHER, "84"),
                Player("Jonathan", "Pintaro", MlbPosition.RELIEF_PITCHER, "91"),
            ),
    )
}

private val mlbTeamNyy by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Yankees",
        nameWidthPercent = 70.9f,
        abbreviation = "NYY",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF132448),
                nameAccent = Color(0xFFC4CED4),
            ),
        venue =
            TeamVenue(
                name = "Yankee Stadium",
                location =
                    VenueLocation(
                        lat = 40.829569,
                        long = -73.926392,
                    ),
            ),
        roster =
            listOf(
                Player("Anthony", "Volpe", MlbPosition.SHORTSTOP, "11"),
                Player("Trent", "Grisham", MlbPosition.CENTER_FIELD, "12"),
                Player("Jazz", "Chisholm", MlbPosition.SECOND_BASE, "13", "Jr."),
                Player("Ryan", "McMahon", MlbPosition.THIRD_BASE, "19"),
                Player("Ben", "Rice", MlbPosition.FIRST_BASE, "22"),
                Player("Jasson", "Dominguez", MlbPosition.LEFT_FIELD, "24"),
                Player("J.C.", "Escarra", MlbPosition.CATCHER, "25"),
                Player("Giancarlo", "Stanton", MlbPosition.DESIGNATED_HITTER, "27"),
                Player("Austin", "Wells", MlbPosition.CATCHER, "28"),
                Player("Cam", "Schlittler", MlbPosition.STARTING_PITCHER, "31"),
                Player("Ryan", "Yarbrough", MlbPosition.RELIEF_PITCHER, "33"),
                Player("Clarke", "Schmidt", MlbPosition.STARTING_PITCHER, "36"),
                Player("Tim", "Hill", MlbPosition.RELIEF_PITCHER, "41"),
                Player("Gerrit", "Cole", MlbPosition.STARTING_PITCHER, "45"),
                Player("Kervin", "Castro", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Brent", "Headrick", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Elmer", "Cruz-Rodriguez", MlbPosition.STARTING_PITCHER, "50"),
                Player("David", "Bednar", MlbPosition.RELIEF_PITCHER, "53"),
                Player("Max", "Fried", MlbPosition.STARTING_PITCHER, "54"),
                Player("Carlos", "Rodon", MlbPosition.STARTING_PITCHER, "55"),
                Player("Jake", "Bird", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Fernando", "Cruz", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Jose", "Caballero", MlbPosition.SHORTSTOP, "72"),
                Player("Yerry", "De los Santos", MlbPosition.RELIEF_PITCHER, "73"),
                Player("Camilo", "Doval", MlbPosition.RELIEF_PITCHER, "75"),
                Player("Spencer", "Jones", MlbPosition.CENTER_FIELD, "78"),
                Player("Luis", "Gil", MlbPosition.STARTING_PITCHER, "81"),
                Player("Chase", "Hampton", MlbPosition.STARTING_PITCHER, "86"),
                Player("Jayvien", "Sandridge", MlbPosition.RELIEF_PITCHER, "88"),
                Player("Braden", "Shewmake", MlbPosition.SHORTSTOP, "89"),
                Player("Cade", "Winquest", MlbPosition.RELIEF_PITCHER, "89"),
                Player("Jorbit", "Vivas", MlbPosition.SECOND_BASE, "90"),
                Player("Oswaldo", "Cabrera", MlbPosition.THIRD_BASE, "95"),
                Player("Will", "Warren", MlbPosition.STARTING_PITCHER, "98"),
                Player("Aaron", "Judge", MlbPosition.RIGHT_FIELD, "99"),
            ),
    )
}

private val mlbTeamAth by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Oakland Athletics",
        nameWidthPercent = 68.9f,
        abbreviation = "ATH",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF003831),
                nameAccent = Color(0xFFEFB21E),
            ),
        venue =
            TeamVenue(
                name = "Sutter Health Park",
                location =
                    VenueLocation(
                        lat = 38.580372,
                        long = -121.513800,
                    ),
            ),
        roster =
            listOf(
                Player("Denzel", "Clarke", MlbPosition.CENTER_FIELD, "1"),
                Player("Jeff", "McNeil", MlbPosition.SECOND_BASE, "1"),
                Player("Darell", "Hernaiz", MlbPosition.THIRD_BASE, "2"),
                Player("Lawrence", "Butler", MlbPosition.RIGHT_FIELD, "4"),
                Player("Jacob", "Wilson", MlbPosition.SHORTSTOP, "5"),
                Player("Max", "Muncy", MlbPosition.THIRD_BASE, "10"),
                Player("Brett", "Harris", MlbPosition.THIRD_BASE, "11"),
                Player("Max", "Schuemann", MlbPosition.THIRD_BASE, "12"),
                Player("Nick", "Kurtz", MlbPosition.FIRST_BASE, "16"),
                Player("Zack", "Gelof", MlbPosition.SECOND_BASE, "20"),
                Player("Tyler", "Soderstrom", MlbPosition.LEFT_FIELD, "21"),
                Player("Shea", "Langeliers", MlbPosition.CATCHER, "23"),
                Player("Brent", "Rooker", MlbPosition.RIGHT_FIELD, "25"),
                Player("Carlos", "Cortes", MlbPosition.LEFT_FIELD, "26"),
                Player("Mitch", "Spence", MlbPosition.RELIEF_PITCHER, "28"),
                Player("Austin", "Wynns", MlbPosition.CATCHER, "29"),
                Player("Colby", "Thomas", MlbPosition.RIGHT_FIELD, "32"),
                Player("Henry", "Baez", MlbPosition.STARTING_PITCHER, "36"),
                Player("Hogan", "Harris", MlbPosition.RELIEF_PITCHER, "36"),
                Player("Luis", "Severino", MlbPosition.STARTING_PITCHER, "40"),
                Player("Tyler", "Ferguson", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Luis", "Medina", MlbPosition.STARTING_PITCHER, "46"),
                Player("Michael", "Kelly", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Jack", "Perkins", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Gunnar", "Hoglund", MlbPosition.STARTING_PITCHER, "53"),
                Player("Eduarniel", "Nunez", MlbPosition.RELIEF_PITCHER, "54"),
                Player("Mark", "Leiter", MlbPosition.RELIEF_PITCHER, "56", "Jr."),
                Player("Jacob", "Lopez", MlbPosition.STARTING_PITCHER, "57"),
                Player("Luis", "Morales", MlbPosition.STARTING_PITCHER, "58"),
                Player("Jeffrey", "Springs", MlbPosition.STARTING_PITCHER, "59"),
                Player("Justin", "Sterner", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Elvis", "Alvarado", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Brady", "Basso", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Grant", "Holman", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Joey", "Estes", MlbPosition.STARTING_PITCHER, "68"),
                Player("J.T.", "Ginn", MlbPosition.STARTING_PITCHER, "70"),
                Player("Junior", "Perez", MlbPosition.CENTER_FIELD, "78"),
                Player("Chen", "Zhuang", MlbPosition.RELIEF_PITCHER, "78"),
                Player("Braden", "Nett", MlbPosition.STARTING_PITCHER, "96"),
            ),
    )
}

private val mlbTeamPhi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Philadelphia Phillies",
        nameWidthPercent = 75.3f,
        abbreviation = "PHI",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFE81828),
                nameAccent = Color(0xFF003278),
            ),
        venue =
            TeamVenue(
                name = "Citizens Bank Park",
                location =
                    VenueLocation(
                        lat = 39.905833,
                        long = -75.166667,
                    ),
            ),
        roster =
            listOf(
                Player("Bryce", "Harper", MlbPosition.FIRST_BASE, "3"),
                Player("Otto", "Kemp", MlbPosition.FIRST_BASE, "4"),
                Player("Bryson", "Stott", MlbPosition.SECOND_BASE, "5"),
                Player("Trea", "Turner", MlbPosition.SHORTSTOP, "7"),
                Player("Nick", "Castellanos", MlbPosition.RIGHT_FIELD, "8"),
                Player("Kyle", "Schwarber", MlbPosition.LEFT_FIELD, "12"),
                Player("Rafael", "Marchan", MlbPosition.CATCHER, "13"),
                Player("Brandon", "Marsh", MlbPosition.CENTER_FIELD, "16"),
                Player("Garrett", "Stubbs", MlbPosition.CATCHER, "21"),
                Player("Johan", "Rojas", MlbPosition.CENTER_FIELD, "23"),
                Player("Aaron", "Nola", MlbPosition.STARTING_PITCHER, "27"),
                Player("Alec", "Bohm", MlbPosition.THIRD_BASE, "28"),
                Player("Edmundo", "Sosa", MlbPosition.SECOND_BASE, "33"),
                Player("Weston", "Wilson", MlbPosition.LEFT_FIELD, "37"),
                Player("Brad", "Keller", MlbPosition.RELIEF_PITCHER, "40"),
                Player("Kyle", "Backhus", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Jesus", "Luzardo", MlbPosition.STARTING_PITCHER, "44"),
                Player("Zack", "Wheeler", MlbPosition.STARTING_PITCHER, "45"),
                Player("Jose", "Alvarado", MlbPosition.RELIEF_PITCHER, "46"),
                Player("Nolan", "Hoffman", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Orion", "Kerkering", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Seth", "Johnson", MlbPosition.STARTING_PITCHER, "51"),
                Player("Jonathan", "Bowlan", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Adolis", "Garcia", MlbPosition.RIGHT_FIELD, "53"),
                Player("Alan", "Rangel", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Tanner", "Banks", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Yoniel", "Curet", MlbPosition.STARTING_PITCHER, "58"),
                Player("Jhoan", "Duran", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Max", "Lazar", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Cristopher", "Sanchez", MlbPosition.STARTING_PITCHER, "61"),
                Player("Moises", "Chace", MlbPosition.STARTING_PITCHER, "75"),
                Player("Andrew", "Painter", MlbPosition.STARTING_PITCHER, "76"),
                Player("Jean", "Cabrera", MlbPosition.STARTING_PITCHER, "79"),
                Player("Gabriel", "Rincones", MlbPosition.RIGHT_FIELD, "93", "Jr."),
                Player("Pedro", "Leon", MlbPosition.RIGHT_FIELD, "98"),
                Player("Taijuan", "Walker", MlbPosition.STARTING_PITCHER, "99"),
            ),
    )
}

private val mlbTeamPit by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Pittsburgh Pirates",
        nameWidthPercent = 69.9f,
        abbreviation = "PIT",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFFDB827),
            ),
        venue =
            TeamVenue(
                name = "PNC Park",
                location =
                    VenueLocation(
                        lat = 40.446944,
                        long = -80.005833,
                    ),
            ),
        roster =
            listOf(
                Player("Spencer", "Horwitz", MlbPosition.FIRST_BASE, "2"),
                Player("Nick", "Gonzales", MlbPosition.SECOND_BASE, "3"),
                Player("Endy", "Rodriguez", MlbPosition.FIRST_BASE, "5"),
                Player("Brandon", "Lowe", MlbPosition.SECOND_BASE, "8"),
                Player("Bryan", "Reynolds", MlbPosition.RIGHT_FIELD, "10"),
                Player("Joey", "Bart", MlbPosition.CATCHER, "14"),
                Player("Oneil", "Cruz", MlbPosition.CENTER_FIELD, "15"),
                Player("Jared", "Triolo", MlbPosition.SHORTSTOP, "19"),
                Player("Mitch", "Keller", MlbPosition.STARTING_PITCHER, "23"),
                Player("Billy", "Cook", MlbPosition.OUTFIELD, "25"),
                Player("Jake", "Mangum", MlbPosition.LEFT_FIELD, "28"),
                Player("Paul", "Skenes", MlbPosition.STARTING_PITCHER, "30"),
                Player("Gregory", "Soto", MlbPosition.RELIEF_PITCHER, "31"),
                Player("Henry", "Davis", MlbPosition.CATCHER, "32"),
                Player("Jhostynxon", "Garcia", MlbPosition.CENTER_FIELD, "34"),
                Player("Marco", "Luciano", MlbPosition.OUTFIELD, "36"),
                Player("Jared", "Jones", MlbPosition.STARTING_PITCHER, "37"),
                Player("Nick", "Yorke", MlbPosition.SECOND_BASE, "38"),
                Player("Rafael", "Flores", MlbPosition.CATCHER, "43"),
                Player("Hunter", "Barco", MlbPosition.STARTING_PITCHER, "45"),
                Player("Enmanuel", "Valdez", MlbPosition.FIRST_BASE, "47"),
                Player("Mason", "Montgomery", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Evan", "Sisk", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Yohan", "Ramirez", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Carmen", "Mlodzinski", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Chase", "Shugart", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Bubba", "Chandler", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Dennis", "Santana", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Justin", "Lawrence", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Cam", "Sanders", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Jack", "Suwinski", MlbPosition.RIGHT_FIELD, "65"),
                Player("Kyle", "Nicolas", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Braxton", "Ashcraft", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Tsung-Che", "Cheng", MlbPosition.SHORTSTOP, "71"),
                Player("Isaac", "Mattson", MlbPosition.RELIEF_PITCHER, "72"),
                Player("Brandan", "Bidois", MlbPosition.RELIEF_PITCHER, "77"),
                Player("Thomas", "Harrington", MlbPosition.STARTING_PITCHER, "78"),
                Player("Jack", "Brannigan", MlbPosition.SHORTSTOP, "83"),
                Player("Ryan", "Harbin", MlbPosition.RELIEF_PITCHER, "84"),
                Player("Esmerlyn", "Valdez", MlbPosition.OUTFIELD, "85"),
            ),
    )
}

private val mlbTeamSd by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Diego Padres",
        nameWidthPercent = 67.2f,
        abbreviation = "SD",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF2F241D),
                nameAccent = Color(0xFFFFC425),
            ),
        venue =
            TeamVenue(
                name = "Petco Park",
                location =
                    VenueLocation(
                        lat = 32.707333,
                        long = -117.156944,
                    ),
            ),
        roster =
            listOf(
                Player("Yuki", "Matsui", MlbPosition.RELIEF_PITCHER, "1"),
                Player("Xander", "Bogaerts", MlbPosition.SHORTSTOP, "2"),
                Player("Jackson", "Merrill", MlbPosition.CENTER_FIELD, "3"),
                Player("Ramon", "Laureano", MlbPosition.RIGHT_FIELD, "5"),
                Player("Jake", "Cronenworth", MlbPosition.SECOND_BASE, "9"),
                Player("Yu", "Darvish", MlbPosition.STARTING_PITCHER, "11"),
                Player("Luis", "Campusano", MlbPosition.CATCHER, "12"),
                Player("Manny", "Machado", MlbPosition.THIRD_BASE, "13"),
                Player("Mason", "McCoy", MlbPosition.SECOND_BASE, "18"),
                Player("Tirso", "Ornelas", MlbPosition.LEFT_FIELD, "21"),
                Player("Mason", "Miller", MlbPosition.RELIEF_PITCHER, "22"),
                Player("Fernando", "Tatis", MlbPosition.RIGHT_FIELD, "23", "Jr."),
                Player("Will", "Wagner", MlbPosition.THIRD_BASE, "24"),
                Player("Nick", "Pivetta", MlbPosition.STARTING_PITCHER, "27"),
                Player("Bryce", "Johnson", MlbPosition.CENTER_FIELD, "29"),
                Player("Gavin", "Sheets", MlbPosition.LEFT_FIELD, "30"),
                Player("Michael", "King", MlbPosition.STARTING_PITCHER, "34"),
                Player("Alek", "Jacob", MlbPosition.RELIEF_PITCHER, "37"),
                Player("JP", "Sears", MlbPosition.STARTING_PITCHER, "38"),
                Player("Jason", "Adam", MlbPosition.RELIEF_PITCHER, "40"),
                Player("Joe", "Musgrove", MlbPosition.STARTING_PITCHER, "44"),
                Player("Adrian", "Morejon", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Ty", "Adcock", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Freddy", "Fermin", MlbPosition.CATCHER, "54"),
                Player("Jeremiah", "Estrada", MlbPosition.RELIEF_PITCHER, "56"),
                Player("Wandy", "Peralta", MlbPosition.RELIEF_PITCHER, "58"),
                Player("Matt", "Waldron", MlbPosition.STARTING_PITCHER, "61"),
                Player("David", "Morgan", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Kyle", "Hart", MlbPosition.RELIEF_PITCHER, "68"),
                Player("Bradgley", "Rodriguez", MlbPosition.STARTING_PITCHER, "72"),
                Player("Daison", "Acosta", MlbPosition.RELIEF_PITCHER, "76"),
                Player("Jhony", "Brito", MlbPosition.RELIEF_PITCHER, "76"),
                Player("Bryan", "Hoeing", MlbPosition.RELIEF_PITCHER, "78"),
                Player("Ron", "Marinaccio", MlbPosition.RELIEF_PITCHER, "97"),
                Player("Randy", "Vasquez", MlbPosition.STARTING_PITCHER, "98"),
                Player("Garrett", "Hawkins", MlbPosition.RELIEF_PITCHER, "99"),
            ),
    )
}

private val mlbTeamSf by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Francisco Giants",
        nameWidthPercent = 81.1f,
        abbreviation = "SF",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFFD5A1E),
            ),
        venue =
            TeamVenue(
                name = "Oracle Park",
                location =
                    VenueLocation(
                        lat = 37.778333,
                        long = -122.389444,
                    ),
            ),
        roster =
            listOf(
                Player("Willy", "Adames", MlbPosition.SHORTSTOP, "2"),
                Player("Casey", "Schmitt", MlbPosition.THIRD_BASE, "10"),
                Player("Patrick", "Bailey", MlbPosition.CATCHER, "14"),
                Player("Rafael", "Devers", MlbPosition.DESIGNATED_HITTER, "16"),
                Player("Heliot", "Ramos", MlbPosition.LEFT_FIELD, "17"),
                Player("Matt", "Chapman", MlbPosition.THIRD_BASE, "26"),
                Player("Luis", "Matos", MlbPosition.RIGHT_FIELD, "29"),
                Player("Sam", "Hentges", MlbPosition.RELIEF_PITCHER, "31"),
                Player("JT", "Brubaker", MlbPosition.RELIEF_PITCHER, "34"),
                Player("Adrian", "Houser", MlbPosition.STARTING_PITCHER, "37"),
                Player("Robbie", "Ray", MlbPosition.STARTING_PITCHER, "38"),
                Player("Blade", "Tidwell", MlbPosition.STARTING_PITCHER, "40"),
                Player("Joey", "Wiemer", MlbPosition.LEFT_FIELD, "41"),
                Player("Tristan", "Beck", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Reiver", "Sanmartin", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Tyler", "Fitzgerald", MlbPosition.SECOND_BASE, "49"),
                Player("Christian", "Koss", MlbPosition.SECOND_BASE, "50"),
                Player("Jung Hoo", "Lee", MlbPosition.CENTER_FIELD, "51"),
                Player("Daniel", "Susac", MlbPosition.CATCHER, "53"),
                Player("Grant", "McCray", MlbPosition.CENTER_FIELD, "58"),
                Player("Jerar", "Encarnacion", MlbPosition.RIGHT_FIELD, "59"),
                Player("Hayden", "Birdsong", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Drew", "Gilbert", MlbPosition.CENTER_FIELD, "61"),
                Player("Logan", "Webb", MlbPosition.STARTING_PITCHER, "62"),
                Player("Joel", "Peguero", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Landen", "Roupp", MlbPosition.STARTING_PITCHER, "65"),
                Player("Kai-Wei", "Teng", MlbPosition.STARTING_PITCHER, "66"),
                Player("Keaton", "Winn", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Jason", "Foley", MlbPosition.RELIEF_PITCHER, "68"),
                Player("Erik", "Miller", MlbPosition.RELIEF_PITCHER, "68"),
                Player("Jose", "Butto", MlbPosition.RELIEF_PITCHER, "70"),
                Player("Trevor", "McDonald", MlbPosition.STARTING_PITCHER, "72"),
                Player("Randy", "Rodriguez", MlbPosition.RELIEF_PITCHER, "73"),
                Player("Ryan", "Walker", MlbPosition.RELIEF_PITCHER, "74"),
                Player("Justin", "Dean", MlbPosition.CENTER_FIELD, "75"),
                Player("Spencer", "Bivens", MlbPosition.RELIEF_PITCHER, "76"),
                Player("Carson", "Seymour", MlbPosition.RELIEF_PITCHER, "77"),
                Player("Bryce", "Eldridge", MlbPosition.FIRST_BASE, "78"),
                Player("Carson", "Whisenhunt", MlbPosition.STARTING_PITCHER, "88"),
                Player("Matt", "Gage", MlbPosition.RELIEF_PITCHER, "93"),
                Player("Jesus", "Rodriguez", MlbPosition.CATCHER, "97"),
            ),
    )
}

private val mlbTeamSea by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Seattle Mariners",
        nameWidthPercent = 63.9f,
        abbreviation = "SEA",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF005C5C),
                nameAccent = Color(0xFF0C2C56),
            ),
        venue =
            TeamVenue(
                name = "T-Mobile Park",
                location =
                    VenueLocation(
                        lat = 47.591389,
                        long = -122.332500,
                    ),
            ),
        roster =
            listOf(
                Player("Samad", "Taylor", MlbPosition.SECOND_BASE, "0"),
                Player("Ryan", "Bliss", MlbPosition.SECOND_BASE, "1"),
                Player("Cole", "Young", MlbPosition.SECOND_BASE, "2"),
                Player("J.P.", "Crawford", MlbPosition.SHORTSTOP, "3"),
                Player("Dominic", "Canzone", MlbPosition.RIGHT_FIELD, "8"),
                Player("Ben", "Williamson", MlbPosition.THIRD_BASE, "9"),
                Player("Victor", "Robles", MlbPosition.RIGHT_FIELD, "10"),
                Player("Josh", "Naylor", MlbPosition.FIRST_BASE, "12"),
                Player("Luke", "Raley", MlbPosition.RIGHT_FIELD, "20"),
                Player("Andrew", "Knizner", MlbPosition.CATCHER, "21"),
                Player("Miles", "Mastrobuoni", MlbPosition.THIRD_BASE, "21"),
                Player("Bryan", "Woo", MlbPosition.STARTING_PITCHER, "22"),
                Player("Emerson", "Hancock", MlbPosition.STARTING_PITCHER, "26"),
                Player("Cal", "Raleigh", MlbPosition.CATCHER, "29"),
                Player("Rob", "Refsnyder", MlbPosition.RIGHT_FIELD, "30"),
                Player("Rhylan", "Thomas", MlbPosition.LEFT_FIELD, "31"),
                Player("Logan", "Gilbert", MlbPosition.STARTING_PITCHER, "36"),
                Player("Jackson", "Kowar", MlbPosition.RELIEF_PITCHER, "37"),
                Player("Julio", "Rodriguez", MlbPosition.CENTER_FIELD, "44"),
                Player("Matt", "Brash", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Jose", "Ferrer", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Bryce", "Miller", MlbPosition.STARTING_PITCHER, "50"),
                Player("Ryan", "Loutos", MlbPosition.RELIEF_PITCHER, "52"),
                Player("Carlos", "Vargas", MlbPosition.RELIEF_PITCHER, "54"),
                Player("Gabe", "Speier", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Randy", "Arozarena", MlbPosition.LEFT_FIELD, "56"),
                Player("Luis", "Castillo", MlbPosition.STARTING_PITCHER, "58"),
                Player("Troy", "Taylor", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Blas", "Castano", MlbPosition.STARTING_PITCHER, "62"),
                Player("Casey", "Legumina", MlbPosition.RELIEF_PITCHER, "64"),
                Player("George", "Kirby", MlbPosition.STARTING_PITCHER, "68"),
                Player("Logan", "Evans", MlbPosition.STARTING_PITCHER, "73"),
                Player("Domingo", "Gonzalez", MlbPosition.STARTING_PITCHER, "73"),
                Player("Cole", "Wilcox", MlbPosition.RELIEF_PITCHER, "73"),
                Player("Jhonathan", "Diaz", MlbPosition.RELIEF_PITCHER, "74"),
                Player("Andres", "Munoz", MlbPosition.RELIEF_PITCHER, "75"),
                Player("Leo", "Rivas", MlbPosition.SECOND_BASE, "76"),
                Player("Eduard", "Bazardo", MlbPosition.RELIEF_PITCHER, "83"),
            ),
    )
}

private val mlbTeamStl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "St. Louis Cardinals",
        nameWidthPercent = 70.3f,
        abbreviation = "STL",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFBE0A14),
                nameAccent = Color(0xFF001541),
            ),
        venue =
            TeamVenue(
                name = "Busch Stadium (III)",
                location =
                    VenueLocation(
                        lat = 38.622500,
                        long = -90.193056,
                    ),
            ),
        roster =
            listOf(
                Player("Masyn", "Winn", MlbPosition.SHORTSTOP, "0"),
                Player("Dustin", "May", MlbPosition.STARTING_PITCHER, "3"),
                Player("Jimmy", "Crooks", MlbPosition.CATCHER, "8"),
                Player("Victor", "Scott", MlbPosition.CENTER_FIELD, "11", "II"),
                Player("Jose", "Fermin", MlbPosition.SECOND_BASE, "15"),
                Player("Nolan", "Gorman", MlbPosition.SECOND_BASE, "16"),
                Player("Jordan", "Walker", MlbPosition.RIGHT_FIELD, "18"),
                Player("Lars", "Nootbaar", MlbPosition.LEFT_FIELD, "21"),
                Player("Thomas", "Saggese", MlbPosition.SECOND_BASE, "25"),
                Player("Nathan", "Church", MlbPosition.LEFT_FIELD, "27"),
                Player("Nolan", "Arenado", MlbPosition.THIRD_BASE, "28"),
                Player("Tink", "Hence", MlbPosition.RELIEF_PITCHER, "30"),
                Player("Cesar", "Prieto", MlbPosition.SECOND_BASE, "31"),
                Player("Brendan", "Donovan", MlbPosition.SECOND_BASE, "33"),
                Player("Michael", "McGreevy", MlbPosition.STARTING_PITCHER, "36"),
                Player("Tekoah", "Roby", MlbPosition.STARTING_PITCHER, "38"),
                Player("Ryan", "Tepera", MlbPosition.RELIEF_PITCHER, "38"),
                Player("Alec", "Burleson", MlbPosition.FIRST_BASE, "41"),
                Player("Pedro", "Pages", MlbPosition.CATCHER, "43"),
                Player("Gordon", "Graceffo", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Ivan", "Herrera", MlbPosition.CATCHER, "48"),
                Player("Matt", "Svanson", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Matthew", "Liberatore", MlbPosition.STARTING_PITCHER, "52"),
                Player("Andre", "Pallante", MlbPosition.STARTING_PITCHER, "53"),
                Player("Riley", "O'Brien", MlbPosition.RELIEF_PITCHER, "55"),
                Player("Chris", "Roycroft", MlbPosition.RELIEF_PITCHER, "58"),
                Player("JoJo", "Romero", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Zak", "Kent", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Kyle", "Leahy", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Ryan", "Fernandez", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Andre", "Granillo", MlbPosition.RELIEF_PITCHER, "65"),
                Player("Nick", "Raquet", MlbPosition.RELIEF_PITCHER, "70"),
                Player("Hunter", "Dobbins", MlbPosition.STARTING_PITCHER, "73"),
                Player("Richard", "Fitts", MlbPosition.STARTING_PITCHER, "80"),
                Player("Cooper", "Hjerpe", MlbPosition.STARTING_PITCHER, "84"),
                Player("Matthew", "Pushard", MlbPosition.RELIEF_PITCHER, "85"),
                Player("Bryan", "Torres", MlbPosition.OUTFIELD, "89"),
                Player("Brycen", "Mautz", MlbPosition.RELIEF_PITCHER, "90"),
                Player("Joshua", "Baez", MlbPosition.RIGHT_FIELD, "94"),
                Player("Leonardo", "Bernal", MlbPosition.CATCHER, "96"),
            ),
    )
}

private val mlbTeamTb by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Tampa Bay Rays",
        nameWidthPercent = 62.5f,
        abbreviation = "TB",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF092C5C),
                nameAccent = Color(0xFF8FBCE6),
            ),
        venue =
            TeamVenue(
                name = "George M Steinbrenner Field",
                location =
                    VenueLocation(
                        lat = 27.980278,
                        long = -82.506667,
                    ),
            ),
        roster =
            listOf(
                Player("Richie", "Palacios", MlbPosition.LEFT_FIELD, "1"),
                Player("Yandy", "Diaz", MlbPosition.FIRST_BASE, "2"),
                Player("Taylor", "Walls", MlbPosition.SHORTSTOP, "6"),
                Player("Carson", "Williams", MlbPosition.SHORTSTOP, "7"),
                Player("Junior", "Caminero", MlbPosition.THIRD_BASE, "13"),
                Player("Chandler", "Simpson", MlbPosition.CENTER_FIELD, "14"),
                Player("Josh", "Lowe", MlbPosition.RIGHT_FIELD, "15"),
                Player("Jake", "Fraley", MlbPosition.RIGHT_FIELD, "17"),
                Player("Shane", "McClanahan", MlbPosition.STARTING_PITCHER, "18"),
                Player("Jonny", "DeLuca", MlbPosition.CENTER_FIELD, "21"),
                Player("Griffin", "Jax", MlbPosition.RELIEF_PITCHER, "22"),
                Player("Steven", "Wilson", MlbPosition.RELIEF_PITCHER, "24"),
                Player("Hunter", "Feduccia", MlbPosition.CATCHER, "30"),
                Player("Jacob", "Melton", MlbPosition.LEFT_FIELD, "31"),
                Player("Cedric", "Mullins", MlbPosition.CENTER_FIELD, "31"),
                Player("Joe", "Boyle", MlbPosition.STARTING_PITCHER, "36"),
                Player("Forrest", "Whitley", MlbPosition.RELIEF_PITCHER, "38"),
                Player("Manuel", "Rodriguez", MlbPosition.RELIEF_PITCHER, "39"),
                Player("Nick", "Fortes", MlbPosition.CATCHER, "40"),
                Player("Steven", "Matz", MlbPosition.RELIEF_PITCHER, "41"),
                Player("Hunter", "Bigge", MlbPosition.RELIEF_PITCHER, "43"),
                Player("Ryan", "Pepiot", MlbPosition.STARTING_PITCHER, "44"),
                Player("Osvaldo", "Bido", MlbPosition.RELIEF_PITCHER, "45"),
                Player("Ryan", "Vilade", MlbPosition.RIGHT_FIELD, "46"),
                Player("Bryan", "Baker", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Kevin", "Kelly", MlbPosition.RELIEF_PITCHER, "49"),
                Player("Drew", "Rasmussen", MlbPosition.STARTING_PITCHER, "57"),
                Player("Mason", "Englert", MlbPosition.RELIEF_PITCHER, "59"),
                Player("Garrett", "Cleavinger", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Ian", "Seymour", MlbPosition.RELIEF_PITCHER, "61"),
                Player("Jonathan", "Aranda", MlbPosition.FIRST_BASE, "62"),
                Player("Edwin", "Uceta", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Jesse", "Scholtens", MlbPosition.RELIEF_PITCHER, "65"),
                Player("Joe", "Rock", MlbPosition.STARTING_PITCHER, "68"),
                Player("Cole", "Sulser", MlbPosition.RELIEF_PITCHER, "71"),
                Player("Dominic", "Keegan", MlbPosition.CATCHER, "75"),
                Player("Alexander", "Cook", MlbPosition.RELIEF_PITCHER, "81"),
                Player("Austin", "Overn", MlbPosition.OUTFIELD, "87"),
                Player("Jadher", "Areinamo", MlbPosition.SECOND_BASE, "92"),
                Player("Yoendrys", "Gomez", MlbPosition.STARTING_PITCHER, "94"),
            ),
    )
}

private val mlbTeamTex by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Texas Rangers",
        nameWidthPercent = 56.1f,
        abbreviation = "TEX",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF003278),
                nameAccent = Color(0xFFC0111F),
            ),
        venue =
            TeamVenue(
                name = "Globe Life Field",
                location =
                    VenueLocation(
                        lat = 32.747361,
                        long = -97.084167,
                    ),
            ),
        roster =
            listOf(
                Player("Sam", "Haggerty", MlbPosition.CENTER_FIELD, "0"),
                Player("Joc", "Pederson", MlbPosition.FIRST_BASE, "4"),
                Player("Corey", "Seager", MlbPosition.SHORTSTOP, "5"),
                Player("Josh", "Jung", MlbPosition.THIRD_BASE, "6"),
                Player("Josh", "Smith", MlbPosition.SHORTSTOP, "8"),
                Player("Kyle", "Higashioka", MlbPosition.CATCHER, "11"),
                Player("Tyler", "Alexander", MlbPosition.RELIEF_PITCHER, "13"),
                Player("Nathan", "Eovaldi", MlbPosition.STARTING_PITCHER, "17"),
                Player("Alejandro", "Osuna", MlbPosition.LEFT_FIELD, "19"),
                Player("Ezequiel", "Duran", MlbPosition.SHORTSTOP, "20"),
                Player("Jake", "Burger", MlbPosition.FIRST_BASE, "21"),
                Player("Michael", "Helman", MlbPosition.CENTER_FIELD, "24"),
                Player("Brandon", "Nimmo", MlbPosition.LEFT_FIELD, "24"),
                Player("Marc", "Church", MlbPosition.RELIEF_PITCHER, "30"),
                Player("Evan", "Carter", MlbPosition.CENTER_FIELD, "32"),
                Player("Jack", "Leiter", MlbPosition.STARTING_PITCHER, "35"),
                Player("Wyatt", "Langford", MlbPosition.LEFT_FIELD, "36"),
                Player("Cody", "Freeman", MlbPosition.THIRD_BASE, "39"),
                Player("Michel", "Otanez", MlbPosition.RELIEF_PITCHER, "47"),
                Player("Alexis", "Diaz", MlbPosition.RELIEF_PITCHER, "48"),
                Player("Jacob", "deGrom", MlbPosition.STARTING_PITCHER, "48"),
                Player("Dominic", "Hamel", MlbPosition.STARTING_PITCHER, "53"),
                Player("Justin", "Foscue", MlbPosition.FIRST_BASE, "56"),
                Player("Luis", "Curvelo", MlbPosition.RELIEF_PITCHER, "57"),
                Player("Jose", "Corniell", MlbPosition.STARTING_PITCHER, "59"),
                Player("Cole", "Winn", MlbPosition.RELIEF_PITCHER, "60"),
                Player("Cody", "Bradford", MlbPosition.STARTING_PITCHER, "61"),
                Player("Robert", "Garcia", MlbPosition.RELIEF_PITCHER, "62"),
                Player("Willie", "MacIver", MlbPosition.CATCHER, "65"),
                Player("Jacob", "Latz", MlbPosition.RELIEF_PITCHER, "67"),
                Player("Kumar", "Rocker", MlbPosition.STARTING_PITCHER, "80"),
                Player("Emiliano", "Teodo", MlbPosition.STARTING_PITCHER, "82"),
                Player("Winston", "Santos", MlbPosition.STARTING_PITCHER, "84"),
                Player("Abimelec", "Ortiz", MlbPosition.FIRST_BASE, "85"),
            ),
    )
}

private val mlbTeamTor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Toronto Blue Jays",
        nameWidthPercent = 69.6f,
        abbreviation = "TOR",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFF134A8E),
                nameAccent = Color(0xFF6CACE5),
            ),
        venue =
            TeamVenue(
                name = "Rogers Centre",
                location =
                    VenueLocation(
                        lat = 43.641389,
                        long = -79.389167,
                    ),
            ),
        roster =
            listOf(
                Player("Andres", "Gimenez", MlbPosition.SECOND_BASE, "0"),
                Player("Myles", "Straw", MlbPosition.CENTER_FIELD, "3"),
                Player("George", "Springer", MlbPosition.RIGHT_FIELD, "4"),
                Player("Daulton", "Varsho", MlbPosition.CENTER_FIELD, "5"),
                Player("Jonatan", "Clase", MlbPosition.LEFT_FIELD, "8"),
                Player("Joey", "Loperfido", MlbPosition.LEFT_FIELD, "10"),
                Player("Jose", "Berrios", MlbPosition.STARTING_PITCHER, "17"),
                Player("Ernie", "Clement", MlbPosition.THIRD_BASE, "22"),
                Player("Jeff", "Hoffman", MlbPosition.RELIEF_PITCHER, "23"),
                Player("Anthony", "Santander", MlbPosition.RIGHT_FIELD, "25"),
                Player("Vladimir", "Guerrero", MlbPosition.FIRST_BASE, "27", "Jr."),
                Player("Jake", "Bloss", MlbPosition.STARTING_PITCHER, "28"),
                Player("Alejandro", "Kirk", MlbPosition.CATCHER, "30"),
                Player("Kevin", "Gausman", MlbPosition.STARTING_PITCHER, "34"),
                Player("Davis", "Schneider", MlbPosition.LEFT_FIELD, "36"),
                Player("Nathan", "Lukes", MlbPosition.RIGHT_FIELD, "38"),
                Player("Trey", "Yesavage", MlbPosition.STARTING_PITCHER, "39"),
                Player("Bowden", "Francis", MlbPosition.STARTING_PITCHER, "44"),
                Player("Cody", "Ponce", MlbPosition.STARTING_PITCHER, "44"),
                Player("Tommy", "Nance", MlbPosition.RELIEF_PITCHER, "45"),
                Player("Addison", "Barger", MlbPosition.THIRD_BASE, "47"),
                Player("Leo", "Jimenez", MlbPosition.SHORTSTOP, "49"),
                Player("Chase", "Lee", MlbPosition.RELIEF_PITCHER, "53"),
                Player("Brendon", "Little", MlbPosition.RELIEF_PITCHER, "54"),
                Player("Tyler", "Heineman", MlbPosition.CATCHER, "55"),
                Player("Eric", "Lauer", MlbPosition.STARTING_PITCHER, "56"),
                Player("Shane", "Bieber", MlbPosition.STARTING_PITCHER, "57"),
                Player("Lazaro", "Estrada", MlbPosition.STARTING_PITCHER, "60"),
                Player("Braydon", "Fisher", MlbPosition.RELIEF_PITCHER, "63"),
                Player("Adam", "Macko", MlbPosition.STARTING_PITCHER, "64"),
                Player("Paxton", "Schultz", MlbPosition.RELIEF_PITCHER, "65"),
                Player("Angel", "Bastardo", MlbPosition.RELIEF_PITCHER, "66"),
                Player("Mason", "Fluharty", MlbPosition.RELIEF_PITCHER, "68"),
                Player("Ricky", "Tiedemann", MlbPosition.STARTING_PITCHER, "70"),
                Player("Tyler", "Rogers", MlbPosition.RELIEF_PITCHER, "71"),
                Player("Louis", "Varland", MlbPosition.RELIEF_PITCHER, "77"),
                Player("Brandon", "Valenzuela", MlbPosition.CATCHER, "91"),
                Player("Yimi", "Garcia", MlbPosition.RELIEF_PITCHER, "93"),
            ),
    )
}

private val mlbTeamWsh by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Washington Nationals",
        nameWidthPercent = 85.1f,
        abbreviation = "WSH",
        league = LeagueId.MLB,
        colors =
            TeamColors(
                primary = Color(0xFFAB0003),
                nameAccent = Color(0xFF11225B),
            ),
        venue =
            TeamVenue(
                name = "Nationals Park",
                location =
                    VenueLocation(
                        lat = 38.872500,
                        long = -77.007778,
                    ),
            ),
        roster =
            listOf(
                Player("MacKenzie", "Gore", MlbPosition.STARTING_PITCHER, "1"),
                Player("Luis", "Garcia", MlbPosition.SECOND_BASE, "2", "Jr."),
                Player("Dylan", "Crews", MlbPosition.RIGHT_FIELD, "3"),
                Player("Daylen", "Lile", MlbPosition.RIGHT_FIELD, "4"),
                Player("CJ", "Abrams", MlbPosition.SHORTSTOP, "5"),
                Player("Jose", "Tena", MlbPosition.THIRD_BASE, "8"),
                Player("Brady", "House", MlbPosition.THIRD_BASE, "12"),
                Player("Riley", "Adams", MlbPosition.CATCHER, "15"),
                Player("Harry", "Ford", MlbPosition.CATCHER, "17"),
                Player("Keibert", "Ruiz", MlbPosition.CATCHER, "20"),
                Player("Cade", "Cavalli", MlbPosition.STARTING_PITCHER, "24"),
                Player("Griff", "McGarry", MlbPosition.STARTING_PITCHER, "25"),
                Player("Nasim", "Nunez", MlbPosition.SHORTSTOP, "26"),
                Player("Jake", "Irvin", MlbPosition.STARTING_PITCHER, "27"),
                Player("James", "Wood", MlbPosition.LEFT_FIELD, "29"),
                Player("Jacob", "Young", MlbPosition.CENTER_FIELD, "30"),
                Player("Trevor", "Williams", MlbPosition.STARTING_PITCHER, "32"),
                Player("Christian", "Franklin", MlbPosition.LEFT_FIELD, "33"),
                Player("Trey", "Lipscomb", MlbPosition.THIRD_BASE, "38"),
                Player("Clayton", "Beeter", MlbPosition.RELIEF_PITCHER, "39"),
                Player("Josiah", "Gray", MlbPosition.STARTING_PITCHER, "40"),
                Player("Brad", "Lord", MlbPosition.RELIEF_PITCHER, "41"),
                Player("Luis", "Perales", MlbPosition.STARTING_PITCHER, "43"),
                Player("Jackson", "Rutledge", MlbPosition.RELIEF_PITCHER, "44"),
                Player("Konnor", "Pilkington", MlbPosition.RELIEF_PITCHER, "45"),
                Player("Jake", "Eder", MlbPosition.RELIEF_PITCHER, "46"),
                Player("P.J.", "Poulin", MlbPosition.RELIEF_PITCHER, "50"),
                Player("Andrew", "Alvarez", MlbPosition.STARTING_PITCHER, "54"),
                Player("Robert", "Hassell", MlbPosition.CENTER_FIELD, "57", "III"),
                Player("Foster", "Griffin", MlbPosition.STARTING_PITCHER, "60"),
                Player("Orlando", "Ribalta", MlbPosition.RELIEF_PITCHER, "64"),
                Player("Julian", "Fernandez", MlbPosition.RELIEF_PITCHER, "65"),
                Player("Mitchell", "Parker", MlbPosition.STARTING_PITCHER, "70"),
                Player("Andry", "Lara", MlbPosition.STARTING_PITCHER, "72"),
                Player("Sauryn", "Lao", MlbPosition.RELIEF_PITCHER, "73"),
                Player("DJ", "Herz", MlbPosition.STARTING_PITCHER, "77"),
                Player("Drew", "Millas", MlbPosition.CATCHER, "81"),
                Player("Andres", "Chaparro", MlbPosition.FIRST_BASE, "87"),
                Player("Cole", "Henry", MlbPosition.RELIEF_PITCHER, "99"),
            ),
    )
}

val MlbTeams: List<Team<MlbPosition>> by lazy(LazyThreadSafetyMode.NONE) {
    listOf(
        mlbTeamAri,
        mlbTeamAtl,
        mlbTeamBal,
        mlbTeamBos,
        mlbTeamChc,
        mlbTeamChw,
        mlbTeamCin,
        mlbTeamCle,
        mlbTeamCol,
        mlbTeamDet,
        mlbTeamHou,
        mlbTeamKc,
        mlbTeamLaa,
        mlbTeamLad,
        mlbTeamMia,
        mlbTeamMil,
        mlbTeamMin,
        mlbTeamNym,
        mlbTeamNyy,
        mlbTeamAth,
        mlbTeamPhi,
        mlbTeamPit,
        mlbTeamSd,
        mlbTeamSf,
        mlbTeamSea,
        mlbTeamStl,
        mlbTeamTb,
        mlbTeamTex,
        mlbTeamTor,
        mlbTeamWsh,
    )
}

internal object MlbTeamRefs {
    val ARI = mlbTeamAri
    val ATL = mlbTeamAtl
    val BAL = mlbTeamBal
    val BOS = mlbTeamBos
    val CHC = mlbTeamChc
    val CHW = mlbTeamChw
    val CIN = mlbTeamCin
    val CLE = mlbTeamCle
    val COL = mlbTeamCol
    val DET = mlbTeamDet
    val HOU = mlbTeamHou
    val KC = mlbTeamKc
    val LAA = mlbTeamLaa
    val LAD = mlbTeamLad
    val MIA = mlbTeamMia
    val MIL = mlbTeamMil
    val MIN = mlbTeamMin
    val NYM = mlbTeamNym
    val NYY = mlbTeamNyy
    val ATH = mlbTeamAth
    val PHI = mlbTeamPhi
    val PIT = mlbTeamPit
    val SD = mlbTeamSd
    val SF = mlbTeamSf
    val SEA = mlbTeamSea
    val STL = mlbTeamStl
    val TB = mlbTeamTb
    val TEX = mlbTeamTex
    val TOR = mlbTeamTor
    val WSH = mlbTeamWsh
}
