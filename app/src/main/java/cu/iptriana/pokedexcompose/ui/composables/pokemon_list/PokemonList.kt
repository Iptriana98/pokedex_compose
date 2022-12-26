package cu.iptriana.pokedexcompose.ui.composables.pokemon_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import cu.iptriana.pokedexcompose.ui.viewmodels.PokemonListViewModel

@Composable
internal fun PokemonList(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemonList by remember { viewModel.pokemonList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = if (pokemonList.size % 2 == 0)
            pokemonList.size / 2
        else
            pokemonList.size / 2 + 1

        items(itemCount) {
            if (it >= itemCount - 1 && !endReached) viewModel.loadPokemon()
            PokedexRow(rowIndex = it, entries = pokemonList, navController = navController)
        }
    }
}