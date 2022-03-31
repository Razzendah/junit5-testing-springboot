package com.superapp.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.Test;

public class JsonPathTest {

	@Test
	public void learning() {
		String responseFromService = "[ { \"id\": 10000, \"name\": \"Pencil\", \"quantity\": 5 }, { \"id\": 10001, \"name\": \"Pen\", \"quantity\": 15 }, { \"id\": 10002, \"name\": \"Eraser\", \"quantity\": 10 } ]";

		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()"); // $ is the root, length gives the length of the array

		assertThat(length).isEqualTo(3);

		// the id present under the root
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10000, 10001, 10002);

		// get an specific element
		context.read("$.[1]");

		// get elements from a beggining to an end, second number is excluisve
		context.read("$.[0:2]");

		// condition, @ means attribute
		// @.name == Eraser, bring the element that has as attribute Eraser
		context.read("$.[?(@.name=='Eraser')]");

		// condition, @.quanitity
		context.read("$.[?(@.quantity==5)]");

	}
}
