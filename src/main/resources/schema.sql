drop table `employee`;

CREATE TABLE if not exists `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `mydb`.`account` (
  `id` INT NOT NULL,
  `number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));