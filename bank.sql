-- MySQL dump 10.10
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	5.0.24-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` int(11) NOT NULL,
  `cname` text,
  `balance` text,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--


/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
LOCK TABLES `customer` WRITE;
INSERT INTO `customer` VALUES (1,'Akshay Kumar Barya','9583060'),(2,'Anuj Sharma','25000'),(3,'Bindu Singh','1130'),(4,'Ronit Verma','2560'),(5,'Neelu Pandit','27080'),(6,'Roushan Chadda','6920'),(7,'Praveen Choksey','2982'),(8,'Arshifa khan','77800'),(9,'Shusmita Sethi','47230'),(10,'Pinku jain','30170');
UNLOCK TABLES;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `tid` int(11) NOT NULL auto_increment,
  `sender` text,
  `reciever` text,
  `amount` text,
  `time` text,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--


/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
LOCK TABLES `transactions` WRITE;
INSERT INTO `transactions` VALUES (1,'Akshay Kumar Barya','Ronit Verma','900','2021-02-20T16:48:58.755'),(2,'Pinku jain','Ronit Verma','1230','2021-02-20T16:53:13.331'),(3,'Neelu Pandit','Arshifa khan','7000','2021-02-20T16:53:29.968'),(4,'Arshifa khan','Neelu Pandit','25000','2021-02-20T16:53:42.414'),(5,'Arshifa khan','Praveen Choksey','2200','2021-02-20T16:54:10.931');
UNLOCK TABLES;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

