import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class QueryClass {

	public QueryClass() {
		// do nothing
	}

	// methods
	public void printPaymentMethod(String[] lala) {

		System.out.println(String.format("%-10s %-10s %-10s %-10s", "1. " + lala[0] + " ", "2. " + lala[1] + " ",
				"3. " + lala[2] + " ", "4. " + lala[3] + " "));

	}

	public void printCategory(String[] lala) {
		// iterate through the array and print nicely the categories
		int count = 1;
		for (int i = 0; i < 5; i++) {

			System.out.println(String.format("%-10s %-10s %-10s %-10s", (count) + ". " + lala[count - 1] + " ",
					(count + 1) + ". " + lala[count] + " ", (count + 2) + ". " + lala[count + 1] + " ",
					(count + 3) + ". " + lala[count + 2] + " "));
			System.out.println();
			count = count + 4;

		}
	}

	public void printProductList(Statement s, ResultSet result, String userCat) throws SQLException {

		// create the query to get the list of products in that category
		String q = "select product_id, product_description from product where product_category = " + "'" + userCat + "'"
				+ " order by product_id asc";

		// test using the same statement for 2 different things
		result = s.executeQuery(q); // need to traverse each resultset from the same statement one
									// at a time

		if (!result.next()) {
			System.out.println("No result");
			result.close();
		}

		else {
			// Put the header
			System.out.println(String.format("%-15s %-30s", "Product ID", "Product Description"));
			System.out.println("----------     ----------------------   ");

			do {
				// Print one tuple at a time
				System.out.println(String.format("%-15s %-30s", result.getString("product_id"),
						result.getString("product_description")));

				CheckClass.checkArray.add(result.getString("product_id"));

			} while (result.next());

			result.close(); // close the result set every time you are done

		}

	}

	public boolean printStoreList(Statement s, ResultSet result, int product_id)
			throws SQLException, InterruptedException {

		// print out a list from sold_at where the user can pick the store with the best
		// price. Sort by lowest price
		String q = "select store_id, store.STORE_TYPE, store.STORE_ADDRESS, product_size, price_per_product, stock "
				+ "from store natural join sold_at " + "where product_id = " + product_id
				+ " order by PRICE_PER_PRODUCT";

		// test using the same statement for 2 different things
		result = s.executeQuery(q); // need to traverse each resultset from the same statement one
									// at a time

		if (!result.next()) {
			System.out.println("Sorry, we do not have that product available");
			System.out.println();
			result.close();
			// take the user back to selection
			return true;
		}

		else {
			System.out.println("Select the store_id where you would like to make the purchase ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
			// Put the header
			System.out.println(String.format("%-10s %-20s %-28s %-15s %-25s %-20s", "Store ID", "Store Name",
					"Store Address", "Product Size", "Price per product", "Stock"));
			System.out.println(
					"--------   --------------       --------------               -------------   -----------------         ------");

			do {
				// Print one tuple at a time
				System.out.println(String.format("%-10s %-20s %-28s %-15s %-25s %-20s", result.getString("store_id"),
						result.getString("store_type"), result.getString("store_address"),
						result.getString("product_size"), result.getString("price_per_product"),
						result.getString("stock")));

				CheckClass.checkArray.add(result.getString("store_id"));

			} while (result.next());

			result.close(); // close the result set every time you are done

			return false;

		}

	}

	public Object[] storeProductInfo(Statement s, ResultSet result, int product_id, int store_id) throws SQLException {

		Object[] numbers = new Object[2];

		// store the price of the product by quering for that price. Note there might be
		// an issue where the store sells two of the same
		String q = "select price_per_product, stock from sold_at where store_id = " + store_id + " and product_id = "
				+ product_id;

		// test using the same statement for 2 different things
		result = s.executeQuery(q); // need to traverse each resultset from the same statement one
									// at a time

		if (!result.next()) {
			System.out.println("Sorry, we couldnt find the price");
			result.close();

			return numbers;

		}

		else {

			numbers[0] = result.getDouble("price_per_product");
			numbers[1] = result.getInt("stock");

			result.close(); // close the result set every time you are done

			return numbers;

		}

	}

	public boolean previousCustomer(String customer_id, String customer_name, Statement s, ResultSet result)
			throws SQLException {

		// perform query to see if the user exists
		// store the price of the product by quering for that price. Note there might be
		// an issue where the store sells two of the same
		String q = "select * from customer where customer_id = " + customer_id + " and name = " + "'" + customer_name
				+ "'";

		// test using the same statement for 2 different things
		result = s.executeQuery(q);

		if (!result.next()) {
			return false;
		}

		else {

			System.out.println("Identity confirmed, proceeding to payment");
			result.close(); // close the result set every time you are done\
			return true;

		}

	}

	public boolean previousCardPayment(String string, Statement s, String customer_id, ResultSet result,
			String payment_type) throws SQLException {
		// TODO Auto-generated method stub
		String table = "";

		// figure out what table to look at
		if (payment_type.equals("Debit Card")) {

			table = "debitcard_payment";

		} else if (payment_type.equals("Credit Card")) {

			table = "creditcard_payment";

		}

		// perform query to see if the user exists
		// store the price of the product by quering for that price. Note there might be
		// an issue where the store sells two of the same
		String q = "select payment_id, name_on_card, expiration_date from " + table + " where customer_id = "
				+ customer_id;

		// test using the same statement for 2 different things
		result = s.executeQuery(q);

		if (!result.next()) {
			return false;
		}

		else {
			// Print out the cards available in his system name and expiration date
			System.out.println(String.format("%-25s %-20s %-20s", "Payment ID", "Name on card", "Expiration date"));
			System.out.println("----------------------------------------------------------------");

			do {
				// Print one tuple at a time
				System.out.println(String.format("%-25s %-20s %-20s", result.getString("payment_id"),
						result.getString("name_on_card"), result.getString("expiration_date")));

				CheckClass.checkArray.add(result.getString("payment_id"));

			} while (result.next());

			result.close(); // close the result set every time you are done

			return true;

		}
	}

	public void insertNewPayment(int payNumber, String customer_id, Statement s, ResultSet result, Payment payment)
			throws SQLException {
		// Insert into the parent Payment relation
		String q = "insert into payment (customer_id, type_payment) values (" + customer_id + ",'"
				+ MainCode.payment_method[payNumber - 1] + "')";

		s.executeUpdate(q);

		// Update the payment id
		payment.setPayment_id(findMaxPk(2, result, s));

		String payment_id = payment.getPayment_id();
		String card_id = payment.getCard_id();
		String name_on_card = payment.getName_on_card();
		String cvv = payment.getCvv();
		String zipcode = payment.getZipcode();
		String routing_number = payment.getRouting_number();
		String bank_id = payment.getBank_account_id();
		String expiration_date = payment.getExpiration_date();

		// Insert into the child relation
		switch (payNumber) {
		case 1: // debit card

			q = "insert into debitcard_payment (payment_id, card_id, customer_id, name_on_card, expiration_date, cvv) values ("
					+ payment_id + "," + card_id + "," + customer_id + ",'" + name_on_card + "','" + expiration_date
					+ "'," + cvv + ")";

			s.executeUpdate(q);

			break;

		case 2: // credit card

			q = "insert into creditcard_payment (payment_id, card_id, customer_id, name_on_card, expiration_date, zipcode) values ("
					+ payment_id + "," + card_id + "," + customer_id + ",'" + name_on_card + "','" + expiration_date
					+ "'," + zipcode + ")";

			s.executeUpdate(q);

			break;

		case 3: // check

			q = "insert into check_payment (payment_id, customer_id, routing_number, bank_account_id) values ("
					+ payment_id + "," + customer_id + "," + routing_number + "," + bank_id + ")";

			s.executeUpdate(q);

			break;

		default:
			// do nothing
			break;
		}

	}

	private static String findMaxPk(int i, ResultSet result, Statement s) throws SQLException {

		String answer = null;
		String q = null;

		switch (i) {
		case 1: // customer_id

			q = "select customer_id from ( select a.*, max(customer_id) over () as max_pk from customer a) where customer_id = max_pk";

			// test using the same statement for 2 different things
			result = s.executeQuery(q);

			if (!result.next()) {
				System.out.println("Thing not responded");
				result.close();
			}

			else {
				// Print out the cards available in his system name and expiration date

				do {
					// store the cutomer id
					answer = result.getString("customer_id");

				} while (result.next());

				result.close(); // close the result set every time you are done

			}

			break;

		case 2: // payment id

			q = "select payment_id from ( select a.*, max(payment_id) over () as max_pk from payment a) where payment_id = max_pk";

			// test using the same statement for 2 different things
			result = s.executeQuery(q);

			if (!result.next()) {
				System.out.println("Thing not responded");
				result.close();
			}

			else {
				// Print out the cards available in his system name and expiration date

				do {
					// store the cutomer id
					answer = result.getString("payment_id");

				} while (result.next());

				result.close(); // close the result set every time you are done

			}

			break;

		}

		return answer;
	}

	public void insertNewCustomer(Statement s, ResultSet result, Customer customer) throws SQLException {

		String customer_name = customer.getName();
		String email = customer.getEmail();
		String primary_phone = customer.getPrimary_phone();
		String address = customer.getAddress();

		// Insert into the parent Payment relation
		String q = "insert into customer (name, email, primary_phone, address) values ('" + customer_name + "','"
				+ email + "'," + primary_phone + ",'" + address + "')";

		s.executeUpdate(q);

		// update the customer_id
		customer.setCustomer_id(findMaxPk(1, result, s));

	}

	public void insertNewCustomerOrder(Statement s, Payment payment, Store store) throws SQLException {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		String daty = date.toString();

		String OrderDate = formatDate(daty); // GET DATE FIGURE OUT format MM/DD/YYY
		
		int product_id = store.getProduct_id();
		int store_id = store.getStore_id();
		String payment_id = payment.getPayment_id();
		int QTY = store.getQty_being_bought();
		double price_per_product = store.getPrice_per_product();

		// Insert into the parent Payment relation
		String q = "insert into customer_order (customer_order_date, product_id, store_id, payment_id, QTY, total_sale) values ( '"
				+ OrderDate + "' ," + product_id + "," + store_id + "," + payment_id + "," + QTY + ","
				+ Math.round(QTY * price_per_product * 100.0) / 100.0 + ")";

		s.executeUpdate(q);

	}
	
	private static String formatDate(String str) {
		// yyyy-mm-dd to MM/DD/YYY
		
		//use to substring method
		String year = str.substring(0, 4);
		String month = str.substring(5,7);
		String day = str.substring(8);
			
		return month + "/" + day + "/" + year;
	}

	public void updateProductStock(Statement s, Store store) throws SQLException {
		
		int QTY = store.getQty_being_bought();
		int product_id = store.getProduct_id();
		int store_id = store.getStore_id();
		
		// Update the product stock
		String q = "update sold_at set stock = stock - " + QTY + " where product_id = " + product_id + " and store_id = "
				+ store_id;

		s.executeUpdate(q);
		
	}

}
