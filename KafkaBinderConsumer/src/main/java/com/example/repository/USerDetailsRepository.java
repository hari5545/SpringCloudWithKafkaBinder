package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UserDetails;

public interface USerDetailsRepository extends JpaRepository<UserDetails, Integer> {
	
}
