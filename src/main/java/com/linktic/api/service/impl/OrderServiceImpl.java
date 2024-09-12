package com.linktic.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.api.dao.OrderDao;
import com.linktic.api.model.Order;
import com.linktic.api.model.OrderDetail;
import com.linktic.api.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	
	@Autowired
	private OrderDao dao;
	
		
	@Override
	public Order create(Order order) {		
		return dao.create(order);
	}

	@Override
	public Order listById(Integer id) {	
		Order order = dao.listById(id);
		//order.setOrderDetails(this.listDetails(order.getOrderId()));;		
		return order;
	}

	@Override
	public List<Order> listPageable(int page, int size) {		
		return dao.listPageable(page, size);
	}

	@Override
	public List<OrderDetail> listDetails(Integer orderId) {		
		return dao.listDetails(orderId);
	}

}
