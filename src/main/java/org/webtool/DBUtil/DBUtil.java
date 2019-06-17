package org.webtool.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.webtool.Utils.Constant;
import org.webtool.bean.Category;
import org.webtool.bean.Menu;
import org.webtool.bean.Post;

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
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			m.setSlug(rs.getString("slug"));
			int parentId = rs.getInt("parent_id");
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
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			m.setSlug(rs.getString("slug"));
			m.setDiscription(rs.getString("discription"));
			int parentId = rs.getInt("parent_id");
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
			result.setId(rs.getInt("id"));
			result.setName(rs.getString("name"));
			result.setSlug(rs.getString("slug"));
			result.setDiscription(rs.getString("discription"));
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
			result.setId(rs.getInt("id"));
			result.setTitle(rs.getString("title"));
			result.setDiscription(rs.getString("discription"));
			result.setContent(rs.getString("content"));
			result.setSlug(rs.getString("slug"));
		}
		pstm.close();
		rs.close();
		close();
		return result;
	}
	
}
