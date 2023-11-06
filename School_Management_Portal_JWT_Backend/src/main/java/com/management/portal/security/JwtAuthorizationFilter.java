/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 6 Nov 2023
*/
package com.management.portal.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthorizationFilter  extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String bearerToken = request.getHeader("Authorization");
		
		if(bearerToken!=null && bearerToken.startsWith("Bearer")) {
			
			String token = bearerToken.replace("Bearer", "");
			UsernamePasswordAuthenticationToken usernamePT = TokenUtils.getAuthenticationToken(token);
			SecurityContextHolder.getContext().setAuthentication(usernamePT);
		}
		
		filterChain.doFilter(request, response);
		
	}

}
