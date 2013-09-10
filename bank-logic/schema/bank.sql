# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.10)
# Database: bank
# Generation Time: 2013-09-10 16:46:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bank
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `pk_bank` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `port` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`pk_bank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;

INSERT INTO `bank` (`pk_bank`, `name`, `header`, `port`, `active`)
VALUES
	(1,'bank','6000018193','8001',1);

/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table batch_txn
# ------------------------------------------------------------

DROP TABLE IF EXISTS `batch_txn`;

CREATE TABLE `batch_txn` (
  `pk_batch_txn` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `card_expire` varchar(255) DEFAULT NULL,
  `txn_time` datetime DEFAULT NULL,
  `reference_number` varchar(255) NOT NULL,
  `authorization_id` varchar(255) DEFAULT NULL,
  `response_code` varchar(255) DEFAULT NULL,
  `batch_number` varchar(255) DEFAULT NULL,
  `fk_trace` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_batch_txn`),
  UNIQUE KEY `UK_4i5jlqykdi687txk54ag7oip8` (`reference_number`),
  KEY `FK_c248rvp7kbgxvbi9s7getd2pl` (`fk_trace`),
  CONSTRAINT `FK_c248rvp7kbgxvbi9s7getd2pl` FOREIGN KEY (`fk_trace`) REFERENCES `trace` (`pk_trace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table command
# ------------------------------------------------------------

DROP TABLE IF EXISTS `command`;

CREATE TABLE `command` (
  `pk_command` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `mti` varchar(255) DEFAULT NULL,
  `processing_code` varchar(255) DEFAULT NULL,
  `fk_bank` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_command`),
  KEY `FK_k4mlfuxpdijsjcf3hjelc1194` (`fk_bank`),
  CONSTRAINT `FK_k4mlfuxpdijsjcf3hjelc1194` FOREIGN KEY (`fk_bank`) REFERENCES `bank` (`pk_bank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `command` WRITE;
/*!40000 ALTER TABLE `command` DISABLE KEYS */;

INSERT INTO `command` (`pk_command`, `name`, `mti`, `processing_code`, `fk_bank`)
VALUES
	(1,'sale','0200','000000',1),
	(2,'void','0200','020000',1),
	(3,'echo','0800','990000',1),
	(4,'reversalsale','0400','000000',1),
	(5,'reversalvoid','0400','020000',1),
	(6,'settlement','0500','920000',1),
	(7,'settlementtrailer','0500','960000',1),
	(8,'batchupload','0320','000000',1);

/*!40000 ALTER TABLE `command` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table settlement_txn
# ------------------------------------------------------------

DROP TABLE IF EXISTS `settlement_txn`;

CREATE TABLE `settlement_txn` (
  `pk_settlement_txn` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_trace` bigint(20) DEFAULT NULL,
  `txn_time` datetime DEFAULT NULL,
  `batch_number` varchar(255) DEFAULT NULL,
  `settlementParameter` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `response_code` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_settlement_txn`),
  KEY `FK_evyvio2a4dsrpdicontr4ayix` (`fk_trace`),
  CONSTRAINT `FK_evyvio2a4dsrpdicontr4ayix` FOREIGN KEY (`fk_trace`) REFERENCES `trace` (`pk_trace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table terminal
# ------------------------------------------------------------

DROP TABLE IF EXISTS `terminal`;

CREATE TABLE `terminal` (
  `pk_terminal` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `tid` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `batch_count` int(11) DEFAULT NULL,
  `batch_amount` bigint(20) DEFAULT NULL,
  `fk_bank` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_terminal`),
  KEY `FK_4m76sei0ht70pkiccgo7w1cyi` (`fk_bank`),
  CONSTRAINT `FK_4m76sei0ht70pkiccgo7w1cyi` FOREIGN KEY (`fk_bank`) REFERENCES `bank` (`pk_bank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `terminal` WRITE;
/*!40000 ALTER TABLE `terminal` DISABLE KEYS */;

INSERT INTO `terminal` (`pk_terminal`, `active`, `mid`, `tid`, `count`, `amount`, `batch_count`, `batch_amount`, `fk_bank`)
VALUES
	(1,1,'000800172860017','11111111',0,0,0,0,1);

/*!40000 ALTER TABLE `terminal` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table trace
# ------------------------------------------------------------

DROP TABLE IF EXISTS `trace`;

CREATE TABLE `trace` (
  `pk_trace` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `fk_terminal` bigint(20) DEFAULT NULL,
  `trace_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_trace`),
  KEY `FK_mpqc0cja57s1mmp5h1xh1j2h2` (`fk_terminal`),
  CONSTRAINT `FK_mpqc0cja57s1mmp5h1xh1j2h2` FOREIGN KEY (`fk_terminal`) REFERENCES `terminal` (`pk_terminal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table transaction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `pk_transaction` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `card_expire` varchar(255) DEFAULT NULL,
  `txn_time` datetime DEFAULT NULL,
  `reference_number` varchar(255) NOT NULL,
  `authorization_id` varchar(255) DEFAULT NULL,
  `response_code` varchar(255) DEFAULT NULL,
  `void_amount` bigint(20) DEFAULT NULL,
  `reversal` tinyint(1) DEFAULT NULL,
  `fk_trace` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_transaction`),
  UNIQUE KEY `UK_4ifxw9gpaqmbisy3balsbu7rn` (`reference_number`),
  KEY `FK_c96v58pjwe3qagh57ky5a4ham` (`fk_trace`),
  CONSTRAINT `FK_c96v58pjwe3qagh57ky5a4ham` FOREIGN KEY (`fk_trace`) REFERENCES `trace` (`pk_trace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table void_txn
# ------------------------------------------------------------

DROP TABLE IF EXISTS `void_txn`;

CREATE TABLE `void_txn` (
  `pk_void_txn` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) DEFAULT NULL,
  `reversal` tinyint(1) DEFAULT NULL,
  `fk_transaction` bigint(20) DEFAULT NULL,
  `authorization_id` varchar(255) DEFAULT NULL,
  `response_code` varchar(255) DEFAULT NULL,
  `fk_trace` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_void_txn`),
  KEY `FK_58fk5ph51f36kov5da0eq0604` (`fk_transaction`),
  KEY `FK_t1j7ea9q2icmio9t9xiw56l0j` (`fk_trace`),
  CONSTRAINT `FK_t1j7ea9q2icmio9t9xiw56l0j` FOREIGN KEY (`fk_trace`) REFERENCES `trace` (`pk_trace`),
  CONSTRAINT `FK_58fk5ph51f36kov5da0eq0604` FOREIGN KEY (`fk_transaction`) REFERENCES `transaction` (`pk_transaction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
