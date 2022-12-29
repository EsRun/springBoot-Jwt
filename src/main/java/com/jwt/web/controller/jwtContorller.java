package com.jwt.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.web.util.jwtProvider;

@RestController
public class jwtContorller {
	
	@GetMapping("/auth")
	public String Auth(@RequestParam String userId) {
		System.out.println("Auth Controller");
		if(userId.equals("admin")) {
			String token = jwtProvider.generateToken(userId);
			return token;
		}
		return "admin 써라!";
	}
	
	@GetMapping("/main")
	public String main() {
		System.out.println("main");
		return "유효한 토큰 ㅇㅈ";
	}
	
	@GetMapping("/join")
	public String Join() {
		return "회원가입";
	}
}