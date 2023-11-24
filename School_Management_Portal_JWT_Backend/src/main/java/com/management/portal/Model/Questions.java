/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="questions")
public class Questions {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;

    @Column(length = 5000)
    private String content;

    private String img;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Transient
    private String userAnswer;

    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Assignment assignments;
    
    
    

	public Questions() {
		super();
	}



	public Questions(Long questionID, String content, String img, String option1, String option2, String option3,
			String option4, String userAnswer, String answer, Assignment assignments) {
		super();
		this.questionID = questionID;
		this.content = content;
		this.img = img;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.userAnswer = userAnswer;
		this.answer = answer;
		this.assignments = assignments;
	}



	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public Assignment getAssignments() {
		return assignments;
	}



	public void setAssignments(Assignment assignments) {
		this.assignments = assignments;
	}

	    
    

}
