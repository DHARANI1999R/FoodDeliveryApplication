package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="order_table")
@Data
public class Order 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId; 
	
	@Column(name="cart_id",unique=true)
	private int cartId;
	
    @Column(name = "order_status")
	private String orderStatus;
    
    @Column(name = "payment_status")
   	private String paymentStatus;
	  
	

	
	
	
	
}
