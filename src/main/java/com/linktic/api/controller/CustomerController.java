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

import com.linktic.api.model.Customer;
import com.linktic.api.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "Customer manager")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	
	@ApiOperation(value = "Get customer by id", response = Customer.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found customer", response = Customer.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found customer"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> listById(@PathVariable("id") Integer id) {
		try {
			Customer supplier = service.listById(id);
			return new ResponseEntity<Customer>(supplier, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	

	@ApiOperation(value = "Get all customers", response = Customer.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "list all customers", response = Customer.class),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value ="/customers")
	public ResponseEntity<List<Customer>> listPageable(@RequestParam("page") int page,
            @RequestParam("size") int size) {
		List<Customer> customers = service.listPageable(page, size);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
}
