-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.17


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema lecture
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ lecture;
USE lecture;

--
-- Table structure for table `lecture`.`module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `mod_id` int(11) NOT NULL AUTO_INCREMENT,
  `crdt` int(11) DEFAULT NULL,
  `mod_code` varchar(255) DEFAULT NULL,
  `mod_leader` varchar(255) DEFAULT NULL,
  `mod_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecture`.`module`
--

/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` (`mod_id`,`crdt`,`mod_code`,`mod_leader`,`mod_name`) VALUES 
 (1,10,'ISAD357SL','Ms. Pushpa Subramanian','Software Development and Project Mgt'),
 (2,10,'SOFT336SL','Mr. Davide Marocco','Cross-Platform Development in C++'),
 (3,10,'ISAD330SL','Mr. Rasika Alahakoon','Advanced Databases and their Applications');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;


--
-- Table structure for table `lecture`.`schedule`
--

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(255) DEFAULT NULL,
  `schedule_end_date_time` datetime DEFAULT NULL,
  `schedule_start_date_time` datetime DEFAULT NULL,
  `module` int(11) DEFAULT NULL,
  `stu_grp` int(11) DEFAULT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `FK_7iohyfxu5tfu5kjgp8l40mh39` (`module`),
  KEY `FK_2tvv4f9dyd7wt00jjm41pnknf` (`stu_grp`),
  CONSTRAINT `FK_2tvv4f9dyd7wt00jjm41pnknf` FOREIGN KEY (`stu_grp`) REFERENCES `stu_grp` (`grp_id`),
  CONSTRAINT `FK_7iohyfxu5tfu5kjgp8l40mh39` FOREIGN KEY (`module`) REFERENCES `module` (`mod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecture`.`schedule`
--

/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` (`schedule_id`,`remark`,`schedule_end_date_time`,`schedule_start_date_time`,`module`,`stu_grp`) VALUES 
 (8,'','2017-04-14 11:00:00','2017-04-14 10:00:00',1,4),
 (9,'','2017-04-15 14:00:00','2017-04-15 11:00:00',3,1);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;


--
-- Table structure for table `lecture`.`stu_grp`
--

DROP TABLE IF EXISTS `stu_grp`;
CREATE TABLE `stu_grp` (
  `grp_id` int(11) NOT NULL AUTO_INCREMENT,
  `grp_code` varchar(255) DEFAULT NULL,
  `grp_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`grp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecture`.`stu_grp`
--

/*!40000 ALTER TABLE `stu_grp` DISABLE KEYS */;
INSERT INTO `stu_grp` (`grp_id`,`grp_code`,`grp_desc`) VALUES 
 (1,'G4','Group 4 - 50 Studnets'),
 (2,'G1','Group 1 - 50 Studnets'),
 (3,'G2','Group 2 - 50 Studnets'),
 (4,'G3','Group 3 - 50 Studnets'),
 (5,'G5','Group 5 - 20 Studnets');
/*!40000 ALTER TABLE `stu_grp` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
