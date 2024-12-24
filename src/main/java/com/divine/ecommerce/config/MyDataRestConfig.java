package com.divine.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.divine.ecommerce.model.Product;
import com.divine.ecommerce.model.ProductCategory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entitymanger;
	
	@Autowired
	public MyDataRestConfig (EntityManager entitymanger) {
		this.entitymanger=entitymanger;
	}
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub

		HttpMethod[]unSupportedMethods = {HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metadata,httpmethod)->httpmethod.disable(unSupportedMethods))
		.withCollectionExposure((metadata,httpmethod)->httpmethod.disable(unSupportedMethods));
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpmethod)->httpmethod.disable(unSupportedMethods))
		.withCollectionExposure((metadata,httpmethod)->httpmethod.disable(unSupportedMethods));
		
		exposIds(config);
	}
	private void exposIds(RepositoryRestConfiguration config) {
		
		// expose id
		// get a list of all enity classes
		Set<EntityType<?>>entities = entitymanger.getMetamodel().getEntities();
		List<Class>entityClasses = new ArrayList<>();
		for(EntityType ent:entities) {
			entityClasses.add(ent.getJavaType());
		}
		Class[]domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
	
}
