/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Services;

import java.util.Set;

import com.management.portal.Model.Assignment;
import com.management.portal.Model.Questions;

public interface QuestionsServices {

	Questions addQuestion(Questions question);

	Questions updateQuestion(Questions question);

	Set<Questions> getAllQuestions();

	Questions getQuestion(Long question);

	Set<Questions> getAssigmentQuestions(Assignment assigment);

	void deleteQuetion(Long questionID);

	Questions getQuestionByID(Long questionID);

}
