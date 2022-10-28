-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: labdb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `laborant`
--

DROP TABLE IF EXISTS `laborant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laborant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hospitalid` varchar(7) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hucag2q1tnyul2lbgnjq34sp8` (`hospitalid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laborant`
--

LOCK TABLES `laborant` WRITE;
/*!40000 ALTER TABLE `laborant` DISABLE KEYS */;
INSERT INTO `laborant` VALUES (1,'6202058','Tamer','Bilici'),(2,'1701205','Osman ','Çelik'),(3,'8987323','Emre Can ','Aydınoğlu'),(4,'2536356','Nazlı','Yiğit');
/*!40000 ALTER TABLE `laborant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `diagnosis_detail` varchar(255) DEFAULT NULL,
  `diagnostic_title` varchar(255) DEFAULT NULL,
  `file_no` varchar(255) DEFAULT NULL,
  `name_surname` varchar(255) DEFAULT NULL,
  `report_date` varchar(255) DEFAULT NULL,
  `tc` varchar(255) DEFAULT NULL,
  `laborant_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi9twxtnkkxlm7io8k5c3r8ov3` (`laborant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,'Kalp ağrısı','Kalp','1010','Umut Korkmaz','1.01.2022','91150666955',4),(2,'Kan dolaşım enfenksiyonu','Kan','1090','Nurcan Özkan','4.02.2022','03375080665',3),(8,'Analiz Yapıldı','Doku Analizi','1050','Betül Kurt','2.02.2022','80146026006',1),(4,'Tomografi Çekildi...','Baş Yaralanması','1037','Şevval Çakir','5.01.2022','79207308971',3),(5,'Tomografi Çekildi...','Beyin Tümörü','1069','Seda Özer','14.04.2022','82803966404',2),(7,'Akciğer Filmi','Bronşit','1046','Murat Aydın','25.07.2022','08300088074',4);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-28  1:40:45
