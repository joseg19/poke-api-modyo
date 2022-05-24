package com.joseg.pokeapimodyo.integration;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.joseg.pokeapimodyo.TestUtils.getBody;
import static com.joseg.pokeapimodyo.TestUtils.getResponseFromJsonFile;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PokemonTest extends BaseTest {

  private static final String POKE_API_URI = "/pokemon/";
  private static final String BASE_FILE_PATH = "contracts/";

  @Test
  void shouldReturnSuccessWhenPokeApiExternalSuccess() throws Exception {

    final String USE_CASE_FILE_PATH = BASE_FILE_PATH.concat("success_raichu.json");
    final JsonObject jsonResponse = getResponseFromJsonFile(USE_CASE_FILE_PATH);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(POKE_API_URI.concat("raichu"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(getBody(jsonResponse)))
        .andExpect(status().isOk());
  }

  @Test
  void shouldReturnErrorWhenPokeApiExternalError() throws Exception {

    final String USE_CASE_FILE_PATH = BASE_FILE_PATH.concat("error_bulbasaur.json");
    final JsonObject jsonResponse = getResponseFromJsonFile(USE_CASE_FILE_PATH);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(POKE_API_URI.concat("bulbasaur"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(getBody(jsonResponse)))
        .andExpect(status().is5xxServerError());
  }

  @Test
  void shouldReturnErrorWhenPokeApiExternalNotFoundPokemon() throws Exception {

    final String USE_CASE_FILE_PATH = BASE_FILE_PATH.concat("error_not_found.json");
    final JsonObject jsonResponse = getResponseFromJsonFile(USE_CASE_FILE_PATH);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(POKE_API_URI.concat("not_found"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(getBody(jsonResponse)))
        .andExpect(status().is4xxClientError());
  }

  @Test
  void shouldReturnErrorWhenPokeApiExternalReturnErrorNoBody() throws Exception {

    final String USE_CASE_FILE_PATH = BASE_FILE_PATH.concat("error_feign_generic.json");
    final JsonObject jsonResponse = getResponseFromJsonFile(USE_CASE_FILE_PATH);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(POKE_API_URI.concat("charizard"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(getBody(jsonResponse)))
        .andExpect(status().is5xxServerError());
  }
}
