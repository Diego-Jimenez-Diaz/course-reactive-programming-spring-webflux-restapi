package com.djimenez.springboot.webflux.app.models.service;

import com.djimenez.springboot.webflux.app.models.documents.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	Mono<Product> save(Product product);
	Flux<Product> findAll();
	Mono<Product> findById(String id);
	Mono<Void> delete(String id);
}
