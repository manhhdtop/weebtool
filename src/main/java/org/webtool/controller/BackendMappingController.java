package org.webtool.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webtool.bean.Menu;
import org.webtool.bean.UserResponse;

@Controller
public class BackendMappingController
{
	ArrayList<Menu> menus = null;
	
	@RequestMapping(value = { "backend" })
	public String main(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Admin side!");
		return "backend/main";
	}
	
	@RequestMapping(value = { "login", "backend/login" })
	public String login(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Login to ADmin side!");
		return "backend/login";
	}
	
	@PostMapping(value = { "do-login", "backend/do-login" })
	@ResponseBody
	public UserResponse doLogin(@RequestParam("username") String username,
	        @RequestParam("password") String password)
	{
		UserResponse response = new UserResponse();
		
		if (username.isEmpty() || password.isEmpty())
		{
			System.out.println("Error: " + username);
			
			response.setValidate(false);
		}
		else
		{
			System.out.println("Username: " + username);
			response.setValidate(true);
		}
		return response;
	}
	
	@RequestMapping(value = { "backend/index", "backend/index.html", "backend/index.jsp" })
	public String index(ModelMap model)
	{
		return "redirect:/backend/main";
	}
	
	@RequestMapping(value = { "backend/404-page-not-found" })
	public String error404(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Trang không tồn tại!");
		return "backend/404";
	}
	
	@RequestMapping(value = { "backend/500-internal-server-error" })
	public String error500(ModelMap model)
	{
		model.addAttribute("title", "ManhHoangIT - Server error!");
		return "backend/500";
	}
	
}
