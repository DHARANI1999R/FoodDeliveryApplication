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
@Table(name="cart_table")
@Data
public class Cart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="item_quantity")
	@NotNull
	public int itemQuantity;

	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="item_id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Item item;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="customer_id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Customer customer;
	

}
