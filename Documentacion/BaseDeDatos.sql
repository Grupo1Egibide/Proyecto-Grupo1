CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.33.10    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `Calendario`
--

DROP TABLE IF EXISTS `Calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Calendario` (
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Calendario`
--

LOCK TABLES `Calendario` WRITE;
/*!40000 ALTER TABLE `Calendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cuenta`
--

DROP TABLE IF EXISTS `Cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cuenta` (
  `nombre` varchar(45) NOT NULL,
  `contrasena` varchar(25) DEFAULT NULL,
  `tipoCuenta` int(11) DEFAULT NULL COMMENT '1- Admin\n2- Dueño\n3- Usuario',
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cuenta`
--

LOCK TABLES `Cuenta` WRITE;
/*!40000 ALTER TABLE `Cuenta` DISABLE KEYS */;
INSERT INTO `Cuenta` VALUES ('222222','22',3),('2pepe11','12345',3),('2pepe111','12345',3),('diego','12345',1),('dueño','12345',2),('hola','12345',2),('Iker','123456',3),('izaro','12345',1),('Juan','123454',3),('juanKie','12345',2),('juanLopez','12345',2),('Mikel','12345',2),('pato','12345',2),('pato2','12345',2),('pepe','12345',3),('sara','12345',1);
/*!40000 ALTER TABLE `Cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dueño`
--

DROP TABLE IF EXISTS `Dueño`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Dueño` (
  `codDueño` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Cuenta_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`codDueño`),
  KEY `fk_Dueño_Cuenta1_idx` (`Cuenta_nombre`),
  CONSTRAINT `fk_Dueño_Cuenta1` FOREIGN KEY (`Cuenta_nombre`) REFERENCES `Cuenta` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dueño`
--

LOCK TABLES `Dueño` WRITE;
/*!40000 ALTER TABLE `Dueño` DISABLE KEYS */;
INSERT INTO `Dueño` VALUES (1,'JuanKie','juanKie'),(2,'Mikel','Mikel'),(3,'dueño','dueño'),(5,'JuanLopez','juanLopez'),(6,'pato2','pato');
/*!40000 ALTER TABLE `Dueño` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo`
--

DROP TABLE IF EXISTS `Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo` (
  `codEquipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `Dueño_codDueño` int(11) NOT NULL,
  PRIMARY KEY (`codEquipo`),
  KEY `fk_Equipo_Dueño1_idx` (`Dueño_codDueño`),
  CONSTRAINT `fk_Equipo_Dueño1` FOREIGN KEY (`Dueño_codDueño`) REFERENCES `Dueño` (`codDueño`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo`
--

LOCK TABLES `Equipo` WRITE;
/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
INSERT INTO `Equipo` VALUES (1,'Sevilla',1),(2,'Alavesito',2),(3,'Athletic',1),(4,'Liverpool',5),(5,'KK',3),(6,'mdo',5),(8,'ss',2),(9,'ee',6);
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo_es_local`
--

DROP TABLE IF EXISTS `Equipo_es_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo_es_local` (
  `Equipo_codEquipo` int(11) NOT NULL,
  `Partido_codPartido` int(11) NOT NULL,
  `Partido_fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`Equipo_codEquipo`,`Partido_codPartido`,`Partido_fecha`),
  KEY `fk_Equipo_has_Partido_Partido1_idx` (`Partido_codPartido`,`Partido_fecha`),
  KEY `fk_Equipo_has_Partido_Equipo1_idx` (`Equipo_codEquipo`),
  CONSTRAINT `fk_Equipo_has_Partido_Equipo1` FOREIGN KEY (`Equipo_codEquipo`) REFERENCES `Equipo` (`codEquipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipo_has_Partido_Partido1` FOREIGN KEY (`Partido_codPartido`, `Partido_fecha`) REFERENCES `Partido` (`codPartido`, `fecha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo_es_local`
--

LOCK TABLES `Equipo_es_local` WRITE;
/*!40000 ALTER TABLE `Equipo_es_local` DISABLE KEYS */;
/*!40000 ALTER TABLE `Equipo_es_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo_es_visitante`
--

DROP TABLE IF EXISTS `Equipo_es_visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo_es_visitante` (
  `Equipo_codEquipo` int(11) NOT NULL,
  `Partido_codPartido` int(11) NOT NULL,
  `Partido_fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`Equipo_codEquipo`,`Partido_codPartido`,`Partido_fecha`),
  KEY `fk_Equipo_has_Partido_Partido2_idx` (`Partido_codPartido`,`Partido_fecha`),
  KEY `fk_Equipo_has_Partido_Equipo2_idx` (`Equipo_codEquipo`),
  CONSTRAINT `fk_Equipo_has_Partido_Equipo2` FOREIGN KEY (`Equipo_codEquipo`) REFERENCES `Equipo` (`codEquipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipo_has_Partido_Partido2` FOREIGN KEY (`Partido_codPartido`, `Partido_fecha`) REFERENCES `Partido` (`codPartido`, `fecha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo_es_visitante`
--

LOCK TABLES `Equipo_es_visitante` WRITE;
/*!40000 ALTER TABLE `Equipo_es_visitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `Equipo_es_visitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jornada`
--

DROP TABLE IF EXISTS `Jornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jornada` (
  `numJornada` int(11) NOT NULL AUTO_INCREMENT,
  `Calendario_fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`numJornada`),
  KEY `fk_Jornada_Calendario1_idx` (`Calendario_fecha`),
  CONSTRAINT `fk_Jornada_Calendario1` FOREIGN KEY (`Calendario_fecha`) REFERENCES `Calendario` (`fecha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jornada`
--

LOCK TABLES `Jornada` WRITE;
/*!40000 ALTER TABLE `Jornada` DISABLE KEYS */;
/*!40000 ALTER TABLE `Jornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jugador`
--

DROP TABLE IF EXISTS `Jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jugador` (
  `codJugador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `nick` varchar(45) DEFAULT NULL,
  `salario` int(5) DEFAULT NULL,
  `fechaAlta` varchar(10) DEFAULT NULL,
  `posicion` varchar(45) DEFAULT NULL,
  `Equipo_codEquipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`codJugador`),
  KEY `fk_Jugador_Equipo1_idx` (`Equipo_codEquipo`),
  CONSTRAINT `fk_Jugador_Equipo1` FOREIGN KEY (`Equipo_codEquipo`) REFERENCES `Equipo` (`codEquipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugador`
--

LOCK TABLES `Jugador` WRITE;
/*!40000 ALTER TABLE `Jugador` DISABLE KEYS */;
INSERT INTO `Jugador` VALUES (1,NULL,'diego12',2000,'15-10-16','',NULL),(3,NULL,'saraa1',2500,'20-01-17','',2),(4,NULL,'silviiia',1500,'15','',NULL),(5,NULL,'silviiia',1500,'15','',NULL),(6,NULL,'perezz',1500,'15-05-17','',9),(7,'juan','perezz',1500,'15-05-17',NULL,9),(8,'juan','perezz',1500,'15-05-17',NULL,NULL),(9,'juan','perezz',1500,'15-05-17',NULL,NULL),(12,NULL,'silvii15',1500,'15-05-17','',9),(13,'amaia','amaaai8',1500,'15-02-18',NULL,5),(14,NULL,'amaaai8',1500,'15-02-18','',NULL),(15,'Victoria','op181',1500,'15-05-18',NULL,NULL),(16,'Ramon','llo',1500,'102-18-12','ala',9),(17,'Oihane','leleqa',1500,'102-18-12','ala',9),(18,'Oihane','leleqa',1500,'102-18-12','ala',NULL),(19,'PEPE','bdsu',1500,'2519','lepe',9),(20,'PEPE','bdsu',1500,'2519','lepe',NULL),(21,NULL,'leiiz1',1500,'01-05-18','ala',NULL),(22,NULL,'saraa112',2500,'20-01-17','',NULL),(23,NULL,'uaaan',200000,'020215','ala',NULL),(24,NULL,'eee',1500,'252524','ala',2),(25,NULL,'adios',1500,'020114','ala',1);
/*!40000 ALTER TABLE `Jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido`
--

DROP TABLE IF EXISTS `Partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partido` (
  `codPartido` int(11) NOT NULL AUTO_INCREMENT,
  `resultado` varchar(45) DEFAULT NULL,
  `fecha` varchar(10) NOT NULL,
  `Jornada_numJornada` int(11) NOT NULL,
  PRIMARY KEY (`codPartido`,`fecha`,`Jornada_numJornada`),
  KEY `fk_Partido_Jornada1_idx` (`Jornada_numJornada`),
  CONSTRAINT `fk_Partido_Jornada1` FOREIGN KEY (`Jornada_numJornada`) REFERENCES `Jornada` (`numJornada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido`
--

LOCK TABLES `Partido` WRITE;
/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje` (
  `destino` int(11) NOT NULL,
  `anyo` int(11) DEFAULT NULL,
  PRIMARY KEY (`destino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-21 21:22:24
