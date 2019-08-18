package com.emp.service;

import static com.emp.enums.MessageKey.USER_DOESNOT_EXIT;
import static com.emp.util.MessageUtil.MESSAGE_PROPERTIES_INSTANCE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.enums.MessageKey;
import com.emp.mapper.UsersMapper;
import com.emp.model.Users;
import com.emp.model.UsersQuery;


@Service
public class UsersServiceImpl extends TransactionService<Users,UsersQuery> implements UsersService {
	
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
		users.setUsersId(empId);

		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		usersMapper.save(users);
		
		return users;
		
	}
	@Transactional
	@Override
	public Users update(Users users) {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		usersMapper.update(users);
		
		return users;
		
	}
	
	@Transactional
	@Override
	public void delete(Integer id) {
		List<Users> usersList  = usersMapper.findById(id);
		if (usersList.isEmpty()) {
			throw new RuntimeException(String.format(MESSAGE_PROPERTIES_INSTANCE.getMessage(USER_DOESNOT_EXIT.name()), id));
		}
		usersMapper.delete(id);
	}
	
	@Override
	public List<Users> findByQuery(UsersQuery usersQuery) {
		List<Users> users  = usersMapper.findByQuery(usersQuery);
		return users;
	}
	
	
	
	
}
