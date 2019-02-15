package com.billig.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import com.billing.helper.ItemHelper;
import com.billing.main.BillingProvider;
import com.billing.model.LineItem;
import com.billing.model.Product;

public class LineItemTest {

	@Test
	public void testForZeroDiscountPercentage() {
		Product product = BillingProvider.getDiscountableProduct();
		assertNotNull(product);
		assertNotNull(product.toString());
		LineItem item = new LineItem(product, 4);
		assertNotNull(item);
		assertNotNull(item.toString());
		Assert.assertEquals(397.68, ItemHelper.getDiscountedPayAmount(item.getProduct().getType(), item.getTotalPayAmount(), 0), 0);	
	}

	@Test
	public void testForDiscountableProductType() {
		Product product = BillingProvider.getDiscountableProduct();
		assertNotNull(product);
		assertNotNull(product.toString());
		LineItem item = new LineItem(product, 4);
		assertNotNull(item);
		assertNotNull(item.toString());
		Assert.assertEquals(377.796, ItemHelper.getDiscountedPayAmount(item.getProduct().getType(), item.getTotalPayAmount(), 5), 0.1);
	}
	
	@Test
	public void testForNonDiscountableProductType() {
		Product product = BillingProvider.getNonDiscountableProduct();
		assertNotNull(product);
		assertNotNull(product.toString());
		LineItem item = new LineItem(product, 4);
		assertNotNull(item);
		assertNotNull(item.toString());
		Assert.assertEquals(183.48, ItemHelper.getDiscountedPayAmount(item.getProduct().getType(), item.getTotalPayAmount(), 5), 0);
	}
}