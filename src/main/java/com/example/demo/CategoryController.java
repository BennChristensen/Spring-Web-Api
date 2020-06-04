package com.example.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	private CategoryRepository categoryRepository;
	private GroceryRepository groceryRepository;

	public CategoryController(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	@GetMapping("categories")
	Iterable<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	@PostMapping("categories")
	ResponseEntity<EntityModel<Category>> addCategory(@RequestBody Category newCategory) {
		categoryRepository.save(newCategory);
		EntityModel<Category> categoryModel = new EntityModel<Category>(newCategory);
		return new ResponseEntity<EntityModel<Category>>(categoryModel, HttpStatus.CREATED);
	}
	
	@GetMapping("categories/{id}")
	EntityModel<Category> getCategory(@PathVariable Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
		EntityModel<Category> categoryModel = new EntityModel<Category>(category);
		categoryModel.add(linkTo(methodOn(CategoryController.class).getCategory(id)).withSelfRel());
		categoryModel.add(linkTo(methodOn(CategoryController.class).getCategories()).withRel("categories"));
		return categoryModel;	
	}
	
	@GetMapping("categories/{id}/groceries")
	Iterable<Grocery> getGroceries(@PathVariable Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
		return category.getGroceries();
	}

}
