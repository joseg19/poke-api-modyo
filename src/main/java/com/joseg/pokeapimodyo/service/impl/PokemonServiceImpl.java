package com.joseg.pokeapimodyo.service.impl;

import com.joseg.pokeapimodyo.client.PokeApiExternalClient;
import com.joseg.pokeapimodyo.client.model.*;
import com.joseg.pokeapimodyo.dtos.EvolutionDTO;
import com.joseg.pokeapimodyo.dtos.PokemonDTO;
import com.joseg.pokeapimodyo.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.joseg.pokeapimodyo.util.CrossUtils.extractIdFromUrl;

@Service
@AllArgsConstructor
public class PokemonServiceImpl implements PokemonService {

  private static final String ENGLISH_LANGUAGE = "en";

  private PokeApiExternalClient pokeApiExternalClient;

  @Override
  public PokemonDTO getPokemonByName(final String pokemonName) {
    final PokemonModel pokemonCp = pokeApiExternalClient.getPokemonByName(pokemonName);

    final SpeciesWrapModel speciesWrap = pokeApiExternalClient.getSpeciesByPokemonName(pokemonName);

    final String description = getDescriptionFromSpeciesWrap(speciesWrap);

    final EvolutionDTO evolutionDTO =
        getEvolutionChainById(extractIdFromUrl(speciesWrap.getEvolutionChain().getUrl()));

    return mapPokemonModelToPokemonDTO(pokemonCp, description, evolutionDTO);
  }

  private EvolutionDTO getEvolutionChainById(final Integer evolutionId) {
    final EvolutionModel evolutionModel = pokeApiExternalClient.getEvolutionChainById(evolutionId);
    return mapEvolutionChainModelToEvolutionDTO(evolutionModel.getChain());
  }

  private EvolutionDTO mapEvolutionChainModelToEvolutionDTO(
      final EvolutionChainModel evolutionChainModel) {
    return EvolutionDTO.builder()
        .name(evolutionChainModel.getSpecies().getName())
        .evolvesTo(
            evolutionChainModel.getEvolvesTo().stream()
                .map(this::mapEvolutionChainModelToEvolutionDTO)
                .collect(Collectors.toList()))
        .build();
  }

  private PokemonDTO mapPokemonModelToPokemonDTO(
      final PokemonModel pokemon, final String description, final EvolutionDTO evolutions) {
    return PokemonDTO.builder()
        .id(pokemon.getId())
        .name(pokemon.getName())
        .photoUrl(pokemon.getSprites().getOther().getDreamWorld().getFrontDefault())
        .weight(pokemon.getWeight())
        .description(description)
        .types(
            pokemon.getTypes().stream()
                .map(tw -> tw.getType().getName())
                .collect(Collectors.toList()))
        .abilities(
            pokemon.getAbilities().stream()
                .map(aw -> aw.getAbility().getName())
                .collect(Collectors.toList()))
        .evolutions(evolutions)
        .build();
  }

  private String getDescriptionFromSpeciesWrap(final SpeciesWrapModel speciesWrap) {
    return speciesWrap.getFlavorTextEntries().stream()
        .filter(f -> ENGLISH_LANGUAGE.equalsIgnoreCase(f.getLanguage().getName()))
        .findFirst()
        .orElse(new SpeciesModel("No description available", null, null))
        .getFlavorText();
  }
}
