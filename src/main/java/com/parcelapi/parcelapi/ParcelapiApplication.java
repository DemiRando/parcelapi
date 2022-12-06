package com.parcelapi.parcelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import com.parcelapi.parcelapi.filters.AuthFilter;


@SpringBootApplication
public class ParcelapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcelapiApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/process/*");
		return registrationBean;
	}
}
