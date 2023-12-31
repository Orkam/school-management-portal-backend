/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 6 Nov 2023
*/
package com.management.portal.security;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.portal.Model.User;

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

		User userDetailsImpl = (User) authResult.getPrincipal();

		String token = TokenUtils.createToken(userDetailsImpl);

		response.addHeader("Authorization", "Bearer " + token);
		Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
   
        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
		response.getWriter().flush();
		

		super.successfulAuthentication(request, response, chain, authResult);
	}

}
