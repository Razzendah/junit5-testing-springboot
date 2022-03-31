package com.superapp.unittesting.unittesting.data;

import com.superapp.unittesting.unittesting.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
