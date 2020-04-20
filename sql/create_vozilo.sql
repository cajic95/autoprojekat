CREATE TABLE `vozilo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `regbroj` varchar(45) COLLATE utf8_bin NOT NULL,
  `godisteProizvodnje` varchar(45) COLLATE utf8_bin NOT NULL,
  `status` varchar(45) COLLATE utf8_bin NOT NULL DEFAULT '1',
  `vlasnikId` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `regbroj_UNIQUE` (`regbroj`)
) ENGINE=InnoDB AUTO_INCREMENT=1522 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
