/**
 * 
 */
package ma.ht.springboot.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ht.springboot.app.model.User;

/**
 * @author H.TARRERITI
 *
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

	 User findByEmail(String email);
	 
	 /* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	
	 List<User> findAll();
	 
}
