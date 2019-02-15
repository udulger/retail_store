package com.billig.model;

import org.junit.Test;

import com.billing.helper.CustomerHelper;
import com.billing.main.BillingProvider;
import com.billing.model.Customer;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;

public class CustomerTest {
	
	@Test
	public void testForNonEmployee() {
		Customer customer = BillingProvider.getAffiliate();
		assertNotNull(customer);
		assertNotNull(customer.toString());
		Assert.assertFalse(CustomerHelper.isLoyalForDiscount(customer.getType(), customer.getMembershipDate()));
	}
	
	@Test
	public void testForMoreThanTwoYearsMembers() {
		Customer customer = BillingProvider.getCustomerWithMoreThanTwoYearsMembership();
		assertNotNull(customer);
		assertNotNull(customer.toString());
		Assert.assertTrue(CustomerHelper.isLoyalForDiscount(customer.getType(), customer.getMembershipDate()));
	}
	
	@Test
	public void testForLessThanTwoYearsMembers() {
		Customer customer = BillingProvider.getCustomerWithLessThanTwoYearsMembership();
		assertNotNull(customer);
		assertNotNull(customer.toString());
		Assert.assertFalse(CustomerHelper.isLoyalForDiscount(customer.getType(), customer.getMembershipDate()));
	}
}