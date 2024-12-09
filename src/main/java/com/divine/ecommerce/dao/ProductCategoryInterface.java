package com.divine.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.divine.ecommerce.model.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "productcategory" ,path = "product-category")
public interface ProductCategoryInterface  extends JpaRepository<ProductCategory, Long>{

}
