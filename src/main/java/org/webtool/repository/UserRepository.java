package org.webtool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.webtool.model.User;
import org.webtool.repository.base.CustomRepository;

@Repository
public interface UserRepository extends CustomRepository<User, String> {
  @Query(
      "UPDATE User u SET u.password=:password, u.salt = :salt, u.tmpPassword=:tmpPassword, u.tmpSalt=:tmpSalt WHERE u.id=:id")
  void changePassword(
      @Param("id") String id,
      @Param("password") String password,
      @Param("salt") String salt,
      @Param("tmpPassword") String tmpPassword,
      @Param("tmpSalt") String tmpSalt);

  @Query(
      "UPDATE User u SET u.password=:password, u.salt = :salt, u.tmpPassword='', u.tmpSalt='' WHERE u.id=:id")
  void updatePassword(
      @Param("id") String id, @Param("password") String password, @Param("salt") String salt);
}
