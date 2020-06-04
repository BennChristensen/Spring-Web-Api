package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.hateoas.EntityModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Category {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String name;
	private int number;
	private int vat;
	@OneToMany(mappedBy = "category")
	@JsonBackReference 
	private List<Grocery> groceries;
	
	public Category() {}
	
	public Category(String name, int number, int vat) {
		this.name = name;
		this.number = number;
		this.vat = vat;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public int getVat() {
		return vat;
	}

	public long getId() {
		return id;
	}

	public List<Grocery> getGroceries() {
		return groceries;
	}
}
