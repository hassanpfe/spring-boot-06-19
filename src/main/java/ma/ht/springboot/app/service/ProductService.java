/**
 * 
 */
package ma.ht.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ht.springboot.app.model.Product;
import ma.ht.springboot.app.repos.ProductRepository;

/**
 * @author H.TARRERITI
 *
 */
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public ProductService(){
		
	}
	
	public Product addProduct(Product p) {
		return productRepository.save(p);
	}
	
	public List<Product> listProduct(){
		return productRepository.findAll();
	}
}
