package com.emp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.emp.model.Emp;
import com.emp.model.EmpQuery;

@Mapper
public interface EmpMapper extends IbatisMapper<Emp,EmpQuery,Integer>{
	
    
    
    
	
}
