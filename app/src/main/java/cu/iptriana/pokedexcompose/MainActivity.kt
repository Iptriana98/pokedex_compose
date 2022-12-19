package cu.iptriana.pokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cu.iptriana.pokedexcompose.ui.composable.pokemon_list.PokemonListScreen
import cu.iptriana.pokedexcompose.ui.theme.PokedexComposeTheme
import cu.iptriana.pokedexcompose.util.Constants.DOMINANT_COLOR
import cu.iptriana.pokedexcompose.util.Constants.POKEMON_DETAIL_ROUTE
import cu.iptriana.pokedexcompose.util.Constants.POKEMON_LIST_ROUTE
import cu.iptriana.pokedexcompose.util.Constants.POKEMON_LIST_SCREEN
import cu.iptriana.pokedexcompose.util.Constants.POKEMON_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = POKEMON_LIST_SCREEN){
                    composable(route = POKEMON_LIST_ROUTE){
                        PokemonListScreen(navController = navController)
                    }

                    composable(
                        route = POKEMON_DETAIL_ROUTE, arguments = listOf(
                        navArgument(name = DOMINANT_COLOR){
                            type = NavType.IntType
                        },
                        navArgument(name = POKEMON_NAME){
                            type = NavType.StringType
                        }
                    )){
                        val domainColor = remember {
                            val color = it.arguments?.getInt(DOMINANT_COLOR)
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString(POKEMON_NAME)
                        }
                    }
                }
            }
        }
    }
}