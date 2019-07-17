/**
 * 
 */
package ma.ht.springboot.app.service;

import java.math.BigDecimal;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author H.TARRERITI
 *
 */

@Service
public class NumberService {
	
	
	@CacheEvict(allEntries = true)
    public void clearCache(){}
	
	@Cacheable(
			value = "squareCache", 
		    key = "#number", 
		    condition = "#number>10")
	public Long square(Long number) {
		BigDecimal temp=BigDecimal.valueOf(number);
		temp=temp.multiply(temp);
		Long square= temp.longValue();
		return square;
	}
}
