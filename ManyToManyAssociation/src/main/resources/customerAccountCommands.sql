CREATE TABLE customer (customerid INT AUTO_INCREMENT, customername VARCHAR(20),  dateofbirth DATE, address VARCHAR(30), phoneno BIGINT,  PRIMARY KEY(customerid));
CREATE TABLE account (accountno INT PRIMARY KEY, accounttype VARCHAR(20) , openingdate DATE, balance DOUBLE, accountstatus VARCHAR(10));
ALTER TABLE account MODIFY COLUMN accountno BIGINT;
INSERT INTO account values (100120025005, 'Savings', '2001-08-08', 50.0, 'Active');
ALTER TABLE customer AUTO_INCREMENT = 1001;


TRUNCATE TABLE customer;TRUNCATE TABLE account;TRUNCATE TABLE customeraccount;


select * from customer;select * from account;select * from customeraccount;