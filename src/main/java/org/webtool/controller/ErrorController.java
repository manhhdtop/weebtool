package org.webtool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
public class ErrorController {
  @RequestMapping("/404")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String notFound() {
    log.info("(notFound) 404");
    return "error/404";
  }

  @RequestMapping("/error/{slug}")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String error(@PathVariable(value = "slug") String slug) {
    switch (slug) {
      case "500":
        return "error/500";
      case "406":
        return "error/406";
      default:
        return "error/404";
    }
  }

  @RequestMapping("/backend/406")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String notFound1() {
    return "error/406";
  }

  @RequestMapping("/403")
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public String forbidden() {
    return "error/403";
  }

  @RequestMapping("/500")
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String internalServerError() {
    return "error/500";
  }
}
