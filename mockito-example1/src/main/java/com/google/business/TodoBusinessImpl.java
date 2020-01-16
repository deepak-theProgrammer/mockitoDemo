package com.google.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.data.api.TodoService;

public class TodoBusinessImpl {

	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos;
		List<String> todos = todoService.retrieveTodos(user);
		filteredTodos = todos.stream()
							 .filter(str -> str.contains("Spring"))
							 .collect(Collectors.toCollection(ArrayList::new));
		return filteredTodos;
	}
}