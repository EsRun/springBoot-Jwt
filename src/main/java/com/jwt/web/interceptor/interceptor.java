package com.jwt.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.web.util.jwtProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class interceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("getHeader= " + request.getHeader("Authorization"));
		// 헤더에서 가져온 토큰 유효성 검사
		String token = request.getHeader("Authorization");
		if (token != null) {
			System.out.println("토큰 보유");
			return jwtProvider.validateToken(token);
		} else {
			System.out.println("토큰 없어");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
