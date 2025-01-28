package com.divine.ecommerce.service;

import com.divine.ecommerce.dto.Purchase;
import com.divine.ecommerce.dto.PurchaseResponse;

public interface CheckOutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
