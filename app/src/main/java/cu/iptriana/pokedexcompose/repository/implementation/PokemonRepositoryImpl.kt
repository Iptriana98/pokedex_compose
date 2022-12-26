package cu.iptriana.pokedexcompose.repository.implementation

import android.util.Log
import cu.iptriana.pokedexcompose.data.remote.PokeApi
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail.Pokemon
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_list.PokemonList
import cu.iptriana.pokedexcompose.repository.PokemonRepo
import cu.iptriana.pokedexcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
internal class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi
) : PokemonRepo{

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception){
            return Resource.Error(message = "An error ocurred.")
        }
        Log.i("PokemonList", "getPokemonList: $response")
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokeInfo(name = pokemonName)
        }catch (e: Error) {
            return Resource.Error(message = "An error ocurred.")
        }
        return Resource.Success(response)
    }
}