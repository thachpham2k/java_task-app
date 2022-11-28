DROP SCHEMA IF EXISTS `task-manager` ;
CREATE SCHEMA IF NOT EXISTS `task-manager` DEFAULT CHARACTER SET utf8mb4 ;
USE `task-manager`;

-- -----------------------------------------------------
-- Table `project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project` ;

CREATE TABLE IF NOT EXISTS `project` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ldap` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `project_manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_manager` ;

CREATE TABLE IF NOT EXISTS `project_manager` (
  `project_id` BIGINT(20) NOT NULL,
  `pm_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`project_id`, `pm_id`));

CREATE INDEX `FKg552cxp0dwsmeo0h6wt1wql06` ON `project_manager` (`pm_id` ASC) VISIBLE;
-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `detail` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task` ;

CREATE TABLE IF NOT EXISTS `task` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `duration` DOUBLE NULL DEFAULT NULL,
  `end_date` VARCHAR(255) NULL DEFAULT NULL,
  `main_id` BIGINT(20) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `progress` INT(11) NULL DEFAULT NULL,
  `start_date` VARCHAR(255) NULL DEFAULT NULL,
  `state` INT(11) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE INDEX `FK2hsytmxysatfvt0p1992cw449` ON `task` (`user_id` ASC) VISIBLE;
-- -----------------------------------------------------
-- Table `user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_role` ;

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`));

CREATE INDEX `FKa68196081fvovjhkek5m97n3y` ON `user_role` (`role_id` ASC) VISIBLE;