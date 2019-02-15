package com.billing.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.billing.main.BillingProvider;
import com.billing.model.Customer;
import com.billing.model.LineItem;
import com.billing.model.Order;
import com.billing.services.BillingService;
import com.billing.services.BillingServiceImpl;

public class BillingServiceImplTest {
	
	private BillingService billingService;
	private List<LineItem> lineItemList;
	
	@Before
	public void init() {
		billingService = new BillingServiceImpl();
		lineItemList = BillingProvider.getItemList();
	}
	
	@Test
	public void testForDiscountEligibleCustomer() {
		Customer customer = BillingProvider.getCustomerWithMoreThanTwoYearsMembership();
		assertNotNull(customer);
		Order order = new Order(1, customer, lineItemList);
		assertNotNull(order);
		assertNotNull(order.toString());
		Assert.assertEquals(1119.00, billingService.getTotalPayAmount(order), 0);
	}
	
	@Test
	public void testForNonEligibleCustomer() {
		Customer customer = BillingProvider.getCustomerWithLessThanTwoYearsMembership();
		assertNotNull(customer);
		Order order = new Order(2, customer, lineItemList);
		assertNotNull(order);
		assertNotNull(order.toString());
		Assert.assertEquals(1164.00, billingService.getTotalPayAmount(order), 0);
	}
	
	@Test
	public void testForAffiliate() {
		Customer customer = BillingProvider.getAffiliate();
		assertNotNull(customer);
		Order order = new Order(3, customer, lineItemList);
		assertNotNull(order);
		assertNotNull(order.toString());
		Assert.assertEquals(1069.00, billingService.getTotalPayAmount(order), 0);
	}
	
	@Test
	public void testForEmployee() {
		Customer customer = BillingProvider.getEmployee();
		assertNotNull(customer);
		Order order = new Order(4, customer, lineItemList);
		assertNotNull(order);
		assertNotNull(order.toString());
		Assert.assertEquals(880.00, billingService.getTotalPayAmount(order), 0);
	}
}