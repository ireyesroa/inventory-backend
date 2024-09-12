package com.linktic.api.service;

import java.util.List;

import com.linktic.api.model.Supplier;

public interface ISupplierService {

	Supplier listById(Integer id);

	List<Supplier> listPageable(int page, int size);
}
