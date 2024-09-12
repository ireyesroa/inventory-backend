package com.linktic.api.service;

import java.util.List;

import com.linktic.api.model.Employee;

public interface IEmployeeService {
	
	Employee listById(Integer id);

	List<Employee> listPageable(int page, int size);

}
