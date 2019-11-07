/**
 * 
 */
package ma.ht.springboot.app.mvc;

import java.util.List;

import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ma.ht.springboot.app.model.User;
import ma.ht.springboot.app.service.NumberService;
import ma.ht.springboot.app.service.UserService;

/**
 * @author H.TARRERITI
 *
 */
@Controller
public class WelcomeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NumberService numberService;
	
	@Autowired
	CacheManager cacheManager;
	
	@RequestMapping(value="/welcome2", method=RequestMethod.GET)
	public ModelAndView welcomeMav(@RequestParam String number) {
		//model.put("message", this.message);
		ModelAndView mav=new ModelAndView("welcome");
		Long square=numberService.square(Long.valueOf(number));
		if(logger.isDebugEnabled()) {
			logger.debug("Square of {} : {}",number,square);
		}
		
		if(logger.isDebugEnabled()) {
			logger.debug("Square of {} : {}",number,square);
		}
		mav.addObject("message",square.toString());
		return mav;
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView getWelcomePage() {
		
		ModelAndView mav=new ModelAndView("welcome");
		
		return mav;
		
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLoginPage() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView mav=new ModelAndView("login");
		
		return mav;
	}
	
	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public ModelAndView getAccessDenied() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView mav=new ModelAndView("accessDenied");
		return mav;
	}
	
	
	
	
	
}
