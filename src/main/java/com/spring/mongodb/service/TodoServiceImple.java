package com.spring.mongodb.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongodb.exception.TodoCollectionException;
import com.spring.mongodb.model.TodoDto;
import com.spring.mongodb.repository.TodoRepository;

@Service
public class TodoServiceImple implements TodoService {

	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void createTodo(TodoDto todo) throws ConstraintViolationException,TodoCollectionException {
		
		Optional<TodoDto> optionalTodo = todoRepository.findByTodo(todo.getTodo());
		
		if(optionalTodo.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.todoAlreadyExists());
		}else {
			todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepository.save(todo);
		}
	}

	
}
