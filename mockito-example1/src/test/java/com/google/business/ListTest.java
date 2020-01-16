package com.google.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Deepak");
		assertEquals("Deepak", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	public void letsMockListGetByArgumentMatcher() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("Deepak");
		assertEquals("Deepak", listMock.get(0));
		assertEquals("Deepak", listMock.get(1));
		assertEquals("Deepak", listMock.get(2));
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_throwAnException() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenThrow(new RuntimeException("Something"));
		listMock.get(0);
	}
	
	@Test
	public void letsMockListGetByVerfiy() {
		List<String> listMock = mock(List.class);
		listMock.add("Hello");
		listMock.size(); 
		verify(listMock).add("Hello");
//		verfify(mockObj, times(no_0f_times)).theCalledMethod();
		verify(listMock, times(1)).size();
//		verify(listMock, times(2)).size();	this test will fail as size() is called only once
	}
}
