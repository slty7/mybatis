-- MySQL dump 10.16  Distrib 10.3.6-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: mybatis
-- ------------------------------------------------------
-- Server version	10.3.6-MariaDB

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
-- Table structure for table `category_`
--

DROP TABLE IF EXISTS `category_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_`
--

LOCK TABLES `category_` WRITE;
/*!40000 ALTER TABLE `category_` DISABLE KEYS */;
INSERT INTO `category_` VALUES (1,'category1'),(2,'category2');
/*!40000 ALTER TABLE `category_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_`
--

DROP TABLE IF EXISTS `order_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_`
--

LOCK TABLES `order_` WRITE;
/*!40000 ALTER TABLE `order_` DISABLE KEYS */;
INSERT INTO `order_` VALUES (1,'code000a'),(2,'code000B');
/*!40000 ALTER TABLE `order_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item_`
--

DROP TABLE IF EXISTS `order_item_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item_` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oid` int(11) DEFAULT NULL COMMENT '订单主键',
  `pid` int(11) DEFAULT NULL COMMENT '产品主键',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item_`
--

LOCK TABLES `order_item_` WRITE;
/*!40000 ALTER TABLE `order_item_` DISABLE KEYS */;
INSERT INTO `order_item_` VALUES (1,1,1,100),(2,1,2,100),(3,1,3,100),(4,2,2,100),(5,2,3,100),(6,2,4,100);
/*!40000 ALTER TABLE `order_item_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_`
--

DROP TABLE IF EXISTS `product_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `price` float DEFAULT 0,
  `cid` int(11) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_`
--

LOCK TABLES `product_` WRITE;
/*!40000 ALTER TABLE `product_` DISABLE KEYS */;
INSERT INTO `product_` VALUES (1,'product a',88.88,1),(2,'product b',88.88,1),(3,'product c',88.88,1),(4,'product x',88.88,2),(5,'product y',88.88,1),(6,'product x',88.88,2);
/*!40000 ALTER TABLE `product_` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-22  1:25:57
