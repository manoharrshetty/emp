package com.emp.service;

import static com.emp.enums.MessageKey.DELETE_NOT_SUCCESSFUL;
import static com.emp.enums.MessageKey.UPDATE_NOT_SUCCESSFUL;
import static com.emp.util.MessageUtil.MESSAGE_PROPERTIES_INSTANCE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.mapper.UsersMapper;
import com.emp.model.Users;
import com.emp.model.UsersQuery;


@Service
public class UsersServiceImpl  implements UsersService {
	
	@Autowired
    private UsersMapper usersMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<Users> findAll() {
		List<Users> users  = usersMapper.findAll();
		return users;
	}
	@Transactional
	@Override
	public Users save(Users users) {
		
		int empId  = usersMapper.findNextSeq();
		users.setId(empId);

		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		usersMapper.save(users);
		
		return users;
		
	}
	@Transactional
	@Override
	public Users update(Users users) {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		int count  = usersMapper.update(users);
		if (count == 0 ) {
			throw new RuntimeException(String.format(MESSAGE_PROPERTIES_INSTANCE.getMessage(UPDATE_NOT_SUCCESSFUL.name()), users.getId()));
		}
		return users;
		
	}
	
	@Transactional
	@Override
	public void delete(Integer id) {
		
		int count = usersMapper.delete(id);
		if (count == 0 ) {
			throw new RuntimeException(String.format(MESSAGE_PROPERTIES_INSTANCE.getMessage(DELETE_NOT_SUCCESSFUL.name()), id));
		}
	}
	
	@Override
	public List<Users> findByQuery(UsersQuery usersQuery) {
		List<Users> users  = usersMapper.findByQuery(usersQuery);
		return users;
	}
	
	
	
	
}
