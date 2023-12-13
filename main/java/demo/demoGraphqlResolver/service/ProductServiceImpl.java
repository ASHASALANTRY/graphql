package demo.demoGraphqlResolver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.demoGraphqlResolver.model.Product;
import demo.demoGraphqlResolver.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
		
	}
	@Override
	public Product getProduct(Long id) {
	
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent())
			return product.get();
		// throw new RuntimeException("not working");
		return null;
		
	}
}
