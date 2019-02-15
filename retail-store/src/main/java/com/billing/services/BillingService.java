package com.billing.services;

import com.billing.model.Order;

public interface BillingService {
	double getTotalPayAmount(Order order);
}
