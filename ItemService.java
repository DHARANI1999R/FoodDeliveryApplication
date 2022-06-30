package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Item;

public interface ItemService {

	void deleteItem(int itemId);

	Item updateItem(Item item, int itemId);

	Item getItemById(int itemId);

	List<Item> getAllItems();

	Item saveItem(@Valid Item item);

}
