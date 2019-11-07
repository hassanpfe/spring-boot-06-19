/**
 * 
 */
package ma.ht.springboot.app.model;

/**
 * @author H.TARRERITI
 *
 */
public class ResponseAddProduct {

	private String status;
	private String message;
	private Product product;
	/**
	 * 
	 */
	public ResponseAddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param status
	 * @param message
	 * @param product
	 */
	public ResponseAddProduct(String status, String message, Product product) {
		super();
		this.status = status;
		this.message = message;
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
