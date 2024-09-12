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

import com.linktic.api.model.Order;
import com.linktic.api.model.OrderDetail;
import com.linktic.api.service.IOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "Order manager")
public class OrderController {

	
	@Autowired
	private IOrderService service;
	
	
	@ApiOperation(value = "create new order", response = Order.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 201, message = "created order", response = Order.class),	        
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> create(@RequestBody Order product) {
		Order orderCreated = service.create(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(orderCreated.getOrderId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@ApiOperation(value = "Get order by id", response = Order.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found order", response = Order.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found order"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> listById(@PathVariable("id") Integer id) {
		try {
			Order order = service.listById(id);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@ApiOperation(value = "Get all orders", response = Order.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "list all orders", response = Order.class),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value ="/orders")
	public ResponseEntity<List<Order>> listPageable(@RequestParam("page") int page,
            @RequestParam("size") int size) {
		List<Order> orders = service.listPageable(page, size);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	

	@ApiOperation(value = "Get order details by id", response = OrderDetail.class)
	@ApiResponses(value = {			
	        @io.swagger.annotations.ApiResponse(code = 200, message = "found order details", response = OrderDetail.class),
	        @io.swagger.annotations.ApiResponse(code = 404, message = "no found order details"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal error server")
	    })
	@GetMapping(value ="/order_details/{id}")
	public ResponseEntity<List<OrderDetail>> listDetails(@PathVariable("id") Integer id) {
		List<OrderDetail> orders = service.listDetails(id);
		return new ResponseEntity<List<OrderDetail>>(orders, HttpStatus.OK);
	}
	
	
	
}
