package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	Customer loginCustomer(Customer customer);
	Customer updateCustomer(Customer customer,long customerId);
	Customer getCustomerById(long customerId);
	List<Customer> getAllCustomers();
	
	void deleteCustomer(long customerId);

}
