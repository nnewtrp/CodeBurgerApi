package com.codeburger.codeburgerapi.service;

import com.codeburger.codeburgerapi.entity.Order;
import com.codeburger.codeburgerapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Page<Order> retrieve(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable);
    }

    public Integer retrieveCount() { return repository.findAll().size(); }

    public Optional<Order> retrieveInfoByCustomer(String customerName) {
        return repository.findByCustomerName(customerName);
    }

    public void create(Order data) {
        repository.save(data);
    }

    public void delete(Order data) {
        repository.delete(data);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
