package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;



@Service
public class UserDetailsServic {

	@Autowired
	UserRepository userRepository;
	
	public UserDetails creatUser(UserDetails user) {
		return userRepository.save(user);
	}

	public void deleteUserById(long id) { 
		userRepository.deleteById(id);
	}
	public UserDetails findById(long id){
		return userRepository.findById(id);
		
	}
	
}