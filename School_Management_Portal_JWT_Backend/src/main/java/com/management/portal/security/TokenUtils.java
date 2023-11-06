/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


public class TokenUtils {

	private final static String ACCESS_TOKEN_SECRET = "$2a$12$1r44JsX.4ho9sEj1hUKpcOBWHIH3BEEd4q/.qv8PIIJClVrRZLQHe";

	public static String createToken(String username, String email) {

		Map<String, Object> extra = new HashMap<>();

		extra.put("email", email);

		return Jwts.builder()

				.setSubject(username).addClaims(extra).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).compact();
	}

	public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

		try {
			Claims claims = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).build()
					.parseClaimsJws(token).getBody();

			String username = claims.getSubject();

			return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
		} catch (JwtException e) {

			return null;
		}

	}

}
