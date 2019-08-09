package com.emp.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.Employee;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository repository;
	
	@Override
	public Employee findById(int id){
		Optional<Employee> e = repository.findById(id);
		return e.orElse(null);
		
	}
	@Override
	public List<Employee> findByName(String name){
		Optional<List<Employee>> emps = repository.findByName(name);
		return emps.orElse(Collections.<Employee>emptyList());
				
	}
	
	@Override
	public List<Employee> findByNameAndAge(String name,int age){
		Optional<List<Employee>> emps = repository.findByNameAndAge(name,age);
		return emps.orElse(Collections.<Employee>emptyList());
				
	}
	
	@Override
	public Employee save(Employee e){
		return repository.save(e);
		
				
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
