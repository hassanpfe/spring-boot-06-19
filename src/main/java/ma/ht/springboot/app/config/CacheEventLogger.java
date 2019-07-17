/**
 * 
 */
package ma.ht.springboot.app.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author H.TARRERITI
 *
 */


public class CacheEventLogger  implements CacheEventListener<Object, Object>{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> event) {
		
		
		if(logger.isDebugEnabled()) {
			logger.debug("Event Log ***-------------------------------------------------------------------*****");
			logger.debug("Cache Key : "+event.getKey()+",Event Old Value :"+event.getOldValue()+", Event new Value: "+event.getNewValue());
		}
	}
	
	

}
