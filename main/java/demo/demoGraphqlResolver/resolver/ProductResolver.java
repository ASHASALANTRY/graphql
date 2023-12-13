package demo.demoGraphqlResolver.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.demoGraphqlResolver.model.Product;
import demo.demoGraphqlResolver.service.ProductService;
import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class ProductResolver implements GraphQLQueryResolver{
@Autowired
ProductService productService;

	public Product getProduct(Integer id) {
		return productService.getProduct(Long.valueOf(id));
	}
}
