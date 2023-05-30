package com.djimenez.springboot.webflux.app.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.djimenez.springboot.webflux.app.models.documents.Category;

public interface CategoryDao extends ReactiveMongoRepository<Category, String>{

}
