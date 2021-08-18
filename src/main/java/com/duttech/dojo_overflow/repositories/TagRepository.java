package com.duttech.dojo_overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.duttech.dojo_overflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	List<Tag>findAll();
	
	Boolean existsBySubject(String subject);
	
	Optional<Tag> getBySubject(String subject);
	
}
