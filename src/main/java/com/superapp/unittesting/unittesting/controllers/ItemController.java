package com.superapp.unittesting.unittesting.controllers;

import java.util.List;

import com.superapp.unittesting.unittesting.business.ItemBusinessService;
import com.superapp.unittesting.unittesting.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-business-service")
	public Item itemFormBusinessService() {
		return businessService.retrieveHardcodedItem();
	}

	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
}