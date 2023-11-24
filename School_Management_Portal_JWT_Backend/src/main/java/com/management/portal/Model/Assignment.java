/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="assigments")
public class Assignment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentID;

    private String title;
    private String description;
    private String maxPoints;
    private String numQuestions;
    private boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cathegory cathegory;

    @OneToMany(mappedBy = "assignments",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Questions> questions = new HashSet<>();
    
    
    

	public Assignment() {
		super();
	}

	public Assignment(Long assignmentID, String title, String description, String maxPoints, String numQuestions,
			boolean active, Cathegory cathegory, Set<Questions> questions) {
		super();
		this.assignmentID = assignmentID;
		this.title = title;
		this.description = description;
		this.maxPoints = maxPoints;
		this.numQuestions = numQuestions;
		this.active = active;
		this.cathegory = cathegory;
		this.questions = questions;
	}

	public Long getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(Long assignmentID) {
		this.assignmentID = assignmentID;
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

	public String getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(String maxPoints) {
		this.maxPoints = maxPoints;
	}

	public String getNumQuestions() {
		return numQuestions;
	}

	public void setNumQuestions(String numQuestions) {
		this.numQuestions = numQuestions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Cathegory getCathegory() {
		return cathegory;
	}

	public void setCathegory(Cathegory cathegory) {
		this.cathegory = cathegory;
	}

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
    
    

}
