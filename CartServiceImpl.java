package com.example.demo.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemService;
@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public Cart saveCart(@Valid Cart cart,int itemId,long customerId) 
	{
		Item item=itemService.getItemById(itemId);
		Customer customer=customerService.getCustomerById(customerId);
		cart.setItem(item);
        cart.setCustomer(customer);
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAllCarts() 
	{
		
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(int cartId) 
	{
		
		return cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart","CartId",cartId));

	}

	@Override
	public void deleteCart(int cartId) 
	{
		cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart","CartId",cartId));
		cartRepository.deleteById(cartId);
		
		
		
	}
	

}
