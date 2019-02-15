package com.billing.model;

public enum ProductType {

	GROCERY(false),
    OTHER(true);
	
	private boolean isDiscountable;
	
	ProductType(boolean isDiscountable) {
		this.isDiscountable = isDiscountable;
	}
	
	public boolean isDiscountable() {
		return isDiscountable;
	}
}
