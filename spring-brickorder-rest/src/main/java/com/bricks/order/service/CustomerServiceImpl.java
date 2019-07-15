package com.bricks.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bricks.order.dao.CustomerDAO;
import com.bricks.order.entity.CustomerOrder;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<CustomerOrder> getOrders() {
		return customerDAO.getOrders();
	}

	@Override
	@Transactional
	public void createUpdateOrder(CustomerOrder theCustomer) {

		customerDAO.createUpdateOrder(theCustomer);
	}
	
	@Override
	@Transactional
	public void updateOrderById(int theId) {

		customerDAO.updateOrderById(theId);
	}

	@Override
	@Transactional
	public CustomerOrder getOrder(int theId) {
		
		return customerDAO.getOrder(theId);
	}

}





