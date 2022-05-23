package com.joseg.pokeapimodyo.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class PokemonModel {
  private Integer id;
  private String name;
  private String url;
  private Integer weight;
  private List<TypeWrapModel> types;
  private List<AbilityWrapModel> abilities;
  private SpritesModel sprites;
}
