package ca.amandeep.playernumber.data

val LeagueCatalog: List<AnyLeague> =
    listOf(
        League(
            id = "NBA",
            displayName = "NBA",
            teams = NbaTeams,
        ),
        League(
            id = "NHL",
            displayName = "NHL",
            teams = NhlTeams,
        ),
        League(
            id = "NFL",
            displayName = "NFL",
            teams = NflTeams,
        ),
        League(
            id = "MLB",
            displayName = "MLB",
            teams = MlbTeams,
        ),
        League(
            id = "MLS",
            displayName = "MLS",
            teams = MlsTeams,
        ),
    )

val AllTeams: List<AnyTeam> = LeagueCatalog.flatMap { it.teams }
