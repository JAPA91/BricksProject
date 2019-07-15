package com.bricks.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bricks.order.entity.CustomerOrder;
import com.bricks.order.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /orders "getOrders" this request have all the orders
	@GetMapping("/orders")
	public List<CustomerOrder> getOrders() {

		return customerService.getOrders();

	}

	// add mapping for GET /order/{orderId} "getOrder" Request

	@GetMapping("/orders/{orderId}")
	public CustomerOrder getOrder(@PathVariable int orderId) {

		CustomerOrder theCustomerOrder = customerService.getOrder(orderId);

		if (theCustomerOrder == null) {
			throw new CustomerNotFoundException("Customer id not found - " + orderId);
		}

		return theCustomerOrder;
	}

	// add mapping for POST /orders - add new order -Stage 1

	@PostMapping("/orders")
	public CustomerOrder addCustomerOrder(@RequestBody CustomerOrder theCustomer) {

		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update

		theCustomer.setId(0);

		customerService.createUpdateOrder(theCustomer);

		return theCustomer;
	}

	// add mapping for PUT /customers - update existing orders with or without order id
	// // for Orders that has been already dispatched a msg is shown as
	// "CustomerOrder is already dispatched for orderID" else updating the
	// order details for the order

	@PutMapping("/orders")
	public CustomerOrder updateCustomer(@RequestBody CustomerOrder theCustomer) {

		if (!("Not Dispatched".equalsIgnoreCase(theCustomer.getStatus()))) {
			System.out.println(("CustomerOrder  is already dispatched for - " + theCustomer.getId()));
		} else {
			customerService.createUpdateOrder(theCustomer);
		}
		return theCustomer;

	}
	// Stage 3 & 4 for Fullfill order request if the status is "Not Dispatched" hard
	// code the value "Dispatched"
	

	@PutMapping("/orders/{orderId}")
	public String updateCustomer(@PathVariable int orderId) {

		CustomerOrder tempCustomer = customerService.getOrder(orderId);

		if (tempCustomer == null) {
			System.out.println(("CustomerOrder id not found - " + orderId));
		}

		customerService.updateOrderById(orderId);

		return "Orders has been  dispatched for -" + orderId;

	}

}
