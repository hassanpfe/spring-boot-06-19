/**
 * 
 */
package ma.ht.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author H.TARRERITI
 *
 */

@Entity
@Table(name="PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="NAME")
	@NotEmpty(message = "Please provide a name")
	private String name;
	@Column(name="PRICE")
	@NotEmpty(message = "Please provide a price")
	private Double price;
	@Column(name="CATEGORY")
	@NotEmpty(message = "Please provide a price")
	private String category;
		
	/**
	 * 
	 */
	public Product() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param category
	 */
	public Product(long id, String name, Double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
}
