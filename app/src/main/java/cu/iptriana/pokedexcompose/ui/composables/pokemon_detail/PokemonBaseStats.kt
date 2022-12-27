package cu.iptriana.pokedexcompose.ui.composables.pokemon_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail.Pokemon
import cu.iptriana.pokedexcompose.util.parseStatToAbbr
import cu.iptriana.pokedexcompose.util.parseStatToColor

@Composable
fun PokemonBaseStats(
    pokemonInfo: Pokemon,
    animDelayPerItem: Int = 100
) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        Text(text = "Base Stats: ", fontSize = 20.sp, color = MaterialTheme.colors.onSurface)
        Spacer(modifier = Modifier.height(4.dp))
        for (i in pokemonInfo.stats.indices){
            val stat = pokemonInfo.stats[i]
            PokemonStat(
                statName = parseStatToAbbr(stat),
                statValue = stat.base_stat,
                statColor = parseStatToColor(stat),
                animDelay = i * animDelayPerItem
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}