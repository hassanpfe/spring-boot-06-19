/**
 * 
 */
package ma.rma.watanya.app.mvc;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author h.tarreriti
 *
 */
@Controller
public class AppErrorController implements ErrorController {

	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.error.ErrorController#getErrorPath()
	 */
	@Override
	@RequestMapping("/error")
    @ResponseBody
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "No Mappings Found";
	}

}
