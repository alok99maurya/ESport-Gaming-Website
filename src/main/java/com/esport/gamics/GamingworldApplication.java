package com.esport.gamics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class GamingworldApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GamingworldApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GamingworldApplication.class);
	}
	@Bean
	public CommonsMultipartResolver commonMultipartResolver() {
		final CommonsMultipartResolver cmpr=new CommonsMultipartResolver();
		cmpr.setMaxUploadSize(-1);
		return cmpr;
	}
}
