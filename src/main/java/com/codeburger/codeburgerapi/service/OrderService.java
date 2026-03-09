package com.codeburger.codeburgerapi.service;

import com.codeburger.codeburgerapi.entity.Order;
import com.codeburger.codeburgerapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> retrieve() {
        return repository.findAll();
    }

    public Optional<Order> retrieveInfoByCustomer(String customerName) {
        return repository.findByCustomerName(customerName);
    }

    public Order create(Order data) {
        return repository.save(data);
    }
}
