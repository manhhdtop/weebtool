package org.webtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MappingController
{
	@RequestMapping("/")
	public String main(Model model)
	{
		return "index";
	}
	
	@RequestMapping(value = { "/index", "/index.html", "index.jsp" })
	public String index(Model model)
	{
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/bai-viet" })
	public String post(Model model)
	{
		return "post";
	}
	
	@RequestMapping(value = { "/thu-thuat" })
	public String tips(Model model)
	{
		return "tips";
	}
	
	@RequestMapping(value = { "/tool" })
	public String tool(Model model)
	{
		return "tool";
	}
	
	@RequestMapping(value = { "/about" })
	public String about(Model model)
	{
		return "about";
	}
	
	@RequestMapping(value = { "/lien-he" })
	public String contact(Model model)
	{
		return "contact";
	}
	
	@RequestMapping(value = { "/404-page-not-found" })
	public String error404(Model model)
	{
		return "404";
	}
	
	@RequestMapping(value = { "/500-internal-server-error" })
	public String error500(Model model)
	{
		return "500";
	}
	
}
