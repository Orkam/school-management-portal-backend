/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.portal.Model.User;
import com.management.portal.Repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);

	}

}
