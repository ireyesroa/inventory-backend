package com.linktic.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity that representation suppliers in the project")
public class Supplier {

	@ApiModelProperty(value = "PK supplier identifier", required = true)
	private Integer supplierId;
	
	@ApiModelProperty(value = "supplier company name")
	private String companyName;
	
	@ApiModelProperty(value = "information of contact title")
	private String contactName;
	
	@ApiModelProperty(value = "principal address of supplier")
	private String address;

	@ApiModelProperty(value = "city point")
	private String city;
	
	@ApiModelProperty(value= "country of supplier")
	private String country;

	@ApiModelProperty(value = "number cellphone")
	private String phone;

	@ApiModelProperty(value = "postal code")
	private String postalCode;
	
	public Supplier() {}

	public Supplier(Integer supplierId, String companyName, String contactName, String address, String city,
			String country, String phone, String postalCode) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.postalCode = postalCode;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
	
}
