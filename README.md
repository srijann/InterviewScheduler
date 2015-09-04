# InterviewScheduler
InterviewScheduler
#Run these sql.
/*
Created: 8/13/2015
Modified: 9/3/2015
Model: MySQL 5.5
Database: MySQL 5.5
*/


-- Create tables section -------------------------------------------------

-- Table consultant

CREATE TABLE `consultant`
(
  `consultant_id` Int NOT NULL AUTO_INCREMENT,
  `consultant_name` Varchar(30) NOT NULL,
  `dob` Date,
  `ssn` Varchar(12),
  `education_detail_id` Int NOT NULL,
  `email` Varchar(50) NOT NULL,
  `phone` Varchar(20) NOT NULL,
  `current_client_id` Int,
  `yrs_exp` Double NOT NULL,
  PRIMARY KEY (`consultant_id`)
)
;

CREATE INDEX `IX_Relationship12` ON `consultant` (`education_detail_id`)
;

CREATE INDEX `IX_Relationship34` ON `consultant` (`current_client_id`)
;

-- Table vendor

CREATE TABLE `vendor`
(
  `vendor_id` Int NOT NULL AUTO_INCREMENT,
  `vendor_name` Varchar(30) NOT NULL,
  `location` Varchar(40) NOT NULL,
  PRIMARY KEY (`vendor_id`),
 UNIQUE `vendor_id` (`vendor_id`)
)
;

-- Table vendor_contact

CREATE TABLE `vendor_contact`
(
  `vendor_contact_id` Int NOT NULL AUTO_INCREMENT,
  `vendor_contact_name` Varchar(30) NOT NULL,
  `email` Varchar(50),
  `phone` Varchar(20) NOT NULL,
  `vendor_id` Int NOT NULL,
  PRIMARY KEY (`vendor_contact_id`,`vendor_id`),
 UNIQUE `vendor_contact_id` (`vendor_contact_id`)
)
;

-- Table education_detail

CREATE TABLE `education_detail`
(
  `education_detail_id` Int NOT NULL AUTO_INCREMENT,
  `institution_name` Varchar(40) NOT NULL,
  `location` Varchar(40) NOT NULL,
  `graduated_year` Int NOT NULL,
  PRIMARY KEY (`education_detail_id`),
 UNIQUE `education_detail_id` (`education_detail_id`)
)
;

-- Table Client

CREATE TABLE `Client`
(
  `client_id` Int NOT NULL AUTO_INCREMENT,
  `client_name` Varchar(30) NOT NULL,
  `location` Varchar(40) NOT NULL,
  PRIMARY KEY (`client_id`)
)
;

-- Table consultant_client

CREATE TABLE `consultant_client`
(
  `consultant_id` Int NOT NULL,
  `client_id` Int NOT NULL,
  `start_date` Date NOT NULL,
  `end_date` Date NOT NULL,
  `consultant_client_id` Int NOT NULL AUTO_INCREMENT,
 UNIQUE `consultant_client_id` (`consultant_client_id`)
)
;

ALTER TABLE `consultant_client` ADD  PRIMARY KEY (`consultant_id`,`client_id`,`consultant_client_id`)
;

-- Table consultant_vendor

CREATE TABLE `consultant_vendor`
(
  `vendor_id` Int NOT NULL,
  `consultant_id` Int NOT NULL
)
;

ALTER TABLE `consultant_vendor` ADD  PRIMARY KEY (`vendor_id`,`consultant_id`)
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE `vendor_contact` ADD CONSTRAINT `Relationship3` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant` ADD CONSTRAINT `Relationship12` FOREIGN KEY (`education_detail_id`) REFERENCES `education_detail` (`education_detail_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_client` ADD CONSTRAINT `Relationship30` FOREIGN KEY (`consultant_id`) REFERENCES `consultant` (`consultant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_client` ADD CONSTRAINT `Relationship31` FOREIGN KEY (`client_id`) REFERENCES `Client` (`client_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_vendor` ADD CONSTRAINT `Relationship32` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_vendor` ADD CONSTRAINT `Relationship33` FOREIGN KEY (`consultant_id`) REFERENCES `consultant` (`consultant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant` ADD CONSTRAINT `Relationship34` FOREIGN KEY (`current_client_id`) REFERENCES `Client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

