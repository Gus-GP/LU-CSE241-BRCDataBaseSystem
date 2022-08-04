--------------------------------------------------------
--  File created - Monday-March-26-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CASH
--------------------------------------------------------

  CREATE TABLE "USER"."CASH" 
   (	"PAYMENT_ID" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CHECK_PAYMENT
--------------------------------------------------------

  CREATE TABLE "USER"."CHECK_PAYMENT" 
   (	"PAYMENT_ID" VARCHAR2(10 BYTE), 
	"ROUTING_NUMBER" VARCHAR2(20 BYTE), 
	"BANK_ID" VARCHAR2(15 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CREDITCARD
--------------------------------------------------------

  CREATE TABLE "USER"."CREDITCARD" 
   (	"PAYMENT_ID" VARCHAR2(10 BYTE), 
	"CARD_ID" VARCHAR2(12 BYTE), 
	"CARD_NAME" VARCHAR2(10 BYTE), 
	"EXPIRATION_DATE" VARCHAR2(12 BYTE), 
	"ZIP_CODE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "USER"."CUSTOMER" 
   (	"CUSTOMER_ID" VARCHAR2(10 BYTE), 
	"NAME" VARCHAR2(10 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE), 
	"PRIMARY_PHONE" VARCHAR2(15 BYTE), 
	"ADDRESS" VARCHAR2(50 BYTE), 
	"PAYMENT_ID" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CUSTOMER_ORDER
--------------------------------------------------------

  CREATE TABLE "USER"."CUSTOMER_ORDER" 
   (	"CUSTOMER_ORDER_ID" VARCHAR2(10 BYTE), 
	"ORDER_DATE" VARCHAR2(12 BYTE), 
	"AMOUNT" VARCHAR2(10 BYTE), 
	"PRODUCT_ID" VARCHAR2(10 BYTE), 
	"QUANTITY" VARCHAR2(8 BYTE), 
	"PRICE" VARCHAR2(10 BYTE), 
	"STORE_ID" VARCHAR2(10 BYTE), 
	"PAYMENT_ID" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DEBITCARD
--------------------------------------------------------

  CREATE TABLE "USER"."DEBITCARD" 
   (	"PAYMENT_ID" VARCHAR2(10 BYTE), 
	"CARD_ID" VARCHAR2(12 BYTE), 
	"CARD_NAME" VARCHAR2(10 BYTE), 
	"EXPIRATION_DATE" VARCHAR2(12 BYTE), 
	"CVV" NUMBER(3,0), 
	"PIN" NUMBER(4,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MADE_BY
--------------------------------------------------------

  CREATE TABLE "USER"."MADE_BY" 
   (	"VENDOR_ID" VARCHAR2(10 BYTE), 
	"PRODUCT_ID" VARCHAR2(10 BYTE), 
	"PRICE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PAYMENT
--------------------------------------------------------

  CREATE TABLE "USER"."PAYMENT" 
   (	"PAYMENT_ID" VARCHAR2(10 BYTE), 
	"PAYMENT_DATE" VARCHAR2(12 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCT
--------------------------------------------------------

  CREATE TABLE "USER"."PRODUCT" 
   (	"PRODUCT_ID" VARCHAR2(10 BYTE), 
	"STOCK" VARCHAR2(10 BYTE), 
	"PRODUCT_TYPE" VARCHAR2(15 BYTE), 
	"BRAND" VARCHAR2(15 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCT_ORDER
--------------------------------------------------------

  CREATE TABLE "USER"."PRODUCT_ORDER" 
   (	"PRODUCT_ORDER_ID" VARCHAR2(10 BYTE), 
	"ORDER_DATE" VARCHAR2(12 BYTE), 
	"AMOUNT" VARCHAR2(10 BYTE), 
	"PRODUCT_ID" VARCHAR2(10 BYTE), 
	"QUANTITY" VARCHAR2(8 BYTE), 
	"PRICE" VARCHAR2(10 BYTE), 
	"STORE_ID" VARCHAR2(10 BYTE), 
	"PAYMENT_ID" VARCHAR2(10 BYTE), 
	"VENDOR_ID" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REGORK
--------------------------------------------------------

  CREATE TABLE "USER"."REGORK" 
   (	"STORE_ID" VARCHAR2(10 BYTE), 
	"REGORK_ADDRESS" VARCHAR2(50 BYTE), 
	"MEMBERSHIP" VARCHAR2(6 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SOLD_AT
--------------------------------------------------------

  CREATE TABLE "USER"."SOLD_AT" 
   (	"STORE_ID" VARCHAR2(10 BYTE), 
	"PRODUCT_ID" VARCHAR2(10 BYTE), 
	"PRICE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STORE
--------------------------------------------------------

  CREATE TABLE "USER"."STORE" 
   (	"STORE_ID" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table VENDOR
--------------------------------------------------------

  CREATE TABLE "USER"."VENDOR" 
   (	"VENDOR_ID" VARCHAR2(10 BYTE), 
	"ADRESS" VARCHAR2(20 BYTE), 
	"PRIMARY_PHONE" VARCHAR2(10 BYTE), 
	"EMAIL" VARCHAR2(15 BYTE), 
	"PRODUCT_ID" VARCHAR2(10 BYTE), 
	"PRICE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table WAREHOUSE
--------------------------------------------------------

  CREATE TABLE "USER"."WAREHOUSE" 
   (	"STORE_ID" VARCHAR2(10 BYTE), 
	"WAREHOUSE_ADDRESS" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076840
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076840" ON "USER"."CASH" ("PAYMENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076865
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076865" ON "USER"."CHECK_PAYMENT" ("PAYMENT_ID", "ROUTING_NUMBER", "BANK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076801
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076801" ON "USER"."CREDITCARD" ("PAYMENT_ID", "CARD_ID", "CARD_NAME", "EXPIRATION_DATE", "ZIP_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076874
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076874" ON "USER"."CUSTOMER" ("CUSTOMER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0077022
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0077022" ON "USER"."CUSTOMER_ORDER" ("CUSTOMER_ORDER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076760
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076760" ON "USER"."DEBITCARD" ("PAYMENT_ID", "CARD_ID", "CARD_NAME", "EXPIRATION_DATE", "CVV", "PIN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0077069
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0077069" ON "USER"."MADE_BY" ("VENDOR_ID", "PRODUCT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076357
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076357" ON "USER"."PAYMENT" ("PAYMENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0077000
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0077000" ON "USER"."PRODUCT" ("PRODUCT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0077043
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0077043" ON "USER"."PRODUCT_ORDER" ("PRODUCT_ORDER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076990
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076990" ON "USER"."REGORK" ("STORE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0077060
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0077060" ON "USER"."SOLD_AT" ("STORE_ID", "PRODUCT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076914
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076914" ON "USER"."STORE" ("STORE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0077015
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0077015" ON "USER"."VENDOR" ("VENDOR_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0076948
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C0076948" ON "USER"."WAREHOUSE" ("STORE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CASH
--------------------------------------------------------

  ALTER TABLE "USER"."CASH" ADD PRIMARY KEY ("PAYMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CHECK_PAYMENT
--------------------------------------------------------

  ALTER TABLE "USER"."CHECK_PAYMENT" ADD PRIMARY KEY ("PAYMENT_ID", "ROUTING_NUMBER", "BANK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CREDITCARD
--------------------------------------------------------

  ALTER TABLE "USER"."CREDITCARD" ADD PRIMARY KEY ("PAYMENT_ID", "CARD_ID", "CARD_NAME", "EXPIRATION_DATE", "ZIP_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "USER"."CUSTOMER" ADD PRIMARY KEY ("CUSTOMER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CUSTOMER_ORDER
--------------------------------------------------------

  ALTER TABLE "USER"."CUSTOMER_ORDER" ADD PRIMARY KEY ("CUSTOMER_ORDER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DEBITCARD
--------------------------------------------------------

  ALTER TABLE "USER"."DEBITCARD" ADD PRIMARY KEY ("PAYMENT_ID", "CARD_ID", "CARD_NAME", "EXPIRATION_DATE", "CVV", "PIN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MADE_BY
--------------------------------------------------------

  ALTER TABLE "USER"."MADE_BY" ADD PRIMARY KEY ("VENDOR_ID", "PRODUCT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PAYMENT
--------------------------------------------------------

  ALTER TABLE "USER"."PAYMENT" ADD PRIMARY KEY ("PAYMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCT
--------------------------------------------------------

  ALTER TABLE "USER"."PRODUCT" ADD PRIMARY KEY ("PRODUCT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCT_ORDER
--------------------------------------------------------

  ALTER TABLE "USER"."PRODUCT_ORDER" ADD PRIMARY KEY ("PRODUCT_ORDER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REGORK
--------------------------------------------------------

  ALTER TABLE "USER"."REGORK" ADD PRIMARY KEY ("STORE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "USER"."REGORK" ADD CHECK (membership in ('yes','no')) ENABLE;
--------------------------------------------------------
--  Constraints for Table SOLD_AT
--------------------------------------------------------

  ALTER TABLE "USER"."SOLD_AT" ADD PRIMARY KEY ("STORE_ID", "PRODUCT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STORE
--------------------------------------------------------

  ALTER TABLE "USER"."STORE" ADD PRIMARY KEY ("STORE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table VENDOR
--------------------------------------------------------

  ALTER TABLE "USER"."VENDOR" ADD PRIMARY KEY ("VENDOR_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table WAREHOUSE
--------------------------------------------------------

  ALTER TABLE "USER"."WAREHOUSE" ADD PRIMARY KEY ("STORE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
