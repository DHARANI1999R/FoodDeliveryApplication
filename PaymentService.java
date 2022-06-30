package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Payment;

public interface PaymentService {

	public Payment savePayment(@Valid Payment payment,int orderId);

	public List<Payment> getAllPayments();

	public Payment getPaymentById(int paymentId);

	

}
