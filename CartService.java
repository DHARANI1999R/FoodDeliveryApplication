package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Cart;

public interface CartService 
{

	Cart saveCart(@Valid Cart cart,int itemId,long customerId);

	List<Cart> getAllCarts();

	Cart getCartById(int cartId);

	void deleteCart(int cartId);
	

}
