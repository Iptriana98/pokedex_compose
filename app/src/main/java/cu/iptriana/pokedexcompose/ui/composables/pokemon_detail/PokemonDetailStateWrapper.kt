package cu.iptriana.pokedexcompose.ui.composables.pokemon_detail

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail.Pokemon
import cu.iptriana.pokedexcompose.util.Resource

@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo: Resource<Pokemon>,
    modifier: Modifier,
    loadingModifier: Modifier
) {
    when (pokemonInfo) {
        is Resource.Success -> {
            PokemonDetailSection(
                pokemonInfo = pokemonInfo.data!!,
                modifier = modifier
            )
        }

        is Resource.Loading -> {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = loadingModifier
            )
        }

        is Resource.Error -> {
            Text(text = pokemonInfo.message!!, color = Color.Red, modifier = modifier)
        }
    }
}