package org.webtool.Utils;

public class Constant
{
	// API message
	public static final String LOGIN_SUCCESS = "Đăng nhập thành công.";
	public static final String ERROR_USER_NOT_FOUND = "Username không tồn tại.";
	public static final String ERROR_PASWORD_NOT_MATCH = "Username và password không khớp.";
	public static final String ERROR_500 = "Server error.";
	
	// Some constant
	public static final int FILE_NAME_LENGTH = 255;
	public static final int TOKEN_RANDOM_LENGTH = 13;
	
	// DB constant
	public static final String DB_NAME = "webtool";
	public static final String DB_HOST = "localhost";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	public static final int DB_PORT = 3306;
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public static final String TABLE_USER = "user";
	public static final String TABLE_CATEGORY = "category";
	public static final String TABLE_TAG = "tag";
	public static final String TABLE_POST = "post";
	public static final String TABLE_TAG_POST = "tag_post";
	
	public static final String COL_USERNAME = "username";
	public static final String COL_NAME = "name";
	public static final String COL_AVATAR = "avatar";
	public static final String COL_PASSWORD = "password";
	public static final String COL_SALT = "salt";
	public static final String COL_TMP_PASSWORD = "tmp_password";
	public static final String COL_TMP_SALT = "tmp_salt";
	public static final String COL_ROLE = "role";
	
	public static final String COL_ID = "id";
	public static final String COL_SLUG = "slug";
	public static final String COL_CREATED = "created";
	public static final String COL_UPDATED = "updated";
	
	public static final String COL_CATEGORY_PARENT_ID = "parent_id";
	public static final String COL_CATEGORY_TYPE = "type";
	public static final String COL_CATEGORY_DISCRIPTION = "discription";
	
	public static final String COL_POST_CATEGORY = "category";
	public static final String COL_POST_TITLE = "title";
	public static final String COL_POST_CONTENT = "content";
	public static final String COL_POST_DISCRIPTION = "discription";
	
	public static final String COL_TAG_ID = "tag_id";
	public static final String COL_POST_ID = "post_id";
	
	public static final String SQL_GET_MENU = "SELECT * FROM `" + TABLE_CATEGORY + "` WHERE "
	        + COL_CATEGORY_TYPE + " = 0 OR " + COL_CATEGORY_TYPE + " = 1 ORDER BY "
	        + COL_CATEGORY_PARENT_ID + ", " + COL_ID + " ASC";
	public static final String SQL_ADD_MENU = "INSERT INTO `" + TABLE_CATEGORY + "`(`"
	        + COL_CATEGORY_PARENT_ID + "`, `" + COL_NAME + "`, `" + COL_SLUG + "`, `"
	        + COL_CATEGORY_DISCRIPTION + "`, `" + COL_CATEGORY_TYPE + "`, `" + COL_CREATED + "`, `"
	        + COL_UPDATED + "`) VALUES (?,?,?,?,?,?,?)";
	public static final String SQL_UPDATE_MENU = "UPDATE `" + TABLE_CATEGORY + "` SET `"
	        + COL_CATEGORY_PARENT_ID + "` = ?, `" + COL_NAME + "` = ?, `" + COL_SLUG + "` = ?, `"
	        + COL_CATEGORY_DISCRIPTION + "` = ?, `" + COL_CATEGORY_TYPE + "` = ?, `" + COL_CREATED
	        + "` = ?, `" + COL_UPDATED + "` = ?";
	public static final String SQL_DELETE_MENU = "DELETE FROM `" + TABLE_CATEGORY + "`" + COL_ID
	        + "` = ?";
	
	public static final String SQL_GET_LIST_CATEGORY = "SELECT * FROM `" + TABLE_CATEGORY
	        + "` WHERE " + COL_CATEGORY_TYPE + " = 1 OR " + COL_CATEGORY_TYPE + " = 2 ORDER BY "
	        + COL_CATEGORY_PARENT_ID + ", " + COL_ID + " ASC";
	
	public static final String SQL_GET_CATEGORY = "SELECT * FROM `" + TABLE_CATEGORY + "` WHERE `"
	        + COL_SLUG + "` = ?";
	
	public static final String SQL_GET_POST = "SELECT * FROM `" + TABLE_POST + "` WHERE `"
	        + COL_SLUG + "` = ?";
	
	public static final String SQL_GET_LIST_USER = "SELECT * FROM `" + TABLE_USER + "`";
	public static final String SQL_GET_USER = "SELECT * FROM `" + TABLE_USER + "` WHERE `"
	        + COL_USERNAME + "` = ?";
	public static final String SQL_UPDATE_USER = "UPDATE `" + TABLE_USER + "` SET `" + COL_USERNAME
	        + "` = ?, `" + COL_NAME + "` = ?, `" + COL_AVATAR + "` = ? WHERE `" + COL_USERNAME
	        + "` = ?";
	public static final String SQL_UPDATE_PASSWORD = "UPDATE `" + TABLE_USER + "` SET "
	        + COL_PASSWORD + " = ?, " + COL_SALT + " = ?, " + COL_TMP_PASSWORD + " = '', "
	        + COL_TMP_SALT + " = '' WHERE `" + COL_USERNAME + "` = ?";
	public static final String SQL_RESET_PASSWORD = "UPDATE `" + TABLE_USER + "` SET "
	        + COL_TMP_PASSWORD + " = ?, " + COL_TMP_SALT + " = ? WHERE `" + COL_USERNAME + "` = ?";
	public static final String SQL_UPDATE_ROLE = "UPDATE `" + TABLE_USER + "` SET " + COL_ROLE
	        + " = ? WHERE `" + COL_USERNAME + "` = ?";
	public static final String SQL_ADD_USER = "INSERT INTO `" + TABLE_USER + "`(`" + COL_USERNAME
	        + "`, `" + COL_NAME + "`, `" + COL_AVATAR + "`, `" + COL_PASSWORD + "`, `" + COL_SALT
	        + "`, `" + COL_ROLE + "`) VALUES (?,?,?,?,?,?)";
	public static final String SQL_DELETE_USER = "DELETE FROM `" + TABLE_USER + "` WHERE `"
	        + COL_USERNAME + "` = ?";
}
