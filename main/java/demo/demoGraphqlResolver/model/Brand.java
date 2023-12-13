package demo.demoGraphqlResolver.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(schema="gql_demo" ,name="Brand")
public class Brand {
	@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long brandId;
private String name;
private List<Product> products;
}
