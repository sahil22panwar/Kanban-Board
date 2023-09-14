package com.capstone;

import com.capstone.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean         //return the routobject
	public RouteLocator myRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(p->p.path("/api/v1/**").uri("lb://USER-AUTHENTICATION-SERVICE"))
				.route(p->p.path("/api/v2/**").uri("lb://USER-PROFILE-SERVICE"))
				.route(p->p.path("/api/Notification/**").uri("lb://NOTIFICATION-SERVICE"))
				.route(p->p.path("/api/space/**").uri("lb://TASK-PROFILE-SERVICE"))
				.route(p->p.path("/api/taskService/**").uri("lb://TASK-PROFILE-SERVICE"))
				.build();
	}

	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean filterBean=new FilterRegistrationBean();
		filterBean.setFilter(new JwtFilter());
		filterBean.addUrlPatterns("/protected/*");
		return filterBean;
	}


}