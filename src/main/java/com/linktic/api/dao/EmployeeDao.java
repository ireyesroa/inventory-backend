package com.linktic.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.linktic.api.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Employee listById(Integer id) throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class), id);
	}
	
	
	public List<Employee> listPageable(int page, int size) {		
		int offset = (page - 1) * size;
		
		String sql = "SELECT * FROM employees LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class), size, offset);
	}
	
}
