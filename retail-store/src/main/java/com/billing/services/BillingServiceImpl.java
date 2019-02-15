package com.billing.services;

import java.util.List;

import com.billing.helper.CustomerHelper;
import com.billing.helper.ItemHelper;
import com.billing.model.Customer;
import com.billing.model.CustomerType;
import com.billing.model.LineItem;
import com.billing.model.Order;

public class BillingServiceImpl implements BillingService {

	@Override
	public double getTotalPayAmount(Order order) {
		double discountPercentage = getCustomerDiscountPercentage(order.getCustomer());
		double totalDiscountedPrice = getTotalDiscountedPrice(order.getLineItemList(), discountPercentage);
		 
		return Math.round(totalDiscountedPrice - getDiscountForTotalAmount(totalDiscountedPrice));
	}

	private double getCustomerDiscountPercentage(Customer customer) {
		CustomerType customerType = customer.getType();
		if(customerType == CustomerType.AFFILIATE || 
		   customerType == CustomerType.EMPLOYEE || 
		   CustomerHelper.isLoyalForDiscount(customerType, customer.getMembershipDate())) {
			return customerType.getDiscountPercentage();
		}
		return 0;
	}
	
	private double getDiscountForTotalAmount(double totalDiscountedPrice) {
		// discount for each 100 is 5
		return Math.floor(totalDiscountedPrice / 100) * 5;
	}
	
	private double getTotalDiscountedPrice(List<LineItem> lineItemList, double discountPercentage) {
		double totalDiscountedPrice = 0;
		for(LineItem item : lineItemList) {
			totalDiscountedPrice = totalDiscountedPrice + ItemHelper.getDiscountedPayAmount(item.getProduct().getType(), item.getTotalPayAmount(), discountPercentage);
		}
		return totalDiscountedPrice;
	}
}