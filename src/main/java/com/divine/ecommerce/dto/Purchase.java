package com.divine.ecommerce.dto;

import java.util.Set;

import com.divine.ecommerce.model.Address;
import com.divine.ecommerce.model.Customer;
import com.divine.ecommerce.model.Order;
import com.divine.ecommerce.model.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	
	private Set<OrderItem>orderItems;
}
