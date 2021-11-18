create table DRIVINGLICENSE (LICENSENUMBER int primary key, NAME  varchar(30), AGE int, GENDER varchar(10), ADDRESS varchar(50), LICENSEISSUEDATE DATE, licenseExpiryDate DATE, LICENSEISSUEZONE varchar(20));
create table HIBERNATE_UNIQUE_KEY (NEXT_HI int);
ALTER TABLE DRIVINGLICENSE modify column LICENSENUMBER int AUTO_INCREMENT;
SELECT * FROM drivinglicense;
TRUNCATE TABLE drivinglicense;