package com.joseg.pokeapimodyo.client.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OtherSpriteModel {

  private DreamWorldSpriteModel dreamWorld;
}
