package com.bricks.order.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bricks.order.entity.CustomerOrder;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<CustomerOrder> getOrders() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<CustomerOrder> theQuery = 
				currentSession.createQuery("from CustomerOrder order by lastName",
						CustomerOrder.class);
		
		// execute query and get result list
		List<CustomerOrder> orderDetails = theQuery.getResultList();
				
		// return the results		
		return orderDetails;
	}

	@Override
	public void createUpdateOrder(CustomerOrder theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public CustomerOrder getOrder(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		CustomerOrder theCustomer = currentSession.get(CustomerOrder.class, theId);
		
		return theCustomer;
	}

	
	@Override
	public void updateOrderById(int theId) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("update CustomerOrder set status=:status where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.setParameter("status", "Dispatched");
		
		theQuery.executeUpdate();
	}

}











