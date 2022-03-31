package com.superapp.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import com.superapp.unittesting.unittesting.model.Item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// JUnit 4
//@RunWith(SpringRunner.class) on top of
//@DataJpaTest

// JUnit 5
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;

	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();

		assertEquals(3, items.size());
	}

	@Test
	public void findById() {
		Optional<Item> item = repository.findById(10001);

		assertNotNull(item.get());
	}
}
