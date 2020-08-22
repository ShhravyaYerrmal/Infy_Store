drop database `airbusdb`;
CREATE DATABASE `airbusdb`;
USE `airbusdb`;
 -- DROP TABLE AIRBUS ;


CREATE TABLE `AIRBUS` (   
  `manufacture_model_no` varchar(4) NOT NULL,
  `model_name` varchar(255) NOT NULL,
  `unit_price` varchar(255) NOT NULL,
  `passenger_seats` varchar(255) NOT NULL,
  `length`varchar(255)  NOT NULL,
  `height` varchar(255) NOT NULL,
  `wingspan` varchar(255) NOT NULL,
  `travel_range` varchar(255) NOT NULL,
  `speed` varchar(255) NOT NULL,
  `max_fuel_capacity` varchar(255) NOT NULL,
  PRIMARY KEY (`manufacture_model_no`)
);
create table Orderdetails(
`order_id` int(5) AUTO_INCREMENT,
`quotation_model_no` varchar(255) NOT NULL,
`customer_id` varchar(255) NOT NULL,
`customer_name` varchar(255) NOT NULL,
`price` varchar(255) NOT NULL,
`email` varchar(255) NOT NULL,
PRIMARY KEY(`order_id`)
);


INSERT INTO `AIRBUS` VALUES
('A330','Airbus Beluga XL','23.85million','440','63.66m','16.79m','60.30m','11750km','880km/hr','139090L');
