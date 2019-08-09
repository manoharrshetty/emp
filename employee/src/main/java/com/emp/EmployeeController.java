package com.emp;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emp.service.EmployeeService;


@RestController
public class EmployeeController {
	/**
	 * produces json response with the following request parameter.
	 */
    @Autowired
    private EmployeeService employeeService;
    
    
    @RequestMapping(value = "/employee",   params = { "id"},produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Employee findOne(@RequestParam(value="id")  int id) {
		return employeeService.findById(id);
		
	}
    /**
     * produces JSON response with the following request parameters.
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/employee",   params = { "name","age"},produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Employee> findByNameAndAge(@RequestParam(value="name")  String name,@RequestParam(value="age")  int age) {
    	return employeeService.findByNameAndAge(name, age);
	}
    
	/*
	 * Annotation for mapping HTTP GET requests onto specific handler methods.
	 * Specifically, @GetMapping is a composed annotation that acts as a shortcut
	 * for @RequestMapping(method = RequestMethod.GET).
	 * 
	 * 
	 */
    
    @GetMapping("/employee")
    List<Book> findAll() {
        //return employeeService.findAll();
    	return null;
    }
    
    
    

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employee")
    public Employee save(@RequestBody Employee newEmployee) {
    	return employeeService.save(newEmployee);
    }
    
}


