/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 5 Nov 2023
*/
package com.management.portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.portal.DTO.UserDTO;
import com.management.portal.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	@Query("SELECT new com.management.portal.DTO.UserDTO(u.id, u.name, u.surname, u.email, u.phone, u.enable"
			+ " ,r.name as role ) " + "FROM User u " + "JOIN u.userRols ur " + "JOIN ur.role r "
			+ "WHERE 1=1")
	public List<UserDTO> getAllUser();

	@Query("SELECT new com.management.portal.DTO.UserDTO(u.id, u.name, u.surname, u.email, u.phone, u.enable"
			+ " ,r.name as role ) " + "FROM User u " + "JOIN u.userRols ur " + "JOIN ur.role r "
			+ "WHERE r.name = :role")
	public List<UserDTO> getListUserByRole(@Param("role") String role);

	@Query("SELECT new com.management.portal.DTO.UserDTO(u.id, u.name, u.surname, u.email, u.phone, u.enable"
			+ " ,r.name as role ) " + "FROM User u " + "JOIN u.userRols ur " + "JOIN ur.role r "
			+ "WHERE u.name = :name and u.surname = :surname")
	public List<UserDTO> getListUserByName(@Param("name") String name, @Param("surname") String surname);

}
