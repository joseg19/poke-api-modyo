package com.joseg.pokeapimodyo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(NON_NULL)
public class ErrorMessage {
  private String message;
  private Map<String, String> details;
}
