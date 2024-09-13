package com.linktic.api.model;


import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Entity that representation orders in the project")
public class Order {

	@ApiModelProperty(value = "primary key order identifier", required = true)
	private Integer orderId;
	
	@ApiModelProperty(value = "primary key customer identifier", required = true)
	private int customerId;
	
	@ApiModelProperty(value = "primary key employee identifier", required = true)
	private int employeeId;

	@ApiModelProperty(value = "current order date")
	@JsonFormat(pattern="yyyy/MM/dd'T'HH:mm:ss")
	private Timestamp orderDate;

	@ApiModelProperty(value = "order name")
	private String shipName;

	@ApiModelProperty(value = "order address")
	private String shipAddress;

	@ApiModelProperty(value = "order city")
	private String shipCity;

	@ApiModelProperty(value = "order country")
	private String shipCountry;
	
	@ApiModelProperty(value = "order details")
	List<OrderDetail> orderDetails;
	
	public Order() {}

	public Order(Integer orderId, int customerId, int employeeId, Timestamp orderDate, String shipName,
			String shipAddress, String shipCity, String shipCountry) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.orderDate = orderDate;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipCountry = shipCountry;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}
