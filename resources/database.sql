
CREATE DATABASE `pnr_db`;

CREATE USER 'pnr_app'@'localhost' IDENTIFIED BY 'password123';

GRANT ALL PRIVILEGES ON `pnr_db`.* TO 'pnr_app'@'localhost';

CREATE TABLE `pnr_db`.`station`(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	description VARCHAR(90) NULL,
	PRIMARY KEY(id)
);