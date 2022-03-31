package com.superapp.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.superapp.unittesting.unittesting.data.SomeDataService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // JUnit 5
//@RunWith(MockitoJUnitRunner.class) // JUnit 4
public class SomeBusinessMock2Test {

	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();

	@Mock
	SomeDataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_basic() {
		// mocking 
		// dataServiceMock retrieveAllData new int[] {1, 2, 3} 
		when(dataServiceMock.rerieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		// mocking 
		// dataServiceMock retrieveAllData new int[] {} 
		when(dataServiceMock.rerieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		// mocking 
		// dataServiceMock retrieveAllData new int[] {5} 
		when(dataServiceMock.rerieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingDataService());
	}
}
