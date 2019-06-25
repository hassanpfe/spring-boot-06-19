/**
 * 
 */
package ma.ht.springboot.app.mvc;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ma.ht.springboot.app.service.NumberService;

/**
 * @author H.TARRERITI
 *
 */
@Controller
public class WelcomeController {

	
	@Autowired
	NumberService numberService;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcomeMav(@RequestParam String number) {
		//model.put("message", this.message);
		ModelAndView mav=new ModelAndView("welcome");
		BigDecimal square=numberService.square(BigDecimal.valueOf(Double.valueOf(number)));
		mav.addObject("message",square.toString());
		return mav;
	}
	
	@RequestMapping(value="/welcome2",method=RequestMethod.GET)
	@ResponseBody
	public String getWelcomePage() {
		
		//ModelAndView mav=new ModelAndView("welcome");
		
		return "GET WELCOME";
	}
}
