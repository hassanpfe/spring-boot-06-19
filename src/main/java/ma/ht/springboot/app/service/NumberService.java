/**
 * 
 */
package ma.ht.springboot.app.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

/**
 * @author H.TARRERITI
 *
 */

@Service
public class NumberService {

	
	public BigDecimal square(BigDecimal number) {
		BigDecimal square=number.multiply(number);
		return square;
	}
}
