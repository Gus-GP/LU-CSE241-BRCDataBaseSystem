
public class Payment {

	// DATA FIELDS
	private String payment_id;
	private String payment_method;
	private String card_id;
	private String name_on_card;
	private String expiration_date;
	private String cvv;
	private String zipcode;
	private String routing_number;
	private String bank_account_id;

	// CONSTRUCTOR
	public Payment() {

		this.payment_id = null;
		this.payment_method = null;
		this.card_id = null;
		this.name_on_card = null;
		this.expiration_date = null;
		this.cvv = null;
		this.zipcode = null;
		this.routing_number = null;
		this.bank_account_id = null;

	}

	// SETTERS

	public void setPayment_id(String A) {
		this.payment_id = A;
	}

	public void setPayment_method(String A) {
		this.payment_method = A;
	}

	public void setCard_id(String A) {
		this.card_id = A;
	}

	public void setName_on_card(String A) {
		this.name_on_card = A;
	}

	public void setExpriration_date(String A) {
		this.expiration_date = A;
	}

	public void setCvv(String A) {
		this.cvv = A;
	}

	public void setZipcode(String A) {
		this.zipcode = A;
	}

	public void setRouting_number(String A) {
		this.routing_number = A;
	}

	public void setBank_account_id(String A) {
		this.bank_account_id = A;
	}
	
	//GETTERS
	public String getPayment_id() {
		return this.payment_id;
	}
	
	public String getPayment_method() {
		return this.payment_method;
	}
	
	public String getCard_id() {
		return this.card_id;
	}
	
	public String getName_on_card() {
		return this.name_on_card;
	}
	
	public String getExpiration_date() {
		return this.expiration_date;
	}
	
	public String getCvv() {
		return this.cvv;
	}
	
	public String getZipcode() {
		return this.zipcode;
	}
	
	public String getRouting_number() {
		return this.routing_number;
	}
	
	public String getBank_account_id() {
		return this.bank_account_id;
	}

}
