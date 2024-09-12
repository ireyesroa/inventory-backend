package com.linktic.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.api.model.Employee;
import com.linktic.api.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "Employee manager")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	
	@ApiOperation(value = "Get employee by id", response = Employee.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found Employee", response = Employee.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found Employee"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> listById(@PathVariable("id") Integer id) {
		try {
			Employee employee = service.listById(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	

	@ApiOperation(value = "Get all employees", response = Employee.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "list all Employees", response = Employee.class),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value ="/employees")
	public ResponseEntity<List<Employee>> listPageable(@RequestParam("page") int page,
            @RequestParam("size") int size) {
		List<Employee> employees = service.listPageable(page, size);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

}
