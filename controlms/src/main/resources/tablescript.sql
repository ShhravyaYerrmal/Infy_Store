CREATE DATABASE `control_db`;

USE `control_db`;

CREATE TABLE `CONTROL` (
  `system_id` varchar(255) NOT NULL,
  `manufacture_id` varchar(255) NOT NULL,
  `model_name` varchar(255) NOT NULL,
  `cost` varchar(255) NOT NULL,
  `efficiency` varchar(255) NOT NULL,
  `no_of_employees` varchar(255) NOT NULL,
  `update_required` varchar(255) NOT NULL,
PRIMARY KEY (`manufacture_id`)
);

create table Orderdetails(
`order_id` int AUTO_INCREMENT,
`quotation_model_no` varchar(255) NOT NULL,
`customer_id` varchar(255) NOT NULL,
`customer_name` varchar(255) NOT NULL,
`price` varchar(255) NOT NULL,
`email` varchar(255) NOT NULL,
PRIMARY KEY(`order_id`)
);

INSERT INTO `CONTROL` VALUES
('AC01','MA01','Aircontrolsystem','2.34m','90percent','7to8','100days');

