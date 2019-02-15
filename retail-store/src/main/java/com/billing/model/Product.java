package com.billing.model;

public class Product {
	
	private int id;
	private String name;
	private ProductType type;
	private double price;
	
	public Product(int id, 
				   String name, 
				   ProductType type, 
				   double price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ProductType getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
}
