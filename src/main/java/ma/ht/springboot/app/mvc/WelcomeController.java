/**
 * 
 */
package ma.ht.springboot.app.mvc;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCache;
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
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NumberService numberService;
	
	@Autowired
	CacheManager cacheManager;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcomeMav(@RequestParam String number) {
		//model.put("message", this.message);
		ModelAndView mav=new ModelAndView("welcome");
		BigDecimal square=numberService.square(BigDecimal.valueOf(Double.valueOf(number)));
		if(logger.isDebugEnabled()) {
			logger.debug("Square of {} : {}",number,square);
		}
		
		if(logger.isDebugEnabled()) {
			logger.debug("Square of {} : {}",number,square);
		}
		mav.addObject("message",square.toString());
		return mav;
	}
	
	@RequestMapping(value="/welcome2",method=RequestMethod.GET)
	@ResponseBody
	public String getWelcomePage() {

		JCacheCache cache= (JCacheCache) cacheManager.getCache("squareCache");
		if(logger.isDebugEnabled()) {
			logger.debug("square cache number : {} ",cache.get("number"));
			cache.get("number");
		}
		return "OK";
	}
}
