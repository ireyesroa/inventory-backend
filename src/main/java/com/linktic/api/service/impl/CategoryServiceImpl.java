package com.linktic.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.api.dao.CategoryDao;
import com.linktic.api.model.Category;
import com.linktic.api.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryDao dao;
	
	@Override
	public Category listById(Integer id) {
		return dao.listById(id);
	}

	@Override
	public List<Category> listPageable(int page, int size) {		
		return dao.listPageable(page, size);
	}

}
