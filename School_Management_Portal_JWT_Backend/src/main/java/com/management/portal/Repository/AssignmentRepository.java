/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Cathegory;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	
	List<Assignment> findByCathegory(Cathegory cathegory);

    List<Assignment> findByActive(Boolean status);

    List<Assignment> findByCathegoryAndActive(Cathegory cathegory,Boolean status);

}
