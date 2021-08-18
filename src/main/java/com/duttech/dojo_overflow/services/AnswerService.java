package com.duttech.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duttech.dojo_overflow.models.Answer;
import com.duttech.dojo_overflow.models.Question;
import com.duttech.dojo_overflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	private final AnswerRepository answerRepo;
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	
//	@Autowired
//	private QuestionRepository questionRepo;
	
//	To retrieve list of all answers
	
	public List<Answer> allanswers(){
		return answerRepo.findAll();
	}
	
//	To create new question
	
	public Answer newAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
//	find answer by id
	
	public Answer anAnswer(Long id) {
		Optional<Answer> optionAnswer = answerRepo.findById(id);
		if(optionAnswer.isPresent()) {
			return optionAnswer.get();
		}else {
			return null;
		}
	}
	
//	update answer
	
	public Answer updateAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
//	Delete answer
	
	public void deleteAnswer(Long id) {
		Optional<Answer> delAnswer = answerRepo.findById(id);
		if(delAnswer.isPresent()) {
			answerRepo.deleteById(id);
		}
	}
}
