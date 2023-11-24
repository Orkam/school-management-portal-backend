/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Controller;



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

import com.management.portal.Model.Cathegory;
import com.management.portal.Services.CathegoryServices;

@RestController
@RequestMapping("/cathegory")
@CrossOrigin("http://localhost:4200")
public class CathegoryController {

	@Autowired
	private CathegoryServices cathegoryServices;

	@PostMapping("/")
	public ResponseEntity<Cathegory> saveCathegory(@RequestBody Cathegory cathegory) {
		Cathegory cathegorySaved = cathegoryServices.addCathegory(cathegory);
		return ResponseEntity.ok(cathegorySaved);
	}

	@GetMapping("/{cathegoryID}")
	public Cathegory listCathegoryByID(@PathVariable("cathegoryID") Long cathegoryID) {
		return cathegoryServices.getCathegory(cathegoryID);
	}

	@GetMapping("/")
	public ResponseEntity<?> listAllCathegories() {
		return ResponseEntity.ok(cathegoryServices.getCathegories());
	}

	@PutMapping("/")
	public Cathegory updateCathegory(@RequestBody Cathegory cathegory) {
		return cathegoryServices.updateCathegory(cathegory);
	}

	@DeleteMapping("/{cathegoryID}")
	public void deleteCathegory(@PathVariable("cathegoryID") Long cathegoryID) {
		cathegoryServices.deleteCathegory(cathegoryID);
	}

}
