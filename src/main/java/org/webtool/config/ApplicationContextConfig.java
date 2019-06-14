package org.webtool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.webtool.*")
public class ApplicationContextConfig extends WebMvcConfigurationSupport
{
	@Bean
	public PathMatcher pathMatcher()
	{
		return new CaseInsensitivePathMatcher();
	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping()
	{
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setOrder(0);
		handlerMapping.setInterceptors(getInterceptors());
		handlerMapping.setPathMatcher(pathMatcher());
		return handlerMapping;
	}
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}