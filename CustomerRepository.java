package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	Optional<Customer> findByCustomerEmailIdAndCustomerPassword(String emailId,String password);

	


}
