package com.linktic.api.service;


import java.util.List;

import com.linktic.api.model.Category;

public interface ICategoryService {

	Category listById(Integer id);
	
	List<Category> listPageable(int page, int size);
	
}
