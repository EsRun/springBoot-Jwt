package com.jwt.web.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class jwtProvider {
	private static final String JWT_SECRET = "secretKey";
	
	private static final int JWT_EXPIRATION_MS = 604800000;
	
	// 토근 생성
	public static String generateToken(String userId) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);		
		
		return Jwts.builder()
				.setSubject("title")
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.claim("userId", "admin")
				.claim("userName", "ㅇㅇㅇ")
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
	}

	// 토근에서 아이디 추출
	public static String getUserIdFromJwt(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(JWT_SECRET)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
	// 토근 유효성 검사
	public static boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
			System.out.println("유효한 토큰");
			return true;
		}
		catch (SignatureException e){
			System.out.println("Invalid JWT signature"+ e);
		}
		catch(MalformedJwtException e) {
			System.out.println("Invalid JWT token"+e);
		}
		catch(ExpiredJwtException e) {
			System.out.println("Expired JWT token"+e);
		}
		catch(UnsupportedJwtException e) {
			System.out.println("Unsupported JWT token"+e);
		}
		catch(IllegalArgumentException e) {
			System.out.println("JWT claims string is empty"+e);
		}
		return false;
	}
}