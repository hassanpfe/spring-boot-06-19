/**
 * 
 */
package ma.ht.springboot.app.mvc;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ht.springboot.app.service.UserService;

/**
 * @author H.TARRERITI
 *
 */

@RestController
public class WSRestController {
	
	@Autowired
	UserService userService;
	@GetMapping(value="/restUsers")
	public Publisher<User> getListUsers(){
		
		return userService.findAllUsers();
	}

}
