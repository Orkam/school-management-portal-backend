/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Services;

import java.util.List;
import java.util.Set;

import com.management.portal.Model.User;
import com.management.portal.Model.UserRole;

public interface UserServices {

	public void saveUser(User user, Set<UserRole> roles) throws Exception;

	public List<User> getUsers();

}
