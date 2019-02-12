-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: job_fair
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (79,'bobiAdmin','b471049c6101b7de9a5660574102e65c35c8dc84ad06253e7eadb4d0511cb491'),(80,'donaAdmin','7b32cb3e178f3d91329981d354d1d408237c51fc874ef5cf9f039f38e3c7c5ef'),(81,'nisdeKompanija','b471049c6101b7de9a5660574102e65c35c8dc84ad06253e7eadb4d0511cb491'),(82,'ninaKompanija','fd28eb98b33741ad60900648cbfbb8a69cc3507a4bf950b6780541602b4203d9'),(83,'milerakKompanija','7b32cb3e178f3d91329981d354d1d408237c51fc874ef5cf9f039f38e3c7c5ef'),(84,'id150325d','599ef71a352b15070c0505749924bc353830e55d795209b9460fe4d6bf311385'),(85,'js150202d','8c9279c5c2298af5e1d33f6044b2198e82b87d93c474224e4df653e63125cb0e'),(87,'na150323d','425f2b889ce7992b198622e1a10df423329e97f76de71567c689496f9216edbe'),(88,'ni150432d','f4fa322532639172167c629a62283f2a9c503895417f8f7046380125b9e752a6'),(89,'ninaKompani','dc9e53db687a264ac281727d34b910ce4896397f4802431999b89bbc7bb9fe39');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `ime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_administrator` FOREIGN KEY (`id`) REFERENCES `User` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (79,'Bobika','Ilic','065432582','bobikaadmin@gmail.com'),(80,'Dona','Stankovic','064855159','donaadmin@gmail.com');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biografija`
--

DROP TABLE IF EXISTS `biografija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biografija` (
  `idstudent` int(11) NOT NULL,
  `ime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `postanski_br` int(11) NOT NULL,
  `drzava` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `grad` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `communication_skills` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `organisational_skills` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `jobrelated_skills` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idstudent`),
  KEY `idstudent_idx` (`idstudent`),
  CONSTRAINT `idstudent` FOREIGN KEY (`idstudent`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biografija`
--

LOCK TABLES `biografija` WRITE;
/*!40000 ALTER TABLE `biografija` DISABLE KEYS */;
INSERT INTO `biografija` VALUES (84,'Dajana','Ilic','VI vojvodjanske brigade',11504,'Srbija','Baric','Strane jezike tecno govorim, pisem i citam.','Umece organizovanja grupe ka boljoj sinergiji.','Telekomunikacije 1 & 2, Racunarske mreze.','06532323'),(85,'Sara','Jevtic','Bulevar kralja Aleksandra',11500,'Srbija','Beograd','/','/','/','065323234'),(87,'Andrijana','Ninkovic','Milutina Milankovica',11500,'Srbija','Beograd','Lako sporazumenavenje na stranom jeziku, spretna i snalazljiva u razgovoru sa razlicitim tipovima ljudi.','Snalazljiva u organizovanju malih grupa ','/','06532323'),(88,'Ivana','Novosel','Cacanska 10',11205,'Srbija','Cacak','/','/','Posedujem dobro strucno znanje iz masinstva, a takodje se samostalno bavim izucavanjem racunara.','06125255');
/*!40000 ALTER TABLE `biografija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datumZaCv`
--

DROP TABLE IF EXISTS `datumZaCv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datumZaCv` (
  `id` int(11) NOT NULL DEFAULT '0',
  `datumPocetak` date NOT NULL,
  `datumKraj` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datumZaCv`
--

LOCK TABLES `datumZaCv` WRITE;
/*!40000 ALTER TABLE `datumZaCv` DISABLE KEYS */;
INSERT INTO `datumZaCv` VALUES (0,'2019-02-08','2019-02-22');
/*!40000 ALTER TABLE `datumZaCv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datumZaSajam`
--

DROP TABLE IF EXISTS `datumZaSajam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datumZaSajam` (
  `id` int(11) NOT NULL,
  `datumPocetak` date NOT NULL,
  `datumKraj` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datumZaSajam`
--

LOCK TABLES `datumZaSajam` WRITE;
/*!40000 ALTER TABLE `datumZaSajam` DISABLE KEYS */;
INSERT INTO `datumZaSajam` VALUES (0,'2019-02-09','2019-02-15');
/*!40000 ALTER TABLE `datumZaSajam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jezici`
--

DROP TABLE IF EXISTS `jezici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jezici` (
  `idjezici` int(11) NOT NULL AUTO_INCREMENT,
  `idCV` int(11) NOT NULL,
  `jezik` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tip` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idjezici`),
  UNIQUE KEY `idjezici_UNIQUE` (`idjezici`),
  KEY `idcv_idx` (`idCV`),
  CONSTRAINT `idjezik` FOREIGN KEY (`idCV`) REFERENCES `biografija` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jezici`
--

LOCK TABLES `jezici` WRITE;
/*!40000 ALTER TABLE `jezici` DISABLE KEYS */;
INSERT INTO `jezici` VALUES (14,84,'Srpski jezik','maternji'),(15,84,'Engleski jezik','strani'),(16,84,'Nemacki jezik','strani'),(17,84,'Francuski jezik','strani'),(18,84,'Srpski jezik','maternji'),(19,84,'Engleski jezik','strani'),(20,84,'Nemacki jezik','strani'),(21,84,'Francuski jezik','strani'),(22,87,'Srpski jezik','maternji'),(23,87,'Ruski jezik','maternji'),(24,87,'Engleski jezik','strani'),(25,87,'Norveski jezik','strani'),(26,88,'Engleski jezik','maternji'),(27,88,'Srpski jezik','strani'),(28,88,'Spanski jezik','strani'),(29,88,'Norveski jezik','strani'),(30,85,'Engleski jezik','maternji'),(31,85,'Srpski jezik','strani');
/*!40000 ALTER TABLE `jezici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kompanija`
--

DROP TABLE IF EXISTS `kompanija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kompanija` (
  `id` int(11) NOT NULL,
  `naziv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `direktor_ime` varchar(45) CHARACTER SET utf8 NOT NULL,
  `direktor_prezime` varchar(45) CHARACTER SET utf8 NOT NULL,
  `pib` int(11) NOT NULL,
  `brojZaposlenih` int(11) NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sajt` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `delatnost` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `specijalnost` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `grad` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_kompanija` FOREIGN KEY (`id`) REFERENCES `User` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kompanija`
--

LOCK TABLES `kompanija` WRITE;
/*!40000 ALTER TABLE `kompanija` DISABLE KEYS */;
INSERT INTO `kompanija` VALUES (81,'NISDE d.o.o',' Blagoja Marjanovica Moše, 110','Denis','Ilic',35865489,35,'nisde@gmail.com','nisdecompany.rs','Energetika','Elektroenergetski pogoni','Beograd'),(82,'NINA d.o.o','Bulevar oslobo?enja , 11B','Nina','Ilic',35855489,40,'nina@gmail.com','ninacompany.rs','Telekomunikacije','Ra?unarske mreže','Novi Sad'),(83,'MILERAK d.o.o','1300 Kaplara, 23E','Mile','Ilic',35856589,120,'milerak@gmail.com','milerakcompany.rs','IT','Distribuirani sistemi','Niš'),(89,'NINA d.o.o','Bulevar oslobodjenja , 11B','Nina','Ilic',6354544,55,'nina@gmail.com','ninacompany.rs','Telekomunikacije','Racunarske mreze','Novi Sad');
/*!40000 ALTER TABLE `kompanija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konkurs`
--

DROP TABLE IF EXISTS `konkurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `konkurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idkonkurs` int(11) NOT NULL,
  `pozicija` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tipKonkurs` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `rok` date NOT NULL,
  `opis` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idkompanija` (`idkonkurs`),
  CONSTRAINT `idkompanija` FOREIGN KEY (`idkonkurs`) REFERENCES `kompanija` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konkurs`
--

LOCK TABLES `konkurs` WRITE;
/*!40000 ALTER TABLE `konkurs` DISABLE KEYS */;
INSERT INTO `konkurs` VALUES (15,81,'Inzenjer energetike','Posao','2019-02-10','Prijava nudi zaposlenje, sa ugovornom obavezom od 6 meseci.'),(16,81,'Inzenjer energetike','Posao','2019-02-20','Prijava nudi zaposlenje, sa ugovornom obavezom od 6 meseci.'),(17,81,'praktikant','Praksa','2019-02-20','Potreban vredan student za tromesecnu praksu.'),(18,81,'praktikant','Praksa','2019-02-20','Potreban vredan student za tromesecnu praksu.'),(19,81,'tehnicar','Praksa','2019-02-12','Potreban vredan student za tromesecnu praksu.'),(20,89,'Tehnicar','Praksa','2019-02-09','Praksa traje 3 meseca'),(21,89,'Tehnicar','Praksa','2019-02-09','Praksa traje 3 meseca'),(22,89,'Inzenjer Telekomunikacija','Posao','2019-02-09','Ugovorna obaveza od 12 meseci'),(23,89,'Praktikant','Praksa','2019-02-15','Ugovorna obaveza od 12 meseci'),(24,83,'Praktikant','Praksa','2019-02-14','Ugovor od 3 meseca'),(25,83,'Praktikant','Praksa','2019-02-14','Ugovor od 3 meseca');
/*!40000 ALTER TABLE `konkurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obrazovanje`
--

DROP TABLE IF EXISTS `obrazovanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obrazovanje` (
  `idobrazovanje` int(11) NOT NULL AUTO_INCREMENT,
  `dateod` date NOT NULL,
  `datedo` date NOT NULL,
  `on_going` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `stepen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `fakultet` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `idBio` int(11) NOT NULL,
  PRIMARY KEY (`idobrazovanje`),
  UNIQUE KEY `idobrazovanje_UNIQUE` (`idobrazovanje`),
  KEY `idobrazovanje_idx` (`idBio`),
  CONSTRAINT `idobr` FOREIGN KEY (`idBio`) REFERENCES `biografija` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obrazovanje`
--

LOCK TABLES `obrazovanje` WRITE;
/*!40000 ALTER TABLE `obrazovanje` DISABLE KEYS */;
INSERT INTO `obrazovanje` VALUES (7,'2012-09-01','2015-05-20','ne','Srednja skola','Gimnazija',84),(8,'2015-09-21','2019-09-21','da','Osnovne studije','ETF',84),(9,'2012-09-01','2015-05-20','ne','Srednja skola','Gimnazija',84),(10,'2015-09-21','2019-09-21','da','Osnovne studije','ETF',84),(11,'2012-09-01','2015-05-20','ne','Srednja skola','Gimnazija',87),(12,'2015-09-22','2019-09-21','da','Osnovne studije','Gradjevinski fakultet',87),(13,'2019-10-20','2021-02-22','da','Master studije','Masinski fakultet',88),(14,'2015-02-10','2019-10-22','da','Osnovne studije','ETF',85);
/*!40000 ALTER TABLE `obrazovanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocenjivanje`
--

DROP TABLE IF EXISTS `ocenjivanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocenjivanje` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `idstudent` int(11) NOT NULL,
  `ocena` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocenjivanje`
--

LOCK TABLES `ocenjivanje` WRITE;
/*!40000 ALTER TABLE `ocenjivanje` DISABLE KEYS */;
INSERT INTO `ocenjivanje` VALUES (13,'NISDE d.o.o',84,'4'),(14,'NISDE d.o.o',84,'');
/*!40000 ALTER TABLE `ocenjivanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prijavanakonkurs`
--

DROP TABLE IF EXISTS `prijavanakonkurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prijavanakonkurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idkonkurs` int(11) NOT NULL,
  `idcv` int(11) NOT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `coverletter` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id1_idx` (`idcv`),
  KEY `konkurs` (`idkonkurs`),
  CONSTRAINT `idkonkursbio` FOREIGN KEY (`idcv`) REFERENCES `biografija` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `konkurs` FOREIGN KEY (`idkonkurs`) REFERENCES `konkurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prijavanakonkurs`
--

LOCK TABLES `prijavanakonkurs` WRITE;
/*!40000 ALTER TABLE `prijavanakonkurs` DISABLE KEYS */;
INSERT INTO `prijavanakonkurs` VALUES (24,20,84,'prihvacen','Zelim da pripadam vasem timu.'),(25,19,84,'prihvacen','Zelim da pripadam vasem timu.'),(26,21,84,'odbijen','Zelim da pripadam vasem timu.'),(27,18,84,'cekanje','Zelim da pripadam vasem timu.'),(28,17,84,'cekanje','Zelim da pripadam vasem timu.'),(29,19,85,'odbijen','Zelim da se usavrsim.'),(30,21,85,'prihvacen','Zelim da se usavrsim.'),(31,18,88,'cekanje','Zelim da se usavrsim.'),(32,17,88,'odbijen','Zelim da se usavrsim.'),(33,21,88,'odbijen','Zelim da se usavrsim.'),(34,16,87,'cekanje','Zelim da usavrsim svoje znanje');
/*!40000 ALTER TABLE `prijavanakonkurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prijavanasajam`
--

DROP TABLE IF EXISTS `prijavanasajam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prijavanasajam` (
  `idkompanije` int(11) NOT NULL,
  `tipprijave` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `komentar` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idkompanije`),
  UNIQUE KEY `id_kompanije_UNIQUE` (`idkompanije`),
  CONSTRAINT `id` FOREIGN KEY (`idkompanije`) REFERENCES `kompanija` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prijavanasajam`
--

LOCK TABLES `prijavanasajam` WRITE;
/*!40000 ALTER TABLE `prijavanasajam` DISABLE KEYS */;
INSERT INTO `prijavanasajam` VALUES (81,'Srebrni','Odbijen','Nije prikladan za sajam'),(82,'bbb','Neaktivan',NULL),(83,'Srebrni','Prihvacen',''),(89,'Zlatni','Cekanje',NULL);
/*!40000 ALTER TABLE `prijavanasajam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standovi`
--

DROP TABLE IF EXISTS `standovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standovi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `kompanijaIme` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `kompanijaId` int(11) NOT NULL,
  `vreme` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `kompanijaid_idx` (`kompanijaId`),
  CONSTRAINT `kompanijaid` FOREIGN KEY (`kompanijaId`) REFERENCES `kompanija` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standovi`
--

LOCK TABLES `standovi` WRITE;
/*!40000 ALTER TABLE `standovi` DISABLE KEYS */;
/*!40000 ALTER TABLE `standovi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `ime` varchar(45) CHARACTER SET utf8 NOT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `godina_studija` int(11) NOT NULL,
  `diplomirao` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  CONSTRAINT `user_student` FOREIGN KEY (`id`) REFERENCES `User` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (84,'Dajana','Ilic','065252525','id150325d@student.etf',4,0),(85,'Sara','Jevtic','065252525','js150202d@student.etf',3,0),(87,'Andrijana','Ninkovic','065323232','na150323d@student.etf',2,0),(88,'Ivana','Novosel','065434334','ni150432d@student.etf',5,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webSites`
--

DROP TABLE IF EXISTS `webSites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webSites` (
  `idwebSites` int(11) NOT NULL AUTO_INCREMENT,
  `idcv` int(11) NOT NULL,
  `web` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idwebSites`),
  KEY `fk_webSites_1_idx` (`idcv`),
  CONSTRAINT `idweb` FOREIGN KEY (`idcv`) REFERENCES `biografija` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webSites`
--

LOCK TABLES `webSites` WRITE;
/*!40000 ALTER TABLE `webSites` DISABLE KEYS */;
INSERT INTO `webSites` VALUES (10,84,'id150325d@student.etf'),(11,84,'dajana@facebook.com'),(12,84,'id150325d@student.etf'),(13,84,'dajana@facebook.com'),(14,87,'na150323d@etf.rs'),(15,87,'andrijana@facebook.rs'),(16,88,'ni150432d@student.etf'),(17,88,'ivana@facebook.com'),(18,88,'WhatsApp/IvanaNovosel'),(19,85,'js150202d@student.etf');
/*!40000 ALTER TABLE `webSites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaposlenje`
--

DROP TABLE IF EXISTS `zaposlenje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zaposlenje` (
  `idzaposlenje` int(11) NOT NULL AUTO_INCREMENT,
  `date_od` date NOT NULL,
  `date_do` date NOT NULL,
  `on_going` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pozicija` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `firma` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `idbio` int(11) NOT NULL,
  PRIMARY KEY (`idzaposlenje`),
  UNIQUE KEY `idzaposlenje_UNIQUE` (`idzaposlenje`),
  KEY `idbio_idx` (`idbio`),
  CONSTRAINT `idzaposlenje` FOREIGN KEY (`idbio`) REFERENCES `biografija` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaposlenje`
--

LOCK TABLES `zaposlenje` WRITE;
/*!40000 ALTER TABLE `zaposlenje` DISABLE KEYS */;
INSERT INTO `zaposlenje` VALUES (10,'2018-10-02','2018-10-31','ne','praktikant','NINA d.o.o',84),(11,'2019-02-01','2019-02-21','da','inzenjer','NISDE d.o.o',84),(12,'2018-10-02','2018-10-31','ne','','NINA d.o.o',84),(13,'2019-02-01','2019-02-21','da','','NISDE d.o.o',84),(14,'2019-02-01','2019-02-23','da','praktikant','MILERAK d.o.o',87),(15,'2019-02-01','2019-02-23','da','Masinski tehnicar','NINA d.o.o',88),(16,'2019-02-06','2019-02-20','da','Operater','MILERAK d.o.o',88),(17,'2019-02-09','2019-02-23','da','praktikant','NISDE d.o.o',85);
/*!40000 ALTER TABLE `zaposlenje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-12 13:38:19
