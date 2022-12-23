package com.jwt.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jwt.web.util.jwtProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class interceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("getHeader= "+request.getHeader("Authorization"));
		// 헤더에서 가져온 토큰 유효성 검사
		String token = request.getHeader("Authorization");

		System.out.println(jwtProvider.validateToken(token));
		
		// 로그인 유지 코드 작성

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
