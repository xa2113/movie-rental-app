CREATE DATABASE  IF NOT EXISTS `VIDEOSTORE` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `VIDEOSTORE`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: VIDEOSTORE
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CUSTOMERS`
--

DROP TABLE IF EXISTS `CUSTOMERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CUSTOMERS` (
  `C_ID` int(5) NOT NULL AUTO_INCREMENT,
  `C_NAME` varchar(200) DEFAULT NULL,
  `C_ADDRESS` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMERS`
--

LOCK TABLES `CUSTOMERS` WRITE;
/*!40000 ALTER TABLE `CUSTOMERS` DISABLE KEYS */;
INSERT INTO `CUSTOMERS` VALUES (1,'Eileen','123 45 street, NY'),(2,'Matt','2387 12 street'),(3,'Roi','987 65 street'),(4,'Alp','123 turkish street'),(5,'Cristian','123 apple street'),(6,'Jordan','234 UK street'),(7,'Seleni','234 pear street'),(8,'Martin','342 papaya street'),(9,'Jane','234 Alexandra street, LA');
/*!40000 ALTER TABLE `CUSTOMERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8),(8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MOVIES`
--

DROP TABLE IF EXISTS `MOVIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `MOVIES` (
  `M_ID` int(5) NOT NULL AUTO_INCREMENT,
  `M_TITLE` varchar(200) DEFAULT NULL,
  `M_MAIN_ACTOR` varchar(200) DEFAULT NULL,
  `M_YEAR` int(4) DEFAULT NULL,
  `M_GENRE` varchar(100) DEFAULT NULL,
  `M_AVAILABLE` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MOVIES`
--

LOCK TABLES `MOVIES` WRITE;
/*!40000 ALTER TABLE `MOVIES` DISABLE KEYS */;
INSERT INTO `MOVIES` VALUES (1,'The Godfather','Marlon Brando',1972,'Drama',1),(2,'The Shawshank Redemption','Tim Robbins',1994,'Drama',1),(3,'Schindler\'s List','Liam Neeson',1993,'Drama',1),(4,'Forrest Gump','Tom Hanks',1994,'Drama',1),(5,'The Sound of Music','Julie Andrews',1965,'Family',1),(6,'The Lord of the Rings','Orlando Bloom',2003,'Fantasy',1),(7,'Titanic','Leonardo DiCaprio',1997,'Romance',1);
/*!40000 ALTER TABLE `MOVIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RENTALS`
--

DROP TABLE IF EXISTS `RENTALS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `RENTALS` (
  `R_ID` int(11) NOT NULL AUTO_INCREMENT,
  `R_C_ID` int(4) DEFAULT NULL,
  `R_M_ID` int(4) DEFAULT NULL,
  `R_Date_Rented` date DEFAULT NULL,
  `R_Date_Returned` date DEFAULT NULL,
  `R_Cost` int(4) DEFAULT NULL,
  PRIMARY KEY (`R_ID`),
  KEY `C_ID_idx` (`R_C_ID`),
  KEY `M_ID_idx` (`R_M_ID`),
  CONSTRAINT `C_ID` FOREIGN KEY (`R_C_ID`) REFERENCES `customers` (`C_ID`),
  CONSTRAINT `M_ID` FOREIGN KEY (`R_M_ID`) REFERENCES `movies` (`M_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RENTALS`
--

LOCK TABLES `RENTALS` WRITE;
/*!40000 ALTER TABLE `RENTALS` DISABLE KEYS */;
INSERT INTO `RENTALS` VALUES (1,1,6,'2019-03-21','2019-03-21',1),(3,3,1,'2019-03-22','2019-03-22',1),(4,9,3,'2019-03-22','2019-03-22',1);
/*!40000 ALTER TABLE `RENTALS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `token` (
  `t_email` varchar(255) NOT NULL,
  `t_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_email`),
  KEY `email_idx` (`t_email`),
  CONSTRAINT `fk_email` FOREIGN KEY (`t_email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES ('mie@goreng.com','$2a$10$9.oNaZu0Q14fzPfRAIAwLufGJJIGu75aMDcTvwDcEodOlXFJmnOoy'),('nasi@goreng.com','$2a$10$TVW5LFF16ZSh4teHE9Sq9e6fzOfsjEzi0bm9MMkYSMEknCfyleeXu'),('soto@babi.com','12345');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `t_email_idx` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,1,'soto@babi.com','Babi','$2a$10$/FA.424ATGoehhMf7VNMHexSIZBKleUb8xG4gICPRl8Sgix24djxq','Soto'),(5,1,'mie@goreng.com','Goreng','$2a$10$YKBgJa2UVhX.UT5vFaKA1e2B2O1a.5sEvGqUTEcjgPS7T91/NYnP2','Mie'),(6,1,'soto@ayam.com','Ayam','$2a$10$.OP4k5nKQSsQVaGNbWzAyuDBa50sKrzRbX80dsadbjtoN49IwOyjG','Soto'),(7,1,'nasi@goreng.com','Goreng','$2a$10$RO.fyvJxjmJYiQ8USQ9/GOhkGvLaQy4QCo87tEJ5gdmx3XablsgEq','Nasi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(4,1),(5,1),(6,1),(7,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-29 15:10:18
