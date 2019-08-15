package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mapper.EmpMapper;
import com.emp.model.Emp;
import com.emp.model.EmpQuery;

@Service
public class EmpServiceImpl extends TransactionService<Emp,EmpQuery> implements EmpService {
	
	@Autowired
    private EmpMapper employeeMapper;
	
	
	@Override
	public List<Emp> findAll() {
		List<Emp> employees  = employeeMapper.findAll();
		return employees;
	}
	
	@Override
	public Emp save(Emp employee) {
		
		int empId  = employeeMapper.findNextSeq();
		employee.setEmpId(empId);
		
		employeeMapper.save(employee);
		
		return employee;
		
	}
	
	@Override
	public Emp update(Emp employee) {
		
		employeeMapper.update(employee);
		
		return employee;
		
	}
	
	@Override
	public List<Emp> findByQuery(EmpQuery employeeQuery) {
		List<Emp> employees  = employeeMapper.findByQuery(employeeQuery);
		return employees;
	}
}
