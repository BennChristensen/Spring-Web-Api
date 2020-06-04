package com.example.demo;

public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException(long id) {
		super("Could not find category: " + id);
	}
}
