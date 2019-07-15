package com.bricks.order.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bricks.order.model.CustomerOrder;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTemplate;

	private String crmRestUrl;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;

		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<CustomerOrder> getCustomers() {

		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<CustomerOrder>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CustomerOrder>>() {
				});

		// get the list of customers from response
		List<CustomerOrder> customers = responseEntity.getBody();

		logger.info("in getCustomers(): customers" + customers);

		return customers;
	}

	@Override
	public CustomerOrder getCustomer(int theId) {

		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);

		// make REST call
		CustomerOrder theCustomer = restTemplate.getForObject(crmRestUrl + "/" + theId, CustomerOrder.class);

		logger.info("in saveCustomer(): theCustomer=" + theCustomer);

		return theCustomer;
	}

	@Override
	public void saveCustomer(CustomerOrder theCustomer) {

		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);

		int orderId = theCustomer.getId();

		String status = theCustomer.getStatus();
		// make REST call
		if (orderId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);

		} else {
			// update employee
		//	restTemplate.put(crmRestUrl + "/" + orderId,CustomerOrder.class);
			restTemplate.put(crmRestUrl, theCustomer);
			
		}

		logger.info("in saveCustomer(): success");
	}


}
