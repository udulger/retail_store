package com.billing.model;

import java.util.List;

public class Order {

	private int id;
	private Customer customer;
	private List<LineItem> lineItemList;
	
	public Order(int id, Customer customer, List<LineItem> lineItemList) {
		super();
		this.id = id;
		this.customer = customer;
		this.lineItemList = lineItemList;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<LineItem> getLineItemList() {
		return lineItemList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", lineItemList=" + lineItemList + "]";
	}
}
