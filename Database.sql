-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: management
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `assesment_marks`
--

DROP TABLE IF EXISTS `assesment_marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assesment_marks` (
  `aid` int NOT NULL,
  `sid` varchar(45) NOT NULL,
  `marks` float DEFAULT NULL,
  PRIMARY KEY (`aid`,`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assesment_marks`
--

LOCK TABLES `assesment_marks` WRITE;
/*!40000 ALTER TABLE `assesment_marks` DISABLE KEYS */;
INSERT INTO `assesment_marks` VALUES (1,'1000',7),(1,'1001',6),(2,'1000',8),(2,'1001',6),(3,'1000',24),(3,'1001',27),(4,'1000',32),(4,'1001',31),(5,'1000',9),(5,'1001',6),(6,'1000',1),(6,'1001',4);
/*!40000 ALTER TABLE `assesment_marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assesments`
--

DROP TABLE IF EXISTS `assesments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assesments` (
  `aid` int NOT NULL,
  `course_id` int DEFAULT NULL,
  `section_no` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `marks` float DEFAULT NULL,
  `st_id` int DEFAULT NULL,
  `st_assigned` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assesments`
--

LOCK TABLES `assesments` WRITE;
/*!40000 ALTER TABLE `assesments` DISABLE KEYS */;
INSERT INTO `assesments` VALUES (1,1000,1,'Quiz',10,1234,'1'),(2,1000,1,'Assignment',10,1234,'1'),(3,1000,1,'Midterm',30,1234,'0'),(4,1000,1,'Final',40,1234,'0'),(5,1000,1,'Quiz',10,1234,'1'),(6,1000,1,'Assignment',10,1234,'0'),(7,1002,1,'Quiz',10,1222,'0'),(8,1002,1,'Quiz',10,1222,'0');
/*!40000 ALTER TABLE `assesments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_info`
--

DROP TABLE IF EXISTS `course_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_info` (
  `course_id` int NOT NULL,
  `tid` int NOT NULL,
  `section_no` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `st_id` int DEFAULT NULL,
  `days` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `course_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`tid`,`section_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_info`
--

LOCK TABLES `course_info` WRITE;
/*!40000 ALTER TABLE `course_info` DISABLE KEYS */;
INSERT INTO `course_info` VALUES (1000,1,1,'theory',1234,'sunday,tuesday','10:00-12:00','CSE111'),(1000,1,2,'theory',1111,'monday,wednesday','10:00-12:00','CSE111'),(1001,1,1,'theory',1000,'sunday,tuesday','10:00-12:00','CSE110'),(1001,1,2,'theory',1001,'sunday,tuesday','10:00-12:00','CSE110'),(1002,1,1,'theory',1222,'Monday,Wdnesday','10:00-12:00','CSE220');
/*!40000 ALTER TABLE `course_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL,
  `course_code` varchar(45) DEFAULT NULL,
  `semester` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `sections` int DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1000,'CSE111','Spring',2023,2),(1001,'CSE110','Spring',2023,2),(1002,'CSE220','Spring',2023,1);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st`
--

DROP TABLE IF EXISTS `st`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st` (
  `sid` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `st_no` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `course_id` varchar(45) DEFAULT NULL,
  `section` int DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st`
--

LOCK TABLES `st` WRITE;
/*!40000 ALTER TABLE `st` DISABLE KEYS */;
INSERT INTO `st` VALUES (1000,'Zoro','z@email.com','s03','1234','1001',1),(1001,'Sanji','sj@email.com','s04','1234','1001',2),(1111,'Shikamaru','sk@email.com','s02','1234','1000',2),(1222,'Sakura','sr@email.com','s10','1234','1002',1),(1234,'Sasuke','s@email.com','s01','1234','1000',1);
/*!40000 ALTER TABLE `st` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1000,'Goku','g@email.com','1234'),(1001,'Vegeta','v@email.com','1234'),(1002,'Luffy','l@email.com','1234'),(1100,'Ichigo','i@email.com','1234'),(1234,'Naruto','n@email.com','1234');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_assesments`
--

DROP TABLE IF EXISTS `student_assesments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_assesments` (
  `sid` int NOT NULL,
  `course_id` int NOT NULL,
  `section_no` int NOT NULL,
  `assesment` varchar(45) NOT NULL,
  `marks` float DEFAULT NULL,
  PRIMARY KEY (`sid`,`course_id`,`section_no`,`assesment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_assesments`
--

LOCK TABLES `student_assesments` WRITE;
/*!40000 ALTER TABLE `student_assesments` DISABLE KEYS */;
INSERT INTO `student_assesments` VALUES (1000,1000,1,'Assignment',0),(1000,1000,1,'Final',48),(1000,1000,1,'Midterm',32),(1000,1000,1,'Quiz',0),(1001,1000,1,'Assignment',0),(1001,1000,1,'Final',46.5),(1001,1000,1,'Midterm',36),(1001,1000,1,'Quiz',0),(1002,1000,2,'Assignment',0),(1002,1000,2,'Final',0),(1002,1000,2,'Midterm',0),(1002,1000,2,'Quiz',0),(1100,1001,2,'Assignment',0),(1100,1001,2,'Final',0),(1100,1001,2,'Midterm',0),(1100,1001,2,'Quiz',0),(1234,1000,1,'Assignment',0),(1234,1000,1,'Final',0),(1234,1000,1,'Midterm',0),(1234,1000,1,'Quiz',0),(1234,1001,1,'Assignment',0),(1234,1001,1,'Final',0),(1234,1001,1,'Midterm',0),(1234,1001,1,'Quiz',0);
/*!40000 ALTER TABLE `student_assesments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_courses`
--

DROP TABLE IF EXISTS `student_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_courses` (
  `sid` int NOT NULL,
  `course_id` int NOT NULL,
  `marks` float DEFAULT NULL,
  `grade` float DEFAULT NULL,
  `section` int NOT NULL,
  `course_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sid`,`course_id`,`section`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_courses`
--

LOCK TABLES `student_courses` WRITE;
/*!40000 ALTER TABLE `student_courses` DISABLE KEYS */;
INSERT INTO `student_courses` VALUES (1000,1000,80,0,1,'CSE111'),(1001,1000,82.5,0,1,'CSE111'),(1002,1000,0,0,2,'CSE111'),(1100,1001,0,0,2,'CSE110'),(1234,1000,0,0,1,'CSE111'),(1234,1001,0,0,1,'CSE110');
/*!40000 ALTER TABLE `student_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `tid` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'kakashi','k@email.com','1234'),(2,'Sensei','sn@email.com','1234');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18 20:40:06
