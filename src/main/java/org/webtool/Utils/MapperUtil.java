package org.webtool.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class MapperUtil {
  private static final Logger log = LoggerFactory.getLogger(MapperUtil.class);
  private static MapperUtil ourInstance = new MapperUtil();
  private ModelMapper modelMapper = new ModelMapper();

  private MapperUtil() {
    this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    this.modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
  }

  private static MapperUtil getInstance() {
    return ourInstance;
  }

  public static Map<String, Object> toMap(Object object) {
    return toMap(toJson(object));
  }

  public static Map<String, Object> toMap(String json) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return (Map) mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
    } catch (IOException var3) {
      log.error("(toMap) Ex: ", var3);
      return null;
    }
  }

  public static String toJson(Object object) {
    if (object == null) {
      return null;
    } else {
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

      try {
        return mapper.writeValueAsString(object);
      } catch (IOException var3) {
        log.error("(toJson) Ex: ", var3);
        return object.toString();
      }
    }
  }

  public static ModelMapper getModelMapper() {
    return getInstance().modelMapper;
  }

  public static ObjectMapper getMapper() {
    return (new ObjectMapper()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
