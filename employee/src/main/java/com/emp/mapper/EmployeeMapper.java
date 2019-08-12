package com.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.emp.model.Employee;

@Mapper
public interface EmployeeMapper {

    List<Employee> findAll();
	
}
