package com.emp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity//enable Spring Security’s web security support and provide the Spring MVC integration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	/**
	 * The configure(HttpSecurity) method defines which URL paths should be secured
	 * and which should not.It also specifies the role
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        //HTTP Basic authentication
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/employee/**").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/employee").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/employee/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PATCH, "/employee/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/employee/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
    }

   
    
  @Override
    public void configure(AuthenticationManagerBuilder builder)    	
            throws Exception {
    	    builder.userDetailsService(userDetailsService);
    }
  
     
    
    @Bean
   	public PasswordEncoder passwordEncoder(){
   		PasswordEncoder encoder = new BCryptPasswordEncoder();
   		return encoder;
   	}
}