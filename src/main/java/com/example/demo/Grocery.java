package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Grocery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String name;
	@ManyToOne()
	@JoinColumn(name ="category_id")
	private Category category;
	private int price;
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Grocery() {}
	
	public Grocery(String name, int price, Category category) {
		this.price = price;
		this.name = name;
		this.category = category;
	}
}
