/**
 * 
 */
package ma.ht.springboot.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ht.springboot.app.model.Role;

/**
 * @author H.TARRERITI
 *
 */

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(String role);
} 
