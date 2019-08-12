package com.emp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.emp.model.Users;

@Mapper
public interface UsersMapper {


    Users findByName(String name);
	
}
