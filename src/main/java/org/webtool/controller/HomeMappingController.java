package org.webtool.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webtool.DBUtil.DBUtil;
import org.webtool.bean.Category;
import org.webtool.bean.Menu;
import org.webtool.bean.Post;

@Controller
public class HomeMappingController
{
	ArrayList<Menu> menus = null;
	
	public ArrayList<Menu> getMenu()
	{
		if (menus == null)
		{
			menus = new ArrayList<>();
			try
			{
				menus = DBUtil.getMenu();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (NullPointerException e)
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return menus;
	}
	
	@RequestMapping(value = { "/" })
	public String main(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Webtool by Takatori!");
		model.addAttribute("menus", getMenu());
		return "layout/index";
	}
	
	@RequestMapping(value = { "/index", "/index.html", "index.jsp" })
	public String index(ModelMap model)
	{
		return "redirect:layout/";
	}
	
	@RequestMapping(value = { "/bai-viet" })
	public String post(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Bài viết!");
		model.addAttribute("menus", getMenu());
		return "layout/post";
	}
	
	@RequestMapping(value = { "{slug}" })
	public String category(ModelMap model, @PathVariable("slug") String slug)
	{
		Category category = null;
		try
		{
			category = DBUtil.getCategory(slug);
		}
		catch (ClassNotFoundException | NullPointerException | SQLException e)
		{
			e.printStackTrace();
		}
		
		if (category == null)
		{
			return "404";
		}
		
		model.addAttribute("title", "ManhHoangIT - " + category.getName() + "!");
		model.addAttribute("category", category);
		model.addAttribute("menus", getMenu());
		return "layout/category";
	}
	
	@RequestMapping(value = { "bai-viet/{slug}" })
	public String getPost(ModelMap model, @PathVariable("category") String category,
	        @PathVariable("slug") String slug)
	{
		Post post = null;
		try
		{
			post = DBUtil.getPost(slug);
		}
		catch (ClassNotFoundException | NullPointerException | SQLException e)
		{
			e.printStackTrace();
		}
		
		if (category == null)
		{
			return "404";
		}
		
		model.addAttribute("title", "ManhHoangIT - " + post.getTitle() + "!");
		model.addAttribute("category", category);
		model.addAttribute("menus", getMenu());
		return "layout/category";
	}
	
	@RequestMapping(value = { "/thu-thuat" })
	public String tips(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Thủ thuật!");
		model.addAttribute("menus", getMenu());
		return "layout/tips";
	}
	
	@RequestMapping(value = { "/tool" })
	public String tools(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Tool tiện ích!");
		model.addAttribute("menus", getMenu());
		return "layout/tool";
	}
	
	@RequestMapping(value = { "/tool/{slug}" })
	public String tool(ModelMap model, @PathVariable("slug") String slug)
	{
		model.addAttribute("title", "ManhHoangIT - Tool tiện ích!");
		model.addAttribute("menus", getMenu());
		return "layout/" + slug;
	}
	
	@RequestMapping(value = { "/about" })
	public String about(ModelMap model)
	{
		return "layout/about";
	}
	
	@RequestMapping(value = { "/lien-he" })
	public String contact(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Liên hệ!");
		model.addAttribute("menus", getMenu());
		return "layout/contact";
	}
	
	@RequestMapping(value = { "/404-page-not-found" })
	public String error404(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Trang không tồn tại!");
		model.addAttribute("menus", getMenu());
		return "layout/404";
	}
	
	@RequestMapping(value = { "/500-internal-server-error" })
	public String error500(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Server error!");
		model.addAttribute("menus", getMenu());
		return "layout/500";
	}
	
}
