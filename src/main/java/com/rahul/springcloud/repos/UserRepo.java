package com.rahul.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.springcloud.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
