CREATE DATABASE  IF NOT EXISTS `ifsp_farmacia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `ifsp_farmacia`;
-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: ifsp_farmacia
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `caixa` (
  `caixa_id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`caixa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa`
--

LOCK TABLES `caixa` WRITE;
/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
INSERT INTO `caixa` VALUES (1,'Caixa 1'),(2,'Caixa 2'),(3,'Caixa 3'),(4,'Caixa 4 (Preferencial)');
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caixa_historico`
--

DROP TABLE IF EXISTS `caixa_historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `caixa_historico` (
  `historico_id` int(11) NOT NULL AUTO_INCREMENT,
  `caixa_id` int(11) NOT NULL,
  `atendente_id` int(11) NOT NULL,
  `valor_abertura` double DEFAULT '0',
  `valor_fechamento` double DEFAULT '0',
  `data_abertura` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fechamento` datetime DEFAULT NULL,
  PRIMARY KEY (`historico_id`),
  KEY `atendente_id` (`atendente_id`),
  CONSTRAINT `caixa_historico_ibfk_1` FOREIGN KEY (`atendente_id`) REFERENCES `funcionario` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa_historico`
--

LOCK TABLES `caixa_historico` WRITE;
/*!40000 ALTER TABLE `caixa_historico` DISABLE KEYS */;
INSERT INTO `caixa_historico` VALUES (1,1,2,100,0,'2018-09-10 00:00:00',NULL);
/*!40000 ALTER TABLE `caixa_historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_nascimento` date NOT NULL,
  `data_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Cliente','Rua Fulano Beltrano, 476','(11) 4033-4909','123.456.789-01','1990-09-09','2018-11-28 19:13:23');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `funcionario_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(256) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_nascimento` date NOT NULL,
  PRIMARY KEY (`funcionario_id`),
  KEY `tipo_id` (`tipo_id`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`tipo_id`) REFERENCES `tipo_funcionario` (`tipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,1,'atendente','123','Atendente','Rua JoÃƒÆ’Ã‚Â£o Pedro Veloso, 1046','(11) 99411-2210','123.456.789-01','1990-09-09'),(2,2,'gerente','123','Gerente','Avenida JoÃƒÆ’Ã‚Â£o InÃƒÆ’Ã‚Â¡cio, 940','(11) 2477-1756','123.456.789-01','1990-09-09');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_pedido`
--

DROP TABLE IF EXISTS `itens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `itens_pedido` (
  `pedido_id` int(11) NOT NULL,
  `medicamento_id` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor_pago` double NOT NULL,
  KEY `pedido_id` (`pedido_id`),
  KEY `medicamento_id` (`medicamento_id`),
  CONSTRAINT `itens_pedido_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`),
  CONSTRAINT `itens_pedido_ibfk_2` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`medicamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_pedido`
--

LOCK TABLES `itens_pedido` WRITE;
/*!40000 ALTER TABLE `itens_pedido` DISABLE KEYS */;
INSERT INTO `itens_pedido` VALUES (1,1,1,12);
/*!40000 ALTER TABLE `itens_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicamento` (
  `medicamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_id` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `preco` double NOT NULL,
  `estoque` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`medicamento_id`),
  KEY `tipo_id` (`tipo_id`),
  CONSTRAINT `medicamento_ibfk_1` FOREIGN KEY (`tipo_id`) REFERENCES `tipo_medicamento` (`tipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES (1,1,'123','Pilula A',12,20);
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_cartao`
--

DROP TABLE IF EXISTS `pagamento_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagamento_cartao` (
  `pagamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `pedido_id` int(11) NOT NULL,
  `desconto` double NOT NULL,
  `total` double DEFAULT NULL,
  `conta` varchar(50) NOT NULL,
  `agencia` varchar(50) NOT NULL,
  PRIMARY KEY (`pagamento_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `pagamento_cartao_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_cartao`
--

LOCK TABLES `pagamento_cartao` WRITE;
/*!40000 ALTER TABLE `pagamento_cartao` DISABLE KEYS */;
INSERT INTO `pagamento_cartao` VALUES (1,1,1,0,12,'123','123');
/*!40000 ALTER TABLE `pagamento_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_dinheiro`
--

DROP TABLE IF EXISTS `pagamento_dinheiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagamento_dinheiro` (
  `pagamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `pedido_id` int(11) NOT NULL,
  `desconto` double NOT NULL,
  `total` double DEFAULT NULL,
  `pago` double NOT NULL,
  `troco` double NOT NULL,
  PRIMARY KEY (`pagamento_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `pagamento_dinheiro_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_dinheiro`
--

LOCK TABLES `pagamento_dinheiro` WRITE;
/*!40000 ALTER TABLE `pagamento_dinheiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento_dinheiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido` (
  `pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `caixa_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `total` double NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pedido_id`),
  KEY `caixa_id` (`caixa_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`caixa_id`) REFERENCES `caixa` (`caixa_id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `pedido_status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1,2,12,'2018-09-10 00:00:00');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_status`
--

DROP TABLE IF EXISTS `pedido_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido_status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_status`
--

LOCK TABLES `pedido_status` WRITE;
/*!40000 ALTER TABLE `pedido_status` DISABLE KEYS */;
INSERT INTO `pedido_status` VALUES (1,'Aberto'),(2,'Finalizado'),(3,'Cancelado');
/*!40000 ALTER TABLE `pedido_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_funcionario`
--

DROP TABLE IF EXISTS `tipo_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_funcionario` (
  `tipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`tipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_funcionario`
--

LOCK TABLES `tipo_funcionario` WRITE;
/*!40000 ALTER TABLE `tipo_funcionario` DISABLE KEYS */;
INSERT INTO `tipo_funcionario` VALUES (1,'Atendente'),(2,'Gerente');
/*!40000 ALTER TABLE `tipo_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_medicamento`
--

DROP TABLE IF EXISTS `tipo_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_medicamento` (
  `tipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`tipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_medicamento`
--

LOCK TABLES `tipo_medicamento` WRITE;
/*!40000 ALTER TABLE `tipo_medicamento` DISABLE KEYS */;
INSERT INTO `tipo_medicamento` VALUES (1,'PÃƒÂ­lula'),(2,'CÃƒÂ¡psula'),(3,'DrÃƒÂ¡gea');
/*!40000 ALTER TABLE `tipo_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pagamento`
--

DROP TABLE IF EXISTS `tipo_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_pagamento` (
  `tipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`tipo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pagamento`
--

LOCK TABLES `tipo_pagamento` WRITE;
/*!40000 ALTER TABLE `tipo_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ifsp_farmacia'
--

--
-- Dumping routines for database 'ifsp_farmacia'
--
/*!50003 DROP PROCEDURE IF EXISTS `PesquisarClientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PesquisarClientes`(in filtro varchar(40))
BEGIN
 select * from cliente
 where `nome` LIKE CONCAT('%', filtro, '%')
        OR `cpf` LIKE CONCAT('%', filtro, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-28 19:15:01
