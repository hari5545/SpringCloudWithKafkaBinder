package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.OrderDetails;
import com.example.model.UserDetails;
import com.example.repository.OrderItemsRepository;
import com.example.repository.USerDetailsRepository;

@Service
public class OrderItemsService {
	@Autowired
	OrderItemsRepository repository;
	
	@Autowired
	USerDetailsRepository userRepository;
	
	public Optional<OrderDetails> getORderDetails(int id) {
		return repository.findById(id);
	}
	public OrderDetails saveORderItems(OrderDetails entity) {
		return repository.saveAndFlush(entity);
	}
	
	public OrderDetails save(OrderDetails orderDetails) {
		return repository.save(orderDetails);
	}
	
	public Optional<UserDetails> getUserDetailEntity(int id) {
		return userRepository.findById(id);
	}
}
