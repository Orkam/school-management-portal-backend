/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.portal.DTO.UserDTO;

import com.management.portal.Model.Role;
import com.management.portal.Model.User;

import com.management.portal.Model.UserRole;
import com.management.portal.Repository.RoleRepository;
import com.management.portal.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private final PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(UserDTO userDto) throws Exception {

		User userDb = userRepository.findByUsername(userDto.getUsername());
		Set<UserRole> userRoleSet = new HashSet<>();

		if (userDb != null) {

			throw new Exception("User already exist");

		} else {

			userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

			User user = new User();

			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setSurname(userDto.getSurname());
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			user.setProfile(userDto.getProfile());
			user.setPhone(userDto.getPhone());

			Role role = new Role();
			role.setId(1L);
			role.setName("Normal");

			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);

			userRoleSet.add(userRole);
			user.getUserRols().addAll(userRoleSet);

			for (UserRole userRol : userRoleSet) {
				roleRepository.save(userRol.getRole());

			}

			return userRepository.save(user);
		}
	}

	@Override
	public List<User> getUsers() {

		return userRepository.findAll();
	}

	
	@Override
	public User loadUserByUsername(String username) throws Exception {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new Exception("Invalid Credentials");
		}

		return user;
	}

}
