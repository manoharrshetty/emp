package com.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeGenerator {

  public static void main(String[] args) {

	int i = 0;
	while (i < 10) {
		String password = "K!delq6w";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		i++;
	}

  }
}