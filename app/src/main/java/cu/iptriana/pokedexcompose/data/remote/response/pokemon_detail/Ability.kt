package cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)