package com.linktic.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.api.dao.CustomerDao;
import com.linktic.api.model.Customer;
import com.linktic.api.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerDao dao;
	
	@Override
	public Customer listById(Integer id) {		
		return dao.listById(id);
	}

	@Override
	public List<Customer> listPageable(int page, int size) {		
		return dao.listPageable(page, size);
	}

}
