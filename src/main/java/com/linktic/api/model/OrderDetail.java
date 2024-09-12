package com.linktic.api.model;

import java.math.BigDecimal;


public class OrderDetail {
	
	private Integer orderId;

	private Integer productId;

	private BigDecimal unitPrice;

	private int quantity;
	
	public OrderDetail() {}

	public OrderDetail(Integer orderId, Integer productId, BigDecimal unitPrice, int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
