package com.carroclean.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carroclean.auth.model.Customer;
import com.carroclean.auth.service.AbstractService;
import com.carroclean.auth.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController extends AbstractController<Customer> {

	@Autowired
	private CustomerService service;

	@Override
	protected AbstractService<Customer> getService() {
		return service;
	}

}
