package com.jwt.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new interceptor())
		.addPathPatterns("/**");// 적용할 url, 모든 url에 적용
		//.excludePathPatterns(null);//제외할 url
	}
}
