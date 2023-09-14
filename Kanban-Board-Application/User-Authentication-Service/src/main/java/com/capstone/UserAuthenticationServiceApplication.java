package com.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationServiceApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean jwtFilter(){
//		FilterRegistrationBean filterBean=new FilterRegistrationBean();
//		filterBean.setFilter(new JwtFilter());
//		filterBean.addUrlPatterns("/protected/*");
//		return filterBean;
//	}


}