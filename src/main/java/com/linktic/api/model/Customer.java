package com.linktic.api.model;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel(description = "Entity that representation Customer in the project")
public class Customer {

	//@ApiModelProperty(value = "primary key customer identifier", required = true)
	private Integer customerId;

	//@ApiModelProperty(value = "customer name")
	private String name;
	
	//@ApiModelProperty(value = "customer address principal")
	private String address;

	//@ApiModelProperty(value = "customer phone principal")
	private String phone;

	//@ApiModelProperty(value = "customer email principal")
	private String email;
	
	public Customer() {}

	public Customer(Integer customerId, String name, String address, String phone, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
