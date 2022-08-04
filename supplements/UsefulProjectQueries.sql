select product_id, product_description 
from product 
where product_category = 'Superpower'
order by product_id asc;

select store_id, store.STORE_TYPE, store.STORE_ADDRESS, price_per_product, stock 
from store natural join sold_at 
where product_id = 78
order by PRICE_PER_PRODUCT;

set pagesize 10000;
set serveroutput on;

insert into customer (name, email, primary_phone, address)
values ('JAIMITO','user@lehigh.edu' ,'7874546666','0 Lindon ave');

--getting the last primary key inserted
select *
  from ( select a.*, max(customer_order_id) over () as max_pk
           from customer_order a
                )
 where customer_order_id = max_pk;
 
 select *
  from ( select a.*, max(customer_id) over () as max_pk
           from customer a
                )
 where customer_id = max_pk;
 
 select *
  from ( select a.*, max(payment_id) over () as max_pk
           from payment a
                )
 where payment_id = max_pk;
 
password
 
 