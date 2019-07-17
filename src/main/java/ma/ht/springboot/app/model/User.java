/**
 * 
 */
package ma.ht.springboot.app.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author H.TARRERITI
 *
 */

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="LOGIN")
	@NotEmpty(message = "*Please provide your login")
	private String login;
	@Column(name="PASSWORD")
	@NotEmpty(message = "*Please provide your password")
	private String password;
	@Column(name="FIRSTNAME")
	@NotEmpty(message = "*Please provide your name")
	private String firstName;
	@Column(name="LASTNAME")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	@Column(name="BIRTHDATE")
	private Date birthDate;
	@Column(name="ROLE")
	private String role;
	@Column(name="EMAIL")
	private String email;
	
	@Column(name = "ACTIVE")
    private int active;
	
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "IDUSER"), inverseJoinColumns = @JoinColumn(name = "IDROLE"))
	private Set<Role> roles;
	/**
	 * 
	 */
	public User() {
		
	}
	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param role
	 */
	
	
	public static class Builder{
		
		private Long id;
		private String login;
		private String password;
		private String firstName;
		private String lastName;
		private String email;
		private Date birthDate;
		private String role;
		private int active;
		private Set<Role> roles;
		
		
		public Builder() {
			
		}
		public Builder withId(Long id) {
			this.id=id;
			return this;
		}
		
		public Builder withLogin(String login) {
			this.login=login;
			return this;
		}
		
		public Builder withPassword(String password) {
			this.password=password;
			return this;
		}
		
		public Builder withFirstName(String firstName) {
			this.firstName=firstName;
			return this;
		}
		
		public Builder withLastName(String lastName) {
			this.lastName=lastName;
			return this;
		}
		
		public Builder withBirthDate(Date birthDate) {
			this.birthDate=birthDate;
			return this;
		}
		
		public Builder withRole(String role) {
			this.role=role;
			return this;
		}
		
		public Builder withActive(int active) {
			this.active=active;
			return this;
		}
		
		public Builder withRoles(Set<Role> roles) {
			this.roles=roles;
			return this;
		}
		
		public Builder withEmail(String email) {
			this.email=email;
			return this;
		}
		
		public User build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
			User user = new User();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
			user.id = this.id;
			user.login = this.login;
			user.password = this.password;
			user.firstName = this.firstName;
			user.lastName = this.lastName;
			user.birthDate = this.birthDate;
			user.role = this.role;
			user.active = this.active;
			user.roles = this.roles;
			user.email=this.email;
            return user;
        }
		
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}
