package com.emp.service;

import java.util.List;

import com.emp.model.Employee;
import com.emp.model.EmployeeQuery;

public interface EmployeeService {
	
	
	public List<Employee> findAll();
	public List<Employee> findByQuery(EmployeeQuery employeeQuery);
	
	public Employee save(Employee employee);
	
	public Employee update(Employee employee);
	
	

}
