/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userRol")
public class UserRol {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRolId;
	
	@ManyToOne(fetch= FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Rol rol;
	
	

	

}
