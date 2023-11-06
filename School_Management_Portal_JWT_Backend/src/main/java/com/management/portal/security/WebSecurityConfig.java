/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfig {

	private final UserDetailsService userDetailsService;
	private final JwtAuthorizationFilter jwtAuthorizationFilter;

	public WebSecurityConfig(UserDetailsService userDetailsService, JwtAuthorizationFilter jwtAuthorizationFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");

		return http

				.csrf(csrf -> csrf.disable())
				.cors().configurationSource(corsConfigurationSource()).and()
				
				.authorizeRequests()
				.requestMatchers(HttpMethod.OPTIONS).permitAll()
				
				.anyRequest().authenticated().and()
				
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class).build();

	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.applyPermitDefaultValues(); 
	    source.registerCorsConfiguration("/**", config);
	    return source;
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {

		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder()).and().build();
	}
	
	

}
