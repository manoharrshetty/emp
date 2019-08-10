package com.emp.config;


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
        .antMatchers(HttpMethod.GET, "/employee/**").hasRole("USER")//all get request must be made by user has USER role configured in the user table.
        .antMatchers(HttpMethod.POST, "/employee").hasRole("USER")
        .antMatchers(HttpMethod.PUT, "/employee/**").hasRole("USER")
        .antMatchers(HttpMethod.PATCH, "/employee/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/employee/**").hasRole("USER")
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
       * this alogorithm .This hashed password will then be compared against the one 
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
}