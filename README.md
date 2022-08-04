Gustavo Grins Final Project
CSE 241
Prof. Korth
05/04/2018

# Description

The goal of this project is to provide a realistic experience in the conceptual design, logical design, implementation, operation, and maintenance of a relational database and associated applications.

Mock enterprise description:

The enterprise is Big River Crossing (BRC), an online retailer selling almost everything. BRC recently acquired a supermarket chain, Regork, giving BRC physical stores to complement its online sales and toprovide an entrance into the fresh-food and grocery markets. This model only pertains to product-sales and inventory aspects of BRC, not employees and salaries,maintenance of physical infrastructure, etc. 

# Details

Disclaimer: This code uses the JDBC API to connect to an Oracle Database at Lehigh University available in 2018. The code can be altered to connect to a working database and use the mock data that this project includes to run the logic.

What ".java" files are in this folder?
CheckClass.java -> this class was made to facilitate writing methods to check user input
Customer.java -> class containing customer information
MainCode.java -> heart of the executable user interface
Payment.java -> class containing payment information
QueryClass.java -> class containing all the query procedures of the code
Store.java -> class containing store info


# How to run my code?

First input the necessary credentials to enter the database. Then follow prompt instructions.


Note: set terminal screen size to at least 120x43 for the printed tables to not overflow.
----


# Customers to test my project:

customer_id = 1
name = Nico
-This customer has 2 debitcards on the system, and one credit card.

customer_id = 1042
name = Gussy Goose
-This customer has no cards in system.


# What is special about my code?

* I have made my code robust for any unintended input from the user. Forcing them to type the correct answer.
* For the payment procedure, the code checks if there are any credit or debit cards in the system for a returning customer. If there is, the program asks the customer if they will use this card.
* The customer interface was designed for anybody to follow through it without any background information. Highly intuitive.
* when the user selects a product, the list of stores is arranged by ascending price, meaning that the cheapest selection will be at the top.
* When the user has to input any id stored in the database, the checkClass runs this input and makes sure it is part of the list that was showned to the user.


# If I had more time I would:

* Improve my current customer interface by introducing:
- An expiration date for food products. Then I would establish a trigger that would empty out all products in the store that have been expired and alert managers of changes in product stock.
- Add a delivery step for the purchasing prcedure. This will ask the user if they would like to get their product mailed or picked up. If it will be mailed then an extra cost for delivery would be charged.
- Instead of having static categories as I have in my code, I would find a way to create this list of categories by performing queries in the database. This way, If a manager interface user decides to add a new categpry to the list this would be reflected in all interfaces.
- Make a better distinction between the online store and regork stores. In the code the only way I distinguish them is by outputing the store type where the product is sold. What I could code is different questions to the user depending if they are in the online store or at the regork store.

* Add a manager interface where one can manage the inventory of the database. This includes look at a list in ascending order where the executive manager of BRC can look at the products that have dangerously low stock. The manager would have the option to do this query by store_id or by region or world wide. This manager interface would also provide the ability to make purchases from vendors, add vendors to the list, and insert new lines of products into the database. The manager using this interface could also look at the total profit and losses made by different stores according to the difference of the original cost of a product and the amount it was sold at.

* Add a marketing interface were the benefits of OLAP could be use. Here a BRC marketer can take a look at the trends of purchases according to store or regions and from here decide the best way to market products.

* Add a research interface where the user can pull specific data from the database to feed into an algorithm to perform some business task. Like using linear regression to see if the time of an user in the BRC interface can be predicted using some sord of attribute. Or even feed this data into a neural network to try to classify a target.


# Data Generation:

Names, addresses, and product descriptions where created using "Mockaroo" <https://mockaroo.com/>. This website allowed me to generate a max of 1000 tuples of data. The attributes for each column could be specified to different categories with specific formats. 

The numeric data for this project was generated using google sheets. The process consisted on using a google sheet add-on called "Random Generator." This streamlined the process of generating integers and real numbers. One simply selected a range of numbers and cells in the sheet and the numbers were generated. Dates formatted in (MM/DD/YYY) could also be generated through this.

