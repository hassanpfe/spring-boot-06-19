/**
 * 
 */
package ma.ht.springboot.app.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.ht.springboot.app.model.User;
import ma.ht.springboot.app.service.UserService;

/**
 * @author H.TARRERITI
 *
 */


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView getAdminHome() {
		
		ModelAndView mav=new ModelAndView("adminHome");
		List<User> listUsers=null;
		listUsers=userService.findAllUsers();
		ObjectMapper mapper=new ObjectMapper();
		String listJson=null;
		try {
			listJson=mapper.writeValueAsString(listUsers);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listUsers.isEmpty()) {
			mav.addObject("NoUserFound", true);
		}
		else {
			mav.addObject("listUsers", listUsers);
		}
		
//		if(listJson!=null && !listJson.isEmpty()) {
//			
//			mav.addObject("listUsers", listJson);
//		}
//		
		
		
		return mav;
	}

}
