package com.rahul.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.springcloud.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
}
