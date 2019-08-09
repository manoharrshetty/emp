package com.emp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.emp.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	
	Optional<List<Employee>> findByName(String name);
	
	Optional<List<Employee>> findByNameAndAge(String name,int age);
	
}
