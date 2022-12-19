package cu.iptriana.pokedexcompose.data.remote

import cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail.Pokemon
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_list.PokemonList
import cu.iptriana.pokedexcompose.util.ApiRoutes.POKEMON
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET(POKEMON)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("$POKEMON/{name}")
    suspend fun getPokeInfo(
        @Path("name") name: String
    ): Pokemon
}