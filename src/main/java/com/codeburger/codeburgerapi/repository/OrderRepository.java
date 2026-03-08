package com.codeburger.codeburgerapi.repository;

import com.codeburger.codeburgerapi.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findByCustomerName(String customerName);

}
