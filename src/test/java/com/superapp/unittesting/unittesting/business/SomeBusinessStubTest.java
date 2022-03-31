package com.superapp.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.superapp.unittesting.unittesting.data.SomeDataService;

import org.junit.jupiter.api.Test;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] rerieveAllData() {
		return new int[] { 1, 2, 3 };
	}

}

class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] rerieveAllData() {
		return new int[] {};
	}

}

class SomeDataServiceOneValueStub implements SomeDataService {

	@Override
	public int[] rerieveAllData() {
		return new int[] { 5 };
	}

}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneValueStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;

		assertEquals(expectedResult, actualResult);
	}
}
