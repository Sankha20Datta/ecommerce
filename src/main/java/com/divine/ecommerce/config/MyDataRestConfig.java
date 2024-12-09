package com.divine.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.divine.ecommerce.model.Product;
import com.divine.ecommerce.model.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub

		HttpMethod[]theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((metadata,httpmethods)->httpmethods.disable(theUnsupportedActions))
				.withCollectionExposure((metadata,httpmethods)->httpmethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpmethods)->httpmethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata,httpmethods)->httpmethods.disable(theUnsupportedActions));
		
	}
	
}
