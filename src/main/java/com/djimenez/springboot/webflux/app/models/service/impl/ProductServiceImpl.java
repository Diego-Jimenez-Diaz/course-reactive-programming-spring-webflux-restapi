package com.djimenez.springboot.webflux.app.models.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djimenez.springboot.webflux.app.models.dao.ProductDao;
import com.djimenez.springboot.webflux.app.models.documents.Product;
import com.djimenez.springboot.webflux.app.models.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao; 
	
	@Override
	public Mono<Product> save(Product product) {
		product.setCreateAt(LocalDate.now());
		return productDao.save(product);
	}

	@Override
	public Flux<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Mono<Product> findById(String id) {
		return productDao.findById(id);
	}

	@Override
	public Mono<Void> delete(String id) {
		return productDao.deleteById(id);
	}

}
