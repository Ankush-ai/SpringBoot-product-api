package com.example.demo.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class productEntity {
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private Long price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public productEntity(String name, int id, String description, Long price) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
		this.price = price;
	}
	public productEntity(){}
	@Override
	public String toString() {
		return "productEntity [name=" + name + ", id=" + id + ", description=" + description + ", price=" + price + "]";
	}
	

}
