package com.billing.model;

public class LineItem {
	
	private Product product;	
	private int quantity;
	private double totalPayAmount;
	
	public LineItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalPayAmount = product.getPrice() * quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public double getTotalPayAmount(){
		return totalPayAmount; 
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + ", totalPayAmount=" + totalPayAmount + "]";
	}
}