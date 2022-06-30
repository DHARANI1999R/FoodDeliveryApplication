package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payment_table")
@Data
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id") 
	private int paymentId;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "card_name")
	private String cardName;
	
	@Column(name = "cvv")
	private int cvv;
	
	@Column(name = "expiry_year")
	private String expiryYear;

	@Column(name = "upi")
	private String upi;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "total_payment")
	private int totalPayment;
	
	
	
	
	
	
	
	
}
