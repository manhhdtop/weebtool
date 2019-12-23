package org.webtool.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.webtool.repository.base.CustomRepositoryImpl;

import javax.annotation.PostConstruct;

@ComponentScan({"org.webtool.service"})
@Configuration
@EnableJpaRepositories(
    basePackages = "org.webtool.repository",
    repositoryBaseClass = CustomRepositoryImpl.class)
@EntityScan("org.webtool.model")
@Slf4j
public class JpaConfiguration {
  @PostConstruct
  public void postConstruct() {
    log.info("(init) JpaConfiguration");
  }
}
