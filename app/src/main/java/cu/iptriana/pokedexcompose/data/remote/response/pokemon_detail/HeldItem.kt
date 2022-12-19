package cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)