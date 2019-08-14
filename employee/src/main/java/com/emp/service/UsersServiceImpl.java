package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.config.EmployeeEncoder;
import com.emp.mapper.UsersMapper;
import com.emp.model.Users;
import com.emp.model.UsersQuery;


@Service
public class UsersServiceImpl extends TransactionService<Users,UsersQuery> implements UsersService {
	
	@Autowired
    private UsersMapper usersMapper;
	
	
	@Override
	public List<Users> findAll() {
		List<Users> users  = usersMapper.findAll();
		return users;
	}
	
	@Override
	public Users save(Users users) {
		
		int empId  = usersMapper.findNextSeq();
		users.setUsersId(empId);

		users.setPassword(EmployeeEncoder.getEncoder().encode(users.getPassword()));
		
		usersMapper.save(users);
		
		return users;
		
	}
	
	@Override
	public Users update(Users users) {
		users.setPassword(EmployeeEncoder.getEncoder().encode(users.getPassword()));
		usersMapper.update(users);
		
		return users;
		
	}
	
	@Override
	public List<Users> findByQuery(UsersQuery usersQuery) {
		List<Users> users  = usersMapper.findByQuery(usersQuery);
		return users;
	}
}
