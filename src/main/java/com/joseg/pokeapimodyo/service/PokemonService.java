package com.joseg.pokeapimodyo.service;

import com.joseg.pokeapimodyo.dtos.PokemonDTO;

public interface PokemonService {

  PokemonDTO getPokemonByName(String pokemonName);
}
