CREATE TABLE `batalhamoral`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `lembrete` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
