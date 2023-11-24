/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Questions;
import com.management.portal.Repository.QuestionsRepository;

@Service
public class QuestionsServicesImpl implements QuestionsServices {

	@Autowired
	private QuestionsRepository questionsRepository;

	@Override
	public Questions addQuestion(Questions question) {

		return questionsRepository.save(question);
	}

	@Override
	public Questions updateQuestion(Questions question) {

		return questionsRepository.save(question);
	}

	@Override
	public Set<Questions> getAllQuestions() {

		return new HashSet<>(questionsRepository.findAll());
	}

	@Override
	public Questions getQuestion(Long question) {

		return questionsRepository.findById(question).get();
	}

	@Override
	public Set<Questions> getAssigmentQuestions(Assignment assigments) {

		return questionsRepository.findByAssignments(assigments);
	}

	@Override
	public void deleteQuetion(Long questionID) {

		Questions questions = new Questions();
		questions.setQuestionID(questionID);
		questionsRepository.delete(questions);

	}

	@Override
	public Questions getQuestionByID(Long questionID) {

		return questionsRepository.getOne(questionID);  
	}

}
