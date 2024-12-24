package com.divine.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.divine.ecommerce.model.ProductCategory;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productcategory" ,path = "product-category")
public interface ProductCategoryInterface  extends JpaRepository<ProductCategory, Long>{
}
