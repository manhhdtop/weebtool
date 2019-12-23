package org.webtool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webtool.model.Category;
import org.webtool.model.Post;
import org.webtool.service.CategoryService;
import org.webtool.service.PostService;

import java.util.List;

@Controller
@Slf4j
public class HomeController {
  @Autowired CategoryService categoryService;
  @Autowired PostService postService;

  private List<Category> menus = null;

  public List<Category> getMenu() {
    if (menus == null) {
      menus = categoryService.findMenu();
    }
    return menus;
  }

  @GetMapping(
      value = {"/", "/index", "/index.html", "/index.jsp"})
  public String main(ModelMap model) {
    log.info("main");
    model.addAttribute("title", "ManhHoangIT - WebTool by Takatori!");
    model.addAttribute("menus", getMenu());
    return "layout/index";
  }

  @RequestMapping(value = {"/bai-viet"})
  public String post(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Bài viết!");
    model.addAttribute("menus", getMenu());
    return "layout/post";
  }

  @Value("${spring.mvc.view.prefix}")
  private String prefix;

  @RequestMapping(value = {"{slug}"})
  public String getCategory(ModelMap model, @PathVariable("slug") String slug) {
    Category category = categoryService.findOneByField("slug", slug);
    log.info("(getCategory) category: {}, prefix: {}", category, prefix);
    if (category == null) {
      return "404";
    }

    model.addAttribute("title", "ManhHoangIT - " + category.getName() + "!");
    model.addAttribute("category", category);
    model.addAttribute("menus", getMenu());
    return "layout/category";
  }

  @RequestMapping(value = {"bai-viet/{category}/{slug}"})
  public String getPost(
      ModelMap model,
      @PathVariable("category") String category,
      @PathVariable("slug") String slug) {
    Post post = postService.findOneByField("slug", slug);

    if (post == null) {
      return "404";
    }

    model.addAttribute("title", "ManhHoangIT - " + post.getName() + "!");
    model.addAttribute("category", category);
    model.addAttribute("menus", getMenu());
    return "layout/category";
  }

  @RequestMapping(value = {"/thu-thuat"})
  public String tips(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Thủ thuật!");
    model.addAttribute("menus", getMenu());
    return "layout/tips";
  }

  @RequestMapping(value = {"/tool"})
  public String tools(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Tool tiện ích!");
    model.addAttribute("menus", getMenu());
    return "layout/tool";
  }

  @RequestMapping(value = {"/tool/{slug}"})
  public String tool(ModelMap model, @PathVariable("slug") String slug) {
    model.addAttribute("title", "ManhHoangIT - Tool tiện ích!");
    model.addAttribute("menus", getMenu());
    return "layout/" + slug;
  }

  @RequestMapping(value = {"/about"})
  public String about() {
    return "layout/about";
  }

  @RequestMapping(value = {"/lien-he"})
  public String contact(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Liên hệ!");
    model.addAttribute("menus", getMenu());
    return "layout/contact";
  }
}
