/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Controller;

import java.security.Principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.portal.DTO.UserDTO;

import com.management.portal.Model.User;

import com.management.portal.Services.UserServices;


@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUserAPI(@RequestBody UserDTO userDTO) throws Exception {

		User user = userServices.saveUser(userDTO);

		return ResponseEntity.ok(user);

	}

	@GetMapping("/allUsers")
	public List<UserDTO> getUsers() {

		return userServices.getUsers();

	}

	@GetMapping("/getByRole/{role}")
	public List<UserDTO> getListUserByRole(@PathVariable String role) {

		return userServices.getListUserByRole(role);

	}

	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) throws Exception {
		return this.userServices.loadUserByUsername(principal.getName());
	}

	@GetMapping("/getByName")
	public List<UserDTO> getListUserByName(@RequestParam(name = "name") String name,
			@RequestParam(name = "surname") String surname) {

		return userServices.getListUserByName(name.trim(), surname.trim());

	}

}
