package org.webtool.Utils;

public class Constant {
  // API message
  public static final String LOGIN_SUCCESS = "Đăng nhập thành công.";
  public static final String SUCCESS_MESSAGE = "Success.";
  public static final String ERROR = "Error.";
  public static final String ERROR_USER_NOT_FOUND = "Tên đăng nhập không tồn tại.";
  public static final String ERROR_PASWORD_NOT_MATCH = "Tên đăng nhập và mật khẩu không khớp.";
  public static final String ERROR_NEW_PASWORD_MATCH_OLD_PASS =
      "Mật khẩu mới không được trùng mật khẩu cũ.";
  public static final String ERROR_500 = "Server error.";

  // Api code
  public static final int CODE_BAD_REQUEST = 404;
  public static final int CODE_SUCCESS = 200;
  public static final int CODE_SERVER_ERROR = 500;

  // Some constant
  public static final int FILE_NAME_LENGTH = 255;
  public static final int SALT_LENGTH = 255;
  public static final int TOKEN_RANDOM_LENGTH = 13;
}
