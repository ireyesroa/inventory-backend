package com.linktic.api.service;

import java.util.List;

import com.linktic.api.model.Order;
import com.linktic.api.model.OrderDetail;

public interface IOrderService {

	Order create(Order order);
	
	Order listById(Integer id);
	
	List<Order> listPageable(int page, int size);
	
	List<OrderDetail> listDetails(Integer orderId);
	
	
}
