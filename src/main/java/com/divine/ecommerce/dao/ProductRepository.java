package com.divine.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divine.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
