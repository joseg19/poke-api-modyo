package com.joseg.pokeapimodyo.exception;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

  private static final String GENERIC_FEIGN_ERROR_MESSAGE = "Generic feign client error";

  @ExceptionHandler(value = {FeignException.class})
  public ResponseEntity<ErrorMessage> handleFeignException(
      final FeignException ex,
      final HttpServletRequest request,
      final HttpServletResponse response) {
    log.error(ex.getMessage());
    String message = "";
    if (ex.responseBody().isPresent()) {
      message = new String(ex.responseBody().get().array(), StandardCharsets.UTF_8);
    }

    return new ResponseEntity<>(
        ErrorMessage.builder()
            .message(message.isEmpty() ? message.concat(GENERIC_FEIGN_ERROR_MESSAGE) : message)
            .build(),
        HttpStatus.valueOf(ex.status()));
  }

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<ErrorMessage> handleGenericException(
      final Exception ex, final HttpServletRequest request, final HttpServletResponse response) {
    log.error(ex.getMessage());
    return new ResponseEntity<>(
        ErrorMessage.builder().message("Internal error").build(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
