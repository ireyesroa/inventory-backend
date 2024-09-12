package com.linktic.api.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.linktic.api.model.Product;
import com.linktic.api.service.IProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "product manager")
public class ProductController {

	@Autowired
	private IProductService service;
	

	@ApiOperation(value = "create new product", response = Product.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 201, message = "created product", response = Product.class),	        
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product productCreated = service.create(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(productCreated.getProductId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@ApiOperation(value = "Get product by id", response = Product.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found product", response = Product.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found product"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> listById(@PathVariable("id") Integer id) {
		try {
			Product product = service.listById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	

	@ApiOperation(value = "Get all products", response = Product.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "list all products", response = Product.class),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value ="/products")
	public ResponseEntity<List<Product>> listPageable(@RequestParam("page") int page,
            @RequestParam("size") int size) {
		List<Product> products = service.listPageable(page, size);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
