package com.duttech.dojo_overflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duttech.dojo_overflow.models.Answer;
import com.duttech.dojo_overflow.models.Question;
import com.duttech.dojo_overflow.models.Tag;
import com.duttech.dojo_overflow.services.AnswerService;
import com.duttech.dojo_overflow.services.QuestionService;
import com.duttech.dojo_overflow.services.TagService;


@Controller
public class MainController {
	private final QuestionService queServe;
	private final AnswerService ansServe;
	private final TagService tagServe;
	
	public MainController(QuestionService queServe, AnswerService ansServe, TagService tagServe) {
		this.queServe=queServe;
		this.ansServe=ansServe;
		this.tagServe=tagServe;
	}
	
//	create a new question
	
	@GetMapping("/questions/new")
	public String newQuestion() {
		return "questions/show.jsp";
	}
	
	@PostMapping(path="/questions/new")
	public String createQuestion(@RequestParam("questionAtt") String questionAtt, @RequestParam("tagAtt")  String tagAtt) {
		Question taggedQuestion = new Question();
		taggedQuestion.setQuestion(questionAtt);
		Question grabbedQuestion = queServe.newQuestion(taggedQuestion);
		
		List<String> myTag = new ArrayList<String>(Arrays.asList(tagAtt.split(",")));
		List<Tag> x = new ArrayList<Tag>();
		for(String Tagger: myTag) {
			if(tagServe.isPresent(Tagger)){
				Tag foundTag = tagServe.findTag(Tagger);
				x.add(foundTag);
			}else {
				Tag newObjTag = new Tag(Tagger);
				Tag passTag= tagServe.newTag(newObjTag);
				x.add(passTag);
			}
		}
		grabbedQuestion.setTags(x);
		queServe.updateQuestion(grabbedQuestion);
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		 List<Question> showQuestions = queServe.allQuestions();
		 model.addAttribute("showQuestions", showQuestions);
		 return "questions/index.jsp";
	}
	
	@GetMapping("/questions/{id}")
	public String getById(@PathVariable ("id") Long id, Model model) {
		Question questionWithId = queServe.aQuestion(id);
		model.addAttribute("questionWithId", questionWithId);
		return "questions/showId.jsp";
	}
	@PostMapping(path="/questions/{id}")
	public String createAnswer(Model model, 
							   @RequestParam("answer") String answer,
							   @PathVariable("id")Long id) {
		
		
			Answer a = new Answer();
			a.setAnswer(answer);
			Question thisQuestion= queServe.aQuestion(id);
			a.setQuestion(thisQuestion);
			Answer foundAnswer = ansServe.newAnswer(a);
			model.addAttribute("foundAnswer", foundAnswer);
			return "redirect:/questions/"+id;
			 
			
			
		}
}

