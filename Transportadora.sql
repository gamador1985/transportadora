-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: transportadora
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `centroacopio`
--

DROP TABLE IF EXISTS `centroacopio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centroacopio` (
  `idCentroAcopio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCentroAcopio` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `locacion` varchar(255) DEFAULT NULL,
  `fkidCliente` int(11) DEFAULT NULL,
  `fkIdTipoCentroAcopio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCentroAcopio`),
  KEY `fkidCliente` (`fkidCliente`),
  KEY `fkIdTipoCentroAcopio` (`fkIdTipoCentroAcopio`),
  CONSTRAINT `centroacopio_ibfk_1` FOREIGN KEY (`fkidCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `centroacopio_ibfk_2` FOREIGN KEY (`fkIdTipoCentroAcopio`) REFERENCES `tipocentroacopio` (`idTipoCentroAcopio`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centroacopio`
--

LOCK TABLES `centroacopio` WRITE;
/*!40000 ALTER TABLE `centroacopio` DISABLE KEYS */;
INSERT INTO `centroacopio` VALUES (1,'Bodega Zona franca','ssssss','dddd',1,1),(2,'Zona indsutrial','ss','10-22',1,1),(3,'La 38','ss','10-22',1,1),(4,'Puerto libre','algo','mas',3,2),(5,'El chorro','calle','bogota',2,2),(6,'Montevideo','calle','bogota',2,2),(7,'Puerto Chile','calle','bogota',2,2),(8,'Puerto paramo','calle','bogota',2,2),(9,'Puerto Grande','calle','bogota',2,2),(10,'Parada rapidda','calle','bogota',2,2),(11,'Zona industrial','Calle 8 su 35 - 45','Bogota',2,2),(12,'Zona franca chia','Calle 8 su 35 - 45','Bogota',2,2),(13,'Zona franca Cajica','Calle 8 su 35 - 45','Bogota',2,2),(14,'Bodega Montevideo','Cra 68A 19 - 59','Bogota',4,1);
/*!40000 ALTER TABLE `centroacopio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombreContacto` varchar(100) DEFAULT NULL,
  `telefonoContacto` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Edicion Datos','Cliente','Alguno','12323232'),(2,'Cargo S.A','Calle 83 # 23-12','Edwin Gacha','317555555'),(3,'Logistica S.A','Cll 96 11-29','Luis Ramirez','3115221211'),(4,'Envios 1A','Tv 5G bis #48-100','Camila Gacha','3175656512');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleenvio`
--

DROP TABLE IF EXISTS `detalleenvio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleenvio` (
  `idDetalleEnvio` int(11) NOT NULL AUTO_INCREMENT,
  `fkIdEnvio` int(11) DEFAULT NULL,
  `fkidProducto` int(11) DEFAULT NULL,
  `valorUnidad` double DEFAULT NULL,
  `cantidad` double DEFAULT NULL,
  `valorTotal` double DEFAULT NULL,
  PRIMARY KEY (`idDetalleEnvio`),
  KEY `fkIdEnvio` (`fkIdEnvio`),
  KEY `fkidProducto` (`fkidProducto`),
  CONSTRAINT `detalleenvio_ibfk_1` FOREIGN KEY (`fkIdEnvio`) REFERENCES `envio` (`idEnvio`),
  CONSTRAINT `detalleenvio_ibfk_2` FOREIGN KEY (`fkidProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleenvio`
--

LOCK TABLES `detalleenvio` WRITE;
/*!40000 ALTER TABLE `detalleenvio` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleenvio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envio`
--

DROP TABLE IF EXISTS `envio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envio` (
  `idEnvio` int(11) NOT NULL AUTO_INCREMENT,
  `numeroGuia` varchar(10) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `fechaEntrega` date DEFAULT NULL,
  `fkIdCentroAcopio` int(11) DEFAULT NULL,
  `fkIdTransporte` int(11) DEFAULT NULL,
  `cantidadEnvio` int(11) DEFAULT NULL,
  `valorEnvio` double DEFAULT NULL,
  `porcentajeDescuento` int(11) DEFAULT NULL,
  `valorDescuento` double DEFAULT NULL,
  PRIMARY KEY (`idEnvio`),
  KEY `fkIdCentroAcopio` (`fkIdCentroAcopio`),
  KEY `fkIdTransporte` (`fkIdTransporte`),
  CONSTRAINT `envio_ibfk_1` FOREIGN KEY (`fkIdCentroAcopio`) REFERENCES `centroacopio` (`idCentroAcopio`),
  CONSTRAINT `envio_ibfk_2` FOREIGN KEY (`fkIdTransporte`) REFERENCES `transporte` (`idTransporte`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envio`
--

LOCK TABLES `envio` WRITE;
/*!40000 ALTER TABLE `envio` DISABLE KEYS */;
INSERT INTO `envio` VALUES (11,'e34t680djt','2022-02-21','2022-02-28',14,2,4,12000,0,0),(12,'1312e','2022-02-21','2022-02-28',14,2,8,25000,0,0),(13,'wc4960965u','2022-02-21','2022-02-28',5,2,3,400000,0,0),(14,'2a190k56uy','2022-02-21','2022-02-28',5,2,4,400000,0,0),(15,'8t4r569m86','2022-02-21','2022-02-28',5,2,5,400000,0,0),(19,'1098654r43','2022-02-21','2022-02-25',5,2,6,400000,0,0),(20,'54rncglsvp','2022-02-21','2022-02-25',5,2,7,400000,0,0),(21,'3it59a16tg','2022-02-21','2022-02-25',5,2,8,250000,0,0),(22,'3edcvgty78','2022-02-21','2022-02-25',5,2,10,250000,0,0),(23,'io8jnd456s','2022-02-21','2022-02-25',5,1,10,250000,0,0),(24,'3drhfty68s','2022-02-21','2022-02-25',5,2,11,250000,0,0),(25,'1qazxsw23e','2022-02-21','2022-02-25',5,1,11,250000,3,7500),(26,'dcvfr45tgb','2022-02-21','2022-02-25',5,1,11,250000,3,7500),(27,'hy67ujmki8','2022-02-21','2022-02-25',5,2,12,50000,5,2500),(28,'oplkmju876','2022-02-21','2022-02-25',5,2,12,50000,5,2500),(29,'htu2834756','2022-02-21','2022-02-25',5,2,10,50000,0,0),(30,'68zmki985y','2022-02-21','2022-02-25',5,1,10,50000,0,0);
/*!40000 ALTER TABLE `envio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(255) DEFAULT NULL,
  `fkCliente` int(11) DEFAULT NULL,
  `fechaCreado` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fkCliente` (`fkCliente`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`fkCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'PRUEBA CREACION PARA EMPRESA CARGO',2,'2022-02-20',1),(2,'PRODUCTOS LOGISTICA S.A',3,'2022-02-20',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocentroacopio`
--

DROP TABLE IF EXISTS `tipocentroacopio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocentroacopio` (
  `idTipoCentroAcopio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipoCentroAcopio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipoCentroAcopio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocentroacopio`
--

LOCK TABLES `tipocentroacopio` WRITE;
/*!40000 ALTER TABLE `tipocentroacopio` DISABLE KEYS */;
INSERT INTO `tipocentroacopio` VALUES (1,'Bodega'),(2,'Puerto');
/*!40000 ALTER TABLE `tipocentroacopio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipotransporte`
--

DROP TABLE IF EXISTS `tipotransporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipotransporte` (
  `idTipoTransporte` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipoTransporte` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipoTransporte`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipotransporte`
--

LOCK TABLES `tipotransporte` WRITE;
/*!40000 ALTER TABLE `tipotransporte` DISABLE KEYS */;
INSERT INTO `tipotransporte` VALUES (1,'Maritimo'),(2,'Terrestre');
/*!40000 ALTER TABLE `tipotransporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transporte`
--

DROP TABLE IF EXISTS `transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transporte` (
  `idTransporte` int(11) NOT NULL AUTO_INCREMENT,
  `identificacionTransporte` varchar(8) DEFAULT NULL,
  `fkidTipoTransporte` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTransporte`),
  KEY `fkidTipoTransporte` (`fkidTipoTransporte`),
  CONSTRAINT `transporte_ibfk_1` FOREIGN KEY (`fkidTipoTransporte`) REFERENCES `tipotransporte` (`idTipoTransporte`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
INSERT INTO `transporte` VALUES (1,'EDW3456A',1,1),(2,'ZYP825',2,1),(3,'BIW198',2,1),(4,'GAS8532S',1,1),(5,'DRF4528B',1,1),(6,'OBE411',2,1);
/*!40000 ALTER TABLE `transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'transportadora'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-21  2:45:57
