package com.linktic.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity that representation Employees in the project")
public class Employee {

	@ApiModelProperty(value = "primary key employee identifier", required = true)
	private Integer employeeId;
	
	@ApiModelProperty(value = "employee name")
	private String name;

	@ApiModelProperty(value = "employee address principal")
	private String address;

	@ApiModelProperty(value = "employee phone principal")
	private String phone;

	@ApiModelProperty(value = "employee email principal")
	private String email;
	
	public Employee() {}

	public Employee(Integer employeeId, String name, String address, String phone, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
