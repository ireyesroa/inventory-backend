package com.linktic.api.service;

import java.util.List;

import com.linktic.api.model.Customer;


public interface ICustomerService {

	Customer listById(Integer id);

	List<Customer> listPageable(int page, int size);

}
