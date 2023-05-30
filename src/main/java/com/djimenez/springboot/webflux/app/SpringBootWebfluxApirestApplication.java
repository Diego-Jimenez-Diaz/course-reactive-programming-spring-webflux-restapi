package com.djimenez.springboot.webflux.app;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.djimenez.springboot.webflux.app.models.documents.Category;
import com.djimenez.springboot.webflux.app.models.documents.Product;
import com.djimenez.springboot.webflux.app.models.service.CategoryService;
import com.djimenez.springboot.webflux.app.models.service.ProductService;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApirestApplication implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApirestApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Eliminar documntos
		 * */
		mongoTemplate.dropCollection("categories").subscribe();
		mongoTemplate.dropCollection("products").subscribe();
		
		Category electronics = new Category("Electonics");
		Category sports = new Category("Sports");
		Category food = new Category("Food");
		Category computing = new Category("Computing");
		
		Flux.just(electronics, sports, food, computing)
		.flatMap(c -> categoryService.create(c))
		.doOnNext(c -> log.info("Category created: " + c.getId() + " " + c.getName()))
		.thenMany(Flux.just(new Product("TV LG 40", 10000.00, electronics),
					new Product("TV LG 65", 30000.00, electronics),
					new Product("Sony Camera", 15000.00, electronics),
					new Product("Iphone 14", 29000.00, electronics),
					new Product("MacBook Pro", 20000.00, computing),
					new Product("Lenovo Legion 5", 25000.00, computing),
					new Product("Lenovo Legion 7i", 24000.00, computing),
					new Product("Apple Watch 7", 22000.00, electronics),
					new Product("Iphone 13", 14000.00, electronics),
					new Product("Monitor Lg", 8000.00, electronics),
					new Product("Samsung S21", 10000.00, electronics)))
		.flatMap(p -> {
			p.setCreateAt(LocalDate.now());
			return productService.save(p);
		})
		.subscribe(p -> log.info("Product created: " + p.getId() + " " + p.getName()));
		
	}

}
