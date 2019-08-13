package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mapper.EmployeeMapper;
import com.emp.model.Employee;
import com.emp.model.EmployeeQuery;

@Service
public class EmployeeServiceImpl extends TransactionService implements EmployeeService {
	
	@Autowired
    private EmployeeMapper employeeMapper;
	
	
	@Override
	public List<Employee> findAll() {
		List<Employee> employees  = employeeMapper.findAll();
		return employees;
	}
	
	@Override
	public Employee save(Employee employee) {
		
		int empId  = employeeMapper.findNextSeq();
		employee.setEmpId(empId);
		
		employeeMapper.save(employee);
		
		return employee;
		
	}
	
	@Override
	public Employee update(Employee employee) {
		
		employeeMapper.update(employee);
		
		return employee;
		
	}
	
	@Override
	public List<Employee> findByQuery(EmployeeQuery employeeQuery) {
		List<Employee> employees  = employeeMapper.findByQuery(employeeQuery);
		return employees;
	}
}
