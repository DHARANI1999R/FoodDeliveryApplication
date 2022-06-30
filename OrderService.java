package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Order;

public interface OrderService {

	public Order saveOrder(@Valid Order order, int cartId);

	public List<Order> getAllOrders();

	public Order getOrderById(int orderId);

	
	public void deleteOrder(int orderId); 

}
