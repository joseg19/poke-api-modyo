package com.joseg.pokeapimodyo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@Getter
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
