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
@Table(name = "Roles")
public class Rol {

	@Id
	private Long id;
	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	private Set<UserRole> userRoles = new HashSet<>();
}