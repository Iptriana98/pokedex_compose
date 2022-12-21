package cu.iptriana.pokedexcompose.ui.composables.pokemon_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import cu.iptriana.pokedexcompose.data.model.PokedexListEntry
import cu.iptriana.pokedexcompose.ui.viewmodels.PokemonListViewModel

@Composable
internal fun PokedexEntry(
    entry: PokedexListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel()
){

}