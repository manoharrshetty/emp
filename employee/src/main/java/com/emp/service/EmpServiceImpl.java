package com.emp.service;

import static com.emp.enums.MessageKey.EMPLOYEE_DOESNOT_EXIT;
import static com.emp.util.MessageUtil.MESSAGE_PROPERTIES_INSTANCE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.mapper.EmpMapper;
import com.emp.model.Emp;
import com.emp.model.EmpQuery;

@Service

public class EmpServiceImpl  implements EmpService {
	
	@Autowired
    private EmpMapper employeeMapper;
	
	
	@Override
	public List<Emp> findAll() {
		List<Emp> employees  = employeeMapper.findAll();
		return employees;
	}
	@Transactional
	@Override
	public Emp save(Emp employee) {
		
		int empId  = employeeMapper.findNextSeq();
		employee.setEmpId(empId);
		
		employeeMapper.save(employee);
		return employee;
		
	}
	@Transactional
	@Override
	public Emp update(Emp employee) {
		
		employeeMapper.update(employee);
		
		return employee;
		
	}
	@Transactional
	@Override
	public void delete(Integer id) {
		List<Emp> employees  = employeeMapper.findById(id);
		if (employees.isEmpty()) {
			throw new RuntimeException(String.format(MESSAGE_PROPERTIES_INSTANCE.getMessage(EMPLOYEE_DOESNOT_EXIT.name()), id));
		}
		
		employeeMapper.delete(id);

	}
	
	@Override
	public List<Emp> findByQuery(EmpQuery employeeQuery) {
		List<Emp> employees  = employeeMapper.findByQuery(employeeQuery);
		return employees;
	}
}
