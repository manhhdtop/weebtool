package org.webtool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
		registry.addResourceHandler("/css/**").addResourceLocations("/resource/css/")
		        .setCachePeriod(31556926);
		registry.addResourceHandler("/font/**").addResourceLocations("/resource/font/")
		        .setCachePeriod(31556926);
		registry.addResourceHandler("/icon/**").addResourceLocations("/resource/icon/")
		        .setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/resource/img/")
		        .setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/resource/js/")
		        .setCachePeriod(31556926);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
}