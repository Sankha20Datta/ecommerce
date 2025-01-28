package com.divine.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.divine.ecommerce.dto.Purchase;
import com.divine.ecommerce.dto.PurchaseResponse;
import com.divine.ecommerce.service.CheckOutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {

	
	private CheckOutService checkoutservice;
	
	@Autowired
	public CheckOutController (CheckOutService checkoutservice) {
		this.checkoutservice=checkoutservice;
	}
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		System.out.println("Received Purchase: " + purchase);
		PurchaseResponse purchaseresponse = checkoutservice.placeOrder(purchase);
		return purchaseresponse;
	}
	
}
