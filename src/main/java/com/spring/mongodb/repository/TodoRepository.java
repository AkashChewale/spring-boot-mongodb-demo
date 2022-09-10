package com.spring.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongodb.model.TodoDto;

@Repository
public interface TodoRepository extends MongoRepository<TodoDto, String> {

	@Query("{'todo': ?0}")
	Optional<TodoDto> findByTodo(String todo);
}
