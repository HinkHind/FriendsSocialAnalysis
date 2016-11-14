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
-- Table structure for table `csdn_entry`
--

DROP TABLE IF EXISTS `csdn_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `csdn_entry` (
  `entryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `csdnID` int(10) unsigned NOT NULL,
  `contentHolder` varchar(45) DEFAULT NULL,
  `publishedTime` datetime NOT NULL,
  `hasRead` tinyint(1) NOT NULL DEFAULT '0',
  `classHolder` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`entryID`),
  UNIQUE KEY `entryID_UNIQUE` (`entryID`),
  KEY `fk_weibo_entry_copy1_csdn_url1_idx` (`csdnID`),
  CONSTRAINT `fk_weibo_entry_copy1_csdn_url1` FOREIGN KEY (`csdnID`) REFERENCES `csdn_url` (`csdnID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csdn_entry`
--

LOCK TABLES `csdn_entry` WRITE;
/*!40000 ALTER TABLE `csdn_entry` DISABLE KEYS */;
INSERT INTO `csdn_entry` VALUES (1,1,'csdn>_<1_1','1999-09-09 00:00:00',0,NULL),(2,1,'csdn>_>1_2','1999-09-09 00:00:00',0,NULL),(3,2,'csdn<_>2_1','1999-09-09 00:00:00',0,NULL),(4,2,'csdn<_<2_2','1999-09-09 00:00:00',0,NULL);
/*!40000 ALTER TABLE `csdn_entry` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csdn_url`
--

LOCK TABLES `csdn_url` WRITE;
/*!40000 ALTER TABLE `csdn_url` DISABLE KEYS */;
INSERT INTO `csdn_url` VALUES (1,'妥',1,NULL),(2,'汗青',1,NULL);
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
  `userID` int(10) unsigned NOT NULL,
  `hasCsdn` tinyint(1) NOT NULL DEFAULT '0',
  `hasWeibo` tinyint(1) NOT NULL DEFAULT '0',
  `hasZhihu` tinyint(1) NOT NULL DEFAULT '0',
  `zhihuID` int(10) unsigned DEFAULT NULL,
  `weiboID` int(10) unsigned DEFAULT NULL,
  `csdnID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`friendID`),
  KEY `fk_friends_users_idx` (`userID`),
  KEY `fk_friends_zhihu_urls1_idx` (`zhihuID`),
  KEY `fk_friends_weibo_urls1_idx` (`weiboID`),
  KEY `fk_friends_csdn_urls1_idx` (`csdnID`),
  CONSTRAINT `fk_friends_csdn_urls1` FOREIGN KEY (`csdnID`) REFERENCES `csdn_url` (`csdnID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_users` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_weibo_urls1` FOREIGN KEY (`weiboID`) REFERENCES `weibo_url` (`weiboID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_zhihu_urls1` FOREIGN KEY (`zhihuID`) REFERENCES `zhihu_url` (`zhihuID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tt','123456789ttt'),(3,'ff','123456789fff'),(4,'eee','123456789eee'),(5,'ttt','123456789ttt'),(6,'tttt','123456789ttt'),(7,'eeew','123456789eee'),(8,'eeaa','123456789eee'),(9,'eaaa','123456789eee'),(10,'fwwd','123456789fff'),(11,'hrh','123456789hhh'),(12,'eegg','123456789eee'),(13,'eeffefe','123456789eee'),(14,'ee','123456789ttt'),(15,'ttttt','123456789ttt'),(16,'fege','123456789fff'),(17,'feg','123456789fff'),(18,'jioj','123456789jjj'),(19,'feage','123456789fff');
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
  `entryUrl` varchar(60) NOT NULL,
  `text` text NOT NULL,
  `likeNumber` int(11) NOT NULL,
  `shareNumber` int(11) NOT NULL,
  `commentNumber` int(11) NOT NULL,
  `sourceDevice` varchar(40) DEFAULT NULL,
  `isShared` tinyint(1) NOT NULL,
  `originLikeNumber` int(11) DEFAULT NULL,
  `originShareNumber` int(11) DEFAULT NULL,
  `originText` text,
  `originCommentNumber` int(11) DEFAULT NULL,
  `publishedTime` datetime NOT NULL,
  `hasRead` tinyint(1) NOT NULL DEFAULT '0',
  `classHolder` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`entryID`),
  UNIQUE KEY `entryID_UNIQUE` (`entryID`),
  KEY `fk_weibo_entries_weibo_urls1` (`weiboID`),
  CONSTRAINT `fk_weibo_entries_weibo_urls1` FOREIGN KEY (`weiboID`) REFERENCES `weibo_url` (`weiboID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
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
  `isNew` tinyint(4) NOT NULL DEFAULT '1',
  `tag` int(11) DEFAULT NULL,
  PRIMARY KEY (`weiboID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weibo_url`
--

LOCK TABLES `weibo_url` WRITE;
/*!40000 ALTER TABLE `weibo_url` DISABLE KEYS */;
/*!40000 ALTER TABLE `weibo_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhihu_entry`
--

DROP TABLE IF EXISTS `zhihu_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhihu_entry` (
  `entryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zhihuID` int(10) unsigned NOT NULL,
  `contentHolder` varchar(45) DEFAULT NULL,
  `publishedTime` datetime NOT NULL,
  `hasRead` tinyint(1) NOT NULL DEFAULT '0',
  `classHolder` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`entryID`),
  UNIQUE KEY `entryID_UNIQUE` (`entryID`),
  KEY `fk_weibo_entry_copy2_zhihu_url1_idx` (`zhihuID`),
  CONSTRAINT `fk_weibo_entry_copy2_zhihu_url1` FOREIGN KEY (`zhihuID`) REFERENCES `zhihu_url` (`zhihuID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhihu_entry`
--

LOCK TABLES `zhihu_entry` WRITE;
/*!40000 ALTER TABLE `zhihu_entry` DISABLE KEYS */;
INSERT INTO `zhihu_entry` VALUES (3,2,'zhihu2——1','1999-09-09 00:00:00',0,NULL),(4,2,'zhihu2——2','1999-09-09 00:00:00',0,NULL),(5,9,'zhihu9----1>^<','1999-08-09 00:00:00',0,NULL),(6,2,'fefe','2016-11-13 13:47:42',0,'f'),(7,2,'fefe','2016-11-13 13:47:44',0,'f');
/*!40000 ALTER TABLE `zhihu_entry` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhihu_url`
--

LOCK TABLES `zhihu_url` WRITE;
/*!40000 ALTER TABLE `zhihu_url` DISABLE KEYS */;
INSERT INTO `zhihu_url` VALUES (2,'zy',2),(3,NULL,1),(4,NULL,1),(5,'egeg',2),(7,'egeghreee',1),(8,'gegh',1),(9,'heshang',1),(10,'hjk',1),(13,'FEGE',1),(14,'geh',1);
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

-- Dump completed on 2016-11-13 22:43:08
