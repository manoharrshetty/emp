package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.model.EmployeeQuery;
import com.emp.service.EmployeeService;


@RestController
public class EmployeeController {
	
    @Autowired
    private EmployeeService employeeService;
    
   
    @RequestMapping(value = "/employee",   params = { "empId"},produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Employee> findByEmpId(@RequestParam(value="empId")  Integer empId) {
    	EmployeeQuery query = new EmployeeQuery();
    	query.setEmpId(empId);
    	return employeeService.findByQuery(query);
	}
    
    /**
     * produces JSON response with the following request parameters.
     * Alternatively you can also use  @GetMapping because it is a composed annotation that acts as a shortcut
	 * for @RequestMapping(method = RequestMethod.GET).
     * @param empId
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping(value = "/employee",  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Employee> findByQuery(@ModelAttribute("employeeQuery") Optional<EmployeeQuery> 	employeeQuery) {
    	return employeeService.findByQuery(employeeQuery.orElse(new EmployeeQuery()));
	}
    
	
    
    
    

    
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employee")
    public Employee save(@RequestBody Employee newEmployee) {
    	return employeeService.save(newEmployee);
    }
    
    
  
    @PutMapping("/employee")
    public Employee put(@RequestBody Employee employee) {
    	return employeeService.update(employee);
    }
}


