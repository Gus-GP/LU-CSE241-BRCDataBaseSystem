import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will have all the methods for checking user input
 *
 * @author Gustavo Grins
 * @version 2018.05.01
 */
public class CheckClass {

	static ArrayList<String> checkArray;
	static int numberLength; //value for the check of number

	public CheckClass() {

		checkArray = new ArrayList<String>();
		numberLength = 0;

	}

	// checking methods
	public String checkInput(String usrInput, int type, Scanner reader, int product_stock) {

		Boolean in = true;

		// perform a do loop until the user inputs the right thing
		switch (type) {
		case 1: // (y/n) inputs

			do {

				if (usrInput.equals("y") || usrInput.equals("n")) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("We did not understand, type your answer again: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;
		case 2: // category selection

			// create an array of the options
			String[] options = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
					"17", "18", "19", "20" };

			do {

				if (checkStringExistance(usrInput, options)) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("We did not understand, type your answer again: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;
		case 3: // check the user inputting ids

			do {

				if (checkStringExistance(usrInput, checkArray)) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("We did not understand, type your answer again: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 4: // QTY

			do {

				try {

					if (Integer.parseInt(usrInput) > 0 && Integer.parseInt(usrInput) <= product_stock) {

						in = false;
						return usrInput;
					}
					
					else if(product_stock == 0) {
						
						System.out.println("Oh no! we do not have this product in stock. Sorry!");
						
						return null;
						
					}

					else {

						System.out.print(
								"Your number needs to be a positive value and less then or equal to the available stock => " + product_stock + ", type your answer again: ");
						usrInput = reader.next() + reader.nextLine();
					}

				}

				catch (NumberFormatException e) {
					System.out.print("Please enter an integer number for you answer: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 5: // check primary key id's

			do {

				try {

					if (Integer.parseInt(usrInput) > 0) {

						in = false;
						return usrInput;
					}

					else {

						System.out.print("The number needs to be a positive value, type your answer again: ");
						usrInput = reader.next() + reader.nextLine();
					}

				}

				catch (NumberFormatException e) {
					System.out.print("Please enter a number for you answer: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 6: // check that name has only alphabetical characters

			do {

				if (usrInput.matches("[a-z[A-Z][\\s]]+") && usrInput.length() <= 12) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("Your answer can't contain any numbers in it and it needs to be at a max 12 characters long. Please enter a valid answer: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 7: // check that name has only alphabetical characters

			do {

				// pattern got from
				// https://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
				String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

				if (usrInput.matches(EMAIL_PATTERN)) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("Enter a valid format for your email address: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 8: // Check for number sizes

			do {

				if (usrInput.matches("[0-9]+") && usrInput.length() == numberLength
						&& Double.parseDouble(usrInput) > Math.pow(10, numberLength - 1)) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print(
							"The number needs to be the right number digits long and can't contain any letters or leading zeros, Please type it again :");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 9: // payment selections selection

			// create an array of the options
			String[] options2 = { "1", "2", "3", "4" };

			do {

				if (checkStringExistance(usrInput, options2)) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("We did not understand, type your answer again: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 11: // check address

			do {

				if (usrInput.matches("[a-z[A-z][\\d][\\s]]+") && usrInput.length() <= 50) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("Please enter a valid answer. Your answer needs to be less than or equal to 50 characters: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		case 12: // check date format obtained from
					// https://stackoverflow.com/questions/15491894/regex-to-validate-date-format-dd-mm-yyyy

			do {

				if (usrInput.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {

					in = false;
					return usrInput;
				}

				else {

					System.out.print("Please enter a valid answer: ");
					usrInput = reader.next() + reader.nextLine();
				}

			} while (in);

			break;

		}

		return "";
	}

	public boolean checkStringExistance(String usrInput, String[] category) {

		for (int i = 0; i < category.length; i++) {
			if (usrInput.equals(category[i])) {
				return true;
			}
		}

		return false;

	}

	public boolean checkStringExistance(String usrInput, ArrayList<String> category) {

		for (int i = 0; i < category.size(); i++) {
			if (usrInput.equals(category.get(i))) {
				return true;
			}
		}

		return false;

	}

}
