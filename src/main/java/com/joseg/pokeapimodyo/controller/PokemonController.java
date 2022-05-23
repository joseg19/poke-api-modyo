package com.joseg.pokeapimodyo.controller;

import com.joseg.pokeapimodyo.dtos.PokemonDTO;
import com.joseg.pokeapimodyo.service.PokemonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@Slf4j
public class PokemonController {

  private PokemonService pokemonService;

  @GetMapping("/pokemon/{pokemonName}")
  public PokemonDTO getPokemonByName(
      final HttpServletRequest request, @PathVariable("pokemonName") final String pokemonName) {
    log.info("getPokemonDetailed -> pokemonName: {}", pokemonName);
    return pokemonService.getPokemonByName(pokemonName);
  }
}
