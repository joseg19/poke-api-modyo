package com.joseg.pokeapimodyo.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Getter
@Setter
public class PokemonListPaginatedModel {

  private int count;
  private String next;
  private String previous;
  private List<PokemonModel> results;
}
