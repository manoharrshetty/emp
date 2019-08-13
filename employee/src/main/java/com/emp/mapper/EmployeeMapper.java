package com.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emp.model.Employee;
import com.emp.model.EmployeeQuery;

@Mapper
public interface EmployeeMapper {
	List<Employee> findByQuery(EmployeeQuery employeeQuery);
	List<Employee> findAll();
	Integer findNextSeq();
    void save(Employee employee);
    void update(Employee employee);
    
    
    
	
}
