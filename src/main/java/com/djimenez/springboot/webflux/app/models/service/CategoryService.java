package com.djimenez.springboot.webflux.app.models.service;

import com.djimenez.springboot.webflux.app.models.documents.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {
	Mono<Category> create(Category category);
	Mono<Category> findById(String id);
	Flux<Category> findAll();
}
