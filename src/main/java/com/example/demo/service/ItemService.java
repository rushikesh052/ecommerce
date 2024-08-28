package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Item;

public interface ItemService {
	
	public List<Item> getAllItems();
	
	public Optional<Item> getItemById(Long id);
	
	public Item createItem(Item item);
	
	public Item updateItem(Long id, Item item);
	
	public void deleteItem(Long id);

}
