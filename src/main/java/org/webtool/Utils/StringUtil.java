package org.webtool.Utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.SPACE;

@Slf4j
public class StringUtil {

  public static String standardizedUrl(String url) {
    url = url.replaceAll("/+", "/");
    if (url.endsWith("/")) {
      url = url.substring(0, url.length() - 1);
    }
    return url;
  }

  public static String join(String... inputList) {
    return Arrays.stream(inputList)
        .filter(StringUtils::isNotBlank)
        .collect(Collectors.joining(SPACE));
  }

  public static String removeSpecialCharacter(String input) {
    if (input != null) {
      return input.replaceAll("[^a-zA-Z0-9@_.]+", "");
    }
    return null;
  }

  public static String replaceDuplicateSpaces(String str) {
    return str.trim().replaceAll("\\s+", " ");
  }

  public static String toRaw(List<String> ids) {
    if (ids == null || ids.isEmpty()) {
      return "";
    }
    StringBuilder output = new StringBuilder();
    for (String id : ids) {
      output.append("'").append(id).append("',");
    }
    return output.substring(0, output.length() - 1);
  }
}
