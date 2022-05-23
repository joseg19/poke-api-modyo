package com.joseg.pokeapimodyo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class CrossUtils {

  public static int extractIdFromUrl(final String url) {
    final StringBuilder sb = new StringBuilder(url);
    sb.delete(sb.lastIndexOf("/"), sb.length());
    final String id = sb.substring(sb.lastIndexOf("/") + 1);
    return Integer.parseInt(id);
  }
}
