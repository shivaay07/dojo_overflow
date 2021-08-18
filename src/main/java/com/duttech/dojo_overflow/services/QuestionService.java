package com.duttech.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duttech.dojo_overflow.models.Question;
import com.duttech.dojo_overflow.repositories.AnswerRepository;
import com.duttech.dojo_overflow.repositories.QuestionRepository;
import com.duttech.dojo_overflow.repositories.TagRepository;

@Service
public class QuestionService {
	
	private final QuestionRepository questionRepo;
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
//	@Autowired
//	private QuestionRepository questionRepo;
	
//	To retrieve list of all questions
	
	public List<Question> allQuestions(){
		return questionRepo.findAll();
	}
	
//	To create new question
	
	public Question newQuestion(Question question) {
		return questionRepo.save(question);
	}
	
//	find question by id
	
	public Question aQuestion(Long id) {
		Optional<Question> optionQuestion = questionRepo.findById(id);
		if(optionQuestion.isPresent()) {
			return optionQuestion.get();
		}else {
			return null;
		}
	}
	
//	update question
	
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}
	
//	Delete Question
	
	public void deleteQuestion(Long id) {
		Optional<Question> delQuestion = questionRepo.findById(id);
		if(delQuestion.isPresent()) {
			questionRepo.deleteById(id);
		}
	}

}
