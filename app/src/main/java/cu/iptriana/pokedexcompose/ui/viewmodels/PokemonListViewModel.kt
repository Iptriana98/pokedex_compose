package cu.iptriana.pokedexcompose.ui.viewmodels

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import cu.iptriana.pokedexcompose.data.model.PokedexListEntry
import cu.iptriana.pokedexcompose.repository.PokemonRepo
import cu.iptriana.pokedexcompose.util.Constants.PAGE_SIZE
import cu.iptriana.pokedexcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepo
) : ViewModel() {

    private var currentPage = 0
    var pokemonList = mutableStateOf<List<PokedexListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    init {
        loadPokemon()
    }

    fun loadPokemon() = viewModelScope.launch {
        isLoading.value = true
        when (val response = repository.getPokemonList(PAGE_SIZE, currentPage * PAGE_SIZE)) {
            is Resource.Success -> {
                endReached.value = currentPage * PAGE_SIZE >= response.data!!.count
                val pokedexListEntry = response.data.results.mapIndexed { _, entry ->
                    val number = if (entry.url.endsWith("/"))
                        entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                    else
                        entry.url.takeLastWhile { it.isDigit() }

                    val url =
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"

                    PokedexListEntry(
                        pokemonName = entry.name.capitalize(Locale.current),
                        imageUrl = url,
                        number = number.toInt()
                    )
                }
                currentPage++
                loadError.value = ""
                isLoading.value = false
                pokemonList.value += pokedexListEntry
            }
            is Resource.Error -> {
                loadError.value = response.message!!
                isLoading.value = false
            }
        }
    }

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate {
            it?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}