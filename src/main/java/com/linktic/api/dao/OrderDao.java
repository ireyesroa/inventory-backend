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

import com.linktic.api.model.Order;
import com.linktic.api.model.OrderDetail;


@Repository
public class OrderDao {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Transactional
	public Order create(Order order) {
		StringBuilder sqlOrder = new StringBuilder();
		sqlOrder.append("INSERT INTO orders(order_id, order_date, ship_address, ship_city, ");
		sqlOrder.append("ship_country, ship_name, customer_id, employee_id) ");
		sqlOrder.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?) ");
		

		//insert order
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlOrder.toString(), new String[] { "order_id" });
			ps.setInt(1, this.getSequence());
			ps.setTimestamp(2, order.getOrderDate());
			ps.setString(3, order.getShipAddress());
			ps.setString(4, order.getShipCity());
			ps.setString(5, order.getShipCountry());
			ps.setString(6, order.getShipName());
			ps.setInt(7, order.getCustomerId());
			ps.setInt(8, order.getEmployeeId());
			return ps;
		}, keyHolder);

		Number key = keyHolder.getKey();
		order.setOrderId(key != null ? key.intValue() : -1);
		
		logger.info("Successfully inserted into the order table");
		
		StringBuilder sqlDetail = new StringBuilder();
				
		//insert details
		if (order.getOrderDetails() != null) {
			order.getOrderDetails().forEach(detail -> {
				
				sqlDetail.append("INSERT INTO order_details(order_id, product_id, quantity, unit_price) ");		
				sqlDetail.append("VALUES(?, ?, ?, ?) ");
				
				jdbcTemplate.update(sqlDetail.toString(), order.getOrderId(), detail.getProductId(), detail.getQuantity(),
						detail.getUnitPrice());
				
			});
		}
		
		logger.info("Successfully inserted into the order details table");

		return order;
	}
	
	
	public Order listById(Integer id) throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM orders WHERE order_id = ?";		
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Order.class), id);
	}
	
	
	public List<Order> listPageable(int page, int size) {		
		int offset = (page - 1) * size;
		
		String sql = "SELECT * FROM orders LIMIT ? OFFSET ?";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Order.class), size, offset);
	}
	
	
	public List<OrderDetail> listDetails(Integer orderId) {
		String sql = "SELECT * FROM order_details WHERE order_id = ?";		
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderDetail.class));
	}
	
	
	@Transactional
	private int getSequence() {
        final String sql = "SELECT nextval('order_seq')";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
