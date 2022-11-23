package com.api.rest.ciber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CiberLunaBackEnd2Application {

	public static void main(String[] args) {
		SpringApplication.run(CiberLunaBackEnd2Application.class, args);
	}
	
	@Bean //A bean to allow connection from unknown points
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
}
