package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadTestData {

	@Bean
	CommandLineRunner initDataBase(CategoryRepository categoryRepository, GroceryRepository groceryRepository) {
		return args -> {
			ArrayList<Category> categories = new ArrayList<Category>();
			var category1 = new Category("Mejerivarer", 10, 25);
			categories.add(category1);
			var category2 = new Category("Frugt og grønt", 20, 15);
			categories.add(category2);
			categoryRepository.saveAll(categories);
			
			var groceryItem1 = new Grocery("Mælk", 8, category1);
			var groceryItem2 = new Grocery("Yogurt", 10, category1);
			var groceryItem3 = new Grocery("Banan", 2, category2);
			var groceryItem4 = new Grocery("Melon", 18, category2);
			groceryRepository.save(groceryItem1);
			groceryRepository.save(groceryItem2);
			groceryRepository.save(groceryItem3);
			groceryRepository.save(groceryItem4);
		};
	}
}
