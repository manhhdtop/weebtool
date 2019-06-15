package org.webtool.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.webtool.Utils.Constant;

public class ConnectionUtils
{
	public static Connection c;
	
	public static void open() throws ClassNotFoundException, SQLException
	{
		String hostName = Constant.DB_HOST;
		String dbName = Constant.DB_NAME;
		String username = Constant.DB_USERNAME;
		String password = Constant.DB_PASSWORD;
		int port = Constant.DB_PORT;
		String option = "?characterEncoding=UTF-8&serverTimezone=Europe/Paris";
		
		Class.forName(Constant.JDBC_DRIVER);
		String connectionURL = "jdbc:mysql://" + hostName + ":" + port + "/" + dbName + option;
		c = DriverManager.getConnection(connectionURL, username, password);
	}
	
	public static void close()
	{
		try
		{
			c.close();
		}
		catch (Exception e)
		{
			System.out.println("Không thể ngắt kết nối cơ sở dữ liệu");
		}
	}
	
	public static void rollbackQuietly(Connection conn)
	{
		try
		{
			conn.rollback();
		}
		catch (Exception e)
		{
		}
	}
}
