import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainCode {

	// payment array
	static String[] payment_method = { "Debit Card", "Credit Card", "Check", "Cash" };
	// category array
	static String[] category = { "House", "Kitchen", "Speed", "Superpower", "Galactic", "Phenomeno", "Totalitarian",
			"Pizzapasta", "Venezuela", "Cantonito", "Lol", "Pretrucious", "Pulis", "Banned", "Not Banned", "Gas",
			"Granon", "Carniceria", "Pimienta", "Cebolla" };

	public static void main(String[] args) throws SQLException, IOException, java.lang.ClassNotFoundException {

		// create a checking object
		CheckClass check = new CheckClass();
		// create a store object
		Store store = new Store();
		// create a payment object
		Payment payment = new Payment();
		// create a customer object
		Customer customer = new Customer();
		// create new printing object
		QueryClass query = new QueryClass();

		// declaration/initialization of used variables to use in the insert statements
		ResultSet result = null;

		// implement this while running in console
		// Console console = System.console();//for hiding the password

		Scanner reader = new Scanner(System.in); // Reading from System.in
		// ask for DBS username
		System.out.print("enter Oracle user id: ");
		String usr = reader.next();
		usr = usr.toUpperCase();
		// ask for DBS password
		System.out.print("enter Oracle password for " + usr + ": ");
		String pswrd = reader.next();
		System.out.println();

		/*
		 * //for console use only char[] ch=console.readPassword(); String
		 * pswrd=String.valueOf(ch);//converting char array into string
		 */

		System.out.println();

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241", usr,
				pswrd); Statement s = con.createStatement();) {

			System.out.println("connection successfully made.");
			System.out.println();

			// Welcome the customer
			System.out.println("%---------------------------------%\n" + "%                                 %\n"
					+ "%  WELCOME TO Big River Crossing  %\n" + "%                                 %\n"
					+ "%---------------------------------%");
			System.out.println();
			// give a stall moment for the user to take it in
			TimeUnit.SECONDS.sleep(1);

			Boolean isIn = true;

			// This loop will be for going back in case the product is not available
			do {

				// see interest in buying
				System.out.print("Would you be interested in buying our products today (y/n)? ");

				String answer = check.checkInput(reader.next() + reader.nextLine(), 1, reader, 0);
				System.out.println();

				if (answer.equals("y")) {

					// go into the selling mode. First step show the categories
					// see interest in buying
					System.out.println("Please type the corresponding number of the category you would like to select");
					TimeUnit.SECONDS.sleep(1);
					System.out.println();

					// print categories
					query.printCategory(category);

					System.out.print("Type the number here: ");
					// take the user input
					answer = check.checkInput(reader.next() + reader.nextLine(), 2, reader, 0);

					System.out.println();

					System.out.println();

					// cast into a int
					int catNumber = Integer.parseInt(answer);

					// get the category from the array
					String userCat = category[catNumber - 1];

					// print a list of products
					query.printProductList(s, result, userCat);

					System.out.println();
					// ask the user to select the product_id of the desired product
					System.out.print("Please type the product_id you are interested in purchasing: ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 3, reader, 0);
					// set the product id for the store object
					store.setProduct_id(Integer.parseInt(answer));
					// clear the check array
					CheckClass.checkArray.clear();

					System.out.println();

					// Print out a list of stores where that product is available
					if (query.printStoreList(s, result, store.getProduct_id())) {
						// the product selected was not available
						continue;
					}

					// ask the user to select the product_id of the desired product
					System.out.println();
					System.out.print("Type store ID here: ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 3, reader, 0);
					System.out.println();
					store.setStore_id(Integer.parseInt(answer));

					CheckClass.checkArray.clear();

					// store the product information by performing a query
					Object[] temp = new Object[2];
					temp = query.storeProductInfo(s, result, store.getProduct_id(), store.getStore_id());

					// if nothing was returned
					if (temp.length == 0) {
						continue;
					}

					// store obtained values into appropriate places
					store.setPrice_per_product((double) temp[0]);
					store.setProduct_stock((int) temp[1]);

					System.out.print("How much of the product are you buying? ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 4, reader, store.getProduct_stock());

					if (answer == null) {
						continue;
					}

					System.out.println();
					store.setQty_being_bought(Integer.parseInt(answer));

					System.out.println("Your total is: $"
							+ (Math.round(store.getQty_being_bought() * store.getPrice_per_product() * 100.0) / 100.0));
					System.out.println();
					System.out.print("Would you like to proceed with the purchase? (y/n) ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 1, reader, 0);
					if (answer.equals("n")) {
						// take the user to the beginning
						System.out.println();
						continue;
					}

					// ask the user customer question
					System.out.println();
					System.out.print("Have you shopped with us before? (y/n) ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 1, reader, 0);
					System.out.println();

					// get the credentials for the user and obtain payment method
					if (answer.equals("y")) {

						// if this method fails go back to the beginning
						if (verifyUser(reader, check, query, s, result, customer)) {
							continue;
						}

					}

					// if the user has never been here before take credentials
					else if (answer.equals("n")) {

						// ask for name/email/primary phone/address
						System.out.print("Type your name: ");
						customer.setName(check.checkInput(reader.next() + reader.nextLine(), 6, reader, 0));
						System.out.print("Type your email: ");
						customer.setEmail(check.checkInput(reader.next() + reader.nextLine(), 7, reader, 0));
						System.out.print("Type your Primary phone: ");
						CheckClass.numberLength = 10; // for the checking procedure
						customer.setPrimary_phone(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));
						System.out.print("Type your billing address: ");
						customer.setAddress(check.checkInput(reader.next() + reader.nextLine(), 11, reader, 0));
						System.out.println();
						System.out.println("proceeding to payment...");

					}

					// payment procedure
					System.out.println();
					query.printPaymentMethod(payment_method);
					System.out.println();
					System.out.print("Please type the corresponding number of your payment method: ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 9, reader, 0);
					System.out.println();
					// cast into a int
					int PayNumber = Integer.parseInt(answer);
					payment.setPayment_method(payment_method[PayNumber - 1]);

					paymentProcedure(PayNumber, customer, result, s, reader, check, query, payment);

					// ask user if they want to proceed with payment
					System.out.println();
					System.out.print(
							"Do you want to finalize the purchase? (y/n) *Selecting n will bring you back to the beginning of the service*: ");
					answer = check.checkInput(reader.next() + reader.nextLine(), 1, reader, 0);
					System.out.println();

					if (answer.equals("y")) {

						// check to see if it is a returning customer
						if (customer.getCustomer_id() != null) {
							// no inserts in the customer database

							// check to see if the customer selected an old payment id
							if (payment.getPayment_id() == null) {
								// insert payment in the payment table
								query.insertNewPayment(PayNumber, customer.getCustomer_id(), s, result, payment);
								System.out.println("Your payment has been processed");
							}

							else {
								// nothing to add here
							}

						}

						// new customer
						else {

							// add the customer to the data base
							query.insertNewCustomer(s, result, customer);
							System.out.println("You were added to our customer list");
							// return the customer id and tell to keep it
							System.out.println();
							System.out.println("Your BRC customer ID is " + customer.getCustomer_id()
									+ "\n please keep this in a safe location. You will need to provide your ID for future purchases ");

							// insert payment in the payment table
							query.insertNewPayment(PayNumber, customer.getCustomer_id(), s, result, payment);
							System.out.println();
							System.out.println("Your payment has been processed");
						}

						// update the customer_order table
						query.insertNewCustomerOrder(s, payment, store);

						// update tables to reflect the new stock number
						query.updateProductStock(s, store);

						// congratulate the user for the purchase
						// go back to the beginning
						System.out.println("Congratulations on your new purchase!");
						System.out.println();

						// clear all variables from the classses
						clearVariables(payment, store, customer);

					}

					else if (answer.equals("n")) {
						// take the user back to the beginning
						System.out.println();
						continue;

					}

				}

				else if (answer.equals("n")) {
					System.out.println("Hope to see you again soon! Good Bye!");
					isIn = false;
				}

			} while (isIn);

		}

		// EXCEPTION HANDLING SECTION
		catch (Exception e) {
			// check if the error is part of SQL
			if (e instanceof SQLException) {
				// check for invalid username/password combination
				if (((SQLException) e).getErrorCode() == 1017) {
					System.out.println("Please enter a valid username and password");
				}

				else {
					System.out.println(e.getMessage());
				}
			}

			else {
				System.out.println(e.getMessage());
			}

		}

		finally {
			// close the scanner
			reader.close();
		}

	}

	private static void clearVariables(Payment payment, Store store, Customer customer) {

		//payment class
		payment.setBank_account_id(null);
		payment.setCard_id(null);
		payment.setCvv(null);
		payment.setExpriration_date(null);
		payment.setName_on_card(null);
		payment.setPayment_id(null);
		payment.setPayment_method(null);
		payment.setRouting_number(null);
		payment.setZipcode(null);
		
		//customer class
		customer.setAddress(null);
		customer.setCustomer_id(null);
		customer.setEmail(null);
		customer.setName(null);
		customer.setPrimary_phone(null);
		
		//store class
		store.setPrice_per_product(0);
		store.setProduct_id(0);
		store.setProduct_stock(0);
		store.setQty_being_bought(0);
		store.setStore_id(0);
		
		//Chekc class
		CheckClass.checkArray.clear();
		CheckClass.numberLength = 0;
	

	}

	private static void paymentProcedure(int PayNumber, Customer customer, ResultSet result, Statement s,
			Scanner reader, CheckClass check, QueryClass query, Payment payment) throws SQLException {

		String answer;
		// run switch statement to perform the corresponding query
		switch (PayNumber) {
		case 1: // Debit Card

			// make method to see if the user has a credit card
			boolean enterAll = true;

			// if there are old payments ask the user to select the card
			if (query.previousCardPayment("Debit Card", s, customer.getCustomer_id(), result,
					payment.getPayment_method())) {

				System.out.println();
				System.out.print("Would you like to use any of these stored payments? (y/n) ");
				answer = check.checkInput(reader.next() + reader.nextLine(), 1, reader, 0);
				System.out.println();

				if (answer.equals("y")) {
					enterAll = false;
					System.out.print("Please type the id of the payment you would like to use: ");
					// this will be used for the insert statement
					payment.setPayment_id(check.checkInput(reader.next() + reader.nextLine(), 3, reader, 0));

					System.out.println();

					// clear the checkArray
					CheckClass.checkArray.clear();
				}

			}

			// if there are not previous cards ask the user for card credentials
			else if (enterAll) {
				// make the user insert the info
				System.out.println("Please enter the your debit card information for the purchase  ");
				// ask for name/email/primary phone/address
				System.out.print("Type your 16 digit Bank account id: ");
				CheckClass.numberLength = 16; // for the checking procedure
				payment.setCard_id(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));
				System.out.print("Type the Name on card: ");
				payment.setName_on_card(check.checkInput(reader.next() + reader.nextLine(), 6, reader, 0));
				System.out.print("Type the expiration date in the following format (MM/DD/YYYY): ");
				payment.setExpriration_date(check.checkInput(reader.next() + reader.nextLine(), 12, reader, 0));
				System.out.print("Type your 3 digit Card Verification Value (CVV) security code: ");
				CheckClass.numberLength = 3; // for the checking procedure
				payment.setCvv(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));
			}

			break;

		case 2: // Credit Card

			boolean enterAll2 = true;

			// if there are old payments ask the user to select the card
			if (query.previousCardPayment("Credit Card", s, customer.getCustomer_id(), result,
					payment.getPayment_method())) {

				System.out.println();
				System.out.print("Would you like to use any of these stored payments? (y/n) ");
				answer = check.checkInput(reader.next() + reader.nextLine(), 1, reader, 0);
				System.out.println();

				if (answer.equals("y")) {

					enterAll2 = false;

					System.out.print("Please type the id of the payment you would like to use: ");
					// this will be used for the insert statement
					payment.setPayment_id(check.checkInput(reader.next() + reader.nextLine(), 3, reader, 0));

					System.out.println();

					// clear the checkArray
					CheckClass.checkArray.clear();
				}

			}

			// if there are not previous cards ask the user for card credentials
			else if (enterAll2) {
				System.out.println("Please enter the your credit card information for the purchase  ");
				// ask for name/email/primary phone/address
				System.out.print("Type your 16 digit Bank account id: ");
				CheckClass.numberLength = 16; // for the checking procedure
				payment.setCard_id(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));
				System.out.print("Type the Name on card: ");
				payment.setName_on_card(check.checkInput(reader.next() + reader.nextLine(), 6, reader, 0));
				System.out.print("Type the expiration date in the following format (MM/DD/YYY): ");
				payment.setExpriration_date(check.checkInput(reader.next() + reader.nextLine(), 12, reader, 0));
				System.out.print("Type your 5 digit zipcode code: ");
				CheckClass.numberLength = 5; // for the checking procedure
				payment.setZipcode(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));
			}

			break;
		case 3: // Check

			// take the user information
			System.out.print("Type the 9 digit routing number: ");
			CheckClass.numberLength = 9; // for the checking procedure
			payment.setRouting_number(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));
			System.out.print("Type your 10 digit account number: ");
			CheckClass.numberLength = 10;
			payment.setBank_account_id(check.checkInput(reader.next() + reader.nextLine(), 8, reader, 0));

			break;
		}

	}

	static boolean verifyUser(Scanner reader, CheckClass check, QueryClass query, Statement s, ResultSet result, Customer customer)
			throws SQLException {

		String customer_id;
		String customer_name;

		int t = 3;

		do {
			// ask for ID and name
			System.out.print("Type your customer ID: ");
			customer_id = check.checkInput(reader.next() + reader.nextLine(), 5, reader, 0);
			System.out.print("Type your name: ");
			customer_name = check.checkInput(reader.next() + reader.nextLine(), 6, reader, 0);
			System.out.println();

			//they are in the system
			if (query.previousCustomer(customer_id, customer_name, s, result)) {
				
				customer.setCustomer_id(customer_id);
				
				t = 0;

			}

			else {
				t -= 1;
				System.out.print("Customer id and name combination not recognized, you have " + t + " attempts more ");
				System.out.println();

				if (t == 0) {
					t = -1;
				}

			}

		} while (t > 0);

		if (t == -1) {
			// take the user to the beginning
			System.out.println("Veryfication process failed. Taking you back to the beginning");
			System.out.println();

			return true;
		}

		return false;

	}

}
