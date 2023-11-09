/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Controller;

import java.net.URI;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.portal.DTO.UserDTO;

import com.management.portal.Model.User;

import com.management.portal.Services.UserServices;
import com.management.portal.security.TokenUtils;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserServices userServices;
	

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUserAPI(@RequestBody UserDTO userDTO) throws Exception {

		userDTO.setToken(TokenUtils.createToken(userDTO.getUsername(), userDTO.getEmail()));

		User user = userServices.saveUser(userDTO);

		return ResponseEntity.created(URI.create("/users" + user.getId())).body(user);

	}


	@GetMapping("/allUsers")
	public List<User> getUsers() {

		return userServices.getUsers();

	}

	@GetMapping("/actual-user")
	public User getCurrentUser(Principal principal) throws Exception {
		return  this.userServices.loadUserByUsername(principal.getName());
	}

}
