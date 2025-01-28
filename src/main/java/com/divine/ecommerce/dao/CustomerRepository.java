package com.divine.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divine.ecommerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
