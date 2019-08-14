package com.emp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.emp.model.Employee;
import com.emp.model.EmployeeQuery;

@Mapper
public interface EmployeeMapper extends IbatisMapper<Employee,EmployeeQuery>{
	
    
    
    
	
}
