/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.6.35-log : Database - nce_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nce_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nce_db`;

/*Table structure for table `emp_customer_table` */

DROP TABLE IF EXISTS `emp_customer_table`;

CREATE TABLE `emp_customer_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `emp_customer_table` */

insert  into `emp_customer_table`(`id`,`name`,`address`,`phone`) values (36,'sadasd','asdasd','asdas'),(37,'asdasdsad','asdasd','asdas'),(38,'asda','','asda'),(39,'asda','','asda'),(40,'sandeep','Pune','9765896417'),(41,'Sachin','KP','8149620252'),(42,'Supriya','KP','675432219808');

/*Table structure for table `emp_product_table` */

DROP TABLE IF EXISTS `emp_product_table`;

CREATE TABLE `emp_product_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandName` varchar(20) DEFAULT NULL,
  `brandModel` varchar(30) DEFAULT NULL,
  `serialNumber` varchar(20) DEFAULT NULL,
  `price` int(30) DEFAULT NULL,
  `tax_type` varchar(30) DEFAULT NULL,
  `stockQuantity` int(30) DEFAULT NULL,
  `isService` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `emp_product_table` */

insert  into `emp_product_table`(`id`,`brandName`,`brandModel`,`serialNumber`,`price`,`tax_type`,`stockQuantity`,`isService`) values (32,'CanonExSuper','1213123312','213124314',9000,'VAT-1',NULL,0);

/*Table structure for table `payment_details_table` */

DROP TABLE IF EXISTS `payment_details_table`;

CREATE TABLE `payment_details_table` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `cash` varchar(60) DEFAULT NULL,
  `cheqNo` varchar(60) DEFAULT NULL,
  `bankName` varchar(60) DEFAULT NULL,
  `ifscCode` varchar(60) DEFAULT NULL,
  `cheqDate` varchar(60) DEFAULT NULL,
  `accountNo` varchar(60) DEFAULT NULL,
  `cardNo` varchar(60) DEFAULT NULL,
  `invoice_id` varchar(60) DEFAULT NULL,
  `invoice_tin` varchar(60) DEFAULT NULL,
  `amount` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Data for the table `payment_details_table` */

insert  into `payment_details_table`(`id`,`cash`,`cheqNo`,`bankName`,`ifscCode`,`cheqDate`,`accountNo`,`cardNo`,`invoice_id`,`invoice_tin`,`amount`) values (97,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','',9000.00);

/*Table structure for table `repair_invoice_table` */

DROP TABLE IF EXISTS `repair_invoice_table`;

CREATE TABLE `repair_invoice_table` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `actualInvoiceId` varchar(60) DEFAULT NULL,
  `defaultValue` varchar(60) NOT NULL DEFAULT 'NCE/2017-18/',
  `vat_tin_number` varchar(60) DEFAULT '2763039355V',
  PRIMARY KEY (`id`),
  UNIQUE KEY `actualInvoiceId` (`actualInvoiceId`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `repair_invoice_table` */

insert  into `repair_invoice_table`(`id`,`actualInvoiceId`,`defaultValue`,`vat_tin_number`) values (53,'1','NCE/2017-18/','2763039355V'),(54,'NCE/2017-18/2','NCE/2017-18/','2763039355V'),(55,'NCE/2017-18/3','NCE/2017-18/','2763039355V'),(56,'NCE/2017-18/4','NCE/2017-18/','2763039355V'),(57,'NCE/2017-18/5','NCE/2017-18/','2763039355V'),(58,'NCE/2017-18/6','NCE/2017-18/','2763039355V'),(59,'NCE/2017-18/7','NCE/2017-18/','2763039355V'),(60,'NCE/2017-18/8','NCE/2017-18/','2763039355V');

/*Table structure for table `sales_invoice_table` */

DROP TABLE IF EXISTS `sales_invoice_table`;

CREATE TABLE `sales_invoice_table` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `actualInvoiceId` varchar(60) DEFAULT NULL,
  `defaultValue` varchar(60) DEFAULT 'CE/2017-18/',
  `vat_tin_number` varchar(60) DEFAULT '2763039355V',
  PRIMARY KEY (`id`),
  UNIQUE KEY `actualInvoiceId` (`actualInvoiceId`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

/*Data for the table `sales_invoice_table` */

insert  into `sales_invoice_table`(`id`,`actualInvoiceId`,`defaultValue`,`vat_tin_number`) values (103,'1','CE/2017-18/','2763039355V');

/*Table structure for table `sales_order_table` */

DROP TABLE IF EXISTS `sales_order_table`;

CREATE TABLE `sales_order_table` (
  `sale_id` int(30) NOT NULL AUTO_INCREMENT,
  `invoice_id` varchar(60) NOT NULL,
  `customer_id` varchar(60) NOT NULL,
  `product_id` varchar(60) NOT NULL,
  `product_unit_price` float(10,2) NOT NULL,
  `product_qty` float(10,2) NOT NULL,
  `product_price_with_qty` float(10,2) NOT NULL,
  `tax_type` varchar(60) DEFAULT NULL,
  `tax_rate` varchar(60) DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tax_amount` float(10,2) DEFAULT NULL,
  `total_amount` float(10,2) NOT NULL,
  `tax_value` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `sales_order_table` */

insert  into `sales_order_table`(`sale_id`,`invoice_id`,`customer_id`,`product_id`,`product_unit_price`,`product_qty`,`product_price_with_qty`,`tax_type`,`tax_rate`,`order_date`,`tax_amount`,`total_amount`,`tax_value`) values (45,'1','40','32',9000.00,1.00,7785.00,'VAT-1','13.5','2017-06-26 11:07:30',1215.00,9000.00,13.00);

/*Table structure for table `service_customer_table` */

DROP TABLE IF EXISTS `service_customer_table`;

CREATE TABLE `service_customer_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `service_customer_table` */

insert  into `service_customer_table`(`id`,`name`,`address`,`phone`) values (1,'Sandeep','Pune','989898989');

/*Table structure for table `service_info_table` */

DROP TABLE IF EXISTS `service_info_table`;

CREATE TABLE `service_info_table` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `productName` varchar(60) DEFAULT NULL,
  `productModel` varchar(60) DEFAULT NULL,
  `productSN` varchar(60) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `accessoryList` varchar(255) DEFAULT NULL,
  `problemList` varchar(255) DEFAULT NULL,
  `isCourier` tinyint(1) DEFAULT '0',
  `courierName` varchar(30) DEFAULT NULL,
  `courierPhone` varchar(30) DEFAULT NULL,
  `techComment` varchar(120) DEFAULT NULL,
  `shopUserComment` varchar(120) DEFAULT NULL,
  `customerComment` varchar(120) DEFAULT NULL,
  `serviceStatus` varchar(20) DEFAULT NULL,
  `courierDocumentNo` varchar(30) DEFAULT NULL,
  `service_order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `service_completion_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tentative_service_completion_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tentative_quoted_cost` varchar(40) DEFAULT '0',
  `actual_service_cost` varchar(40) DEFAULT NULL,
  `service_order_number` varchar(50) NOT NULL,
  `taxName` varchar(40) DEFAULT NULL,
  `taxRate` varchar(40) DEFAULT NULL,
  `taxValue` varchar(40) DEFAULT NULL,
  `vatTinNumber` varchar(60) DEFAULT NULL,
  `advancedPayment` varchar(40) DEFAULT NULL,
  `finalPayment` varchar(40) DEFAULT NULL,
  `finalDeleted` varchar(255) DEFAULT NULL,
  `technician_handle_status` varchar(80) DEFAULT 'NA',
  `technician_handle_comment` varchar(255) DEFAULT NULL,
  `customer_approval_status` varchar(80) DEFAULT 'NA',
  `customer_approval_comment` varchar(255) DEFAULT NULL,
  `part_pending_status` varchar(80) DEFAULT 'NA',
  `part_pending_comment` varchar(255) DEFAULT NULL,
  `technician_handle_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customer_approval_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `part_pending_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `completed_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tech_completed_comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `userId` (`userId`),
  CONSTRAINT `service_info_table_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `emp_customer_table` (`id`),
  CONSTRAINT `service_info_table_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `validemporiumuser` (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `service_info_table` */

insert  into `service_info_table`(`id`,`customerId`,`productName`,`productModel`,`productSN`,`userId`,`accessoryList`,`problemList`,`isCourier`,`courierName`,`courierPhone`,`techComment`,`shopUserComment`,`customerComment`,`serviceStatus`,`courierDocumentNo`,`service_order_date`,`service_completion_date`,`tentative_service_completion_date`,`tentative_quoted_cost`,`actual_service_cost`,`service_order_number`,`taxName`,`taxRate`,`taxValue`,`vatTinNumber`,`advancedPayment`,`finalPayment`,`finalDeleted`,`technician_handle_status`,`technician_handle_comment`,`customer_approval_status`,`customer_approval_comment`,`part_pending_status`,`part_pending_comment`,`technician_handle_time`,`customer_approval_time`,`part_pending_time`,`completed_time`,`tech_completed_comment`) values (36,40,'BrandNameExtreme','9090909090909090','YESSN90909090909',1,'Filter UV,Memory Card','Dust In View Finder,Scratches on Focusing Screen',0,'YesName','YesPhon09090909',' Added comments for NS ','','','DTC','YesDOcNo0021312','2017-06-26 11:12:27','2017-06-26 11:14:06','2017-06-26 11:12:27','0',NULL,'NCE/2017-18/6',NULL,NULL,NULL,'2763039355V','800','0',NULL,'TH','  Added comments for NS ','NA','  Added comments for NS ','NA','  Added comments for NS ','2017-06-26 12:13:38','2017-06-26 12:13:59','2017-06-26 12:13:50','2017-06-26 11:27:58',NULL),(37,41,'BrandNameLocal','Model898989','SN9892131',1,'AC Cord,Filter UV','Scratches on Focusing Screen,Salt Water Damage',0,'','',' Added comments for NS now moving it to TH state','','','DTC','','2017-06-26 12:54:04','2017-06-26 12:54:45','2017-06-26 12:54:04','0',NULL,'NCE/2017-18/7',NULL,NULL,NULL,'2763039355V','0','0',NULL,'NA','This cannot  be moved so need to be updated to CA','NA','CA to different State... ','NA','  Added comments for NS now moving it to TH state','2017-06-26 12:56:25','2017-06-26 13:02:27','2017-06-26 13:33:04','2017-06-26 12:54:45',NULL),(38,42,'CanonExSuper','1213123312','213123',1,'','',0,'','',' Moved to Technician Handle from Not Started state','','','C','','2017-06-26 14:09:23','2017-06-26 14:09:52','2017-06-26 14:09:23','0',NULL,'NCE/2017-18/8',NULL,NULL,NULL,'2763039355V','0',NULL,NULL,'NA','So from NS state there is update Customer Approval','NA','Hello Man.. now the product is not available so move to something else like Part Pending','NA','Kay pan challay tar kay kar... shalllooo nach nach nach','2017-06-26 14:11:25','2017-06-26 14:11:58','2017-06-26 14:12:25','2017-06-26 14:09:52',NULL);

/*Table structure for table `validemporiumuser` */

DROP TABLE IF EXISTS `validemporiumuser`;

CREATE TABLE `validemporiumuser` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(20) DEFAULT NULL,
  `empPassword` varchar(20) DEFAULT NULL,
  `empRole` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `validemporiumuser` */

insert  into `validemporiumuser`(`empId`,`empName`,`empPassword`,`empRole`) values (1,'admin','admin','ADMIN'),(2,'tech','tech','TECH');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
