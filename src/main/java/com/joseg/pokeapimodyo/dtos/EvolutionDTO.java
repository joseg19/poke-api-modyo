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
public class EvolutionDTO {
  private String name;
  private List<EvolutionDTO> evolvesTo;
}
