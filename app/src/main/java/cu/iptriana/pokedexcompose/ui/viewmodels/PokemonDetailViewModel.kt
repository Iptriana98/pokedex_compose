package cu.iptriana.pokedexcompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail.Pokemon
import cu.iptriana.pokedexcompose.repository.PokemonRepo
import cu.iptriana.pokedexcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repo: PokemonRepo
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> =
        repo.getPokemonInfo(pokemonName)
}