package com.billing.model;

public enum CustomerType {
	
	EMPLOYEE(30),
	AFFILIATE(10),
	CUSTOMER(5);
	
	private double discountPercentage;
	
	CustomerType(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public double getDiscountPercentage() {
		return discountPercentage;
	}
}