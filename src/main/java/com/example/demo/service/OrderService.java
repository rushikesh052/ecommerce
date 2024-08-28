package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Order;

public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Optional<Order> getOrderById(Long id);
	
	public Order createOrder(Order order);
	
	public Order updateOrder(Long id, Order order);
	
	public void deleteOrder(Long id);

}
