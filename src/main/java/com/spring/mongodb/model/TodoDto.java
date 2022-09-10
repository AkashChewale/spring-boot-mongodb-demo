package com.spring.mongodb.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class TodoDto {

	@Id
	private String id;
	
	@NotNull(message = "todo cannot be null")
	private String todo;
	
	@NotNull(message = "description cannot be null")
	private String description;
	
	@NotNull(message = "completed cannot be null")
	private boolean completed;
	
	private Date createdAt;
	private Date updatedAt;
	
	public TodoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TodoDto(String id, String todo, String description, boolean completed, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.todo = todo;
		this.description = description;
		this.completed = completed;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
