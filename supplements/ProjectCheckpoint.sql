/*
Gustavo Grins
Project - Checkpoint 2
CSE 241 - Prof. Korth
03/22/2018
*/

/*Drop all the tables that I have*/

/*Drop all the tables with foreign keys first*/
drop table debitcard_payment;
drop table check_payment;
drop table customer_order;
drop table creditcard_payment;
drop table payment;
drop table frequent_buyer;
drop table customer;
drop table product_order;
drop table sold_at;
drop table created_by;
drop table store;
drop table vendor;
drop table product;

/*create the tables one by one and then start filling them in */

create table customer(
        customer_id numeric(12) generated always as identity, 
        name varchar(20) not null, 
        email varchar(50),
        primary_phone numeric(10) check (primary_phone > 1000000000 and primary_phone < 10000000000),
        address varchar(50),
        primary key (customer_id));
        
create table payment(
        payment_id numeric(12) generated always as identity,
        customer_id numeric(12),
        type_payment varchar(30) check (type_payment in ('Debit Card','Credit Card','Check','Cash')),
        primary key (payment_id),
        foreign key (customer_id) references customer);
        
create table creditcard_payment(
        payment_id numeric(12),
        card_id numeric(16) check (card_id > 1000000000000000 and card_id < 10000000000000000) not null,
        customer_id numeric(12), 
        name_on_card varchar(20) not null,
        expiration_date varchar(20),
        zipcode numeric(5) check (zipcode > 10000 and zipcode < 100000),
        primary key (payment_id),
        foreign key (customer_id) references customer,
        foreign key (payment_id) references payment);

create table debitcard_payment(
        payment_id numeric(12),
        card_id numeric(16) check (card_id > 1000000000000000 and card_id < 10000000000000000) not null,
        customer_id numeric(12),
        name_on_card varchar(12) not null, 
        expiration_date varchar(20),
        cvv numeric(3) check (cvv > 100 and cvv < 1000),
        primary key (payment_id),
        foreign key (customer_id) references customer,
        foreign key (payment_id) references payment);
      
create table check_payment(
        payment_id numeric(12),
        customer_id numeric(12),
        routing_number numeric(9) check (routing_number > 100000000 and routing_number < 1000000000) not null,
        bank_account_id numeric(10) check (bank_account_id > 1000000000 and bank_account_id < 10000000000) not null,
        primary key (payment_id),
        foreign key (customer_id) references customer,
        foreign key (payment_id) references payment);

create table store(
        store_id numeric(12) generated always as identity,
        store_type varchar(50) check (store_type in ('Associate warehouse','Regork')),
        store_address varchar(100),
        primary key (store_id));
        
create table product(
        product_id numeric(12) generated always as identity,
        product_category varchar(100),
        product_description varchar(100),
        primary key (product_id));
        
create table sold_at(
        store_id numeric(12),
        product_id numeric(12),
        product_size varchar(50) check (product_size in ('Big','Medium','Small')),
        price_per_product number(12,2) not null,
        stock number(15) not null,
        primary key (store_id, product_id),
        foreign key (store_id) references store,
        foreign key (product_id) references product);
        
create table customer_order(
        customer_order_id numeric(12) generated always as identity,
        customer_order_date varchar(20) not null,
        product_id numeric(12),
        store_id numeric(12), 
        payment_id numeric(12),
        QTY number(10) check(QTY > 0) not null,
        total_sale number(12,2) not null,
        primary key (customer_order_id),
        foreign key (product_id) references product,
        foreign key (store_id) references store,
        foreign key (payment_id) references payment);
        
create table vendor(
        vendor_id numeric(12) generated always as identity,
        vendor_address varchar(50),
        primary_phone varchar(10) not null,
        email varchar(50),
        primary key (vendor_id));
        
create table product_order(
        product_order_id numeric(12) generated always as identity,
        product_order_date varchar(20) not null,
        product_id numeric(12),
        QTY number(20) not null,
        price_per_product number(12,2) not null,
        store_id numeric(12), 
        vendor_id numeric(12),
        primary key (product_order_id),
        foreign key (product_id) references product,
        foreign key (store_id) references store,
        foreign key (vendor_id) references vendor);
        
create table created_by(
        vendor_id numeric(12),
        product_id numeric(12),
        primary key (vendor_id, product_id),
        foreign key (vendor_id) references vendor,
        foreign key (product_id) references product);
        
create table frequent_buyer(
        customer_id numeric(12),
        store_id numeric(12),
        purchase_points numeric(12) not null,
        dollar_per_point numeric(5) not null,
        primary key (customer_id, store_id),
        foreign key (customer_id) references customer,
        foreign key (store_id) references store);


    

        








