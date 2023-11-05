/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private boolean enable = true;
	@Column
	private String profile;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRols = new HashSet<>();

}
