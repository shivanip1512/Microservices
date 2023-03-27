package com.springboot.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restfulwebservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
}
