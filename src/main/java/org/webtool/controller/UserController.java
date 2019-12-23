package org.webtool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webtool.Utils.Constant;
import org.webtool.cryptography.Encrypt;
import org.webtool.jwt.JwtToken;
import org.webtool.model.User;
import org.webtool.model.response.ApiResponse;
import org.webtool.model.response.UserResponse;
import org.webtool.service.UserService;

@Component
@Slf4j
public class UserController {
  @Autowired private static UserService userService;

  public static boolean logout(String token) {
    JwtToken.removeToken(token);
    return true;
  }

  public static ApiResponse login(String username, String password) {
    ApiResponse response = new ApiResponse();
    response.setMethod("Login");
    User user = userService.findOneByField("username", username);
    if (user == null) {
      response.setCode(Constant.CODE_BAD_REQUEST);
      response.setMessage(Constant.ERROR_USER_NOT_FOUND);
    } else {
      if (user.getTmpPassword().equals("")) {
        if (Encrypt.verifyPassword(password, user.getPassword(), user.getSalt())) {
          UserResponse userResponse = new UserResponse();
          userResponse.setToken(JwtToken.createJWT(username));
          response.setResponse(userResponse);
          response.setCode(Constant.CODE_SUCCESS);
          response.setMessage(Constant.LOGIN_SUCCESS);
        } else {
          response.setCode(Constant.CODE_BAD_REQUEST);
          response.setMessage(Constant.ERROR_PASWORD_NOT_MATCH);
        }
      } else {
        if (Encrypt.verifyPassword(password, user.getPassword(), user.getSalt())) {
          userService.updatePassword(user);
          UserResponse userResponse = new UserResponse();
          userResponse.setToken(JwtToken.createJWT(username));
          response.setResponse(userResponse);
          response.setCode(Constant.CODE_SUCCESS);
          response.setMessage(Constant.LOGIN_SUCCESS);
        } else {
          if (Encrypt.verifyPassword(password, user.getTmpPassword(), user.getTmpSalt())) {
            userService.updatePassword(user);
            UserResponse userResponse = new UserResponse();
            userResponse.setToken(JwtToken.createJWT(username));
            response.setResponse(userResponse);
            response.setCode(Constant.CODE_SUCCESS);
            response.setMessage(Constant.LOGIN_SUCCESS);
          } else {
            response.setCode(Constant.CODE_BAD_REQUEST);
            response.setMessage(Constant.ERROR_PASWORD_NOT_MATCH);
          }
        }
      }
    }
    return response;
  }

  public static ApiResponse changePassword(User user) {
    ApiResponse response = new ApiResponse();
    User old = userService.findOneByField("username", user.getUsername());
    if (old == null) {
      response.setCode(Constant.CODE_BAD_REQUEST);
      response.setMessage(Constant.ERROR_USER_NOT_FOUND);
    } else {
      String salt = Encrypt.getSalt();
      String securePassword = Encrypt.generateSecurePassword(user.getPassword(), salt);
      if (old.getPassword().equals(user.getPassword())) {
        response.setCode(Constant.CODE_BAD_REQUEST);
        response.setMessage(Constant.ERROR_NEW_PASWORD_MATCH_OLD_PASS);
      } else {
        user.setId(old.getId());
        user.changePassword(securePassword, salt);
        userService.changePassword(user);
        response.setCode(Constant.CODE_SUCCESS);
        response.setMessage(Constant.SUCCESS_MESSAGE);
      }
    }
    return response;
  }
}
