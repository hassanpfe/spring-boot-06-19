/**
 * 
 */
package ma.ht.springboot.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author H.TARRERITI
 *
 */
public class BCryptPasswordGeneratorTest {

	/**
	 * @param args
	 */
	@Test
	public void passwordEncryptEncoderTest() {
		
		String hardPassword="hassan";
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String hashedPassword=passwordEncoder.encode(hardPassword);
		System.out.println(hashedPassword);
		
		assertTrue(passwordEncoder.matches("hassan","$2a$10$42EzGJMRhroANyQQn.Cge.X0MUwIyyVTWGePOGPDKYuSG76Ih5Uda"));
	}

}
