package org.webtool.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webtool.cryptography.Encrypt;
import org.webtool.model.User;
import org.webtool.repository.base.CustomRepository;
import org.webtool.repository.UserRepository;
import org.webtool.service.UserService;

@Service
@Slf4j
class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
  @Autowired UserRepository repository;

  @Override
  CustomRepository<User, String> getRepository() {
    return repository;
  }

  @Override
  public Integer updatePassword(User user) {
    User old = findOneByField("username", user.getUsername());
    if (old == null) {
      return 0;
    } else {
      String salt = Encrypt.getSalt();
      String securePassword = Encrypt.generateSecurePassword(user.getPassword(), salt);
      if (old.getPassword().equals(user.getPassword())) {
        return -1;
      }
      repository.updatePassword(old.getId(), securePassword, salt);
    }
    return 1;
  }

  @Override
  public void changePassword(User user) {
    repository.changePassword(
        user.getId(), user.getPassword(), user.getSalt(), user.getTmpPassword(), user.getTmpSalt());
  }
}
