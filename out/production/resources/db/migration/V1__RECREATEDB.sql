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
  `C_ID` int(5) NOT NULL,
  `C_NAME` varchar(200) DEFAULT NULL,
  `C_ADDRESS` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping com.eileen.data for table `CUSTOMERS`
--

LOCK TABLES `CUSTOMERS` WRITE;
/*!40000 ALTER TABLE `CUSTOMERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOMERS` ENABLE KEYS */;
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
-- Dumping com.eileen.data for table `MOVIES`
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
  `R_Date_Rented` date DEFAULT NULL,
  `R_COST` int(5) DEFAULT NULL,
  `R_C_ID` int(5) DEFAULT NULL,
  `R_M_ID` int(5) DEFAULT NULL,
  `R_Date_Returned` date DEFAULT NULL,
  KEY `C_ID_idx` (`R_C_ID`),
  KEY `M_ID_idx` (`R_M_ID`),
  CONSTRAINT `C_ID` FOREIGN KEY (`R_C_ID`) REFERENCES `customers` (`C_ID`),
  CONSTRAINT `M_ID` FOREIGN KEY (`R_M_ID`) REFERENCES `movies` (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping com.eileen.data for table `RENTALS`
--

LOCK TABLES `RENTALS` WRITE;
/*!40000 ALTER TABLE `RENTALS` DISABLE KEYS */;
/*!40000 ALTER TABLE `RENTALS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-08 14:51:06
