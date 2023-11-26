/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 24 Nov 2023
*/
package com.management.portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Cathegory;
import com.management.portal.Services.AssignmentServices;

@RestController
@RequestMapping("/assignment")
@CrossOrigin("http://localhost:4200")
public class AssignmentController {

	@Autowired
	private AssignmentServices assignmentServices;

	@PostMapping("/")
	public ResponseEntity<Assignment> saveAssignment(@RequestBody Assignment assignment) {
		return ResponseEntity.ok(assignmentServices.addAssignment(assignment));
	}

	@PutMapping("/")
	public ResponseEntity<Assignment> updateAssignmet(@RequestBody Assignment assignment) {
		return ResponseEntity.ok(assignmentServices.updateAssigment(assignment));
	}

	@GetMapping("/")
	public ResponseEntity<?> listAssignments() {
		return ResponseEntity.ok(assignmentServices.getAllAssigments());
	}

	@GetMapping("/{assignmentID}")
	public Assignment listOneAssignment(@PathVariable("assignmentID") Long assignmentID) {
		return assignmentServices.getAssignment(assignmentID);
	}

	@DeleteMapping("/{assignmentID}")
	public void deleteAssigment(@PathVariable("assignmentID") Long assignmentID) {
		assignmentServices.deleteAssigment(assignmentID);
	}

	@GetMapping("/cathegory/{cathegoryID}")
	public List<Assignment> listAssignmentOneCathegory(@PathVariable("cathegoryID") Long cathegoryID) {
		Cathegory cathegory = new Cathegory();
		cathegory.setCathegoryID(cathegoryID);
		return assignmentServices.listAssignmentOneCathegory(cathegory);
	}

	@GetMapping("/active")
	public List<Assignment> ListAssignmentActive() {
		return assignmentServices.getActiveAssigments();
	}

	@GetMapping("/cathegory/active/{cathegoryID}")
	public List<Assignment> listActiveAssignmentOneCathegory(@PathVariable("cathegoryID") Long cathegoryID) {
		Cathegory cathegory = new Cathegory();
		cathegory.setCathegoryID(cathegoryID);
		return assignmentServices.getActiveAssignmentOneCathegory(cathegory);
	}

}
