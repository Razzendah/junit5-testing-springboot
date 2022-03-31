package com.superapp.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.superapp.unittesting.unittesting.data.ItemRepository;
import com.superapp.unittesting.unittesting.model.Item;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // JUnit 5
//@RunWith(MockitoJUnitRunner.class) // JUnit 4
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService business = new ItemBusinessService();

	@Mock
	private ItemRepository repository;

	@Test
	public void retrieveAllItems_basic() {
		// mocking 
		// dataServiceMock retrieveAllData new int[] {1, 2, 3} 
		when(repository.findAll()).thenReturn(Arrays.asList(
				new Item(2, "Item2", 10, 10),
				new Item(3, "Item3", 20, 20)));

		List<Item> items = business.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}

}
