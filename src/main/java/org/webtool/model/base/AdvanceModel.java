package org.webtool.model.base;

import lombok.Data;

import java.util.UUID;

@Data
public class AdvanceModel {
  String id;

  public String getId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
    return id;
  }
}
