package com.linktic.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.linktic.api.model.Supplier;

@Repository
public class SupplierDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Supplier listById(Integer id) throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM suppliers WHERE supplier_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Supplier.class), id);
	}
	
	
	public List<Supplier> listPageable(int page, int size) {		
		int offset = (page - 1) * size;
		
		String sql = "SELECT * FROM suppliers LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Supplier.class), size, offset);
	}
	
}
