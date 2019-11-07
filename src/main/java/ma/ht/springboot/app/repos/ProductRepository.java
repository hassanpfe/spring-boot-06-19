/**
 * 
 */
package ma.ht.springboot.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ht.springboot.app.model.Product;

/**
 * @author H.TARRERITI
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
