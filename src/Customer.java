
/**
 * This class will represent a customer for the BRC enterprise
 *
 * @author Gustavo Grins
 * @version 2018.05.01
 */
public class Customer {

	// DATA FIELDS
	private String name;
	private String customer_id;
	private String email;
	private String primary_phone;
	private String address;

	// CONSTRUCTOR
	public Customer() {

		this.name = null;
		this.customer_id = null;
		this.address = null;
		this.email = null;
		this.primary_phone = null;

	}

	// SETTERS
	public void setName(String A) {

		this.name = A;

	}
	
	public void setCustomer_id(String A) {

		this.customer_id = A;

	}

	public void setEmail(String A) {

		this.email = A;

	}

	public void setPrimary_phone(String A) {

		this.primary_phone = A;

	}

	public void setAddress(String A) {

		this.address = A;

	}
	
	// GETTERS
	
	public String getName() {

		return this.name;

	}
	
	public String getCustomer_id() {

		return this.customer_id;

	}

	public String getEmail() {

		return this.email;

	}

	public String getPrimary_phone() {

		return this.primary_phone;

	}

	public String getAddress() {

		return this.address;

	}
	

}
