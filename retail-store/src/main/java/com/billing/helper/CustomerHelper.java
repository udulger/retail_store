package com.billing.helper;

import org.joda.time.DateTime;

import com.billing.model.CustomerType;

public class CustomerHelper {

	private static final int DEFAULT_LOYAlTY_FOR_YEARS = 2;
	
	private CustomerHelper() {}
	
	public static boolean isLoyalForDiscount(CustomerType type, DateTime membershipDate) {
		DateTime dateOfTwoYearBefore = getMinimumDateOfLoyality();
		return membershipDate.isBefore(dateOfTwoYearBefore) && (CustomerType.CUSTOMER == type);
	}
	
	private static DateTime getMinimumDateOfLoyality() {
		// minimum loyalty in years is 2
		return DateTime.now().minusYears(DEFAULT_LOYAlTY_FOR_YEARS);
	}
}