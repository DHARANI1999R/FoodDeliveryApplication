package com.example.demo.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.model.Item;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		itemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("Item","ItemId",itemId));
		itemRepository.deleteById(itemId);

		
	}

	@Override
	public Item updateItem(Item item, int itemId) {
		// TODO Auto-generated method stub
		Item existingUser = itemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("Item","ItemId",itemId));
		existingUser.setItemName(item.getItemName());
		existingUser.setItemPrice(item.getItemPrice());
		itemRepository.save(existingUser);
		return existingUser;
		

	}

	@Override
	public Item getItemById(int itemId) {
		// TODO Auto-generated method stub
		return itemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("Item","ItemId",itemId));
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item saveItem(@Valid Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

}
