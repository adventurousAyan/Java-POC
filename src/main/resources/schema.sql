--CREATE TABLE ORDER (
--  ID INTEGER AUTO_INCREMENT  PRIMARY KEY,
--  CUSTOMER_NAME VARCHAR(250) NOT NULL,
--  ORDER_DATE VARCHAR(250) NOT NULL,
--  SHIPPING_ADDRESS VARCHAR(250) DEFAULT NULL,
--  TOTAL_COST INTEGER
--);
CREATE TABLE ORDER_ITEM (
  ID INTEGER AUTO_INCREMENT  PRIMARY KEY,
  PRODUCT_CODE VARCHAR(250) NOT NULL,
  PRODUCT_NAME VARCHAR(250) NOT NULL,
  QUANTITY INTEGER DEFAULT NULL,
  ORDER_ID INTEGER NOT NULL,
  COST DECIMAL NOT NULL
);
CREATE TABLE ORDER_INFO (
  ID INTEGER AUTO_INCREMENT  PRIMARY KEY,
  CUSTOMER_NAME VARCHAR(250) NOT NULL,
  ORDER_DATE VARCHAR(250) NOT NULL,
  SHIPPING_ADDRESS VARCHAR(250) DEFAULT NULL
);
