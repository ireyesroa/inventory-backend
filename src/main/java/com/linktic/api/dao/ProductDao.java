package com.linktic.api.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.linktic.api.model.Product;


@Repository
public class ProductDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public Product create(Product product) {

		String sql = "INSERT INTO products(product_id, discontinued, picture, product_name, "
				+ "sku, unit_in_stock, unit_price, category_id, supplier_id) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, new String[] { "product_id" });
			ps.setInt(1, this.getSequence());
			ps.setBoolean(2, product.isDiscontinued());
			ps.setString(3, product.getPicture());
			ps.setString(4, product.getProductName());
			ps.setString(5, product.getSku());
			ps.setInt(6, product.getUnitInStock());
			ps.setBigDecimal(7, product.getUnitPrice());
			ps.setInt(8, product.getCategoryId());
			ps.setInt(9, product.getSupplierId());
			return ps;
		}, keyHolder);

		Number key = keyHolder.getKey();
		product.setProductId(key != null ? key.intValue() : -1);
		
		logger.info("Successfully inserted into the product table");

		return product;
	}
	
	@Transactional
	private int getSequence() {
        final String sql = "SELECT nextval('product_seq')";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
	
	
	public Product listById(Integer id) throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM products WHERE product_id = ?";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Product.class), id);
	}
	
	
	public List<Product> listPageable(int page, int size) {		
		int offset = (page - 1) * size;
		
		String sql = "SELECT * FROM products LIMIT ? OFFSET ?";		
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class), size, offset);
	}

}
