/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Cathegory;
import com.management.portal.Repository.AssignmentRepository;

@Service
public class AssignmentServicesImpl implements AssignmentServices {

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Override
	public Assignment addAssignment(Assignment assignment) {

		return assignmentRepository.save(assignment);
	}

	@Override
	public Assignment updateAssigment(Assignment assignment) {

		return assignmentRepository.save(assignment);
	}

	@Override
	public Set<Assignment> getAllAssigments() {

		return new LinkedHashSet<>(assignmentRepository.findAll());
	}

	@Override
	public Assignment getAssignment(Long examenId) {

		return assignmentRepository.findById(examenId).get();
	}

	@Override
	public void deleteAssigment(Long assignmentId) {

		Assignment assignment = new Assignment();

		assignment.setAssignmentID(assignmentId);

		assignmentRepository.delete(assignment);

	}

	@Override
	public List<Assignment> listAssignmentOneCathegory(Cathegory cathegory) {

		return assignmentRepository.findByCathegory(cathegory);
	}

	@Override
	public List<Assignment> getActiveAssigments() {

		return assignmentRepository.findByActive(true);
	}

	@Override
	public List<Assignment> getActiveAssignmentOneCathegory(Cathegory cathegory) {

		return assignmentRepository.findByCathegoryAndActive(cathegory,true);
	}

}
