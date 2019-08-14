package com.emp.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmployeeEncoder {
	
	public static PasswordEncoder getEncoder() {
		return  new BCryptPasswordEncoder();
	}
}
