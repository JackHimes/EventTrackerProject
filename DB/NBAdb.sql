-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema NBAdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `NBAdb` ;

-- -----------------------------------------------------
-- Schema NBAdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NBAdb` DEFAULT CHARACTER SET utf8 ;
USE `NBAdb` ;

-- -----------------------------------------------------
-- Table `team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team` ;

CREATE TABLE IF NOT EXISTS `team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NULL,
  `logo_url` VARCHAR(1500) NULL,
  `twitter_url` VARCHAR(1500) NULL,
  `city` VARCHAR(250) NULL,
  `venue` VARCHAR(500) NULL,
  `conference` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `player` ;

CREATE TABLE IF NOT EXISTS `player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(75) NOT NULL,
  `last_name` VARCHAR(75) NOT NULL,
  `number` INT NULL,
  `height` DOUBLE NULL,
  `weight` DOUBLE NULL,
  `points` DOUBLE NULL,
  `assists` DOUBLE NULL,
  `rebounds` DOUBLE NULL,
  `salary` DOUBLE NULL,
  `team_id` INT NULL,
  `enabled` TINYINT NULL,
  `position` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_player_team1_idx` (`team_id` ASC),
  CONSTRAINT `fk_player_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coach`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coach` ;

CREATE TABLE IF NOT EXISTS `coach` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(75) NULL,
  `salary` DOUBLE NULL,
  `team_id` INT NOT NULL,
  `first_name` VARCHAR(150) NULL,
  `last_name` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_coach_team1_idx` (`team_id` ASC),
  CONSTRAINT `fk_coach_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS nba@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'nba'@'localhost' IDENTIFIED BY 'nba';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'nba'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `team`
-- -----------------------------------------------------
START TRANSACTION;
USE `NBAdb`;
INSERT INTO `team` (`id`, `name`, `logo_url`, `twitter_url`, `city`, `venue`, `conference`) VALUES (1, 'Nuggets', 'https://www.nba.com/nuggets/sites/nuggets/files/dnuggets-primary-web-150x150.png?', 'https://twitter.com/nuggets', 'Denver', 'Ball Arena', 'Western');
INSERT INTO `team` (`id`, `name`, `logo_url`, `twitter_url`, `city`, `venue`, `conference`) VALUES (2, 'Thunder', 'https://cdn.nba.com/teams/uploads/sites/1610612760/2021/12/logo.svg', 'https://twitter.com/okcthunder', 'Oklahoma City', 'Paycom Center', 'Western');

COMMIT;


-- -----------------------------------------------------
-- Data for table `player`
-- -----------------------------------------------------
START TRANSACTION;
USE `NBAdb`;
INSERT INTO `player` (`id`, `first_name`, `last_name`, `number`, `height`, `weight`, `points`, `assists`, `rebounds`, `salary`, `team_id`, `enabled`, `position`) VALUES (1, 'Nikola', 'Jokic', 15, 83, 284, 26.0, 7.0, 14.1, 28.54, 1, NULL, 'C');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `number`, `height`, `weight`, `points`, `assists`, `rebounds`, `salary`, `team_id`, `enabled`, `position`) VALUES (2, 'Josh', 'Giddey', 3, 80, 205, 11.5, 6.4, 7.3, 6.0, 2, NULL, 'PG');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `number`, `height`, `weight`, `points`, `assists`, `rebounds`, `salary`, `team_id`, `enabled`, `position`) VALUES (3, 'Jamal', 'Murray', 27, 75, 215, 19.2, 5.7, 2.2, 5.1, 1, NULL, 'PG');

COMMIT;


-- -----------------------------------------------------
-- Data for table `coach`
-- -----------------------------------------------------
START TRANSACTION;
USE `NBAdb`;
INSERT INTO `coach` (`id`, `position`, `salary`, `team_id`, `first_name`, `last_name`) VALUES (1, 'Head Coach', 2, 1, 'Mike', 'Malone');
INSERT INTO `coach` (`id`, `position`, `salary`, `team_id`, `first_name`, `last_name`) VALUES (2, 'Head Coach', 1.5, 2, 'Mark', 'Daigneault');

COMMIT;

