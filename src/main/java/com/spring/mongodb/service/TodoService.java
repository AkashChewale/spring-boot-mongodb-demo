package com.spring.mongodb.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.spring.mongodb.exception.TodoCollectionException;
import com.spring.mongodb.model.TodoDto;

public interface TodoService {

	public void createTodo(TodoDto todo) throws ConstraintViolationException,TodoCollectionException;
	
}
