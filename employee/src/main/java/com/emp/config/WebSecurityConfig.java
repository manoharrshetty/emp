package com.emp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity//enable Spring Security’s web security support and provide the Spring MVC integration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private DaoAuthenticationProvider authProvider;
	
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
        .antMatchers(HttpMethod.GET, "/employee/users/**").hasRole("ADMIN")//all request related to users must be an ADMIN
        .antMatchers(HttpMethod.POST, "/employee/users").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/employee/users/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/employee/users/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/employee/emp/**").hasAnyRole("USER","ADMIN")//all get request must be made by user has USER/ADMIN role configured in the user table.
        .antMatchers(HttpMethod.POST, "/employee/emp").hasAnyRole("USER","ADMIN")
        .antMatchers(HttpMethod.PUT, "/employee/emp/**").hasAnyRole("USER","ADMIN")
        .antMatchers(HttpMethod.PATCH, "/employee/emp/**").hasAnyRole("USER","ADMIN")
        .antMatchers(HttpMethod.DELETE, "/employee/emp/**").hasAnyRole("USER","ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
    }

   
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
  
    
    
   
}