package cu.iptriana.pokedexcompose.data.remote

import cu.iptriana.pokedexcompose.data.remote.response.Pokemon
import cu.iptriana.pokedexcompose.data.remote.response.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokeInfo(
        @Path("name") name: String
    ): Pokemon
}