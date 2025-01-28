package com.divine.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divine.ecommerce.dao.CustomerRepository;
import com.divine.ecommerce.dto.Purchase;
import com.divine.ecommerce.dto.PurchaseResponse;
import com.divine.ecommerce.model.Customer;
import com.divine.ecommerce.model.Order;
import com.divine.ecommerce.model.OrderItem;

import jakarta.transaction.Transactional;

@Service
public class CheckOutServiceImpl implements CheckOutService {

	private CustomerRepository customerepository;
	

	public CheckOutServiceImpl(CustomerRepository customerepository) {
		this.customerepository=customerepository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		// retrive the order info from dto
		Order order = purchase.getOrder();
		
		// generate the tracking number
		String orderTrackingNumber  = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		// populate with OrderItems
		Set <OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
		// populate order with BillingAddress and shipping Address
		
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		//populate customer with order

		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		// save in db
		customerepository.save(customer);
		
		// return response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		//generate a random UUID number
		return UUID.randomUUID().toString();
	}

}
