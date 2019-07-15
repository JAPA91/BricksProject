package com.bricks.order.service;

import java.util.List;

import com.bricks.order.model.CustomerOrder;

public interface CustomerService {

	public List<CustomerOrder> getCustomers();

	public void saveCustomer(CustomerOrder theCustomer);

	public CustomerOrder getCustomer(int theId);

	
	
}
