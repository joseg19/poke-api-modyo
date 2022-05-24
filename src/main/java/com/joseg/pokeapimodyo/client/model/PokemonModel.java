package com.joseg.pokeapimodyo.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PokemonModel {
  private Integer id;
  private String name;
  private Integer weight;
  private List<TypeWrapModel> types;
  private List<AbilityWrapModel> abilities;
  private SpritesModel sprites;
}
