package org.webtool.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
  private int code;
  private String method;
  private String message;
  private ResponseData response;
}
