package com.joseg.pokeapimodyo.client.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SpeciesWrapModel {
  private List<SpeciesModel> flavorTextEntries;
  private EvolutionChainModel evolutionChain;
}
