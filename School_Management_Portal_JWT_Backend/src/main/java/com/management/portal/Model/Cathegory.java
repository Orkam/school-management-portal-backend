/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cathegories")
public class Cathegory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cathegoryID;

	private String title;

	private String description;

	@OneToMany(mappedBy = "cathegory", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Assignment> assigments = new LinkedHashSet<>();

	public Cathegory() {
		super();
	}

	

	public Cathegory(Long cathegoryID, String title, String description, Set<Assignment> assigments) {
		super();
		this.cathegoryID = cathegoryID;
		this.title = title;
		this.description = description;
		this.assigments = assigments;
	}



	public Long getCathegoryID() {
		return cathegoryID;
	}

	public void setCathegoryID(Long cathegoryID) {
		this.cathegoryID = cathegoryID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Set<Assignment> getAssigments() {
		return assigments;
	}



	public void setAssigments(Set<Assignment> assigments) {
		this.assigments = assigments;
	}

	

}
