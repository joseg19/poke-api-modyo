package com.joseg.pokeapimodyo.integration;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.joseg.pokeapimodyo.config.WireMockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {WireMockConfig.class})
public abstract class BaseTest {

  @Autowired protected MockMvc mockMvc;
  @Autowired protected WireMockServer wireMockServer;
}
