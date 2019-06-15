package org.webtool.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil extends ConnectionUtils
{
	private static String sql = "";
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
//	public static void addUser(User u) throws ClassNotFoundException, SQLException, NullPointerException
//	{
//		open();
//		sql = Constant.SQL_ADD_USER;
//		pstm = c.prepareStatement(sql);
//		pstm.setString(1, u.getUsername());
//		pstm.setString(2, u.getPassword());
//		pstm.setString(3, u.getSalt());
//		pstm.setInt(4, u.getRole());
//		pstm.executeUpdate();
//		close();
//	}
//	
}
