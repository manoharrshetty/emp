package com.emp.config;


import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
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
        auth.authenticationProvider(authProvider());
    }
  
    
  @Bean
  public DaoAuthenticationProvider authProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailsService);
      /*basically I am specifying that the BCryptPasswordEncoder(BCrypt algorithm) 
       * must be used to authenticate the user against the hashed password in the DB.
       * That is the user who will log in with plain text password will be hashed using 
       * this algorithm .This hashed password will then be compared against the one 
       * stored in the password column of user table.
       */
      authProvider.setPasswordEncoder(passwordEncoder());
      return authProvider;
  }
    
    @Bean
   	public PasswordEncoder passwordEncoder(){
   		PasswordEncoder encoder = new BCryptPasswordEncoder();
   		return encoder;
   	}
    
    
    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }
}