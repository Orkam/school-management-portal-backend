/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Services;

import java.util.List;
import java.util.Set;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Cathegory;

public interface AssignmentServices {

	Assignment addAssignment(Assignment assignment);

	Assignment updateAssigment(Assignment assignment);

	Set<Assignment> getAllAssigments();

	Assignment getAssignment(Long assignmentID);

	void deleteAssigment(Long assignmentID);

	List<Assignment> listAssignmentOneCathegory(Cathegory cathegory);

	List<Assignment> getActiveAssigments();

	List<Assignment> getActiveAssignmentOneCathegory(Cathegory cathegory);
}
