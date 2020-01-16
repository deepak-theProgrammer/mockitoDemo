package com.google.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.data.api.TodoService;

public class TodoBusinessImplMockTest {

	private static TodoService todoServiceMock;
	private static TodoBusinessImpl todoBusinessImpl;

	@BeforeClass
	public static void setup() {
		todoServiceMock = mock(TodoService.class);
		todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingAMock() {
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}
}