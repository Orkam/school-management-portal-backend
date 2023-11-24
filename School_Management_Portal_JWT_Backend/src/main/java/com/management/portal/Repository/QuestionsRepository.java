/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long>{
	
	Set<Questions>findByAssignments(Assignment assignment);

}
