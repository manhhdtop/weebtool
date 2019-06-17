package org.webtool.Utils;

public class Constant
{
	// DB constant
	public static final String DB_NAME = "webtool";
	public static final String DB_HOST = "localhost";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	public static final int DB_PORT = 3306;
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public static final String SQL_GET_MENU = "SELECT * FROM `category` WHERE type = 0 OR type = 1 ORDER BY parent_id, id ASC";
	
	public static final String SQL_GET_LIST_CATEGORY = "SELECT * FROM `category` WHERE type = 1 OR type = 2 ORDER BY parent_id, id ASC";
	
	public static final String SQL_GET_CATEGORY = "SELECT * FROM `category` WHERE `slug` = ?";
	
	public static final String SQL_GET_POST = "SELECT * FROM `post` WHERE `slug` = ?";
	
}
