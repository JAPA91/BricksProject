package com.bricks.order.service;

import java.util.List;

import com.bricks.order.entity.CustomerOrder;

public interface CustomerService {

	public List<CustomerOrder> getOrders();

	public void createUpdateOrder(CustomerOrder theCustomer);
	
	public void updateOrderById(int theOrderId);

	public CustomerOrder getOrder(int theOrderId);
	
}
