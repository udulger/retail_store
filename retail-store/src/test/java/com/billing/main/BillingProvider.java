package com.billing.main;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.billing.model.Customer;
import com.billing.model.CustomerType;
import com.billing.model.LineItem;
import com.billing.model.Product;
import com.billing.model.ProductType;

public class BillingProvider {
	
	private static final int DEFAULT_LOYAlTY_FOR_YEARS = 2;
	
	public static Product getDiscountableProduct() {
		return new Product(1, "nongrocery1", ProductType.OTHER, 99.42);
	}
	
	public static Product getNonDiscountableProduct() {
		return new Product(2, "grocery1", ProductType.GROCERY, 45.87);
	}
	
	public static Customer getAffiliate() {
		return new Customer(0, "Affiliate1", CustomerType.AFFILIATE, new DateTime().minusYears(3));
	}
	
	public static Customer getEmployee() {
		return new Customer(1, "Employee1", CustomerType.EMPLOYEE, new DateTime().minusYears(3));
	}
	
	public static Customer getCustomerWithMoreThanTwoYearsMembership() {
		return new Customer(2, "Customer2", CustomerType.CUSTOMER, new DateTime().minusYears(DEFAULT_LOYAlTY_FOR_YEARS).minusDays(1));
	}
	
	public static Customer getCustomerWithLessThanTwoYearsMembership() {
		return new Customer(3, "Customer3", CustomerType.CUSTOMER, new DateTime().minusYears(DEFAULT_LOYAlTY_FOR_YEARS).plusDays(1));
	}
	
	public static List<LineItem> getItemList() {
		List<LineItem> lineItemlist = new ArrayList<LineItem>();
		lineItemlist.add(new LineItem(getDiscountableProduct(), 10));
		lineItemlist.add(new LineItem(getNonDiscountableProduct(), 5));
		return lineItemlist;
	}
}
