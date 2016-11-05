-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `csdn_url`
--

DROP TABLE IF EXISTS `csdn_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `csdn_url` (
  `csdnID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `csdnUrl` varchar(45) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `attributeHolder` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`csdnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csdn_url`
--

LOCK TABLES `csdn_url` WRITE;
/*!40000 ALTER TABLE `csdn_url` DISABLE KEYS */;
/*!40000 ALTER TABLE `csdn_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `friendID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `friendName` varchar(20) NOT NULL,
  `users_userID` int(10) unsigned NOT NULL,
  `hasCsdn` tinyint(1) DEFAULT '0',
  `hasWeibo` tinyint(1) DEFAULT '0',
  `hasZhihu` tinyint(1) DEFAULT '0',
  `zhihuID` int(10) unsigned DEFAULT NULL,
  `weiboID` int(10) unsigned DEFAULT NULL,
  `csdnID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`friendID`),
  KEY `fk_friends_users_idx` (`users_userID`),
  KEY `fk_friends_zhihu_urls1_idx` (`zhihuID`),
  KEY `fk_friends_weibo_urls1_idx` (`weiboID`),
  KEY `fk_friends_csdn_urls1_idx` (`csdnID`),
  CONSTRAINT `fk_friends_csdn_urls1` FOREIGN KEY (`csdnID`) REFERENCES `csdn_url` (`csdnID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_users` FOREIGN KEY (`users_userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_weibo_urls1` FOREIGN KEY (`weiboID`) REFERENCES `weibo_url` (`weiboID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_zhihu_urls1` FOREIGN KEY (`zhihuID`) REFERENCES `zhihu_url` (`zhihuID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` VALUES (1,'ee',1,NULL,1,NULL,NULL,1,NULL),(2,'wer',1,0,1,0,NULL,2,NULL);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `imgUrl` varchar(128) NOT NULL,
  `lastActivity` datetime NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tt','123456789ttt','1','2016-11-04 16:35:42');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weibo_entry`
--

DROP TABLE IF EXISTS `weibo_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weibo_entry` (
  `entryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `weiboID` int(10) unsigned NOT NULL,
  `contentHolder` varchar(45) DEFAULT NULL,
  `publishedTime` datetime NOT NULL,
  `hasRead` tinyint(1) NOT NULL DEFAULT '0',
  `classHolder` varchar(45) DEFAULT NULL,
  `weibo_entriescol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`entryID`),
  UNIQUE KEY `entryID_UNIQUE` (`entryID`),
  KEY `fk_weibo_entries_weibo_urls1` (`weiboID`),
  CONSTRAINT `fk_weibo_entries_weibo_urls1` FOREIGN KEY (`weiboID`) REFERENCES `weibo_url` (`weiboID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weibo_entry`
--

LOCK TABLES `weibo_entry` WRITE;
/*!40000 ALTER TABLE `weibo_entry` DISABLE KEYS */;
INSERT INTO `weibo_entry` VALUES (1,1,'ttt1fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(2,1,'ttt2fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(3,1,'ttt3fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(4,1,'ttt4fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(5,1,'ttt5fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(6,1,'ttt6fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(7,1,'ttt7fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(8,1,'ttt8fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(9,1,'ttt9fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(10,1,'ttt10fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(11,1,'ttt11fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(12,1,'ttt12fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(13,1,'ttt13fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(14,1,'ttt14fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(15,1,'ttt15fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(16,1,'ttt16fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(17,1,'ttt17fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(18,1,'ttt18fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(19,1,'ttt19fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(20,1,'ttt20fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(21,1,'ttt21fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(22,1,'ttt22fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(23,1,'ttt23fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(24,1,'ttt24fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(25,1,'ttt25fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(26,1,'ttt26fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(27,1,'ttt27fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(28,1,'ttt28fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(29,1,'ttt29fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(30,1,'ttt30fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(31,1,'ttt31fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(32,1,'ttt32fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(33,1,'ttt33fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(34,1,'ttt34fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(35,1,'ttt35fff','2016-11-05 19:42:20',0,'ffeefege','gea'),(36,1,'ttt36fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(37,1,'ttt37fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(38,1,'ttt38fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(39,1,'ttt39fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(40,1,'ttt40fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(41,1,'ttt41fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(42,1,'ttt42fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(43,1,'ttt43fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(44,1,'ttt44fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(45,1,'ttt45fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(46,1,'ttt46fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(47,1,'ttt47fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(48,1,'ttt48fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(49,1,'ttt49fff','2016-11-05 19:42:21',0,'ffeefege','gea'),(99,2,'w3ders1efg','2016-11-05 19:59:07',0,'ffee1fege','gea'),(100,2,'w3ders2efg','2016-11-05 19:59:07',0,'ffee2fege','gea'),(101,2,'w3ders3efg','2016-11-05 19:59:07',0,'ffee3fege','gea'),(102,2,'w3ders4efg','2016-11-05 19:59:07',0,'ffee4fege','gea'),(103,2,'w3ders5efg','2016-11-05 19:59:07',0,'ffee5fege','gea'),(104,2,'w3ders6efg','2016-11-05 19:59:07',0,'ffee6fege','gea'),(105,2,'w3ders7efg','2016-11-05 19:59:07',0,'ffee7fege','gea'),(106,2,'w3ders8efg','2016-11-05 19:59:07',0,'ffee8fege','gea'),(107,2,'w3ders9efg','2016-11-05 19:59:07',0,'ffee9fege','gea'),(108,2,'w3ders10efg','2016-11-05 19:59:07',0,'ffee10fege','gea'),(109,2,'w3ders11efg','2016-11-05 19:59:07',0,'ffee11fege','gea'),(110,2,'w3ders12efg','2016-11-05 19:59:07',0,'ffee12fege','gea'),(111,2,'w3ders13efg','2016-11-05 19:59:07',0,'ffee13fege','gea'),(112,2,'w3ders14efg','2016-11-05 19:59:07',0,'ffee14fege','gea'),(113,2,'w3ders15efg','2016-11-05 19:59:07',0,'ffee15fege','gea'),(114,2,'w3ders16efg','2016-11-05 19:59:07',0,'ffee16fege','gea'),(115,2,'w3ders17efg','2016-11-05 19:59:07',0,'ffee17fege','gea'),(116,2,'w3ders18efg','2016-11-05 19:59:07',0,'ffee18fege','gea'),(117,2,'w3ders19efg','2016-11-05 19:59:07',0,'ffee19fege','gea'),(118,2,'w3ders20efg','2016-11-05 19:59:07',0,'ffee20fege','gea'),(119,2,'w3ders21efg','2016-11-05 19:59:07',0,'ffee21fege','gea'),(120,2,'w3ders22efg','2016-11-05 19:59:07',0,'ffee22fege','gea'),(121,2,'w3ders23efg','2016-11-05 19:59:07',0,'ffee23fege','gea'),(122,2,'w3ders24efg','2016-11-05 19:59:07',0,'ffee24fege','gea'),(123,2,'w3ders25efg','2016-11-05 19:59:07',0,'ffee25fege','gea'),(124,2,'w3ders26efg','2016-11-05 19:59:07',0,'ffee26fege','gea'),(125,2,'w3ders27efg','2016-11-05 19:59:07',0,'ffee27fege','gea'),(126,2,'w3ders28efg','2016-11-05 19:59:07',0,'ffee28fege','gea'),(127,2,'w3ders29efg','2016-11-05 19:59:07',0,'ffee29fege','gea'),(128,2,'w3ders30efg','2016-11-05 19:59:07',0,'ffee30fege','gea'),(129,2,'w3ders31efg','2016-11-05 19:59:07',0,'ffee31fege','gea'),(130,2,'w3ders32efg','2016-11-05 19:59:07',0,'ffee32fege','gea'),(131,2,'w3ders33efg','2016-11-05 19:59:07',0,'ffee33fege','gea'),(132,2,'w3ders34efg','2016-11-05 19:59:07',0,'ffee34fege','gea'),(133,2,'w3ders35efg','2016-11-05 19:59:07',0,'ffee35fege','gea'),(134,2,'w3ders36efg','2016-11-05 19:59:07',0,'ffee36fege','gea'),(135,2,'w3ders37efg','2016-11-05 19:59:07',0,'ffee37fege','gea'),(136,2,'w3ders38efg','2016-11-05 19:59:07',0,'ffee38fege','gea'),(137,2,'w3ders39efg','2016-11-05 19:59:07',0,'ffee39fege','gea'),(138,2,'w3ders40efg','2016-11-05 19:59:07',0,'ffee40fege','gea'),(139,2,'w3ders41efg','2016-11-05 19:59:07',0,'ffee41fege','gea'),(140,2,'w3ders42efg','2016-11-05 19:59:07',0,'ffee42fege','gea'),(141,2,'w3ders43efg','2016-11-05 19:59:07',0,'ffee43fege','gea'),(142,2,'w3ders44efg','2016-11-05 19:59:07',0,'ffee44fege','gea'),(143,2,'w3ders45efg','2016-11-05 19:59:07',0,'ffee45fege','gea'),(144,2,'w3ders46efg','2016-11-05 19:59:07',0,'ffee46fege','gea'),(145,2,'w3ders47efg','2016-11-05 19:59:07',0,'ffee47fege','gea'),(146,2,'w3ders48efg','2016-11-05 19:59:07',0,'ffee48fege','gea'),(147,2,'w3ders49efg','2016-11-05 19:59:07',0,'ffee49fege','gea');
/*!40000 ALTER TABLE `weibo_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weibo_url`
--

DROP TABLE IF EXISTS `weibo_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weibo_url` (
  `weiboID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `weiboUrl` varchar(45) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `placeHolder` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`weiboID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weibo_url`
--

LOCK TABLES `weibo_url` WRITE;
/*!40000 ALTER TABLE `weibo_url` DISABLE KEYS */;
INSERT INTO `weibo_url` VALUES (1,'tteesstt',1,'t'),(2,'fege',1,'rhrge');
/*!40000 ALTER TABLE `weibo_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhihu_url`
--

DROP TABLE IF EXISTS `zhihu_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhihu_url` (
  `zhihuID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zhihuUrl` varchar(45) DEFAULT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`zhihuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhihu_url`
--

LOCK TABLES `zhihu_url` WRITE;
/*!40000 ALTER TABLE `zhihu_url` DISABLE KEYS */;
/*!40000 ALTER TABLE `zhihu_url` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-05 21:16:18
