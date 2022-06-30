package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>
{
	

}
