package ca.amandeep.playernumber.data

import androidx.compose.ui.graphics.Color

private val mlsTeamAtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Atlanta United FC",
        nameWidthPercent = 67.6f,
        abbreviation = "ATL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF9D2235),
                nameAccent = Color(0xFFAA9767),
            ),
        venue =
            TeamVenue(
                name = "Mercedes-Benz Stadium",
                location =
                    VenueLocation(
                        lat = 33.755278,
                        long = -84.400833,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamAtx by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Austin FC",
        nameWidthPercent = 36.5f,
        abbreviation = "ATX",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF00B140),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Q2 Stadium",
                location =
                    VenueLocation(
                        lat = 30.388206,
                        long = -97.719837,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamMtl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "CF Montr\u00E9al",
        nameWidthPercent = 47.3f,
        abbreviation = "MTL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF003DA6),
                nameAccent = Color(0xFFC1C5C8),
            ),
        venue =
            TeamVenue(
                name = "Stade Saputo",
                location =
                    VenueLocation(
                        lat = 45.563056,
                        long = -73.552500,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamClt by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Charlotte FC",
        nameWidthPercent = 49.0f,
        abbreviation = "CLT",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF0085CA),
                nameAccent = Color(0xFF000000),
            ),
        venue =
            TeamVenue(
                name = "Bank of America Stadium",
                location =
                    VenueLocation(
                        lat = 35.225833,
                        long = -80.852778,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamChi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Chicago Fire FC",
        nameWidthPercent = 60.1f,
        abbreviation = "CHI",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF7CCDEF),
                nameAccent = Color(0xFFFF0000),
            ),
        venue =
            TeamVenue(
                name = "Soldier Field",
                location =
                    VenueLocation(
                        lat = 41.862500,
                        long = -87.616667,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamCol by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Colorado Rapids",
        nameWidthPercent = 63.9f,
        abbreviation = "COL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF8A2432),
                nameAccent = Color(0xFF8AB7E9),
            ),
        venue =
            TeamVenue(
                name = "Dick's Sporting Goods Park",
                location =
                    VenueLocation(
                        lat = 39.805556,
                        long = -104.891944,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamClb by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Columbus Crew",
        nameWidthPercent = 60.5f,
        abbreviation = "CLB",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFFEDD00),
            ),
        venue =
            TeamVenue(
                name = "Lower.com Field",
                location =
                    VenueLocation(
                        lat = 39.968460,
                        long = -83.017090,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamDc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "D.C. United",
        nameWidthPercent = 42.6f,
        abbreviation = "DC",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFD61018),
            ),
        venue =
            TeamVenue(
                name = "Audi Field",
                location =
                    VenueLocation(
                        lat = 38.868504,
                        long = -77.012935,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamCin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "FC Cincinnati",
        nameWidthPercent = 50.7f,
        abbreviation = "CIN",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF003087),
                nameAccent = Color(0xFFFE5000),
            ),
        venue =
            TeamVenue(
                name = "TQL Stadium",
                location =
                    VenueLocation(
                        lat = 39.111389,
                        long = -84.522222,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamDal by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "FC Dallas",
        nameWidthPercent = 35.1f,
        abbreviation = "DAL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFC6093B),
                nameAccent = Color(0xFF001F5B),
            ),
        venue =
            TeamVenue(
                name = "Toyota Stadium Dallas",
                location =
                    VenueLocation(
                        lat = 33.154458,
                        long = -96.835158,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamHou by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Houston Dynamo FC",
        nameWidthPercent = 78.4f,
        abbreviation = "HOU",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFFF6B00),
                nameAccent = Color(0xFF101820),
            ),
        venue =
            TeamVenue(
                name = "Shell Energy Stadium",
                location =
                    VenueLocation(
                        lat = 29.752200,
                        long = -95.352400,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamMia by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Inter Miami CF",
        nameWidthPercent = 55.4f,
        abbreviation = "MIA",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF231F20),
                nameAccent = Color(0xFFF7B5CD),
            ),
        venue =
            TeamVenue(
                name = "Chase Stadium",
                location =
                    VenueLocation(
                        lat = 26.193056,
                        long = -80.161111,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamLa by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "LA Galaxy",
        nameWidthPercent = 38.9f,
        abbreviation = "LA",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF00235D),
                nameAccent = Color(0xFFFFFFFF),
            ),
        venue =
            TeamVenue(
                name = "Dignity Health Sports Park",
                location =
                    VenueLocation(
                        lat = 33.864444,
                        long = -118.261111,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamLafc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "LAFC",
        nameWidthPercent = 20.3f,
        abbreviation = "LAFC",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFFC7A36F),
            ),
        venue =
            TeamVenue(
                name = "BMO Stadium",
                location =
                    VenueLocation(
                        lat = 34.013000,
                        long = -118.285000,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamMin by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Minnesota United FC",
        nameWidthPercent = 79.7f,
        abbreviation = "MIN",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF000000),
                nameAccent = Color(0xFF9BCDE4),
            ),
        venue =
            TeamVenue(
                name = "Allianz Field",
                location =
                    VenueLocation(
                        lat = 44.952800,
                        long = -93.165100,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamNsh by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Nashville SC",
        nameWidthPercent = 47.0f,
        abbreviation = "NSH",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFECE83A),
                nameAccent = Color(0xFF1F1646),
            ),
        venue =
            TeamVenue(
                name = "GEODIS Park",
                location =
                    VenueLocation(
                        lat = 36.130961,
                        long = -86.767693,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamNe by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New England Revolution",
        nameWidthPercent = 92.9f,
        abbreviation = "NE",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF022166),
                nameAccent = Color(0xFFCE0E2D),
            ),
        venue =
            TeamVenue(
                name = "Gillette Stadium",
                location =
                    VenueLocation(
                        lat = 42.090944,
                        long = -71.264344,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamNyc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York City FC",
        nameWidthPercent = 65.9f,
        abbreviation = "NYC",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF9FD2FF),
                nameAccent = Color(0xFF000229),
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
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamNy by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "New York Red Bulls",
        nameWidthPercent = 73.3f,
        abbreviation = "NY",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFBA0C2F),
                nameAccent = Color(0xFFFFC72C),
            ),
        venue =
            TeamVenue(
                name = "Sports Illustrated Stadium",
                location =
                    VenueLocation(
                        lat = 40.736667,
                        long = -74.150278,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamOrl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Orlando City SC",
        nameWidthPercent = 61.1f,
        abbreviation = "ORL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF60269E),
                nameAccent = Color(0xFFF0D283),
            ),
        venue =
            TeamVenue(
                name = "Inter&Co Stadium",
                location =
                    VenueLocation(
                        lat = 28.541065,
                        long = -81.389035,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamPhi by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Philadelphia Union",
        nameWidthPercent = 70.6f,
        abbreviation = "PHI",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF051F31),
                nameAccent = Color(0xFFE0D0A6),
            ),
        venue =
            TeamVenue(
                name = "Subaru Park",
                location =
                    VenueLocation(
                        lat = 39.832222,
                        long = -75.378889,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamPor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Portland Timbers",
        nameWidthPercent = 66.2f,
        abbreviation = "POR",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF2C5234),
                nameAccent = Color(0xFFC99700),
            ),
        venue =
            TeamVenue(
                name = "Providence Park",
                location =
                    VenueLocation(
                        lat = 45.521389,
                        long = -122.691667,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamRsl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Real Salt Lake",
        nameWidthPercent = 53.0f,
        abbreviation = "RSL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFA32035),
                nameAccent = Color(0xFFDAA900),
            ),
        venue =
            TeamVenue(
                name = "America First Field",
                location =
                    VenueLocation(
                        lat = 40.582900,
                        long = -111.893000,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamSd by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Diego FC",
        nameWidthPercent = 50.3f,
        abbreviation = "SD",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF697A7C),
                nameAccent = Color(0xFFF89E1A),
            ),
        venue =
            TeamVenue(
                name = "Snapdragon Stadium",
                location =
                    VenueLocation(
                        lat = 32.784444,
                        long = -117.122833,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamSj by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "San Jose Earthquakes",
        nameWidthPercent = 84.8f,
        abbreviation = "SJ",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF003DA6),
                nameAccent = Color(0xFFFFFFFF),
            ),
        venue =
            TeamVenue(
                name = "PayPal Park",
                location =
                    VenueLocation(
                        lat = 37.351389,
                        long = -121.925000,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamSea by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Seattle Sounders FC",
        nameWidthPercent = 77.7f,
        abbreviation = "SEA",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFF2DC84D),
                nameAccent = Color(0xFF0033A0),
            ),
        venue =
            TeamVenue(
                name = "Lumen Field",
                location =
                    VenueLocation(
                        lat = 47.595278,
                        long = -122.331667,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamSkc by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Sporting Kansas City",
        nameWidthPercent = 80.1f,
        abbreviation = "SKC",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFA7C6ED),
                nameAccent = Color(0xFF0A2240),
            ),
        venue =
            TeamVenue(
                name = "Children's Mercy Park",
                location =
                    VenueLocation(
                        lat = 39.121800,
                        long = -94.823700,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamStl by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "St. Louis CITY SC",
        nameWidthPercent = 63.9f,
        abbreviation = "STL",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFEC1458),
                nameAccent = Color(0xFF001544),
            ),
        venue =
            TeamVenue(
                name = "Energizer Park",
                location =
                    VenueLocation(
                        lat = 38.631052,
                        long = -90.210921,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamTor by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Toronto FC",
        nameWidthPercent = 43.2f,
        abbreviation = "TOR",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFAA182C),
                nameAccent = Color(0xFFA2A9AD),
            ),
        venue =
            TeamVenue(
                name = "BMO Field",
                location =
                    VenueLocation(
                        lat = 43.632778,
                        long = -79.418611,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
    )
}

private val mlsTeamVan by lazy(LazyThreadSafetyMode.NONE) {
    Team(
        name = "Vancouver Whitecaps",
        nameWidthPercent = 85.1f,
        abbreviation = "VAN",
        league = LeagueId.MLS,
        colors =
            TeamColors(
                primary = Color(0xFFFFFFFF),
                nameAccent = Color(0xFF12284C),
            ),
        venue =
            TeamVenue(
                name = "BC Place",
                location =
                    VenueLocation(
                        lat = 49.276667,
                        long = -123.111944,
                    ),
            ),
        roster = emptyList<Player<MlsPosition>>(),
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
