package ca.amandeep.playernumber.data

import androidx.compose.ui.graphics.Color

private val mlsTeamAtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Atlanta United FC",
        nameWidthPercent = 67.6f,
        abbreviation = "ATL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF9D2235),
            nameAccent = Color(0xFFAA9767),
        ),
        venue = TeamVenue(
            name = "Mercedes-Benz Stadium",
            location = VenueLocation(
                lat = 33.755278,
                long = -84.400833,
            ),
        ),
        roster = listOf(
            Player("Ronald", "Hernández", MlsPosition.DEFENDER, "2"),
            Player("Enea", "Mihaj", MlsPosition.DEFENDER, "4"),
            Player("Stian", "Gregersen", MlsPosition.DEFENDER, "5"),
            Player("Juan", "Berrocal", MlsPosition.DEFENDER, "6"),
            Player("Steven", "Alzate", MlsPosition.MIDFIELDER, "7"),
            Player("Tristan", "Muyumba", MlsPosition.MIDFIELDER, "8"),
            Player("Saba", "Lobjanidze", MlsPosition.MIDFIELDER, "9"),
            Player("Miguel", "Almirón", MlsPosition.MIDFIELDER, "10"),
            Player("Jamal", "Thiaré", MlsPosition.FORWARD, "14"),
            Player("Pedro", "Amador", MlsPosition.DEFENDER, "18"),
            Player("Emmanuel", "Latte Lath", MlsPosition.FORWARD, "19"),
            Player("Luke", "Brennan", MlsPosition.FORWARD, "20"),
            Player("Adyn", "Torres", MlsPosition.MIDFIELDER, "23"),
            Player("Noah", "Cobb", MlsPosition.DEFENDER, "24"),
            Player("Ashton", "Gordon", MlsPosition.FORWARD, "27"),
            Player("Will", "Reilly", MlsPosition.MIDFIELDER, "28"),
            Player("Cayman", "Togashi", MlsPosition.FORWARD, "30"),
            Player("Patrick", "Weah", MlsPosition.FORWARD, "33"),
            Player("Jay", "Fortune", MlsPosition.MIDFIELDER, "35"),
            Player("Jayden", "Hibbert", MlsPosition.GOALKEEPER, "42"),
            Player("Matt", "Edwards", MlsPosition.DEFENDER, "47"),
            Player("Cooper", "Sanchez", MlsPosition.MIDFIELDER, "48"),
            Player("Dominik", "Chong Qui", MlsPosition.DEFENDER, "50"),
            Player("Salvatore", "Mazzaferro", MlsPosition.DEFENDER, "55"),
            Player("Alexey", "Miranchuk", MlsPosition.MIDFIELDER, "59"),
            Player("Rodrigo", "Neri", MlsPosition.FORWARD, "77"),
        ),
    )
}

private val mlsTeamAtx by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Austin FC",
        nameWidthPercent = 36.5f,
        abbreviation = "ATX",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF00B140),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Q2 Stadium",
            location = VenueLocation(
                lat = 30.388206,
                long = -97.719837,
            ),
        ),
        roster = listOf(
            Player("Brad", "Stuver", MlsPosition.GOALKEEPER, "1"),
            Player("Riley", "Thomas", MlsPosition.DEFENDER, "2"),
            Player("Mikkel", "Desler", MlsPosition.DEFENDER, "3"),
            Player("Brendan", "Hines-Ike", MlsPosition.DEFENDER, "4"),
            Player("Oleksandr", "Svatok", MlsPosition.DEFENDER, "5"),
            Player("Ilie", "Sánchez", MlsPosition.MIDFIELDER, "6"),
            Player("Jáder", "Obrian", MlsPosition.FORWARD, "7"),
            Player("Dani", "Pereira", MlsPosition.MIDFIELDER, "8"),
            Player("Brandon", "Vázquez", MlsPosition.FORWARD, "9"),
            Player("Myrto", "Uzuni", MlsPosition.FORWARD, "10"),
            Player("Osman", "Bukari", MlsPosition.FORWARD, "11"),
            Player("Damian", "Las", MlsPosition.GOALKEEPER, "12"),
            Player("Besard", "Sabovic", MlsPosition.MIDFIELDER, "14"),
            Player("Robert", "Taylor", MlsPosition.FORWARD, "16"),
            Player("Jon", "Gallagher", MlsPosition.DEFENDER, "17"),
            Player("CJ", "Fodrey", MlsPosition.MIDFIELDER, "19"),
            Player("Nicolás", "Dubersarsky", MlsPosition.MIDFIELDER, "20"),
            Player("Zan", "Kolmanic", MlsPosition.DEFENDER, "23"),
            Player("Guilherme", "Biro", MlsPosition.DEFENDER, "29"),
            Player("Stefan", "Cleveland", MlsPosition.GOALKEEPER, "30"),
            Player("Micah", "Burton", MlsPosition.MIDFIELDER, "32"),
            Player("Owen", "Wolff", MlsPosition.MIDFIELDER, "33"),
            Player("Antonio", "Gomez", MlsPosition.DEFENDER, "34"),
            Player("Mateja", "Djordjevic", MlsPosition.DEFENDER, "35"),
            Player("Adrian", "Gonzalez", MlsPosition.MIDFIELDER, "37"),
            Player("Ervin", "Torres", MlsPosition.MIDFIELDER, "38"),
        ),
    )
}

private val mlsTeamMtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "CF Montr\u00E9al",
        nameWidthPercent = 47.3f,
        abbreviation = "MTL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF003DA6),
            nameAccent = Color(0xFFC1C5C8),
        ),
        venue = TeamVenue(
            name = "Stade Saputo",
            location = VenueLocation(
                lat = 45.563056,
                long = -73.552500,
            ),
        ),
        roster = listOf(
            Player("Sébastian", "Breza", MlsPosition.GOALKEEPER, "1"),
            Player("Jalen", "Neal", MlsPosition.DEFENDER, "2"),
            Player("Brandan", "Craig", MlsPosition.DEFENDER, "5"),
            Player("Samuel", "Piette", MlsPosition.MIDFIELDER, "6"),
            Player("Kwadwo", "Opoku", MlsPosition.FORWARD, "7"),
            Player("Matthew", "Longstaff", MlsPosition.MIDFIELDER, "8"),
            Player("Prince", "Owusu", MlsPosition.FORWARD, "9"),
            Player("Bryce", "Duke", MlsPosition.MIDFIELDER, "10"),
            Player("Iván", "Jaime", MlsPosition.MIDFIELDER, "11"),
            Player("Luca", "Petrasso", MlsPosition.DEFENDER, "13"),
            Player("Sunusi", "Ibrahim", MlsPosition.FORWARD, "14"),
            Player("Giacomo", "Vrioni", MlsPosition.FORWARD, "17"),
            Player("Hennadii", "Synchuk", MlsPosition.FORWARD, "18"),
            Player("Bode", "Hidalgo", MlsPosition.DEFENDER, "19"),
            Player("Fabian", "Herbers", MlsPosition.FORWARD, "21"),
            Player("Victor", "Loturi", MlsPosition.MIDFIELDER, "22"),
            Player("Efraín", "Morales", MlsPosition.DEFENDER, "24"),
            Player("Dante", "Sealy", MlsPosition.FORWARD, "25"),
            Player("Dawid", "Bugaj", MlsPosition.DEFENDER, "27"),
            Player("Olger", "Escobar", MlsPosition.FORWARD, "29"),
            Player("Thomas", "Gillier", MlsPosition.GOALKEEPER, "31"),
            Player("Owen", "Graham-Roache", MlsPosition.FORWARD, "35"),
            Player("Aleksandr", "Guboglo", MlsPosition.DEFENDER, "39"),
            Player("Jonathan", "Sirois", MlsPosition.GOALKEEPER, "40"),
        ),
    )
}

private val mlsTeamClt by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Charlotte FC",
        nameWidthPercent = 49.0f,
        abbreviation = "CLT",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF0085CA),
            nameAccent = Color(0xFF000000),
        ),
        venue = TeamVenue(
            name = "Bank of America Stadium",
            location = VenueLocation(
                lat = 35.225833,
                long = -80.852778,
            ),
        ),
        roster = listOf(
            Player("Kristijan", "Kahlina", MlsPosition.GOALKEEPER, "1"),
            Player("Tim", "Ream", MlsPosition.DEFENDER, "3"),
            Player("Andrew", "Privett", MlsPosition.MIDFIELDER, "4"),
            Player("Archie", "Goodwin", MlsPosition.FORWARD, "7"),
            Player("Ashley", "Westwood", MlsPosition.MIDFIELDER, "8"),
            Player("Wilfried", "Zaha", MlsPosition.FORWARD, "10"),
            Player("Liel", "Abada", MlsPosition.FORWARD, "11"),
            Player("Drake", "Callender", MlsPosition.GOALKEEPER, "12"),
            Player("Brandt", "Bronico", MlsPosition.MIDFIELDER, "13"),
            Player("Nathan", "Byrne", MlsPosition.DEFENDER, "14"),
            Player("Harry", "Toffolo", MlsPosition.DEFENDER, "15"),
            Player("Idan", "Toklomati", MlsPosition.FORWARD, "17"),
            Player("Kerwin", "Vargas", MlsPosition.FORWARD, "18"),
            Player("Nikola", "Petkovic", MlsPosition.MIDFIELDER, "23"),
            Player("Mikah", "Thomas", MlsPosition.DEFENDER, "24"),
            Player("Tyger", "Smalls", MlsPosition.FORWARD, "25"),
            Player("Chituru", "Odunze", MlsPosition.GOALKEEPER, "26"),
            Player("Nimfasha", "Berchimas", MlsPosition.FORWARD, "27"),
            Player("Djibril", "Diani", MlsPosition.MIDFIELDER, "28"),
            Player("Brandon", "Cambridge", MlsPosition.FORWARD, "36"),
            Player("Jack", "Neeley", MlsPosition.DEFENDER, "39"),
            Player("Brian", "Carmona Romero", MlsPosition.FORWARD, "41"),
            Player("Baye", "Coulibaly", MlsPosition.MIDFIELDER, "55"),
        ),
    )
}

private val mlsTeamChi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Chicago Fire FC",
        nameWidthPercent = 60.1f,
        abbreviation = "CHI",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF7CCDEF),
            nameAccent = Color(0xFFFF0000),
        ),
        venue = TeamVenue(
            name = "Soldier Field",
            location = VenueLocation(
                lat = 41.862500,
                long = -87.616667,
            ),
        ),
        roster = listOf(
            Player("Chris", "Brady", MlsPosition.GOALKEEPER, "1"),
            Player("Leonardo", "Barroso", MlsPosition.DEFENDER, "2"),
            Player("Jack", "Elliott", MlsPosition.DEFENDER, "3"),
            Player("Samual", "Rogers", MlsPosition.DEFENDER, "5"),
            Player("Maren", "Haile-Selassie", MlsPosition.MIDFIELDER, "7"),
            Player("Chris", "Mueller", MlsPosition.FORWARD, "8"),
            Player("Hugo", "Cuypers", MlsPosition.FORWARD, "9"),
            Player("Philip", "Zinckernagel", MlsPosition.FORWARD, "11"),
            Player("Viktor", "Radojevic", MlsPosition.DEFENDER, "14"),
            Player("Andrew", "Gutman", MlsPosition.DEFENDER, "15"),
            Player("Joel", "Waterman", MlsPosition.DEFENDER, "16"),
            Player("Jonathan", "Bamba", MlsPosition.FORWARD, "19"),
            Player("Mauricio", "Pineda", MlsPosition.DEFENDER, "22"),
            Player("Kellyn", "Acosta", MlsPosition.MIDFIELDER, "23"),
            Player("Jonathan", "Dean", MlsPosition.MIDFIELDER, "24"),
            Player("Jeff", "Gal", MlsPosition.GOALKEEPER, "25"),
            Player("Dylan", "Borso", MlsPosition.MIDFIELDER, "27"),
            Player("David", "Poreba", MlsPosition.MIDFIELDER, "29"),
            Player("Sergio", "Oregel", MlsPosition.MIDFIELDER, "35"),
            Player("Justin", "Reynolds", MlsPosition.DEFENDER, "36"),
            Player("Robert", "Turdean", MlsPosition.MIDFIELDER, "37"),
            Player("Christopher", "Cupps", MlsPosition.DEFENDER, "38"),
            Player("D'Avilla", "Dje Tah", MlsPosition.MIDFIELDER, "42"),
            Player("Jason", "Shokalook", MlsPosition.FORWARD, "44"),
            Player("Harold", "Osorio", MlsPosition.MIDFIELDER, "45"),
            Player("Samuel", "Williams", MlsPosition.MIDFIELDER, "47"),
            Player("Richard", "Fleming", MlsPosition.MIDFIELDER, "48"),
            Player("Damian", "Nigg", MlsPosition.FORWARD, "55"),
            Player("Vitaliy", "Hlyut", MlsPosition.FORWARD, "68"),
        ),
    )
}

private val mlsTeamCol by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Colorado Rapids",
        nameWidthPercent = 63.9f,
        abbreviation = "COL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF8A2432),
            nameAccent = Color(0xFF8AB7E9),
        ),
        venue = TeamVenue(
            name = "Dick's Sporting Goods Park",
            location = VenueLocation(
                lat = 39.805556,
                long = -104.891944,
            ),
        ),
        roster = listOf(
            Player("Zack", "Steffen", MlsPosition.GOALKEEPER, "1"),
            Player("Keegan", "Rosenberry", MlsPosition.DEFENDER, "2"),
            Player("Sam", "Vines", MlsPosition.DEFENDER, "3"),
            Player("Reggie", "Cannon", MlsPosition.DEFENDER, "4"),
            Player("Rob", "Holding", MlsPosition.DEFENDER, "6"),
            Player("Oliver", "Larraz", MlsPosition.MIDFIELDER, "8"),
            Player("Rafael", "Navarro", MlsPosition.FORWARD, "9"),
            Player("Paxten", "Aaronson", MlsPosition.MIDFIELDER, "10"),
            Player("Alexis", "Castillo Manyoma", MlsPosition.MIDFIELDER, "11"),
            Player("Joshua", "Atencio", MlsPosition.MIDFIELDER, "12"),
            Player("Wayne", "Frederick", MlsPosition.FORWARD, "13"),
            Player("Ali", "Fadal", MlsPosition.MIDFIELDER, "15"),
            Player("Alex", "Harris", MlsPosition.MIDFIELDER, "16"),
            Player("Ian", "Murphy", MlsPosition.DEFENDER, "19"),
            Player("Connor", "Ronan", MlsPosition.MIDFIELDER, "20"),
            Player("Ted", "Ku-Dipietro", MlsPosition.MIDFIELDER, "21"),
            Player("Cole", "Bassett", MlsPosition.MIDFIELDER, "23"),
            Player("Kimani", "Stewart-Baynes", MlsPosition.FORWARD, "27"),
            Player("Rafael", "Santos", MlsPosition.DEFENDER, "30"),
            Player("Adam", "Beaudry", MlsPosition.GOALKEEPER, "31"),
            Player("Anderson", "Rosa", MlsPosition.DEFENDER, "36"),
            Player("Nico", "Hansen", MlsPosition.GOALKEEPER, "41"),
            Player("Sydney", "Wathuta", MlsPosition.FORWARD, "47"),
            Player("Darren", "Yapi", MlsPosition.FORWARD, "77"),
            Player("Jackson", "Travis", MlsPosition.DEFENDER, "99"),
        ),
    )
}

private val mlsTeamClb by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Columbus Crew",
        nameWidthPercent = 60.5f,
        abbreviation = "CLB",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF000000),
            nameAccent = Color(0xFFFEDD00),
        ),
        venue = TeamVenue(
            name = "Lower.com Field",
            location = VenueLocation(
                lat = 39.968460,
                long = -83.017090,
            ),
        ),
        roster = listOf(
            Player("Nicholas", "Hagen", MlsPosition.GOALKEEPER, "1"),
            Player("Andrés", "Herrera", MlsPosition.DEFENDER, "2"),
            Player("Rudy", "Camacho", MlsPosition.DEFENDER, "4"),
            Player("Dylan", "Chambost", MlsPosition.MIDFIELDER, "7"),
            Player("Dániel", "Gazdag", MlsPosition.MIDFIELDER, "8"),
            Player("Wessam Abou", "Ali", MlsPosition.FORWARD, "9"),
            Player("Diego", "Rossi", MlsPosition.MIDFIELDER, "10"),
            Player("Ibrahim", "Aliyu", MlsPosition.FORWARD, "11"),
            Player("Amar", "Sejdic", MlsPosition.MIDFIELDER, "14"),
            Player("Taha", "Habroune", MlsPosition.MIDFIELDER, "16"),
            Player("Malte", "Amundsen", MlsPosition.DEFENDER, "18"),
            Player("Jacen", "Russell-Rowe", MlsPosition.FORWARD, "19"),
            Player("Yevhen", "Cheberko", MlsPosition.DEFENDER, "21"),
            Player("Mohamed", "Farsi", MlsPosition.DEFENDER, "23"),
            Player("Evan", "Bush", MlsPosition.GOALKEEPER, "24"),
            Player("Sean", "Zawadzki", MlsPosition.MIDFIELDER, "25"),
            Player("Max", "Arfsten", MlsPosition.FORWARD, "27"),
            Player("Patrick", "Schulte", MlsPosition.GOALKEEPER, "28"),
            Player("Cole", "Mrowka", MlsPosition.MIDFIELDER, "29"),
            Player("Hugo", "Picard", MlsPosition.MIDFIELDER, "30"),
            Player("Steven", "Moreira", MlsPosition.DEFENDER, "31"),
            Player("Stanislav", "Lapkes", MlsPosition.GOALKEEPER, "41"),
            Player("Tristan", "Brown", MlsPosition.DEFENDER, "44"),
            Player("Owen", "Presthus", MlsPosition.DEFENDER, "45"),
            Player("Chase", "Adams", MlsPosition.FORWARD, "46"),
            Player("Cesar", "Ruvalcaba", MlsPosition.DEFENDER, "48"),
            Player("Luke", "Pruter", MlsPosition.GOALKEEPER, "54"),
        ),
    )
}

private val mlsTeamDc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "D.C. United",
        nameWidthPercent = 42.6f,
        abbreviation = "DC",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF000000),
            nameAccent = Color(0xFFD61018),
        ),
        venue = TeamVenue(
            name = "Audi Field",
            location = VenueLocation(
                lat = 38.868504,
                long = -77.012935,
            ),
        ),
        roster = listOf(
            Player("Kim", "Joon-Hong", MlsPosition.GOALKEEPER, "1"),
            Player("Lucas", "Bartlett", MlsPosition.DEFENDER, "3"),
            Player("Matti", "Peltola", MlsPosition.DEFENDER, "4"),
            Player("João", "Peglow", MlsPosition.FORWARD, "7"),
            Player("Jared", "Stroud", MlsPosition.MIDFIELDER, "8"),
            Player("Gabriel", "Pirani", MlsPosition.MIDFIELDER, "10"),
            Player("Conner", "Antley", MlsPosition.DEFENDER, "12"),
            Player("Dominique", "Badji", MlsPosition.FORWARD, "14"),
            Player("Kye", "Rowles", MlsPosition.DEFENDER, "15"),
            Player("Garrison", "Tubbs", MlsPosition.DEFENDER, "16"),
            Player("Jacob", "Murrell", MlsPosition.FORWARD, "17"),
            Player("Hakim", "Karamoko", MlsPosition.FORWARD, "19"),
            Player("Aaron", "Herrera", MlsPosition.DEFENDER, "22"),
            Player("Brandon", "Servania", MlsPosition.MIDFIELDER, "23"),
            Player("Jordan", "Farr", MlsPosition.GOALKEEPER, "24"),
            Player("Jackson", "Hopkins", MlsPosition.MIDFIELDER, "25"),
            Player("Kristian", "Fletcher", MlsPosition.FORWARD, "27"),
            Player("Caden", "Clark", MlsPosition.MIDFIELDER, "30"),
            Player("Gavin", "Turner", MlsPosition.MIDFIELDER, "48"),
            Player("Hosei", "Kijima", MlsPosition.MIDFIELDER, "77"),
        ),
    )
}

private val mlsTeamCin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "FC Cincinnati",
        nameWidthPercent = 50.7f,
        abbreviation = "CIN",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF003087),
            nameAccent = Color(0xFFFE5000),
        ),
        venue = TeamVenue(
            name = "TQL Stadium",
            location = VenueLocation(
                lat = 39.111389,
                long = -84.522222,
            ),
        ),
        roster = listOf(
            Player("Alvas", "Powell", MlsPosition.DEFENDER, "2"),
            Player("Gilberto", "Flores", MlsPosition.DEFENDER, "3"),
            Player("Nick", "Hagglund", MlsPosition.DEFENDER, "4"),
            Player("Obinna", "Nwobodo", MlsPosition.MIDFIELDER, "5"),
            Player("Kévin", "Denkey", MlsPosition.FORWARD, "9"),
            Player("Evander", "", MlsPosition.MIDFIELDER, "10"),
            Player("Samuel", "Gidi", MlsPosition.MIDFIELDER, "11"),
            Player("Miles", "Robinson", MlsPosition.DEFENDER, "12"),
            Player("Evan", "Louro", MlsPosition.GOALKEEPER, "13"),
            Player("Teenage", "Hadebe", MlsPosition.DEFENDER, "16"),
            Player("Roman", "Celentano", MlsPosition.GOALKEEPER, "18"),
            Player("Stefan", "Chirila", MlsPosition.MIDFIELDER, "19"),
            Player("Pavel", "Bucha", MlsPosition.MIDFIELDER, "20"),
            Player("Matt", "Miazga", MlsPosition.DEFENDER, "21"),
            Player("Gerardo", "Valenzuela", MlsPosition.MIDFIELDER, "22"),
            Player("Paul", "Walters", MlsPosition.GOALKEEPER, "25"),
            Player("Tah", "Anunga", MlsPosition.MIDFIELDER, "27"),
            Player("Nate", "Crockford", MlsPosition.GOALKEEPER, "30"),
            Player("Noah", "Adnan", MlsPosition.DEFENDER, "32"),
            Player("Kenji", "Mboma Dem", MlsPosition.FORWARD, "35"),
            Player("Stiven", "Jimenez", MlsPosition.MIDFIELDER, "37"),
            Player("Andrés", "Dávila", MlsPosition.FORWARD, "43"),
            Player("Peter", "Mangione", MlsPosition.MIDFIELDER, "49"),
            Player("Ender", "Echenique", MlsPosition.FORWARD, "66"),
        ),
    )
}

private val mlsTeamDal by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "FC Dallas",
        nameWidthPercent = 35.1f,
        abbreviation = "DAL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFC6093B),
            nameAccent = Color(0xFF001F5B),
        ),
        venue = TeamVenue(
            name = "Toyota Stadium Dallas",
            location = VenueLocation(
                lat = 33.154458,
                long = -96.835158,
            ),
        ),
        roster = listOf(
            Player("Maarten", "Paes", MlsPosition.GOALKEEPER, "1"),
            Player("Geovane", "Jesus", MlsPosition.DEFENDER, "2"),
            Player("Osaze", "Urhoghide", MlsPosition.DEFENDER, "3"),
            Player("Lalas", "Abubakar", MlsPosition.DEFENDER, "5"),
            Player("Patrickson", "Delgado", MlsPosition.MIDFIELDER, "6"),
            Player("Louicius Don", "Deedson", MlsPosition.FORWARD, "7"),
            Player("Petar", "Musa", MlsPosition.FORWARD, "9"),
            Player("Anderson", "Julio", MlsPosition.FORWARD, "11"),
            Player("Christian", "Cappis", MlsPosition.MIDFIELDER, "12"),
            Player("Jt", "Harms", MlsPosition.GOALKEEPER, "13"),
            Player("Ramiro", "", MlsPosition.MIDFIELDER, "17"),
            Player("Shaq", "Moore", MlsPosition.DEFENDER, "18"),
            Player("Paxton", "Pomykal", MlsPosition.MIDFIELDER, "19"),
            Player("Álvaro", "Augusto", MlsPosition.DEFENDER, "22"),
            Player("Logan", "Farrington", MlsPosition.FORWARD, "23"),
            Player("Joshua", "Torquato", MlsPosition.DEFENDER, "24"),
            Player("Sebastien", "Ibeagha", MlsPosition.DEFENDER, "25"),
            Player("Samuel", "Sarver", MlsPosition.FORWARD, "28"),
            Player("Enzo", "Newman", MlsPosition.DEFENDER, "29"),
            Player("Michael", "Collodi", MlsPosition.GOALKEEPER, "30"),
            Player("Nolan", "Norris", MlsPosition.DEFENDER, "32"),
            Player("Malachi", "Molina", MlsPosition.DEFENDER, "35"),
            Player("Daniel", "Baran", MlsPosition.FORWARD, "36"),
            Player("Diego", "García", MlsPosition.MIDFIELDER, "50"),
            Player("Kaick", "Da Silva Ferreira", MlsPosition.MIDFIELDER, "55"),
            Player("Bernard", "Kamungo", MlsPosition.FORWARD, "77"),
            Player("Enes", "Sali", MlsPosition.FORWARD, "99"),
        ),
    )
}

private val mlsTeamHou by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Houston Dynamo FC",
        nameWidthPercent = 78.4f,
        abbreviation = "HOU",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFFF6B00),
            nameAccent = Color(0xFF101820),
        ),
        venue = TeamVenue(
            name = "Shell Energy Stadium",
            location = VenueLocation(
                lat = 29.752200,
                long = -95.352400,
            ),
        ),
        roster = listOf(
            Player("Jimmy", "Maurer", MlsPosition.GOALKEEPER, "1"),
            Player("Antônio Carlos", "Carlos", MlsPosition.DEFENDER, "3"),
            Player("Ethan", "Bartlow", MlsPosition.DEFENDER, "4"),
            Player("Artur", "", MlsPosition.MIDFIELDER, "6"),
            Player("Nelson", "Quiñones", MlsPosition.FORWARD, "7"),
            Player("Amine", "Bassi", MlsPosition.MIDFIELDER, "8"),
            Player("Ondrej", "Lingr", MlsPosition.MIDFIELDER, "9"),
            Player("Ezequiel", "Ponce", MlsPosition.DEFENDER, "10"),
            Player("Lawrence", "Ennali", MlsPosition.FORWARD, "11"),
            Player("Toyosi", "Olusanya", MlsPosition.FORWARD, "12"),
            Player("Duane", "Holmes", MlsPosition.MIDFIELDER, "14"),
            Player("Diadie", "Samassekou", MlsPosition.MIDFIELDER, "18"),
            Player("Jack", "McGlynn", MlsPosition.MIDFIELDER, "21"),
            Player("Kieran", "Sargeant", MlsPosition.DEFENDER, "23"),
            Player("Griffin", "Dorsey", MlsPosition.MIDFIELDER, "25"),
            Player("Blake", "Gillingham", MlsPosition.GOALKEEPER, "26"),
            Player("Erik", "Sviatchenko", MlsPosition.DEFENDER, "28"),
            Player("Diego", "Gonzalez", MlsPosition.MIDFIELDER, "29"),
            Player("Jonathan", "Bond", MlsPosition.GOALKEEPER, "31"),
            Player("Pedro Henrique", "De Oliveira Cruz", MlsPosition.GOALKEEPER, "32"),
            Player("Exon", "Arzú", MlsPosition.FORWARD, "33"),
            Player("Sebastian", "Rodriguez", MlsPosition.MIDFIELDER, "34"),
            Player("Brooklyn", "Raines", MlsPosition.MIDFIELDER, "35"),
        ),
    )
}

private val mlsTeamMia by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Inter Miami CF",
        nameWidthPercent = 55.4f,
        abbreviation = "MIA",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF231F20),
            nameAccent = Color(0xFFF7B5CD),
        ),
        venue = TeamVenue(
            name = "Chase Stadium",
            location = VenueLocation(
                lat = 26.193056,
                long = -80.161111,
            ),
        ),
        roster = listOf(
            Player("Gonzalo", "Luján", MlsPosition.DEFENDER, "2"),
            Player("Tomás", "Avilés", MlsPosition.DEFENDER, "6"),
            Player("Telasco", "Segovia", MlsPosition.MIDFIELDER, "8"),
            Player("Luis", "Suárez", MlsPosition.FORWARD, "9"),
            Player("Lionel", "Messi", MlsPosition.FORWARD, "10"),
            Player("Ian", "Fray", MlsPosition.DEFENDER, "17"),
            Player("Oscar", "Ustari", MlsPosition.GOALKEEPER, "19"),
            Player("Mateo", "Silvetti", MlsPosition.FORWARD, "24"),
            Player("Tyler", "Hall", MlsPosition.DEFENDER, "26"),
            Player("Noah", "Allen", MlsPosition.DEFENDER, "32"),
            Player("Maximiliano", "Falcón", MlsPosition.DEFENDER, "37"),
            Player("David", "Ruiz", MlsPosition.MIDFIELDER, "41"),
            Player("Yannick", "Bright", MlsPosition.MIDFIELDER, "42"),
            Player("Samuel", "Basabe", MlsPosition.DEFENDER, "51"),
            Player("Dániel", "Pintér", MlsPosition.FORWARD, "56"),
            Player("Israel", "Boatwright", MlsPosition.DEFENDER, "62"),
            Player("Ricardo", "Montenegro", MlsPosition.MIDFIELDER, "69"),
            Player("Cesar", "Abadia-Reda", MlsPosition.DEFENDER, "76"),
            Player("Santiago", "Morales", MlsPosition.DEFENDER, "81"),
        ),
    )
}

private val mlsTeamLa by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "LA Galaxy",
        nameWidthPercent = 38.9f,
        abbreviation = "LA",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF00235D),
            nameAccent = Color(0xFFFFFFFF),
        ),
        venue = TeamVenue(
            name = "Dignity Health Sports Park",
            location = VenueLocation(
                lat = 33.864444,
                long = -118.261111,
            ),
        ),
        roster = listOf(
            Player("Novak", "Micovic", MlsPosition.GOALKEEPER, "1"),
            Player("Miki", "Yamane", MlsPosition.DEFENDER, "2"),
            Player("Julián", "Aude", MlsPosition.DEFENDER, "3"),
            Player("Maya", "Yoshida", MlsPosition.DEFENDER, "4"),
            Player("Mathias", "Jørgensen", MlsPosition.DEFENDER, "5"),
            Player("Edwin", "Cerrillo", MlsPosition.MIDFIELDER, "6"),
            Player("Diego", "Fagundez", MlsPosition.MIDFIELDER, "7"),
            Player("Lucas", "Sanabria", MlsPosition.MIDFIELDER, "8"),
            Player("Ricard", "Puig", MlsPosition.MIDFIELDER, "10"),
            Player("Gabriel Pec", "Pec", MlsPosition.FORWARD, "11"),
            Player("JT", "Marcinkowski", MlsPosition.GOALKEEPER, "12"),
            Player("John", "Nelson", MlsPosition.DEFENDER, "14"),
            Player("Isaiah", "Parente", MlsPosition.MIDFIELDER, "16"),
            Player("Christian", "Ramírez", MlsPosition.FORWARD, "17"),
            Player("Marco", "Reus", MlsPosition.MIDFIELDER, "18"),
            Player("Maruicio", "Cuevas", MlsPosition.DEFENDER, "19"),
            Player("Tucker", "Lepley", MlsPosition.MIDFIELDER, "21"),
            Player("Elijah", "Wynder", MlsPosition.MIDFIELDER, "22"),
            Player("Rúben", "Ismael", MlsPosition.MIDFIELDER, "24"),
            Player("Carlos", "Garcés", MlsPosition.DEFENDER, "25"),
            Player("Harbor", "Miller", MlsPosition.DEFENDER, "26"),
            Player("Joseph", "Paintsil", MlsPosition.FORWARD, "28"),
            Player("Gino", "Vivi", MlsPosition.FORWARD, "30"),
            Player("Brady", "Scott", MlsPosition.GOALKEEPER, "31"),
            Player("Thomas", "Musto", MlsPosition.MIDFIELDER, "65"),
            Player("Nicklaus", "Sullivan", MlsPosition.FORWARD, "83"),
        ),
    )
}

private val mlsTeamLafc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "LAFC",
        nameWidthPercent = 20.3f,
        abbreviation = "LAFC",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF000000),
            nameAccent = Color(0xFFC7A36F),
        ),
        venue = TeamVenue(
            name = "BMO Stadium",
            location = VenueLocation(
                lat = 34.013000,
                long = -118.285000,
            ),
        ),
        roster = listOf(
            Player("Hugo", "Lloris", MlsPosition.GOALKEEPER, "1"),
            Player("Eddie", "Segura", MlsPosition.DEFENDER, "4"),
            Player("Ryan", "Porteous", MlsPosition.DEFENDER, "5"),
            Player("Igor Jesus", "Jesus", MlsPosition.MIDFIELDER, "6"),
            Player("Son", "Heung-Min", MlsPosition.FORWARD, "7"),
            Player("Mark", "Delgado", MlsPosition.MIDFIELDER, "8"),
            Player("Timothy", "Tillman", MlsPosition.MIDFIELDER, "11"),
            Player("Thomas", "Hasal", MlsPosition.GOALKEEPER, "12"),
            Player("Sergi", "Palencia", MlsPosition.DEFENDER, "14"),
            Player("Lorenzo", "Dellavalle", MlsPosition.DEFENDER, "15"),
            Player("Jeremy", "Ebobisse", MlsPosition.FORWARD, "17"),
            Player("Yaw", "Yeboah", MlsPosition.MIDFIELDER, "20"),
            Player("Ryan", "Raposo", MlsPosition.MIDFIELDER, "21"),
            Player("Ryan", "Hollingshead", MlsPosition.DEFENDER, "24"),
            Player("Nathan", "Ordaz", MlsPosition.FORWARD, "27"),
            Player("Artem", "Smolyakov", MlsPosition.DEFENDER, "29"),
            Player("David", "Martínez", MlsPosition.FORWARD, "30"),
            Player("Cabral", "Carter", MlsPosition.GOALKEEPER, "31"),
            Player("Aaron", "Long", MlsPosition.DEFENDER, "33"),
            Player("Luca", "Bombino", MlsPosition.DEFENDER, "42"),
            Player("Kenny", "Nielsen", MlsPosition.DEFENDER, "45"),
            Player("Érick", "Díaz", MlsPosition.DEFENDER, "55"),
            Player("Jude", "Terry", MlsPosition.MIDFIELDER, "56"),
            Player("Joshua", "Santiago", MlsPosition.DEFENDER, "62"),
            Player("Matthew", "Evans", MlsPosition.MIDFIELDER, "70"),
            Player("Adrian", "Wibowo", MlsPosition.FORWARD, "77"),
            Player("Tommy", "Mihalic", MlsPosition.FORWARD, "90"),
            Player("Nkosi", "Tafari", MlsPosition.DEFENDER, "91"),
            Player("Denis", "Bouanga", MlsPosition.FORWARD, "99"),
        ),
    )
}

private val mlsTeamMin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Minnesota United FC",
        nameWidthPercent = 79.7f,
        abbreviation = "MIN",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF000000),
            nameAccent = Color(0xFF9BCDE4),
        ),
        venue = TeamVenue(
            name = "Allianz Field",
            location = VenueLocation(
                lat = 44.952800,
                long = -93.165100,
            ),
        ),
        roster = listOf(
            Player("Alec", "Smir", MlsPosition.GOALKEEPER, "1"),
            Player("Devin", "Padelford", MlsPosition.DEFENDER, "2"),
            Player("Nicolás", "Romero", MlsPosition.DEFENDER, "5"),
            Player("Dominik", "Fitz", MlsPosition.MIDFIELDER, "7"),
            Player("Joseph", "Rosales", MlsPosition.MIDFIELDER, "8"),
            Player("Kelvin", "Yeboah", MlsPosition.FORWARD, "9"),
            Player("Anthony", "Markanich", MlsPosition.DEFENDER, "13"),
            Player("Michael", "Boxall", MlsPosition.DEFENDER, "15"),
            Player("Alexis", "Fariña", MlsPosition.MIDFIELDER, "16"),
            Player("Wil", "Trapp", MlsPosition.MIDFIELDER, "20"),
            Player("Bongokuhle", "Hlongwane", MlsPosition.FORWARD, "21"),
            Player("Ho-Yeon", "Jeong", MlsPosition.MIDFIELDER, "22"),
            Player("Morris", "Duggan", MlsPosition.DEFENDER, "23"),
            Player("Julian", "Gressel", MlsPosition.MIDFIELDER, "24"),
            Player("Nectarios", "Triantis", MlsPosition.DEFENDER, "25"),
            Player("Joaquín", "Pereyra", MlsPosition.DEFENDER, "26"),
            Player("D.J.", "Taylor", MlsPosition.DEFENDER, "27"),
            Player("Jefferson", "Díaz", MlsPosition.DEFENDER, "28"),
            Player("Dieng", "Mamadou", MlsPosition.FORWARD, "29"),
            Player("Owen", "Gene", MlsPosition.MIDFIELDER, "30"),
            Player("Kieran", "Chandler", MlsPosition.DEFENDER, "33"),
            Player("Curt", "Calov", MlsPosition.MIDFIELDER, "34"),
            Player("Britton", "Fischer", MlsPosition.DEFENDER, "35"),
            Player("Kisa", "Kiingi", MlsPosition.DEFENDER, "36"),
            Player("Babacar", "Niang", MlsPosition.MIDFIELDER, "37"),
            Player("Luke", "Hille", MlsPosition.MIDFIELDER, "39"),
            Player("Carlos", "Harvey", MlsPosition.MIDFIELDER, "67"),
            Player("Loïc", "Mesanvi", MlsPosition.FORWARD, "90"),
            Player("Kayne", "Rizvanovich", MlsPosition.GOALKEEPER, "94"),
            Player("Muba", "Nour", MlsPosition.FORWARD, "95"),
            Player("Alisa", "Randell", MlsPosition.FORWARD, "98"),
            Player("Jordan", "Adebayo-Smith", MlsPosition.FORWARD, "99"),
        ),
    )
}

private val mlsTeamNsh by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Nashville SC",
        nameWidthPercent = 47.0f,
        abbreviation = "NSH",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFECE83A),
            nameAccent = Color(0xFF1F1646),
        ),
        venue = TeamVenue(
            name = "GEODIS Park",
            location = VenueLocation(
                lat = 36.130961,
                long = -86.767693,
            ),
        ),
        roster = listOf(
            Player("Daniel", "Lovitz", MlsPosition.DEFENDER, "2"),
            Player("Jeisson", "Palacios", MlsPosition.DEFENDER, "4"),
            Player("Jack", "Maher", MlsPosition.DEFENDER, "5"),
            Player("Bryan", "Acosta", MlsPosition.MIDFIELDER, "6"),
            Player("Patrick", "Yazbek", MlsPosition.MIDFIELDER, "8"),
            Player("Sam", "Surridge", MlsPosition.FORWARD, "9"),
            Player("Hany", "Mukhtar", MlsPosition.MIDFIELDER, "10"),
            Player("Xavier", "Valdez", MlsPosition.GOALKEEPER, "13"),
            Player("Jacob", "Shaffelburg", MlsPosition.FORWARD, "14"),
            Player("Matthew", "Corcoran", MlsPosition.MIDFIELDER, "16"),
            Player("Alex", "Muyl", MlsPosition.MIDFIELDER, "19"),
            Player("Edvard", "Tagseth", MlsPosition.MIDFIELDER, "20"),
            Player("Josh", "Bauer", MlsPosition.DEFENDER, "22"),
            Player("Jonathan", "Pérez", MlsPosition.DEFENDER, "24"),
            Player("Woobens", "Pacius", MlsPosition.FORWARD, "28"),
            Player("Julian", "Gaines", MlsPosition.DEFENDER, "29"),
            Player("Andy", "Nájar", MlsPosition.DEFENDER, "31"),
            Player("Chris", "Applewhite", MlsPosition.DEFENDER, "33"),
            Player("Ahmed", "Qasem", MlsPosition.FORWARD, "37"),
            Player("Isaiah", "Jones", MlsPosition.FORWARD, "47"),
            Player("Alan", "Carleton", MlsPosition.MIDFIELDER, "62"),
            Player("Jordan", "Knight", MlsPosition.MIDFIELDER, "66"),
            Player("Adem", "Sipic", MlsPosition.FORWARD, "77"),
            Player("Christian", "Koffi", MlsPosition.MIDFIELDER, "86"),
            Player("Brian", "Schwake", MlsPosition.GOALKEEPER, "99"),
        ),
    )
}

private val mlsTeamNe by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New England Revolution",
        nameWidthPercent = 92.9f,
        abbreviation = "NE",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF022166),
            nameAccent = Color(0xFFCE0E2D),
        ),
        venue = TeamVenue(
            name = "Gillette Stadium",
            location = VenueLocation(
                lat = 42.090944,
                long = -71.264344,
            ),
        ),
        roster = listOf(
            Player("Mamadou", "Fofana", MlsPosition.DEFENDER, "2"),
            Player("Brayan", "Ceballos", MlsPosition.DEFENDER, "3"),
            Player("Tanner", "Beason", MlsPosition.DEFENDER, "4"),
            Player("Keegan", "Hughes", MlsPosition.DEFENDER, "5"),
            Player("Tomás", "Chancalay", MlsPosition.FORWARD, "7"),
            Player("Matt", "Polster", MlsPosition.MIDFIELDER, "8"),
            Player("Leonardo", "Campana", MlsPosition.FORWARD, "9"),
            Player("Carles", "Gil", MlsPosition.MIDFIELDER, "10"),
            Player("Dor", "Turgeman", MlsPosition.FORWARD, "11"),
            Player("Ilay", "Feingold", MlsPosition.DEFENDER, "12"),
            Player("Jackson", "Yueill", MlsPosition.MIDFIELDER, "14"),
            Player("Allan", "Oyirwoth", MlsPosition.MIDFIELDER, "18"),
            Player("Jack", "Panayotou", MlsPosition.MIDFIELDER, "22"),
            Player("William", "Sands", MlsPosition.DEFENDER, "23"),
            Player("Alex", "Bono", MlsPosition.GOALKEEPER, "24"),
            Player("Peyton", "Miller", MlsPosition.DEFENDER, "25"),
            Player("Matt", "Turner", MlsPosition.GOALKEEPER, "30"),
            Player("Malcolm", "Fry", MlsPosition.FORWARD, "32"),
            Player("Donovan", "Parisian", MlsPosition.GOALKEEPER, "33"),
            Player("Cristiano", "Oliveira", MlsPosition.MIDFIELDER, "35"),
            Player("Eric", "Klein", MlsPosition.MIDFIELDER, "38"),
            Player("Marcos", "Domingos Dias", MlsPosition.FORWARD, "39"),
            Player("Luca", "Langoni", MlsPosition.FORWARD, "41"),
            Player("Santiago", "Suarez", MlsPosition.DEFENDER, "43"),
            Player("Gevork", "Diarbian", MlsPosition.MIDFIELDER, "45"),
            Player("Victor", "Souza", MlsPosition.GOALKEEPER, "47"),
            Player("Liam", "Butts", MlsPosition.FORWARD, "48"),
            Player("Alex", "Monis", MlsPosition.FORWARD, "49"),
            Player("Hesron", "Barry", MlsPosition.DEFENDER, "55"),
            Player("Gabe", "Dahlin", MlsPosition.DEFENDER, "58"),
            Player("Sharod", "George", MlsPosition.MIDFIELDER, "59"),
            Player("JD", "Gunn", MlsPosition.GOALKEEPER, "73"),
            Player("Alhassan", "Yusuf", MlsPosition.MIDFIELDER, "80"),
            Player("Andrew", "Farrell", MlsPosition.DEFENDER, "88"),
        ),
    )
}

private val mlsTeamNyc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York City FC",
        nameWidthPercent = 65.9f,
        abbreviation = "NYC",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF9FD2FF),
            nameAccent = Color(0xFF000229),
        ),
        venue = TeamVenue(
            name = "Yankee Stadium",
            location = VenueLocation(
                lat = 40.829569,
                long = -73.926392,
            ),
        ),
        roster = listOf(
            Player("Nico", "Cavallo", MlsPosition.DEFENDER, "2"),
            Player("Nicolás", "Fernández", MlsPosition.MIDFIELDER, "7"),
            Player("Andrés", "Perea", MlsPosition.MIDFIELDER, "8"),
            Player("Maxi", "Morález", MlsPosition.MIDFIELDER, "10"),
            Player("Julián", "Fernández", MlsPosition.FORWARD, "11"),
            Player("Thiago", "Martins", MlsPosition.DEFENDER, "13"),
            Player("Alonso", "Martínez", MlsPosition.FORWARD, "16"),
            Player("Hannes", "Wolf", MlsPosition.FORWARD, "17"),
            Player("Greg", "Ranjitsingh", MlsPosition.GOALKEEPER, "18"),
            Player("Strahinja", "Tanasijevic", MlsPosition.DEFENDER, "19"),
            Player("Aiden", "O'Neill", MlsPosition.MIDFIELDER, "21"),
            Player("Kevin", "O'Toole", MlsPosition.DEFENDER, "22"),
            Player("Max", "Murray", MlsPosition.DEFENDER, "23"),
            Player("Tayvon", "Gray", MlsPosition.DEFENDER, "24"),
            Player("Agustin", "Ojeda", MlsPosition.FORWARD, "26"),
            Player("Maxi", "Carrizo", MlsPosition.MIDFIELDER, "29"),
            Player("Tomas", "Romero", MlsPosition.GOALKEEPER, "30"),
            Player("Jonathan", "Shore", MlsPosition.MIDFIELDER, "32"),
            Player("Raul Gustavo", "Gustavo", MlsPosition.DEFENDER, "34"),
            Player("Mitja", "Ilenic", MlsPosition.DEFENDER, "35"),
            Player("Zidane", "Yañez", MlsPosition.FORWARD, "36"),
            Player("Andrew", "Baiera", MlsPosition.DEFENDER, "38"),
            Player("Talles Magno", "Magno", MlsPosition.FORWARD, "43"),
            Player("Jacob", "Arroyave", MlsPosition.MIDFIELDER, "47"),
            Player("Matthew", "Freese", MlsPosition.GOALKEEPER, "49"),
            Player("Keaton", "Parks", MlsPosition.MIDFIELDER, "55"),
            Player("Peter", "Molinari", MlsPosition.MIDFIELDER, "71"),
            Player("Sebastiano", "Musu", MlsPosition.FORWARD, "81"),
            Player("Malachi", "Jones", MlsPosition.FORWARD, "88"),
            Player("Seymour", "Reid", MlsPosition.FORWARD, "99"),
        ),
    )
}

private val mlsTeamNy by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Red Bulls",
        nameWidthPercent = 73.3f,
        abbreviation = "NY",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFBA0C2F),
            nameAccent = Color(0xFFFFC72C),
        ),
        venue = TeamVenue(
            name = "Sports Illustrated Stadium",
            location = VenueLocation(
                lat = 40.736667,
                long = -74.150278,
            ),
        ),
        roster = listOf(
            Player("Anthony", "Marcucci", MlsPosition.GOALKEEPER, "1"),
            Player("Noah", "Eile", MlsPosition.DEFENDER, "3"),
            Player("Gustaf", "Beggren", MlsPosition.MIDFIELDER, "4"),
            Player("Omar", "Valencia", MlsPosition.DEFENDER, "5"),
            Player("Wiktor", "Bogacz", MlsPosition.FORWARD, "7"),
            Player("Peter", "Stroud", MlsPosition.MIDFIELDER, "8"),
            Player("Lewis", "Morgan", MlsPosition.MIDFIELDER, "9"),
            Player("Emil", "Forsberg", MlsPosition.MIDFIELDER, "10"),
            Player("Dylan", "Nealis", MlsPosition.DEFENDER, "12"),
            Player("Eric Maxim", "Choupo-Moting", MlsPosition.FORWARD, "13"),
            Player("Marcelo", "Morales", MlsPosition.DEFENDER, "14"),
            Player("Sean", "Nealis", MlsPosition.DEFENDER, "15"),
            Player("Cameron", "Harper", MlsPosition.DEFENDER, "17"),
            Player("Wikelman", "Carmona", MlsPosition.MIDFIELDER, "19"),
            Player("Juan", "Mina", MlsPosition.DEFENDER, "20"),
            Player("Aidan", "Stokes", MlsPosition.GOALKEEPER, "21"),
            Player("Dennis", "Gjengaar", MlsPosition.FORWARD, "22"),
            Player("John", "McCarthy", MlsPosition.GOALKEEPER, "23"),
            Player("Tim", "Parker", MlsPosition.DEFENDER, "26"),
            Player("Roald", "Mitchell", MlsPosition.FORWARD, "33"),
            Player("Mohammed", "Sofo", MlsPosition.FORWARD, "37"),
            Player("Raheem", "Edwards", MlsPosition.MIDFIELDER, "44"),
            Player("Ronald", "Donkor", MlsPosition.MIDFIELDER, "48"),
            Player("Austin", "Causey", MlsPosition.GOALKEEPER, "55"),
            Player("Tanner", "Rosborough", MlsPosition.MIDFIELDER, "66"),
            Player("Andy", "Rojas", MlsPosition.FORWARD, "70"),
            Player("Tobias", "Szewczyk", MlsPosition.GOALKEEPER, "72"),
            Player("Daniel", "Edelman", MlsPosition.MIDFIELDER, "75"),
            Player("Rafael", "Mosquera", MlsPosition.FORWARD, "79"),
            Player("Serge", "Ngoma", MlsPosition.FORWARD, "81"),
            Player("Aiden", "Jarvis", MlsPosition.MIDFIELDER, "88"),
        ),
    )
}

private val mlsTeamOrl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Orlando City SC",
        nameWidthPercent = 61.1f,
        abbreviation = "ORL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF60269E),
            nameAccent = Color(0xFFF0D283),
        ),
        venue = TeamVenue(
            name = "Inter&Co Stadium",
            location = VenueLocation(
                lat = 28.541065,
                long = -81.389035,
            ),
        ),
        roster = listOf(
            Player("David", "Brekalo", MlsPosition.DEFENDER, "4"),
            Player("Robin", "Jansson", MlsPosition.DEFENDER, "6"),
            Player("Martín", "Ojeda", MlsPosition.MIDFIELDER, "10"),
            Player("Javier", "Otero", MlsPosition.GOALKEEPER, "12"),
            Player("Duncan", "McGuire", MlsPosition.FORWARD, "13"),
            Player("Tyrese", "Spicer", MlsPosition.FORWARD, "14"),
            Player("Wilder", "Cartagena", MlsPosition.MIDFIELDER, "16"),
            Player("Dagur", "Thórhallsson", MlsPosition.MIDFIELDER, "17"),
            Player("Eduard", "Atuesta", MlsPosition.MIDFIELDER, "20"),
            Player("Adrián", "Marín", MlsPosition.DEFENDER, "21"),
            Player("Kyle", "Smith", MlsPosition.DEFENDER, "24"),
            Player("Colin", "Guske", MlsPosition.MIDFIELDER, "25"),
            Player("Tahir", "Reid-Brown", MlsPosition.DEFENDER, "29"),
            Player("Alex", "Freeman", MlsPosition.DEFENDER, "30"),
            Player("Yutaro", "Tsukada", MlsPosition.FORWARD, "34"),
            Player("Joran", "Gerbet", MlsPosition.MIDFIELDER, "35"),
            Player("Titus", "Sandy", MlsPosition.DEFENDER, "36", "Jr."),
            Player("Bernardo", "Rhein Goncalves", MlsPosition.FORWARD, "44"),
            Player("Justin", "Ellis", MlsPosition.FORWARD, "59"),
            Player("Jackson", "Platts", MlsPosition.DEFENDER, "61"),
            Player("Gustavo", "Caraballo", MlsPosition.FORWARD, "65"),
            Player("Thomas", "Williams", MlsPosition.DEFENDER, "68"),
            Player("Dylan", "Judelson", MlsPosition.MIDFIELDER, "74"),
            Player("Iván", "Angulo", MlsPosition.MIDFIELDER, "77"),
            Player("Marco", "Pasalic", MlsPosition.FORWARD, "87"),
            Player("Zakaria", "Taifi", MlsPosition.MIDFIELDER, "96"),
        ),
    )
}

private val mlsTeamPhi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Philadelphia Union",
        nameWidthPercent = 70.6f,
        abbreviation = "PHI",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF051F31),
            nameAccent = Color(0xFFE0D0A6),
        ),
        venue = TeamVenue(
            name = "Subaru Park",
            location = VenueLocation(
                lat = 39.832222,
                long = -75.378889,
            ),
        ),
        roster = listOf(
            Player("Jovan", "Lukic", MlsPosition.MIDFIELDER, "4"),
            Player("Jakob", "Glesnes", MlsPosition.DEFENDER, "5"),
            Player("Cavan", "Sullivan", MlsPosition.MIDFIELDER, "6"),
            Player("Jesús", "Bueno", MlsPosition.MIDFIELDER, "8"),
            Player("Tai", "Baribo", MlsPosition.FORWARD, "9"),
            Player("Alejandro", "Bedoya", MlsPosition.MIDFIELDER, "11"),
            Player("Jeremy", "Rafanello", MlsPosition.MIDFIELDER, "14"),
            Player("Olivier", "Mbaizo", MlsPosition.DEFENDER, "15"),
            Player("Ben", "Bender", MlsPosition.MIDFIELDER, "16"),
            Player("Andre", "Blake", MlsPosition.GOALKEEPER, "18"),
            Player("Indiana", "Vassilev", MlsPosition.MIDFIELDER, "19"),
            Player("Bruno", "Damiani", MlsPosition.FORWARD, "20"),
            Player("Danley", "Jean Jacques", MlsPosition.MIDFIELDER, "21"),
            Player("David", "Vazquez", MlsPosition.MIDFIELDER, "22"),
            Player("Nathan", "Harriel", MlsPosition.DEFENDER, "26"),
            Player("Olwethu", "Makhanya", MlsPosition.DEFENDER, "29"),
            Player("Pierce", "Holbrook", MlsPosition.GOALKEEPER, "30"),
            Player("George", "Marks", MlsPosition.GOALKEEPER, "31"),
            Player("Milan", "Iloski", MlsPosition.FORWARD, "32"),
            Player("Quinn", "Sullivan", MlsPosition.MIDFIELDER, "33"),
            Player("Markus", "Anderson", MlsPosition.FORWARD, "35"),
            Player("Stas", "Korzeniowski", MlsPosition.FORWARD, "37"),
            Player("Frankie", "Westfield", MlsPosition.DEFENDER, "39"),
            Player("Neil", "Pierre", MlsPosition.DEFENDER, "44"),
            Player("Sal", "Olivas", MlsPosition.FORWARD, "55"),
            Player("Andrew", "Rick", MlsPosition.GOALKEEPER, "76"),
            Player("Edward", "Davis", MlsPosition.FORWARD, "77"),
        ),
    )
}

private val mlsTeamPor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Portland Timbers",
        nameWidthPercent = 66.2f,
        abbreviation = "POR",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF2C5234),
            nameAccent = Color(0xFFC99700),
        ),
        venue = TeamVenue(
            name = "Providence Park",
            location = VenueLocation(
                lat = 45.521389,
                long = -122.691667,
            ),
        ),
        roster = listOf(
            Player("Kamal", "Miller", MlsPosition.DEFENDER, "4"),
            Player("Ariel", "Lassiter", MlsPosition.FORWARD, "7"),
            Player("Felipe", "Mora", MlsPosition.FORWARD, "9"),
            Player("David", "Da Costa", MlsPosition.MIDFIELDER, "10"),
            Player("Antony", "", MlsPosition.FORWARD, "11"),
            Player("Jonathan", "Rodríguez", MlsPosition.FORWARD, "14"),
            Player("Zac", "McGraw", MlsPosition.DEFENDER, "18"),
            Player("Kevin", "Kelsy", MlsPosition.FORWARD, "19"),
            Player("Finn", "Surman", MlsPosition.DEFENDER, "20"),
            Player("Diego", "Chará", MlsPosition.MIDFIELDER, "21"),
            Player("Omir", "Fernández", MlsPosition.FORWARD, "22"),
            Player("Ian", "Smith", MlsPosition.DEFENDER, "23"),
            Player("David", "Ayala", MlsPosition.MIDFIELDER, "24"),
            Player("Trey", "Muse", MlsPosition.GOALKEEPER, "25"),
            Player("Jimer", "Fory", MlsPosition.MIDFIELDER, "27"),
            Player("Juan", "Mosquera", MlsPosition.DEFENDER, "29"),
            Player("Noah", "Santos", MlsPosition.FORWARD, "37"),
            Player("James", "Pantemis", MlsPosition.GOALKEEPER, "41"),
            Player("Blake", "Pope", MlsPosition.DEFENDER, "45"),
            Player("Adolfo", "Enriquez", MlsPosition.MIDFIELDER, "46"),
            Player("Sawyer", "Jura", MlsPosition.DEFENDER, "51"),
            Player("Daniel", "Nunez", MlsPosition.FORWARD, "63"),
            Player("Joao", "Ortiz", MlsPosition.MIDFIELDER, "80"),
            Player("Gage", "Guerra", MlsPosition.FORWARD, "88"),
            Player("Kristoffer", "Velde", MlsPosition.FORWARD, "99"),
        ),
    )
}

private val mlsTeamRsl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Real Salt Lake",
        nameWidthPercent = 53.0f,
        abbreviation = "RSL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFA32035),
            nameAccent = Color(0xFFDAA900),
        ),
        venue = TeamVenue(
            name = "America First Field",
            location = VenueLocation(
                lat = 40.582900,
                long = -111.893000,
            ),
        ),
        roster = listOf(
            Player("Rafael", "", MlsPosition.GOALKEEPER, "1"),
            Player("DeAndre", "Yedlin", MlsPosition.DEFENDER, "2"),
            Player("Brayan", "Vera", MlsPosition.DEFENDER, "4"),
            Player("Braian", "Ojeda", MlsPosition.MIDFIELDER, "6"),
            Player("Pablo", "Ruiz", MlsPosition.MIDFIELDER, "7"),
            Player("Diego", "Luna", MlsPosition.MIDFIELDER, "8"),
            Player("Diogo", "Gonçalves", MlsPosition.MIDFIELDER, "10"),
            Player("Dominik", "Marczuk", MlsPosition.FORWARD, "11"),
            Player("Rwan Cruz", "Cruz", MlsPosition.FORWARD, "12"),
            Player("Emeka", "Eneli", MlsPosition.MIDFIELDER, "14"),
            Player("Justen", "Glad", MlsPosition.DEFENDER, "15"),
            Player("Tyler", "Wolff", MlsPosition.FORWARD, "16"),
            Player("Victor", "Olatunji", MlsPosition.FORWARD, "17"),
            Player("Marcos", "Zambrano-Delgado", MlsPosition.FORWARD, "20"),
            Player("Ariath", "Piol", MlsPosition.FORWARD, "23"),
            Player("Max", "Kerkvliet", MlsPosition.GOALKEEPER, "24"),
            Player("Philip", "Quinton", MlsPosition.DEFENDER, "26"),
            Player("Owen", "Anderson", MlsPosition.MIDFIELDER, "30"),
            Player("Mason", "Stajduhar", MlsPosition.GOALKEEPER, "31"),
            Player("Luca", "Moisa", MlsPosition.MIDFIELDER, "34"),
            Player("Jesús", "Barea", MlsPosition.FORWARD, "36"),
            Player("Luis", "Rivera", MlsPosition.DEFENDER, "37"),
            Player("Aiden", "Hezarkhani", MlsPosition.FORWARD, "39"),
            Player("Omar", "Marquez", MlsPosition.FORWARD, "40"),
            Player("Gio", "Villa", MlsPosition.DEFENDER, "41"),
            Player("Zavier", "Gozo", MlsPosition.FORWARD, "72"),
            Player("Griffin", "Dillon", MlsPosition.MIDFIELDER, "81"),
            Player("Javain", "Brown", MlsPosition.DEFENDER, "91"),
            Player("Noel", "Caliskan", MlsPosition.MIDFIELDER, "92"),
            Player("Alexandros", "Katranis", MlsPosition.DEFENDER, "98"),
        ),
    )
}

private val mlsTeamSd by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Diego FC",
        nameWidthPercent = 50.3f,
        abbreviation = "SD",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF697A7C),
            nameAccent = Color(0xFFF89E1A),
        ),
        venue = TeamVenue(
            name = "Snapdragon Stadium",
            location = VenueLocation(
                lat = 32.784444,
                long = -117.122833,
            ),
        ),
        roster = listOf(
            Player("Carlos", "Dos Santos", MlsPosition.GOALKEEPER, "1"),
            Player("William", "Kumado", MlsPosition.DEFENDER, "2"),
            Player("Leo", "Duru", MlsPosition.DEFENDER, "3"),
            Player("Andrés", "Reyes", MlsPosition.DEFENDER, "4"),
            Player("Jeppe", "Tverskov", MlsPosition.MIDFIELDER, "6"),
            Player("Marcus", "Ingvartsen", MlsPosition.FORWARD, "7"),
            Player("Tomás", "Ángel", MlsPosition.FORWARD, "9"),
            Player("Anders", "Dreyer", MlsPosition.MIDFIELDER, "10"),
            Player("Hirving", "Lozano", MlsPosition.FORWARD, "11"),
            Player("Pablo", "Sisniega", MlsPosition.GOALKEEPER, "13"),
            Player("Pedro", "Soma", MlsPosition.MIDFIELDER, "15"),
            Player("Heine", "Gikling Bruseth", MlsPosition.MIDFIELDER, "16"),
            Player("Paddy", "McNair", MlsPosition.DEFENDER, "17"),
            Player("Duran", "Ferree", MlsPosition.GOALKEEPER, "18"),
            Player("Aníbal", "Godoy", MlsPosition.MIDFIELDER, "20"),
            Player("Corey", "Baird", MlsPosition.FORWARD, "21"),
            Player("Emmanuel", "Boateng", MlsPosition.MIDFIELDER, "24"),
            Player("Ian", "Pilcher", MlsPosition.DEFENDER, "25"),
            Player("Manu", "Duah", MlsPosition.MIDFIELDER, "26"),
            Player("Anisse", "Saidi", MlsPosition.FORWARD, "29"),
            Player("Alejandro", "Alvarado", MlsPosition.FORWARD, "70", "Jr."),
            Player("Alex", "Mighten", MlsPosition.FORWARD, "77"),
            Player("Amahl", "Pellegrino", MlsPosition.FORWARD, "90"),
            Player("Christopher", "McVey", MlsPosition.DEFENDER, "97"),
        ),
    )
}

private val mlsTeamSj by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Jose Earthquakes",
        nameWidthPercent = 84.8f,
        abbreviation = "SJ",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF003DA6),
            nameAccent = Color(0xFFFFFFFF),
        ),
        venue = TeamVenue(
            name = "PayPal Park",
            location = VenueLocation(
                lat = 37.351389,
                long = -121.925000,
            ),
        ),
        roster = listOf(
            Player("Jamar", "Ricketts", MlsPosition.DEFENDER, "2"),
            Player("Paul", "Marie", MlsPosition.DEFENDER, "3"),
            Player("Daniel", "Munie", MlsPosition.DEFENDER, "5"),
            Player("Ian", "Harkes", MlsPosition.MIDFIELDER, "6"),
            Player("Cristian", "Arango", MlsPosition.FORWARD, "9"),
            Player("Ousseni", "Bouda", MlsPosition.FORWARD, "11"),
            Player("Dave", "Romney", MlsPosition.DEFENDER, "12"),
            Player("Cruz", "Medina", MlsPosition.MIDFIELDER, "15"),
            Player("Jack", "Skahan", MlsPosition.MIDFIELDER, "16"),
            Player("Reid", "Roberts", MlsPosition.DEFENDER, "18"),
            Player("Preston", "Judd", MlsPosition.FORWARD, "19"),
            Player("Nick", "Fernandez", MlsPosition.MIDFIELDER, "20"),
            Player("Noel", "Buck", MlsPosition.MIDFIELDER, "21"),
            Player("DeJuan", "Jones", MlsPosition.DEFENDER, "22"),
            Player("Nick", "Lima", MlsPosition.DEFENDER, "24"),
            Player("Max", "Floriani", MlsPosition.DEFENDER, "25"),
            Player("Benjamin", "Kikanovic", MlsPosition.FORWARD, "28"),
            Player("Kaedren", "Spivey", MlsPosition.MIDFIELDER, "29"),
            Player("Niko", "Tsakiris", MlsPosition.MIDFIELDER, "30"),
            Player("Francesco", "Montali", MlsPosition.GOALKEEPER, "31"),
            Player("Oscar", "Verhoeven", MlsPosition.DEFENDER, "33"),
            Player("Beau", "Leroux", MlsPosition.MIDFIELDER, "34"),
            Player("Earl", "Edwards", MlsPosition.GOALKEEPER, "36"),
            Player("Ronaldo", "Vieira", MlsPosition.MIDFIELDER, "37"),
            Player("Edwyn", "Mendoza", MlsPosition.MIDFIELDER, "38"),
            Player("Daniel", "", MlsPosition.GOALKEEPER, "42"),
            Player("Chance", "Cowell", MlsPosition.FORWARD, "44"),
            Player("Vítor", "Costa", MlsPosition.DEFENDER, "94"),
            Player("Luca", "Ulrich", MlsPosition.GOALKEEPER, "97"),
        ),
    )
}

private val mlsTeamSea by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Seattle Sounders FC",
        nameWidthPercent = 77.7f,
        abbreviation = "SEA",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFF2DC84D),
            nameAccent = Color(0xFF0033A0),
        ),
        venue = TeamVenue(
            name = "Lumen Field",
            location = VenueLocation(
                lat = 47.595278,
                long = -122.331667,
            ),
        ),
        roster = listOf(
            Player("Nouhou", "Tolo", MlsPosition.DEFENDER, "5"),
            Player("Cristian", "Roldan", MlsPosition.MIDFIELDER, "7"),
            Player("Jesús", "Ferreira", MlsPosition.FORWARD, "9"),
            Player("Pedro", "de la Vega", MlsPosition.FORWARD, "10"),
            Player("Albert", "Rusnák", MlsPosition.MIDFIELDER, "11"),
            Player("Jordan", "Morris", MlsPosition.FORWARD, "13"),
            Player("Alex", "Roldan", MlsPosition.DEFENDER, "16"),
            Player("Paul", "Arriola", MlsPosition.FORWARD, "17"),
            Player("Obed", "Vargas", MlsPosition.MIDFIELDER, "18"),
            Player("Daniel", "Musovski", MlsPosition.FORWARD, "19"),
            Player("Kim", "Kee-Hee", MlsPosition.DEFENDER, "20"),
            Player("Reed", "Baker-Whiting", MlsPosition.MIDFIELDER, "21"),
            Player("Jackson", "Ragen", MlsPosition.DEFENDER, "25"),
            Player("Andrew", "Thomas", MlsPosition.GOALKEEPER, "26"),
            Player("Yeimar", "Gómez", MlsPosition.DEFENDER, "28"),
            Player("Antino", "Lopez", MlsPosition.DEFENDER, "35"),
            Player("Snyder", "Brunell", MlsPosition.MIDFIELDER, "37"),
            Player("Stuart", "Hawkins", MlsPosition.DEFENDER, "39"),
            Player("Mohammed", "Shour", MlsPosition.GOALKEEPER, "41"),
            Player("Peter", "Kingston", MlsPosition.MIDFIELDER, "45"),
            Player("Kalani", "Kossa-Rienzi", MlsPosition.MIDFIELDER, "85"),
            Player("Sebastian", "Gomez", MlsPosition.MIDFIELDER, "90"),
            Player("Georgi", "Minoungou", MlsPosition.FORWARD, "93"),
            Player("Osaze", "De Rosario", MlsPosition.FORWARD, "95"),
        ),
    )
}

private val mlsTeamSkc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Sporting Kansas City",
        nameWidthPercent = 80.1f,
        abbreviation = "SKC",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFA7C6ED),
            nameAccent = Color(0xFF0A2240),
        ),
        venue = TeamVenue(
            name = "Children's Mercy Park",
            location = VenueLocation(
                lat = 39.121800,
                long = -94.823700,
            ),
        ),
        roster = listOf(
            Player("John", "Pulskamp", MlsPosition.GOALKEEPER, "1"),
            Player("Ian", "James", MlsPosition.DEFENDER, "2"),
            Player("Dejan", "Joveljic", MlsPosition.FORWARD, "9"),
            Player("Dániel", "Sallói", MlsPosition.FORWARD, "10"),
            Player("Jack", "Kortkamp", MlsPosition.GOALKEEPER, "12"),
            Player("Jansen", "Miller", MlsPosition.DEFENDER, "15"),
            Player("Jacob", "Bartlett", MlsPosition.DEFENDER, "16"),
            Player("Jacob", "Davis", MlsPosition.MIDFIELDER, "17"),
            Player("Manu", "García", MlsPosition.MIDFIELDER, "21"),
            Player("Zorhan", "Bassong", MlsPosition.DEFENDER, "22"),
            Player("Stephen", "Afrifa", MlsPosition.FORWARD, "30"),
            Player("Ryan", "Schewe", MlsPosition.GOALKEEPER, "36"),
            Player("Cielo", "Tschantret", MlsPosition.MIDFIELDER, "52"),
            Player("Shapi", "Suleymanov", MlsPosition.FORWARD, "93"),
        ),
    )
}

private val mlsTeamStl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "St. Louis CITY SC",
        nameWidthPercent = 63.9f,
        abbreviation = "STL",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFEC1458),
            nameAccent = Color(0xFF001544),
        ),
        venue = TeamVenue(
            name = "Energizer Park",
            location = VenueLocation(
                lat = 38.631052,
                long = -90.210921,
            ),
        ),
        roster = listOf(
            Player("Roman", "Bürki", MlsPosition.GOALKEEPER, "1"),
            Player("Henry", "Kessler", MlsPosition.DEFENDER, "5"),
            Player("Tomas", "Ostrak", MlsPosition.MIDFIELDER, "7"),
            Player("Christopher", "Durkin", MlsPosition.MIDFIELDER, "8"),
            Player("João", "Klauss", MlsPosition.FORWARD, "9"),
            Player("Eduard", "Löwen", MlsPosition.MIDFIELDER, "10"),
            Player("Simon", "Becher", MlsPosition.FORWARD, "11"),
            Player("Célio", "Pompeu", MlsPosition.MIDFIELDER, "12"),
            Player("Tomas", "Totland", MlsPosition.DEFENDER, "14"),
            Player("Joshua", "Yaro", MlsPosition.DEFENDER, "15"),
            Player("Emil", "Jääskeläinen", MlsPosition.FORWARD, "16"),
            Player("Marcel", "Hartel", MlsPosition.MIDFIELDER, "17"),
            Player("Kyle", "Hiebert", MlsPosition.DEFENDER, "22"),
            Player("Christian", "Olivares", MlsPosition.GOALKEEPER, "31"),
            Player("Timo", "Baumgartl", MlsPosition.DEFENDER, "32"),
            Player("Tyson", "Pearce", MlsPosition.MIDFIELDER, "33"),
            Player("Cedric", "Teuchert", MlsPosition.FORWARD, "36"),
            Player("Cameron", "Cilley", MlsPosition.MIDFIELDER, "43"),
            Player("Caden", "Glover", MlsPosition.FORWARD, "46"),
            Player("Mykhi", "Joyner", MlsPosition.MIDFIELDER, "59"),
            Player("Jeong", "Sang-Bin", MlsPosition.FORWARD, "77"),
            Player("Brendan", "McSorley", MlsPosition.FORWARD, "80"),
            Player("Jaziel", "Orozco", MlsPosition.DEFENDER, "91"),
            Player("Fallou", "Fall", MlsPosition.MIDFIELDER, "95"),
            Player("Jayden", "Reid", MlsPosition.DEFENDER, "99"),
        ),
    )
}

private val mlsTeamTor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Toronto FC",
        nameWidthPercent = 43.2f,
        abbreviation = "TOR",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFAA182C),
            nameAccent = Color(0xFFA2A9AD),
        ),
        venue = TeamVenue(
            name = "BMO Field",
            location = VenueLocation(
                lat = 43.632778,
                long = -79.418611,
            ),
        ),
        roster = listOf(
            Player("Henry", "Wingo", MlsPosition.DEFENDER, "2"),
            Player("Kosi", "Thompson", MlsPosition.MIDFIELDER, "6"),
            Player("José", "Cifuentes", MlsPosition.MIDFIELDER, "8"),
            Player("Djordje", "Mihailovic", MlsPosition.MIDFIELDER, "10"),
            Player("Derrick", "Etienne", MlsPosition.FORWARD, "11", "Jr."),
            Player("Zane", "Monlouis", MlsPosition.DEFENDER, "12"),
            Player("Alonso", "Coello", MlsPosition.MIDFIELDER, "14"),
            Player("Nickseon", "Gomis", MlsPosition.DEFENDER, "15"),
            Player("Kobe", "Franklin", MlsPosition.DEFENDER, "19"),
            Player("Jonathan", "Osorio", MlsPosition.MIDFIELDER, "21"),
            Player("Richie", "Laryea", MlsPosition.DEFENDER, "22"),
            Player("Deandre", "Kerr", MlsPosition.FORWARD, "29"),
            Player("Adam", "Pearlman", MlsPosition.DEFENDER, "51"),
            Player("Markus", "Cimermancic", MlsPosition.MIDFIELDER, "71"),
            Player("Michael", "Sullivan", MlsPosition.MIDFIELDER, "74"),
            Player("Reid", "Fisher", MlsPosition.DEFENDER, "75"),
            Player("Lazar", "Stefanovic", MlsPosition.DEFENDER, "76"),
            Player("Adisa", "De Rosario", MlsPosition.GOALKEEPER, "77"),
            Player("Malik", "Henry", MlsPosition.MIDFIELDER, "78"),
            Player("Luka", "Gavran", MlsPosition.GOALKEEPER, "90"),
            Player("Jules-Anthony", "Vilsaint", MlsPosition.FORWARD, "99"),
        ),
    )
}

private val mlsTeamVan by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Vancouver Whitecaps",
        nameWidthPercent = 85.1f,
        abbreviation = "VAN",
        league = LeagueId.MLS,
        colors = TeamColors(
            primary = Color(0xFFFFFFFF),
            nameAccent = Color(0xFF12284C),
        ),
        venue = TeamVenue(
            name = "BC Place",
            location = VenueLocation(
                lat = 49.276667,
                long = -123.111944,
            ),
        ),
        roster = listOf(
            Player("Yohei", "Takaoka", MlsPosition.GOALKEEPER, "1"),
            Player("Mathías", "Laborda", MlsPosition.DEFENDER, "2"),
            Player("Sam", "Adekugbe", MlsPosition.DEFENDER, "3"),
            Player("Ranko", "Veselinovic", MlsPosition.DEFENDER, "4"),
            Player("Ralph", "Priso-Mbongue", MlsPosition.MIDFIELDER, "6"),
            Player("Jayden", "Nelson", MlsPosition.FORWARD, "7"),
            Player("Emmanuel", "Sabbi", MlsPosition.FORWARD, "11"),
            Player("Belal", "Halbouni", MlsPosition.DEFENDER, "12"),
            Player("Thomas", "Müller", MlsPosition.FORWARD, "13"),
            Player("Sebastian", "Schonlau", MlsPosition.DEFENDER, "15"),
            Player("Sebastian", "Berhalter", MlsPosition.MIDFIELDER, "16"),
            Player("Kenji", "Cabrera", MlsPosition.FORWARD, "17"),
            Player("Édier", "Ocampo", MlsPosition.DEFENDER, "18"),
            Player("Andrés", "Cubas", MlsPosition.MIDFIELDER, "20"),
            Player("Joederik", "Pupe", MlsPosition.DEFENDER, "23"),
            Player("Brian", "White", MlsPosition.FORWARD, "24"),
            Player("Ryan", "Gauld", MlsPosition.MIDFIELDER, "25"),
            Player("Jean-Claude", "Ngando", MlsPosition.MIDFIELDER, "26"),
            Player("Giuseppe", "Bovalina", MlsPosition.DEFENDER, "27"),
            Player("Tate", "Johnson", MlsPosition.DEFENDER, "28"),
            Player("Adrián", "Zendejas", MlsPosition.GOALKEEPER, "30"),
            Player("Isaac", "Boehmer", MlsPosition.GOALKEEPER, "32"),
            Player("Tristan", "Blackmon", MlsPosition.DEFENDER, "33"),
            Player("Nikola", "Djordjevic", MlsPosition.DEFENDER, "41"),
            Player("Nelson", "Pierre", MlsPosition.FORWARD, "42"),
            Player("Antoine", "Coupland", MlsPosition.MIDFIELDER, "43"),
            Player("Jackson", "Castro", MlsPosition.MIDFIELDER, "44"),
            Player("Adrian", "Pelayo", MlsPosition.DEFENDER, "48"),
            Player("Daniel", "Russo", MlsPosition.DEFENDER, "54"),
            Player("Jeevan", "Badwal", MlsPosition.MIDFIELDER, "59"),
            Player("Johnny", "Selemani", MlsPosition.FORWARD, "63"),
            Player("Rayan", "Elloumi", MlsPosition.FORWARD, "75"),
            Player("Liam", "Mackenzie", MlsPosition.MIDFIELDER, "97"),
        ),
    )
}

val MlsTeams: List<Team<MlsPosition>> by lazy(LazyThreadSafetyMode.NONE) {
    listOf(
        mlsTeamAtl,
        mlsTeamAtx,
        mlsTeamMtl,
        mlsTeamClt,
        mlsTeamChi,
        mlsTeamCol,
        mlsTeamClb,
        mlsTeamDc,
        mlsTeamCin,
        mlsTeamDal,
        mlsTeamHou,
        mlsTeamMia,
        mlsTeamLa,
        mlsTeamLafc,
        mlsTeamMin,
        mlsTeamNsh,
        mlsTeamNe,
        mlsTeamNyc,
        mlsTeamNy,
        mlsTeamOrl,
        mlsTeamPhi,
        mlsTeamPor,
        mlsTeamRsl,
        mlsTeamSd,
        mlsTeamSj,
        mlsTeamSea,
        mlsTeamSkc,
        mlsTeamStl,
        mlsTeamTor,
        mlsTeamVan,
    )
}

internal object MlsTeamRefs {
    val ATL = mlsTeamAtl
    val ATX = mlsTeamAtx
    val MTL = mlsTeamMtl
    val CLT = mlsTeamClt
    val CHI = mlsTeamChi
    val COL = mlsTeamCol
    val CLB = mlsTeamClb
    val DC = mlsTeamDc
    val CIN = mlsTeamCin
    val DAL = mlsTeamDal
    val HOU = mlsTeamHou
    val MIA = mlsTeamMia
    val LA = mlsTeamLa
    val LAFC = mlsTeamLafc
    val MIN = mlsTeamMin
    val NSH = mlsTeamNsh
    val NE = mlsTeamNe
    val NYC = mlsTeamNyc
    val NY = mlsTeamNy
    val ORL = mlsTeamOrl
    val PHI = mlsTeamPhi
    val POR = mlsTeamPor
    val RSL = mlsTeamRsl
    val SD = mlsTeamSd
    val SJ = mlsTeamSj
    val SEA = mlsTeamSea
    val SKC = mlsTeamSkc
    val STL = mlsTeamStl
    val TOR = mlsTeamTor
    val VAN = mlsTeamVan
}
