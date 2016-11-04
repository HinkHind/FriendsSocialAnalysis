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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
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
INSERT INTO `user` VALUES (1,'tt','tttttttttttttttt','1','2016-11-04 16:35:42');
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
  PRIMARY KEY (`entryID`,`publishedTime`),
  UNIQUE KEY `entryID_UNIQUE` (`entryID`),
  KEY `fk_weibo_entries_weibo_urls1` (`weiboID`),
  CONSTRAINT `fk_weibo_entries_weibo_urls1` FOREIGN KEY (`weiboID`) REFERENCES `weibo_url` (`weiboID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weibo_entry`
--

LOCK TABLES `weibo_entry` WRITE;
/*!40000 ALTER TABLE `weibo_entry` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weibo_url`
--

LOCK TABLES `weibo_url` WRITE;
/*!40000 ALTER TABLE `weibo_url` DISABLE KEYS */;
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

-- Dump completed on 2016-11-04 18:51:54
