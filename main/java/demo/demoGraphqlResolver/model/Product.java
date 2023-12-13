package demo.demoGraphqlResolver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "gql_demo", name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String name;
	private Double price;
	@OneToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
//	private ProductBlueprint productBlueprint;
//	
//	public ProductBlueprint getProductBlueprint() {
//		return productBlueprint;
//	}
//
//	public void setProductBlueprint(ProductBlueprint productBlueprint) {
//		this.productBlueprint = productBlueprint;
//	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public Product() {}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}


