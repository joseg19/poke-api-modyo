package com.joseg.pokeapimodyo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(NON_NULL)
public class EvolutionDTO {
  private String name;
  private List<EvolutionDTO> evolvesTo;
}
