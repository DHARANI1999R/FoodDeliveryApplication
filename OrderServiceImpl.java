package com.example.demo.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderRepository orderRepository;

	
	@Autowired
	private CartService cartService;
	@Override
	public Order saveOrder(@Valid Order order,int cartId) 
	{
		Cart cart=cartService.getCartById(cartId);
		order.setCartId(cart.getCartId());
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(int orderId) {
		
		return orderRepository.findById(orderId)
				.orElseThrow(()->new ResourceNotFoundException("Order","OrderId",orderId));
		
	}

	

	@Override
	public void deleteOrder(int orderId) {
		Order existingOrder=orderRepository.findById(orderId)
				.orElseThrow(()->new ResourceNotFoundException("Order","OrderId",orderId));
		orderRepository.delete(existingOrder);
	
		
	}
	

}
