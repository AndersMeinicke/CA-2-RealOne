-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ca2_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ca2_db` ;

-- -----------------------------------------------------
-- Schema ca2_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ca2_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ca2_db` ;

-- -----------------------------------------------------
-- Table `ca2_db`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ca2_db`.`roles` ;

CREATE TABLE IF NOT EXISTS `ca2_db`.`roles` (
    `role_name` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`role_name`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ca2_db`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ca2_db`.`users` ;

CREATE TABLE IF NOT EXISTS `ca2_db`.`users` (
    `user_name` VARCHAR(25) NOT NULL,
    `user_pass` VARCHAR(255) NULL DEFAULT NULL,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`user_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ca2_db`.`users_has_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ca2_db`.`users_has_roles` ;

CREATE TABLE IF NOT EXISTS `ca2_db`.`users_has_roles` (
                                                          `users_user_id` INT NOT NULL,
                                                          `roles_role_name` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`users_user_id`, `roles_role_name`),
    INDEX `fk_users_has_roles_roles1_idx` (`roles_role_name` ASC) VISIBLE,
    INDEX `fk_users_has_roles_users_idx` (`users_user_id` ASC) VISIBLE,
    CONSTRAINT `fk_users_has_roles_users`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `ca2_db`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_users_has_roles_roles1`
    FOREIGN KEY (`roles_role_name`)
    REFERENCES `ca2_db`.`roles` (`role_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
