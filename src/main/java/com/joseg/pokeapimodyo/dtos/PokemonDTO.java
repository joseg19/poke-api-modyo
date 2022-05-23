package com.joseg.pokeapimodyo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(NON_NULL)
public class PokemonDTO {
  private Integer id;
  private String name;
  private String photoUrl;
  private List<String> types;
  private Integer weight;
  private String description;
  private List<String> abilities;
  private EvolutionDTO evolutions;
}
