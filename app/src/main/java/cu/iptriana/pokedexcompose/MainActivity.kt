package cu.iptriana.pokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import cu.iptriana.pokedexcompose.ui.composables.pokemon_list.PokemonListScreen
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
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            PokedexComposeTheme {
                val navController = rememberNavController()
                // Remember a SystemUiController
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()

                DisposableEffect(systemUiController, useDarkIcons) {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.run {
                        setSystemBarsColor(
                            color = Color.Transparent,
                            darkIcons = useDarkIcons
                        )

                        setNavigationBarColor(color = Color.Transparent, darkIcons = useDarkIcons)
                        onDispose {}
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = POKEMON_LIST_SCREEN,
                ) {
                    composable(route = POKEMON_LIST_ROUTE) {
                        PokemonListScreen(navController = navController)
                    }

                    composable(
                        route = POKEMON_DETAIL_ROUTE, arguments = listOf(
                            navArgument(name = DOMINANT_COLOR) {
                                type = NavType.IntType
                            },
                            navArgument(name = POKEMON_NAME) {
                                type = NavType.StringType
                            }
                        )) {
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