package com.joseg.pokeapimodyo.service.impl;

import com.joseg.pokeapimodyo.client.PokeApiExternalClient;
import com.joseg.pokeapimodyo.client.model.PokemonModel;
import com.joseg.pokeapimodyo.dtos.PokemonDTO;
import com.joseg.pokeapimodyo.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PokemonServiceImpl implements PokemonService {

  private PokeApiExternalClient pokeApiExternalClient;

  @Override
  public PokemonDTO getPokemonByName(final String pokemonName) {
    final PokemonModel pokemon = pokeApiExternalClient.getPokemonByName(pokemonName);
    return mapPokemonModelToPokemonDTO(pokemon);
  }

  private PokemonDTO mapPokemonModelToPokemonDTO(final PokemonModel pokemon) {
    return PokemonDTO.builder()
        .id(pokemon.getId())
        .name(pokemon.getName())
        .photoUrl(pokemon.getSprites().getOther().getDreamWorld().getFrontDefault())
        .weight(pokemon.getWeight())
        .types(
            pokemon.getTypes().stream()
                .map(tw -> tw.getType().getName())
                .collect(Collectors.toList()))
        .abilities(
            pokemon.getAbilities().stream()
                .map(aw -> aw.getAbility().getName())
                .collect(Collectors.toList()))
        .build();
  }
}
