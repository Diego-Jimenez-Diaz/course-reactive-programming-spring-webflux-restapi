package com.djimenez.springboot.webflux.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djimenez.springboot.webflux.app.models.documents.Category;
import com.djimenez.springboot.webflux.app.models.service.CategoryService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public Flux<Category> getAll() {
		return categoryService.findAll();
	}
}
