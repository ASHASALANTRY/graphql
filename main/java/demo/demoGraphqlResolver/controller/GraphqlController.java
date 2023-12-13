package demo.demoGraphqlResolver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import demo.demoGraphqlResolver.model.Brand;
import demo.demoGraphqlResolver.model.Product;
import demo.demoGraphqlResolver.service.ProductService;

@Controller
public class GraphqlController {
	@Autowired
	ProductService productService;
	
@QueryMapping
public /* DataFetcherResult<Product> */Product getProduct(
		@Argument("id") Integer id/* , GraphQLContext graphQLContext */) {
	        return productService.getProduct(Long.valueOf(id));
//	        		DataFetcherResult
//	        		.<Product>newResult().data(productService.getProduct(Long.valueOf(id)))
//	        		.error(new GenericGraphQLError("partial response from db"))
//	        		.build();
	    }

@SchemaMapping(typeName = "Mutation")
public /* DataFetcherResult<Product> */Product createProduct(
		 @Argument("product") Product product/* , GraphQLContext graphQLContext */) {
	        return productService.createProduct(product);
}

@SchemaMapping(typeName = "Mutation")
public Brand brand(Brand brand){
	return null;
}}