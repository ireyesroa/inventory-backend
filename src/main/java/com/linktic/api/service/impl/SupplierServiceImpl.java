package com.linktic.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.api.dao.SupplierDao;
import com.linktic.api.model.Supplier;
import com.linktic.api.service.ISupplierService;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private SupplierDao dao;
	
	@Override
	public Supplier listById(Integer id) {
		return dao.listById(id);
	}

	@Override
	public List<Supplier> listPageable(int page, int size) {
		return dao.listPageable(page, size);
	}

}
