/**
 * 
 */
package ma.ht.springboot.app.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ht.springboot.app.service.PutMessageService;

/**
 * @author H.TARRERITI
 *
 */

@RestController
public class WSRestController {
		
	@Autowired
	PutMessageService putMessageService;
	
	@RequestMapping("/testRest")
	public String printTest() {
		
		this.putMessageService.createJmsObjects();
		return "TEST";
	}
}
