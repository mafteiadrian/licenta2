-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: aspp
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `angajat`
--

DROP TABLE IF EXISTS `angajat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `angajat` (
  `id` bigint NOT NULL,
  `adresa` varchar(255) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `telefon` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `angajat`
--

LOCK TABLES `angajat` WRITE;
/*!40000 ALTER TABLE `angajat` DISABLE KEYS */;
INSERT INTO `angajat` VALUES (1,'Craiova','Jianu','Lavinia','1234',1),(2,'Bals','Ivanescu','Cristina','4321',1),(3,'Craiova','Pana','Dan','5678',1),(4,'Craiova','Maftei','Adrian','8765',1);
/*!40000 ALTER TABLE `angajat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL,
  `adresa` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `telefon` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'str. Tehnicii, nr 3, BL U1, sc 1, ap 18','saas.rom@gmail.com','MAFTEI ADRIAN MIHAI','+40749098764',0),(4,'Dabuleni','bla@gmail.com','Ratoiu Andrei','1234',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `constatare`
--

DROP TABLE IF EXISTS `constatare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `constatare` (
  `id` bigint NOT NULL,
  `descriere` varchar(4000) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `constatare`
--

LOCK TABLES `constatare` WRITE;
/*!40000 ALTER TABLE `constatare` DISABLE KEYS */;
INSERT INTO `constatare` VALUES (2,'Cap de printare defect',1);
/*!40000 ALTER TABLE `constatare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echipament_productie`
--

DROP TABLE IF EXISTS `echipament_productie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `echipament_productie` (
  `id` bigint NOT NULL,
  `nume` varchar(255) NOT NULL,
  `operatiune` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echipament_productie`
--

LOCK TABLES `echipament_productie` WRITE;
/*!40000 ALTER TABLE `echipament_productie` DISABLE KEYS */;
INSERT INTO `echipament_productie` VALUES (9,'Helios 130','TaiereGravareLaser','Ocupat',0);
/*!40000 ALTER TABLE `echipament_productie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echipament_productie_material`
--

DROP TABLE IF EXISTS `echipament_productie_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `echipament_productie_material` (
  `echipament_productie_id` bigint NOT NULL,
  `material_id` bigint NOT NULL,
  PRIMARY KEY (`echipament_productie_id`,`material_id`),
  KEY `FKknw3rcqve0psj21k5fgb6desw` (`material_id`),
  CONSTRAINT `FK2l3nntce8vhs9e94kycyyjshy` FOREIGN KEY (`echipament_productie_id`) REFERENCES `echipament_productie` (`id`),
  CONSTRAINT `FKknw3rcqve0psj21k5fgb6desw` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echipament_productie_material`
--

LOCK TABLES `echipament_productie_material` WRITE;
/*!40000 ALTER TABLE `echipament_productie_material` DISABLE KEYS */;
INSERT INTO `echipament_productie_material` VALUES (9,6);
/*!40000 ALTER TABLE `echipament_productie_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echipament_service`
--

DROP TABLE IF EXISTS `echipament_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `echipament_service` (
  `id` bigint NOT NULL,
  `nume` varchar(255) NOT NULL,
  `serie` varchar(255) NOT NULL,
  `tip` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kh8way8697y1eyvbk6336kgkv` (`serie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echipament_service`
--

LOCK TABLES `echipament_service` WRITE;
/*!40000 ALTER TABLE `echipament_service` DISABLE KEYS */;
INSERT INTO `echipament_service` VALUES (3,'HP LaserJet','21','Printer',0);
/*!40000 ALTER TABLE `echipament_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (12);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interventie`
--

DROP TABLE IF EXISTS `interventie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interventie` (
  `id` bigint NOT NULL,
  `data_inceput` datetime(6) NOT NULL,
  `data_sfarsit` datetime(6) DEFAULT NULL,
  `descriere_defect` varchar(4000) NOT NULL,
  `version` int DEFAULT NULL,
  `angajat_id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  `constatare_id` bigint NOT NULL,
  `echipament_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpp2pii7nugv3wcy4p8roigs2m` (`angajat_id`),
  KEY `FKdnqlpbs7wyc1r0oayvruf0juc` (`client_id`),
  KEY `FKmcqqjxly11avjct9ekcrsj7r0` (`constatare_id`),
  KEY `FK47hmkw9o7kpv5qgdcrtcb8197` (`echipament_id`),
  CONSTRAINT `FK47hmkw9o7kpv5qgdcrtcb8197` FOREIGN KEY (`echipament_id`) REFERENCES `echipament_service` (`id`),
  CONSTRAINT `FKdnqlpbs7wyc1r0oayvruf0juc` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKmcqqjxly11avjct9ekcrsj7r0` FOREIGN KEY (`constatare_id`) REFERENCES `constatare` (`id`),
  CONSTRAINT `FKpp2pii7nugv3wcy4p8roigs2m` FOREIGN KEY (`angajat_id`) REFERENCES `angajat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interventie`
--

LOCK TABLES `interventie` WRITE;
/*!40000 ALTER TABLE `interventie` DISABLE KEYS */;
INSERT INTO `interventie` VALUES (11,'2022-09-04 00:00:00.000000','2022-09-04 00:00:00.000000','S-a inlocuit capul de imprimare.',1,2,1,2,3);
/*!40000 ALTER TABLE `interventie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` bigint NOT NULL,
  `data_finalizarii` datetime(6) DEFAULT NULL,
  `data_primirii` datetime(6) NOT NULL,
  `latime` double DEFAULT NULL,
  `lungime` double DEFAULT NULL,
  `status_job` varchar(255) NOT NULL,
  `tip_finisare` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  `client_id` bigint NOT NULL,
  `echipament_id` bigint NOT NULL,
  `material_id` bigint NOT NULL,
  `responsabil_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17amy3r92wfc4rwxm15q4t252` (`client_id`),
  KEY `FKauct4lm5r3kxxpmq3ogqaf7c0` (`echipament_id`),
  KEY `FKraxpdokvb25ecksjk1i1ftg8r` (`material_id`),
  KEY `FKhkywthhlrmwcrskoxh6taq10f` (`responsabil_id`),
  CONSTRAINT `FK17amy3r92wfc4rwxm15q4t252` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKauct4lm5r3kxxpmq3ogqaf7c0` FOREIGN KEY (`echipament_id`) REFERENCES `echipament_productie` (`id`),
  CONSTRAINT `FKhkywthhlrmwcrskoxh6taq10f` FOREIGN KEY (`responsabil_id`) REFERENCES `angajat` (`id`),
  CONSTRAINT `FKraxpdokvb25ecksjk1i1ftg8r` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (10,'2022-09-14 00:00:00.000000','2022-09-04 00:00:00.000000',2,3,'Noua','CuTiv',0,1,9,6,1);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` bigint NOT NULL,
  `cantitate_mp` double DEFAULT NULL,
  `nume` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (6,12,'PMMA3',1),(7,18,'PMMA2',1),(8,12,'PMMA4',0);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` bigint NOT NULL,
  `nume_rol` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin',1),(2,'sales',1),(3,'service',1),(4,'manager',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizator`
--

DROP TABLE IF EXISTS `utilizator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizator` (
  `id` bigint NOT NULL,
  `nume_utilizator` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL,
  `version` int DEFAULT NULL,
  `angajat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7a0arqndk0gwr1wdf9quuf7hm` (`nume_utilizator`),
  KEY `FKinoj3bf5pex5wd4d0cf0m4f80` (`angajat_id`),
  CONSTRAINT `FKinoj3bf5pex5wd4d0cf0m4f80` FOREIGN KEY (`angajat_id`) REFERENCES `angajat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizator`
--

LOCK TABLES `utilizator` WRITE;
/*!40000 ALTER TABLE `utilizator` DISABLE KEYS */;
INSERT INTO `utilizator` VALUES (1,'ljianu','$2a$10$D0yceZUd.k4MzJhRY.0NTefCmcvvp6SYf8KQE7zmOVT65zKXzBT6W',1,1),(5,'civanescu','$2a$10$38rS0tVxflqGGYHzYyFAkOR3lBWBom8aOPVjQMaTqLX5Woy/QfElu',1,2);
/*!40000 ALTER TABLE `utilizator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizator_rol`
--

DROP TABLE IF EXISTS `utilizator_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizator_rol` (
  `utilizator_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`utilizator_id`,`rol_id`),
  KEY `FK6v0r0ljpv5h6jdeqnqlm5tv51` (`rol_id`),
  CONSTRAINT `FK6v0r0ljpv5h6jdeqnqlm5tv51` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKlymi61ov41o3qd9yotyxi7qtl` FOREIGN KEY (`utilizator_id`) REFERENCES `utilizator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizator_rol`
--

LOCK TABLES `utilizator_rol` WRITE;
/*!40000 ALTER TABLE `utilizator_rol` DISABLE KEYS */;
INSERT INTO `utilizator_rol` VALUES (1,1),(1,2),(5,2),(1,3),(1,4);
/*!40000 ALTER TABLE `utilizator_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-04 12:32:18
