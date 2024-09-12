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

import com.linktic.api.model.Supplier;
import com.linktic.api.service.ISupplierService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "supplier manager")
public class SupplierController {

	@Autowired
	private ISupplierService service;

	
	@ApiOperation(value = "Get supplier by id", response = Supplier.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found supplier", response = Supplier.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found supplier"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/suppliers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> listById(@PathVariable("id") Integer id) {
		try {
			Supplier supplier = service.listById(id);
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	
	@ApiOperation(value = "Get all suppliers", response = Supplier.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "list all suppliers", response = Supplier.class),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value ="/suppliers")
	public ResponseEntity<List<Supplier>> listPageable(@RequestParam("page") int page,
            @RequestParam("size") int size) {
		List<Supplier> suppliers = service.listPageable(page, size);
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}
	
}
