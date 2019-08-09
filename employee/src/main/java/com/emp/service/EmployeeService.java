package com.emp.service;

import java.util.List;

import com.emp.Employee;

public interface EmployeeService {
	
	public Employee findById(int empId);
	public List<Employee> findByName(String name);
	public List<Employee> findAll();
	public List<Employee> findByNameAndAge(String name,int age);
	public Employee save(Employee e);

}
