/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.management.portal.Model.User;

import com.management.portal.Model.UserRole;
import com.management.portal.Repository.RoleRepository;
import com.management.portal.Repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveUser(User user, Set<UserRole> roles) throws Exception {

		User userDb = userRepository.findByUsername(user.getUsername());

		if (userDb != null) {

			throw new Exception("User already exist");

		} else {

			for (UserRole userRol : roles) {
				roleRepository.save(userRol.getRole());

			}

			user.getUserRols().addAll(roles);
			userRepository.save(user);
		}
	}

}
