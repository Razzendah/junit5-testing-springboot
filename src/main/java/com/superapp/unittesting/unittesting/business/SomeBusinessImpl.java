package com.superapp.unittesting.unittesting.business;

import java.util.Arrays;
import java.util.OptionalInt;

import com.superapp.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);

		/*int sum = 0;
		for (int value : data) {
			sum += value;
		}
		
		return sum;
		*/
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.rerieveAllData();
		for (int value : data) {
			sum += value;
		}

		return sum;
	}

}
