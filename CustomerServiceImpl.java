package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return  customerRepository. findByCustomerEmailIdAndCustomerPassword(customer.customerEmailId, customer.customerPassword).orElseThrow(()->new ResourceNotFoundException("Customer", "CustomerEmaildIdAndPassword",customer.customerEmailId+"and password "+customer.customerPassword));
	}

	@Override
	public Customer updateCustomer(Customer customer, long customerId) {
		// TODO Auto-generated method stub
		Customer oldCustomer=customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "CustomerId", customerId));
		oldCustomer.setCustomerContactNo(customer.getCustomerContactNo());
		oldCustomer.setCustomerEmailId(customer.getCustomerEmailId());
		oldCustomer.setCustomerPassword(customer.getCustomerPassword());
		oldCustomer.setCustomerUserName(customer.getCustomerUserName());
		oldCustomer.setDateOfBirth(customer.getDateOfBirth());
		oldCustomer.setDistrict(customer.getDistrict());
		oldCustomer.setGender(customer.getGender());
		oldCustomer.setState(customer.getState());
		oldCustomer.setZipCode(customer.getZipCode());
		customerRepository.save(oldCustomer);
		return oldCustomer;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "CustomerId", customerId));
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}



	@Override
	public void deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "CustomerId", customerId));
		customerRepository.delete(customer);
	}
		
		
		
	


}
