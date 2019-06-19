package org.webtool.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.webtool.Utils.Constant;
import org.webtool.bean.Category;
import org.webtool.bean.Menu;
import org.webtool.bean.Post;
import org.webtool.bean.User;

public class DBUtil extends ConnectionUtils
{
	private static String sql = "";
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	public static ArrayList<Menu> getMenu()
	        throws ClassNotFoundException, SQLException, NullPointerException
	{
		open();
		ArrayList<Menu> result = new ArrayList<>();
		sql = Constant.SQL_GET_MENU;
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next())
		{
			Menu m = new Menu();
			m.setId(rs.getInt(Constant.COL_ID));
			m.setName(rs.getString(Constant.COL_NAME));
			m.setSlug(rs.getString(Constant.COL_SLUG));
			int parentId = rs.getInt(Constant.COL_CATEGORY_PARENT_ID);
			if (parentId == 0)
			{
				result.add(m);
			}
			else
			{
				for (Menu menu : result)
				{
					if (parentId == menu.getId())
					{
						menu.getChild().add(m);
					}
				}
			}
		}
		
		pstm.close();
		rs.close();
		close();
		return result;
	}
	
	public static ArrayList<Category> getListCategory()
	        throws ClassNotFoundException, SQLException, NullPointerException
	{
		open();
		ArrayList<Category> result = new ArrayList<>();
		sql = Constant.SQL_GET_CATEGORY;
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next())
		{
			Category m = new Category();
			m.setId(rs.getInt(Constant.COL_ID));
			m.setName(rs.getString(Constant.COL_NAME));
			m.setSlug(rs.getString(Constant.COL_SLUG));
			m.setDiscription(rs.getString(Constant.COL_CATEGORY_DISCRIPTION));
			int parentId = rs.getInt(Constant.COL_CATEGORY_PARENT_ID);
			if (parentId == 0)
			{
				result.add(m);
			}
			else
			{
				for (Category menu : result)
				{
					if (parentId == menu.getId())
					{
						menu.getChild().add(m);
					}
				}
			}
		}
		pstm.close();
		rs.close();
		close();
		return result;
	}
	
	public static Category getCategory(String slug)
	        throws ClassNotFoundException, SQLException, NullPointerException
	{
		open();
		Category result = null;
		sql = Constant.SQL_GET_CATEGORY;
		pstm = c.prepareStatement(sql);
		pstm.setString(1, slug);
		rs = pstm.executeQuery();
		
		while (rs.next())
		{
			result = new Category();
			result.setId(rs.getInt(Constant.COL_ID));
			result.setName(rs.getString(Constant.COL_NAME));
			result.setSlug(rs.getString(Constant.COL_SLUG));
			result.setDiscription(rs.getString(Constant.COL_CATEGORY_DISCRIPTION));
		}
		pstm.close();
		rs.close();
		close();
		return result;
	}
	
	public static Post getPost(String slug)
	        throws ClassNotFoundException, SQLException, NullPointerException
	{
		open();
		Post result = null;
		sql = Constant.SQL_GET_POST;
		pstm = c.prepareStatement(sql);
		pstm.setString(1, slug);
		rs = pstm.executeQuery();
		
		while (rs.next())
		{
			result = new Post();
			result.setId(rs.getInt(Constant.COL_ID));
			result.setTitle(rs.getString(Constant.COL_POST_TITLE));
			result.setDiscription(Constant.COL_POST_DISCRIPTION);
			result.setContent(rs.getString(Constant.COL_POST_CONTENT));
			result.setSlug(rs.getString(Constant.COL_SLUG));
		}
		pstm.close();
		rs.close();
		close();
		return result;
	}
	
	public static User getUser(String username)
	        throws ClassNotFoundException, SQLException, NullPointerException
	{
		open();
		User result = null;
		sql = Constant.SQL_GET_USER;
		pstm = c.prepareStatement(sql);
		pstm.setString(1, username);
		rs = pstm.executeQuery();
		
		if (rs.next())
		{
			result = new User();
			result.setUsername(rs.getString(Constant.COL_USERNAME));
			result.setName(rs.getString(Constant.COL_NAME));
			result.setPassword(rs.getString(Constant.COL_PASSWORD));
			result.setSalt(rs.getString(Constant.COL_SALT));
			result.setAvatar(rs.getString(Constant.COL_AVATAR));
			result.setTmpPassword(rs.getString(Constant.COL_TMP_PASSWORD));
			result.setTmpSalt(rs.getString(Constant.COL_TMP_SALT));
			result.setRole(rs.getInt(Constant.COL_ROLE));
		}
		pstm.close();
		rs.close();
		close();
		return result;
	}
	
	public static void updatePassword(String username, String password, String salt)
	        throws ClassNotFoundException, SQLException, NullPointerException
	{
		open();
		sql = Constant.SQL_UPDATE_PASSWORD;
		pstm = c.prepareStatement(sql);
		pstm.setString(1, password);
		pstm.setString(2, salt);
		pstm.setString(3, username);
		pstm.executeUpdate();
		pstm.close();
		close();
	}
	
}
