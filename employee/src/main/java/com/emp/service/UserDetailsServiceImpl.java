package com.emp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp.entity.Users;
import com.emp.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

	
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Users> user = userRepository.findByUsername(username);
        if (user.isPresent() == false) {
                 throw new UsernameNotFoundException("User not found by name: " + username);
        }
       
        return toUserDetails(user.get());
    }
    
    
    
    
    private UserDetails toUserDetails(Users user) {
  
    	return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
    			  .password(passwordEncoder.encode(user.getPassword()))
    			  //.password(user.getPassword())
                .roles(user.getRole()).build();
    	
    	
    	    }
    
        
}