/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 6 Nov 2023
*/
package com.management.portal.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		AuthCredentials authCredentials = new AuthCredentials();

		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		UsernamePasswordAuthenticationToken usernamePT = new UsernamePasswordAuthenticationToken(
				authCredentials.getUsername(), authCredentials.getPassword(), Collections.emptyList());

		return getAuthenticationManager().authenticate(usernamePT);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();

		String token = TokenUtils.createToken(userDetailsImpl.getUsername(), userDetailsImpl.getPassword());

		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();
		

		super.successfulAuthentication(request, response, chain, authResult);
	}

}
