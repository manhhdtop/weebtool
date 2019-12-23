package org.webtool.service;

import org.webtool.model.User;

public interface UserService extends BaseService<User> {
  Integer updatePassword(User user);

  void changePassword(User user);
}
