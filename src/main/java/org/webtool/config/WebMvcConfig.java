package org.webtool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
	// Cấu hình để sử dụng các file nguồn tĩnh (html, image, ..)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/")
		        .setCachePeriod(31556926);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	@Bean
	public PathMatcher pathMatcher()
	{
		return new CaseInsensitivePathMatcher();
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer)
	{
		AntPathMatcher matcher = new AntPathMatcher();
		matcher.setCaseSensitive(false);
		configurer.setPathMatcher(matcher);
	}
}