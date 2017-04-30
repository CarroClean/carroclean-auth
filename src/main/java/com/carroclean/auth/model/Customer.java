package com.carroclean.auth.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer extends AbstractModel {

	private static final long serialVersionUID = 1L;

	public String firstName;
	public String lastName;

	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", getId(), firstName, lastName);
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

}
