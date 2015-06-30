CREATE DATABASE media;

CREATE TABLE `media`.`audio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trackNumber` INT NULL,
  `title` VARCHAR(45) NULL,
  `album` VARCHAR(45) NULL,
  `artist` VARCHAR(45) NULL,
  `composer` VARCHAR(45) NULL,
  `year` VARCHAR(45) NULL,
  `genre` VARCHAR(45) NULL,
  `comment` VARCHAR(45) NULL,
  `lyrics` VARCHAR(45) NULL,
  `icon` LONGBLOB NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `media`.`users` (
  `id`    INT         NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(45) NOT NULL,
  `pass`  VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
);