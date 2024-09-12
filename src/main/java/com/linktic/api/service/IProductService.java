package com.linktic.api.service;

import java.util.List;

import com.linktic.api.model.Product;

public interface IProductService {

	Product create(Product product);
	
	Product listById(Integer id);
	
	List<Product> listPageable(int page, int size);
	
	
}
