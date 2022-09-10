package com.spring.mongodb.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.exception.TodoCollectionException;
import com.spring.mongodb.model.TodoDto;
import com.spring.mongodb.repository.TodoRepository;
import com.spring.mongodb.service.TodoServiceImple;

@RestController
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoServiceImple todoServiceImple;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllTodos(){
		List<TodoDto> todos = todoRepository.findAll();
		
		if(todos.size() > 0) {
			return new ResponseEntity<List<TodoDto>>(todos, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No Todos Available", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/todos")
	public ResponseEntity<?> createTodo(@RequestBody TodoDto todoDto){
		try {
			todoServiceImple.createTodo(todoDto);
			return new ResponseEntity<TodoDto>(todoDto,HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/todos/{id}")
	public ResponseEntity<?> getSingleTodo(@PathVariable("id") String id){
		Optional<TodoDto> todo = todoRepository.findById(id);
		
		if(todo.isPresent()) {
			return new ResponseEntity<>(todo,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Todo not found with id "+id, HttpStatus.NOT_FOUND);
		}
	}
}
