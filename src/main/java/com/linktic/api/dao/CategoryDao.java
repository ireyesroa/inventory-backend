package com.linktic.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.linktic.api.model.Category;

@Repository
public class CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public Category listById(Integer id) throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM categories WHERE category_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class), id);
	}
	
	
	public List<Category> listPageable(int page, int size) {		
		int offset = (page - 1) * size;
		
		String sql = "SELECT * FROM categories LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class), size, offset);
	}
	

}
