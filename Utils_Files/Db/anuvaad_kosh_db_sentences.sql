-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: anuvaad_kosh_db
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `sentences`
--

DROP TABLE IF EXISTS `sentences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sentences` (
  `sentence_id` int NOT NULL AUTO_INCREMENT,
  `document_id` int NOT NULL,
  `sentence_text` text NOT NULL,
  `translation_text` text,
  `sentence_language_id` int NOT NULL,
  `translation_language_id` int DEFAULT NULL,
  `status` enum('pending','verified','rejected') NOT NULL DEFAULT 'pending',
  PRIMARY KEY (`sentence_id`),
  KEY `document_id` (`document_id`),
  KEY `sentence_language_id` (`sentence_language_id`),
  KEY `translation_language_id` (`translation_language_id`),
  CONSTRAINT `sentences_ibfk_1` FOREIGN KEY (`document_id`) REFERENCES `documents` (`document_id`) ON DELETE CASCADE,
  CONSTRAINT `sentences_ibfk_2` FOREIGN KEY (`sentence_language_id`) REFERENCES `languages` (`language_id`),
  CONSTRAINT `sentences_ibfk_3` FOREIGN KEY (`translation_language_id`) REFERENCES `languages` (`language_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sentences`
--

LOCK TABLES `sentences` WRITE;
/*!40000 ALTER TABLE `sentences` DISABLE KEYS */;
INSERT INTO `sentences` VALUES (1,6,'Hello, how are you?','नमस्ते, आप कैसे हैं?',1,2,'pending'),(2,6,'Good morning.','शुभ प्रभात।',1,2,'pending'),(3,6,'What is your name?','आपका नाम क्या है?',1,2,'pending'),(4,6,'I am learning programming.','मैं प्रोग्रामिंग सीख रहा हूँ।',1,2,'pending'),(5,6,'Thank you very much.','आपका बहुत धन्यवाद।',1,2,'pending'),(6,7,'Hello, how are you?','नमस्ते, आप कैसे हैं?',1,2,'pending'),(7,7,'Good morning.','शुभ प्रभात।',1,2,'pending'),(8,7,'What is your name?','आपका नाम क्या है?',1,2,'pending'),(9,7,'I am learning programming.','मैं प्रोग्रामिंग सीख रहा हूँ।',1,2,'pending'),(10,7,'Thank you very much.','आपका बहुत धन्यवाद।',1,2,'pending'),(11,8,'Hello, how are you?','नमस्ते, आप कैसे हैं?',1,2,'pending'),(12,8,'Good morning.','शुभ प्रभात।',1,2,'pending'),(13,8,'What is your name?','आपका नाम क्या है?',1,2,'pending'),(14,8,'I am learning programming.','मैं प्रोग्रामिंग सीख रहा हूँ।',1,2,'pending'),(15,8,'Thank you very much.','आपका बहुत धन्यवाद।',1,2,'pending'),(16,9,'Hello, how are you?','नमस्ते, आप कैसे हैं?',1,2,'pending'),(17,9,'Good morning.','शुभ प्रभात।',1,2,'pending'),(18,9,'What is your name?','आपका नाम क्या है?',1,2,'pending'),(19,9,'I am learning programming.','मैं प्रोग्रामिंग सीख रहा हूँ।',1,2,'pending'),(20,9,'Thank you very much.','आपका बहुत धन्यवाद।',1,2,'pending'),(21,10,'Hello, how are you?','नमस्ते, आप कैसे हैं?',1,2,'pending'),(22,10,'Good morning.','शुभ प्रभात।',1,2,'pending'),(23,10,'What is your name?','आपका नाम क्या है?',1,2,'pending'),(24,10,'I am learning programming.','मैं प्रोग्रामिंग सीख रहा हूँ।',1,2,'pending'),(25,10,'Thank you very much.','आपका बहुत धन्यवाद।',1,2,'pending');
/*!40000 ALTER TABLE `sentences` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-31 16:28:58
