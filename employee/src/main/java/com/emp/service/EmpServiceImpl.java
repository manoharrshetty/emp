package com.emp.service;

import static com.emp.enums.MessageKey.EMPLOYEE_DOESNOT_EXIT;
import static com.emp.enums.MessageKey.UPDATE_NOT_SUCCESSFUL;
import static com.emp.enums.MessageKey.DELETE_NOT_SUCCESSFUL;
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
		employee.setId(empId);
		
		employeeMapper.save(employee);
		return employee;
		
	}
	@Transactional
	@Override
	public Emp update(Emp employee) {
		
		int count = employeeMapper.update(employee);
		if (count == 0 ) {
			throw new RuntimeException(String.format(MESSAGE_PROPERTIES_INSTANCE.getMessage(UPDATE_NOT_SUCCESSFUL.name()), employee.getId()));
		}
		
		return employee;
		
	}
	@Transactional
	@Override
	public void delete(Integer id) {
			
		int count  = employeeMapper.delete(id);
		if (count == 0 ) {
			throw new RuntimeException(String.format(MESSAGE_PROPERTIES_INSTANCE.getMessage(DELETE_NOT_SUCCESSFUL.name()), id));
		}
		

	}
	
	@Override
	public List<Emp> findByQuery(EmpQuery employeeQuery) {
		List<Emp> employees  = employeeMapper.findByQuery(employeeQuery);
		return employees;
	}
}
