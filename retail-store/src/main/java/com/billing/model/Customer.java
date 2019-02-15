package com.billing.model;

import org.joda.time.DateTime;

public class Customer {
	
	private int id;
	private String name;
	private CustomerType type;
	private DateTime membershipDate;
	
	public Customer(int id, 
					String name, 
					CustomerType type, 
					DateTime membershipDate) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.membershipDate = membershipDate;
	}

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CustomerType getType() {
		return type;
	}
	
	public DateTime getMembershipDate() {
		return membershipDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + name + ", type=" + type
				+ ", membershipDate=" + membershipDate + "]";
	}
}