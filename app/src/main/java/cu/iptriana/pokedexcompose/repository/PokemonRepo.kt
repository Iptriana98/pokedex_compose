package cu.iptriana.pokedexcompose.repository

import cu.iptriana.pokedexcompose.data.remote.response.pokemon_detail.Pokemon
import cu.iptriana.pokedexcompose.data.remote.response.pokemon_list.PokemonList
import cu.iptriana.pokedexcompose.util.Resource

interface PokemonRepo {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>
}