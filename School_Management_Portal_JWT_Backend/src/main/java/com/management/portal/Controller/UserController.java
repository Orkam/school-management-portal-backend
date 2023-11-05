/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.portal.Model.User;
import com.management.portal.Model.UserRole;
import com.management.portal.Services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User user) {
		
		Set<UserRole>userRole = new HashSet<>();

		userServices.saveUser(user);

	}

}