package cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)