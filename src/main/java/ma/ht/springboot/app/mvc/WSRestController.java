/**
 * 
 */
package ma.ht.springboot.app.mvc;

import java.util.List;

import javax.validation.Valid;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ht.springboot.app.model.Product;
import ma.ht.springboot.app.model.ResponseAddProduct;
import ma.ht.springboot.app.model.User;
import ma.ht.springboot.app.service.ProductService;
import ma.ht.springboot.app.service.UserService;

/**
 * @author H.TARRERITI
 *
 */

@RestController
public class WSRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/restUsers")
	public List<User> getListUsers(){
		
		return  userService.findAllUsers();
	}
	
	
	@PostMapping(value="/addProduct")
	public ResponseEntity<ResponseAddProduct> addProduct(@Valid Product product){
		ResponseAddProduct response= new ResponseAddProduct();
		try {
			response.setProduct(product);
			productService.addProduct(product);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(response);
		}
		response.setStatus(HttpStatus.OK.toString());
		response.setMessage("Product added successfully");
		return ResponseEntity.status(HttpStatus.OK)
				.body(response);
	}
	
	@PostMapping(value="/listProduct")
	@ResponseBody
	public ResponseEntity<List<Product>> listProduct(){
		ResponseAddProduct response= new ResponseAddProduct();
		List<Product> listProducts=null;
		try {
			
			listProducts= productService.listProduct();
			
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(listProducts);
		}
		response.setStatus(HttpStatus.OK.toString());
		response.setMessage("Product added successfully");
		return ResponseEntity.status(HttpStatus.OK)
				.body(listProducts);
	}

}
