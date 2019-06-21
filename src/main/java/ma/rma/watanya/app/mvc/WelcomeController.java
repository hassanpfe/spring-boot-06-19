/**
 * 
 */
package ma.rma.watanya.app.mvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author H.TARRERITI
 *
 */
@Controller
public class WelcomeController {

	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcomeMav() {
		//model.put("message", this.message);
		ModelAndView mav=new ModelAndView("welcome");
		mav.addObject("message","mav working");
		return mav;
	}
	
	@RequestMapping(value="/welcome2",method=RequestMethod.GET)
	@ResponseBody
	public String getWelcomePage() {
		
		//ModelAndView mav=new ModelAndView("welcome");
		
		return "GET WELCOME";
	}
}
