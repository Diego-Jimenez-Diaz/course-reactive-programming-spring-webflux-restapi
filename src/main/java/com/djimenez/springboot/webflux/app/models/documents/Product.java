package com.djimenez.springboot.webflux.app.models.documents;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@Document(collection = "products")
public class Product {
	
	@Id
	private String id;

	private String name;
	private double price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createAt;
	
	private Category category;
	private String photo;
	
	
	public Product(String name, Double price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
}
