package org.webtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webtool.model.response.ApiResponse;

@Controller
public class BackendController {
  @RequestMapping(value = {"backend"})
  public String main(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Admin side!");
    return "backend/main";
  }

  @RequestMapping(value = {"login", "backend/login"})
  public String login(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Login to ADmin side!");
    return "backend/login";
  }

  @PostMapping(value = {"do-login", "backend/do-login"})
  @ResponseBody
  public ApiResponse doLogin(
      @RequestParam("username") String username, @RequestParam("password") String password) {
    return UserController.login(username, password);
  }

  @PostMapping(value = {"do-logout", "backend/do-logout"})
  @ResponseBody
  public Boolean doLogout(@RequestParam("token") String token) {
    UserController.logout(token);
    return true;
  }

  @RequestMapping(value = {"backend/index", "backend/index.html", "backend/index.jsp"})
  public String index() {
    return "redirect:/backend/main";
  }

  @RequestMapping(value = {"backend/404-page-not-found"})
  public String error404(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Trang không tồn tại!");
    return "backend/404";
  }

  @RequestMapping(value = {"backend/500-internal-server-error"})
  public String error500(ModelMap model) {
    model.addAttribute("title", "ManhHoangIT - Server error!");
    return "backend/500";
  }
}
