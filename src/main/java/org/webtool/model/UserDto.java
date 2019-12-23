package org.webtool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.webtool.model.base.ModelWithUpdate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class UserDto extends ModelWithUpdate {
  @NotNull
  @Column(name = "role")
  private String username;

  @NotNull
  @Column(name = "role")
  private int role;

  @Column(name = "avatar")
  private String avatar;
}
