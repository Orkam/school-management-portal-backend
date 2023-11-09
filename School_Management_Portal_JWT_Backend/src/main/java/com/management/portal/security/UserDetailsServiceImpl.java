/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 6 Nov 2023
*/
package com.management.portal.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.portal.Model.Authority;
import com.management.portal.Model.User;
import com.management.portal.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userDb = userRepository.findByUsername(username);

		if (userDb == null) {

			throw new UsernameNotFoundException("User not found " + username);
		}

		Set<Authority> autorities = new HashSet<>();
		userDb.getUserRols().forEach(usuarioRol -> {
			autorities.add(new Authority(usuarioRol.getRole().getName()));
		});

		return (UserDetails) userDb;
	}

}
