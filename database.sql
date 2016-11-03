-- MySQL Script generated by MySQL Workbench
-- 11/03/16 19:17:39
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db` DEFAULT CHARACTER SET utf8 ;
USE `db` ;

-- -----------------------------------------------------
-- Table `db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`users` (
  `userID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `imgUrl` VARCHAR(128) NOT NULL,
  `lastActivity` DATETIME NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`zhihu_urls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`zhihu_urls` (
  `zhihuID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `zhihuUrl` VARCHAR(45) NULL DEFAULT NULL,
  `count` INT NOT NULL,
  PRIMARY KEY (`zhihuID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`weibo_urls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`weibo_urls` (
  `weiboID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `weiboUrl` VARCHAR(45) NULL DEFAULT NULL,
  `count` INT NOT NULL,
  `placeHolder` VARCHAR(45) NULL,
  PRIMARY KEY (`weiboID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`csdn_urls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`csdn_urls` (
  `csdnID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `csdnUrl` VARCHAR(45) NULL DEFAULT NULL,
  `count` INT NOT NULL,
  `attributeHolder` VARCHAR(45) NULL,
  PRIMARY KEY (`csdnID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`friends`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`friends` (
  `friendID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `friendName` VARCHAR(20) NOT NULL,
  `users_userID` INT UNSIGNED NOT NULL,
  `hasCsdn` TINYINT(1) NULL DEFAULT 0,
  `hasWeibo` TINYINT(1) NULL DEFAULT 0,
  `hasZhihu` TINYINT(1) NULL DEFAULT 0,
  `zhihuID` INT UNSIGNED NULL DEFAULT NULL,
  `weiboID` INT UNSIGNED NULL DEFAULT NULL,
  `csdnID` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`friendID`),
  INDEX `fk_friends_users_idx` (`users_userID` ASC),
  INDEX `fk_friends_zhihu_urls1_idx` (`zhihuID` ASC),
  INDEX `fk_friends_weibo_urls1_idx` (`weiboID` ASC),
  INDEX `fk_friends_csdn_urls1_idx` (`csdnID` ASC),
  CONSTRAINT `fk_friends_users`
    FOREIGN KEY (`users_userID`)
    REFERENCES `db`.`users` (`userID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_zhihu_urls1`
    FOREIGN KEY (`zhihuID`)
    REFERENCES `db`.`zhihu_urls` (`zhihuID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_weibo_urls1`
    FOREIGN KEY (`weiboID`)
    REFERENCES `db`.`weibo_urls` (`weiboID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friends_csdn_urls1`
    FOREIGN KEY (`csdnID`)
    REFERENCES `db`.`csdn_urls` (`csdnID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`weibo_entries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`weibo_entries` (
  `entryID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `weiboID` INT UNSIGNED NOT NULL,
  `contentHolder` VARCHAR(45) NULL,
  `publishedTime` DATETIME NOT NULL,
  `hasRead` TINYINT(1) NOT NULL DEFAULT 0,
  `classHolder` VARCHAR(45) NULL,
  `weibo_entriescol` VARCHAR(45) NULL,
  PRIMARY KEY (`entryID`, `publishedTime`),
  UNIQUE INDEX `entryID_UNIQUE` (`entryID` ASC),
  CONSTRAINT `fk_weibo_entries_weibo_urls1`
    FOREIGN KEY (`weiboID`)
    REFERENCES `db`.`weibo_urls` (`weiboID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
