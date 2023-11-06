/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 6 Nov 2023
*/
package com.management.portal.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.management.portal.Model.User;

public class UserDetailsImpl implements UserDetails{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1359631710332125896L;
	private final User user;
	
	

	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}




	public User getUser() {
		return user;
	}

}
