CREATE TABLE `batalhamoral`.`candidato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(250) NOT NULL,
  `cargo` VARCHAR(100) NOT NULL,
  `url` TEXT NOT NULL,
  `cidade` VARCHAR(250) NOT NULL,
  `partido` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));