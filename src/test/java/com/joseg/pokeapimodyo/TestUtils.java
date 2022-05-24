package com.joseg.pokeapimodyo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public abstract class TestUtils {

  private static final String BASE_TEST_RESOURCES = "src/test/resources/";

  private static final Gson GSON = new Gson();

  private static JsonObject jsonObjectFromJsonFile(final String jsonFileNamePath)
      throws IOException {
    return JsonParser.parseReader(
            new FileReader(BASE_TEST_RESOURCES + jsonFileNamePath, StandardCharsets.UTF_8))
        .getAsJsonObject();
  }

  public static JsonObject getRequestFromJsonFile(final String jsonFilePath) throws IOException {
    final JsonElement jsonRequest = jsonObjectFromJsonFile(jsonFilePath).get("request");
    if (Objects.nonNull(jsonRequest)) {
      return jsonRequest.getAsJsonObject();
    }
    return new JsonObject();
  }

  public static JsonObject getResponseFromJsonFile(final String jsonFilePath) throws IOException {
    final JsonElement jsonRequest = jsonObjectFromJsonFile(jsonFilePath).get("response");
    if (Objects.nonNull(jsonRequest)) {
      return jsonRequest.getAsJsonObject();
    }
    return new JsonObject();
  }

  public static MultiValueMap<String, String> getParams(final JsonObject jsonObject) {
    final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    final JsonElement jsonParams = jsonObject.get("params");
    if (Objects.nonNull(jsonParams)) {
      final Map<?, ?> map = GSON.fromJson(jsonParams, Map.class);
      for (final Map.Entry<?, ?> entry : map.entrySet()) {
        params.add(entry.getKey().toString(), entry.getValue().toString());
      }
    }
    return params;
  }

  public static HttpHeaders getHeaders(final JsonObject jsonObject) {
    final HttpHeaders headers = new HttpHeaders();
    final JsonElement jsonHeaders = jsonObject.get("headers");
    if (Objects.nonNull(jsonHeaders)) {
      final Map<?, ?> map = GSON.fromJson(jsonHeaders, Map.class);
      for (final Map.Entry<?, ?> entry : map.entrySet()) {
        headers.add(entry.getKey().toString(), entry.getValue().toString());
      }
    }
    return headers;
  }

  public static String getBody(final JsonObject jsonObject) {
    final JsonElement jsonBody = jsonObject.get("body");
    if (Objects.nonNull(jsonBody)) {
      try {
        return jsonBody.getAsJsonObject().toString();
      } catch (IllegalStateException ex) {
        return jsonBody.getAsJsonArray().toString();
      }
    }
    return new JsonObject().toString();
  }
}
