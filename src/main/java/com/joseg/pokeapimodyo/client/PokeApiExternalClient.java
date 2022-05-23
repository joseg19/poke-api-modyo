package com.joseg.pokeapimodyo.client;

import com.joseg.pokeapimodyo.client.model.EvolutionModel;
import com.joseg.pokeapimodyo.client.model.PokemonModel;
import com.joseg.pokeapimodyo.client.model.SpeciesWrapModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "poke-api-v2", url = "${poke-api.v2.url}")
public interface PokeApiExternalClient {
  @GetMapping("/pokemon/{pokemonName}")
  @Cacheable("pokemon")
  PokemonModel getPokemonByName(@PathVariable("pokemonName") String pokemonName);

  @GetMapping("/pokemon-species/{pokemonName}")
  SpeciesWrapModel getSpeciesByPokemonName(@PathVariable("pokemonName") String pokemonName);

  @GetMapping("/evolution-chain/{evolutionId}")
  EvolutionModel getEvolutionChainById(@PathVariable("evolutionId") Integer evolutionId);
}
