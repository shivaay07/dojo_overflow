package com.duttech.dojo_overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duttech.dojo_overflow.models.Tag;
import com.duttech.dojo_overflow.repositories.TagRepository;

@Service
public class TagService {

	private final TagRepository tagRepo;
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
//	@Autowired
//	private QuestionRepository questionRepo;
	
//	To retrieve list of all answers
	
	public List<Tag> alltags(){
		return tagRepo.findAll();
	}
	
//	To create new question
	
	public Tag newTag(Tag tag) {
		return tagRepo.save(tag);
	}

	
//	find answer by id
	
	public Tag aTag(Long id) {
		Optional<Tag> optionTag = tagRepo.findById(id);
		if(optionTag.isPresent()) {
			return optionTag.get();
		}else {
			return null;
		}
	}
	
//	update answer
	
	public Tag updateTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
//	Delete answer
	
	public void deleteTag(Long id) {
		Optional<Tag> delTag = tagRepo.findById(id);
		if(delTag.isPresent()) {
			tagRepo.deleteById(id);
		}
	}
	
	public Boolean isPresent(String tag) {
		return tagRepo.existsBySubject(tag);
	}
	
	public Tag findTag(String subject) {
		Optional<Tag> questionTag = tagRepo.getBySubject(subject);
		if(questionTag.isPresent()) {
			return questionTag.get();
		}else {
			return null;
		}
	}
}
