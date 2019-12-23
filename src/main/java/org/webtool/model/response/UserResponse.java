package org.webtool.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.webtool.model.User;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public class UserResponse extends ResponseData<User> {
  private String token;
}
