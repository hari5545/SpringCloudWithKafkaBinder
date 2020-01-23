package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;


@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{

	public UserDetails findById(long id);
}
