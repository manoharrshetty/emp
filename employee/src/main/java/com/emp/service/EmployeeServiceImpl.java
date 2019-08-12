package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mapper.EmployeeMapper;
import com.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeMapper employeeMapper;
	
	
	@Override
	public List<Employee> findAll() {
		List<Employee> employees  = employeeMapper.findAll();
		return employees;
	}
	

}
