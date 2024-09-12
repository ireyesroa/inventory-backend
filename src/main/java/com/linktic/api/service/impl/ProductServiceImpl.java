package com.linktic.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.api.dao.ProductDao;
import com.linktic.api.model.Product;
import com.linktic.api.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductDao dao;

	@Override
	public Product create(Product product) {		
		return dao.create(product);
	}

	@Override
	public Product listById(Integer id) {		
		return dao.listById(id);
	}

	@Override
	public List<Product> listPageable(int page, int size) {		
		return dao.listPageable(page, size);
	}

}
