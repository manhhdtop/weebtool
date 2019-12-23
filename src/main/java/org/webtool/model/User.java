package org.webtool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.webtool.model.base.ModelWithUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Where(clause = "deleted is null or deleted = 0")
public class User extends ModelWithUpdate {
  @NotNull
  @Column(name = "username")
  private String username;

  @NotNull
  @Column(name = "password")
  private String password;

  @Column(name = "salt")
  private String salt;

  @Column(name = "tmp_password")
  private String tmpPassword;

  @Column(name = "tmp_salt")
  private String tmpSalt;

  @NotNull
  @Column(name = "role")
  private int role;

  @Column(name = "avatar")
  private String avatar;

  public void changePassword(String securePassword, String salt) {
    tmpPassword = password;
    tmpSalt = this.salt;
    password = securePassword;
    this.salt = salt;
  }
}
