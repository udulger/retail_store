package com.billing.helper;

import com.billing.model.ProductType;

public class ItemHelper {
	
	private ItemHelper() {}
	
	public static double getDiscountedPayAmount(ProductType productType, double totalPayAmount, double discountPercentage) {
		if(productType.isDiscountable() && discountPercentage > 0) {
			return (totalPayAmount - totalPayAmount * discountPercentage/100);
		}
		return totalPayAmount;
	}
}