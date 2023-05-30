package com.djimenez.springboot.webflux.app.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djimenez.springboot.webflux.app.models.dao.CategoryDao;
import com.djimenez.springboot.webflux.app.models.documents.Category;
import com.djimenez.springboot.webflux.app.models.service.CategoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Mono<Category> create(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public Mono<Category> findById(String id) {
		return categoryDao.findById(id);
	}

	@Override
	public Flux<Category> findAll() {
		return categoryDao.findAll();
	}

}
