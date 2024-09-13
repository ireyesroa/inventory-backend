package com.linktic.api.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Entity that representation products in the project")
public class Product {

	@ApiModelProperty(value = "primary key product identifier", required = true)
	private Integer productId;

	@ApiModelProperty(value = "unique identification product", required = true)
	private String sku;
	
	@ApiModelProperty(value = "foreing key suppliers Id", required = true)
	private Integer supplierId;
	
	@ApiModelProperty(value = "foreing key categories Id", required = true)
	private Integer categoryId;
	
	@ApiModelProperty(value = "product name")
	private String productName;

	@ApiModelProperty(value = "product unit precio")
	private BigDecimal unitPrice;
	
	@ApiModelProperty(value = "product units in stock")
	private int unitInStock;

	@ApiModelProperty(value = "identifier product discotinued")
	private boolean discontinued;

	@ApiModelProperty(value = "product picture")
	private String picture;
	
	public Product() {}

	public Product(Integer productId, String sku, Integer supplierId, Integer categoryId, String productName,
			BigDecimal unitPrice, int unitInStock, boolean discontinued, String picture) {
		super();
		this.productId = productId;
		this.sku = sku;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitInStock = unitInStock;
		this.discontinued = discontinued;
		this.picture = picture;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
