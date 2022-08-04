
public class Store {
	
	//Data fields
	private int product_id;
	private int store_id;
	private double price_per_product;
	private int product_stock;
	private int qty_being_bought;
	
	public Store () {
		
		this.product_id = 0;
		this.store_id = 0;
		this.price_per_product = 0;
		this.product_stock = 0;
		this.qty_being_bought = 0;
		
	}
	
	//GETTERS
	public int getProduct_id() {
		return this.product_id;
	}
	
	public int getStore_id() {
		return this.store_id;
	}
	
	public double getPrice_per_product() {
		return this.price_per_product;
	}
	
	public int getProduct_stock() {
		return this.product_stock;
	}
	
	public int getQty_being_bought() {
		return this.qty_being_bought;
	}
	
	//SETTERS
	public void setProduct_id(int A){
		this.product_id = A;
	}
	
	public void setStore_id(int A){
		this.store_id = A;
	}
	
	public void setPrice_per_product(double A){
		this.price_per_product = A;
	}
	
	public void setProduct_stock(int A){
		this.product_stock = A;
	}
	
	public void setQty_being_bought(int A){
		this.qty_being_bought = A;
	}

}
