package com.emp.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.emp.entity.Users;

public interface UserRepository extends CrudRepository<Users, Long> {
 
	Optional<Users>  findByUsername(String username);
}