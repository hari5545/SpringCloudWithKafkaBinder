package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.OrderDetails;

public interface OrderItemsRepository extends JpaRepository<OrderDetails, Integer>  {

}
