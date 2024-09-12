package com.linktic.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.linktic.api.model.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Customer listById(Integer id) throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM customers WHERE customer_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Customer.class), id);
	}
	
	
	public List<Customer> listPageable(int page, int size) {		
		int offset = (page - 1) * size;
		
		String sql = "SELECT * FROM customers LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class), size, offset);
	}
	
}
