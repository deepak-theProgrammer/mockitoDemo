package com.google.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.data.api.TodoService;
import com.google.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {
	
	private static TodoService todoServiceStub;
	private static TodoBusinessImpl todoBusinessImpl;
	
	@BeforeClass
	public static void setup() {
		todoServiceStub = new TodoServiceStub();
		todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingAStub() {
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
}