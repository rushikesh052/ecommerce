package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepo;

	@Override
	public List<Item> getAllItems() {
		List<Item> all = itemRepo.findAll();
		return all;
	}

	@Override
	public Optional<Item> getItemById(Long id) {
		
		return itemRepo.findById(id);
	}

	@Override
	public Item createItem(Item item) {
		
		return itemRepo.save(item);
	}

	@Override
	public Item updateItem(Long id, Item item) {
		if(!itemRepo.existsById(id)) {
			throw new IllegalArgumentException("Item not found");
		}
		item.setId(id);
		return itemRepo.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		if(!itemRepo.existsById(id)) {
			throw new IllegalArgumentException("Item not found");
		}
		itemRepo.deleteById(id);
	}
}
