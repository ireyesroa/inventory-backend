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

import com.linktic.api.model.Category;
import com.linktic.api.service.ICategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "category manager")
public class CategoryController {

	@Autowired
	private ICategoryService service;

	@ApiOperation(value = "Get category by id", response = Category.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found category", response = Category.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found category"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> listById(@PathVariable("id") Integer id) {
		try {
			Category category = service.listById(id);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	
	@ApiOperation(value = "Get all categories", response = Category.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "list all categories", response = Category.class),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/categories")
	public ResponseEntity<List<Category>> listPageable(@RequestParam("page") int page, @RequestParam("size") int size) {
		List<Category> categories = service.listPageable(page, size);
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

}
