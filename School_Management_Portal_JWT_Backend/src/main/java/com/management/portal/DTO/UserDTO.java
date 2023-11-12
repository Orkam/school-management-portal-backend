/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 7 Nov 2023
*/
package com.management.portal.DTO;

import java.util.HashSet;
import java.util.Set;

import com.management.portal.Model.UserRole;

public class UserDTO {
	
	
	private Long id;	
	private String username;
	private String password;	
	private String name;	
	private String surname;	
	private String email;	
	private String phone;	
	private boolean enable = true;
	private String profile;
	private String token;
	private String role;
	private Set<UserRole> userRols = new HashSet<>();
	
	
	
	public UserDTO(Long id, String name, String surname, String email, String phone, boolean enable, String role) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.enable = enable;
		this.role = role;
	}

	public UserDTO(Long id, String username, String password, String name, String surname, String email, String phone,
			boolean enable, String profile, String token, String role, Set<UserRole> userRols) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.enable = enable;
		this.profile = profile;
		this.token = token;
		this.role = role;
		this.userRols = userRols;
	}

	public UserDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Set<UserRole> getUserRols() {
		return userRols;
	}
	public void setUserRols(Set<UserRole> userRols) {
		this.userRols = userRols;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	
	
}
