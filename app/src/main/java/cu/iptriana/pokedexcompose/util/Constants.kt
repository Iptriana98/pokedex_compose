package cu.iptriana.pokedexcompose.util

object Constants {
    const val BASE_URL = "https://pokeapi.co/api/v2/"

    //Navigation Screens
    const val POKEMON_LIST_SCREEN = "pokemon_list_screen"
    const val POKEMON_DETAIL_SCREEN = "pokemon_detail_screen"

    //Navigation Arguments
    const val DOMINANT_COLOR = "dominantColor"
    const val POKEMON_NAME = "pokemonName"

    //Navigation Routes
    const val POKEMON_LIST_ROUTE = POKEMON_LIST_SCREEN
    const val POKEMON_DETAIL_ROUTE = "$POKEMON_DETAIL_SCREEN/{$DOMINANT_COLOR}/{$POKEMON_NAME}"
}