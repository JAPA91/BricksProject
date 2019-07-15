package com.bricks.order.model;

public class CustomerOrder {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int bricksQuantity;
	
	private String status;
	
	

	public CustomerOrder() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getBricksQuantity() {
		return bricksQuantity;
	}

	public void setBricksQuantity(int bricksQuantity) {
		this.bricksQuantity = bricksQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", bricksQuantity=" + bricksQuantity + ", status=" + status + "]";
	}

	

		
}





