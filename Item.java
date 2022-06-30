package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="item_table")
@Data
public class Item 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name",unique=true) 
	@NotEmpty
	@Size(min=2 , message="Itemname must contain atleast 2 characters")
	public String itemName;
	
	@Column(name="item_price")
	@NotNull
	public int itemPrice;

}
