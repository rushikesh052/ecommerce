package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        if (!orderRepo.existsById(id)) {
            throw new IllegalArgumentException("Order not found");
        }
        order.setId(id);
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepo.existsById(id)) {
            throw new IllegalArgumentException("Order not found");
        }
        orderRepo.deleteById(id);
    }
}
