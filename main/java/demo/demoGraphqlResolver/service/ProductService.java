package demo.demoGraphqlResolver.service;

import demo.demoGraphqlResolver.model.Product;

public interface ProductService {
	Product getProduct(Long id);
	Product createProduct(Product product);
}
