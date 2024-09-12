package com.linktic.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.api.dao.EmployeeDao;
import com.linktic.api.model.Employee;
import com.linktic.api.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	private EmployeeDao dao;
	
	
	@Override
	public Employee listById(Integer id) {		
		return dao.listById(id);
	}

	@Override
	public List<Employee> listPageable(int page, int size) {		
		return dao.listPageable(page, size);
	}

}
