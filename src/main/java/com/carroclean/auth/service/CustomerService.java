package com.carroclean.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.carroclean.auth.model.Customer;
import com.carroclean.auth.repository.CustomerRepository;

@Service
public class CustomerService extends AbstractService<Customer> {

	@Autowired
	private CustomerRepository repository;

	@Override
	protected MongoRepository<Customer, String> getRepository() {
		return repository;
	}

	public Customer findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	public List<Customer> findByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

}
