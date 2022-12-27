package cu.iptriana.pokedexcompose.ui.composables.pokemon_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PokemonDetailTopSection(navController: NavController, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = modifier.background(
            Brush.verticalGradient(
                listOf(
                    Color.Black, Color.Transparent
                )
            )
        )
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "BackAction",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .displayCutoutPadding()
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .padding(2.dp)
                .clip(CircleShape)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}