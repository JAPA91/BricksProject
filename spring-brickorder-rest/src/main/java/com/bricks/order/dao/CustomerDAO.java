package com.bricks.order.dao;

import java.util.List;

import com.bricks.order.entity.CustomerOrder;

public interface CustomerDAO {

	public List<CustomerOrder> getOrders();

	public void createUpdateOrder(CustomerOrder theCustomer);

	public CustomerOrder getOrder(int theId);


	public void updateOrderById(int theId);
	
}
