package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItem(){
		List<Item> allItems = itemService.getAllItems();
		return new ResponseEntity<>(allItems,HttpStatus.OK);
	}
	
	 @GetMapping("/items/{id}")
	 public ResponseEntity<Item> getItemById(@PathVariable Long id) {
	        Optional<Item> item = itemService.getItemById(id);
	        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }
	 @PostMapping("/items")
	 public Item createItem(@RequestBody Item item) {
	        return itemService.createItem(item);
	 }
	 
	 @PutMapping("/items/{id}")
	 public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
	        try {
	            return ResponseEntity.ok(itemService.updateItem(id, item));
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.notFound().build();
	        } 
	 }
	 @DeleteMapping("/items/{id}")
	    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
	        try {
	            itemService.deleteItem(id);
	            return ResponseEntity.noContent().build();
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	

}
