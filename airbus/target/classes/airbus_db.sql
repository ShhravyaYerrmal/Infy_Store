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
		('A330','16.79m','63.66m','139090L','Airbus BelugaXL','440','880km/hr','11750km','238.5million','60.30');
insert into airbus values('A310','15.54m','44m','754701L','AirbusXing A310','220','901km/hr','9750km','80million','44');
insert into airbus values('A320','12.51m','34m','25730L','AirbusDelaris ','170','275km/hr','5750km','107.6million','34');
insert into airbus values('A319','11.6m','34m','301901L','AirbusNathan ','160','829km/hr','6940km','89.6million','34');


