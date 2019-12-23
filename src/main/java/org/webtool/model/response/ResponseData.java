package org.webtool.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseData<T> {
  private T obj;
  private List<T> objs;
}
