package com.example.demo.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.Payment;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import com.example.demo.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public Payment savePayment(@Valid Payment payment,int orderId) {
	
		Order order=orderService.getOrderById(orderId);
		Cart cart=cartService.getCartById(order.getCartId());
		Item item=cart.getItem();
		int price=item.getItemPrice();
		System.out.println(price);
		payment.setTotalPayment(cart.getItemQuantity()*price);
		order.setOrderStatus("Received");
		order.setPaymentStatus("Paid");
		orderRepository.save(order);
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		
		return paymentRepository.findById(paymentId)
				.orElseThrow(()->new ResourceNotFoundException("Payment","PaymentId",paymentId));
	}

	

	
}
