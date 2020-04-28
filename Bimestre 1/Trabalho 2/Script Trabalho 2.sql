-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdtrabalho2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdtrabalho2` ;

-- -----------------------------------------------------
-- Schema bdtrabalho2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdtrabalho2` DEFAULT CHARACTER SET utf8 ;
USE `bdtrabalho2` ;

-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbadministrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbadministrador` (
  `CdAdministrador` INT(11) NOT NULL AUTO_INCREMENT,
  `NmAdministrador` VARCHAR(45) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Senha` VARCHAR(45) NOT NULL,
  `FoneAdministrador` VARCHAR(45) NULL DEFAULT NULL,
  `EndAdministrador` VARCHAR(100) NULL DEFAULT NULL,
  `CpfAdministrador` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CdAdministrador`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbcliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbcliente` (
  `CdCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `NmCliente` VARCHAR(45) NOT NULL,
  `FoneCliente` VARCHAR(45) NOT NULL,
  `EndCliente` VARCHAR(100) NULL DEFAULT NULL,
  `TipoCliente` CHAR(1) NOT NULL,
  `DocCliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CdCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbfornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbfornecedor` (
  `CdFornecedor` INT(11) NOT NULL AUTO_INCREMENT,
  `NmFornecedor` VARCHAR(45) NOT NULL,
  `FoneFornecedor` VARCHAR(45) NOT NULL,
  `CnpjFornecedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CdFornecedor`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbcompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbcompra` (
  `CdCompra` INT(11) NOT NULL AUTO_INCREMENT,
  `DtCompra` VARCHAR(10) NOT NULL,
  `ValorCompra` DOUBLE NOT NULL,
  `FormaPgCompra` CHAR(1) NOT NULL,
  `CdFornecedor` INT(11) NOT NULL,
  PRIMARY KEY (`CdCompra`),
  INDEX `fk_TbCompra_TbFornecedor1_idx` (`CdFornecedor` ASC),
  CONSTRAINT `fk_TbCompra_TbFornecedor1`
    FOREIGN KEY (`CdFornecedor`)
    REFERENCES `bdtrabalho2`.`tbfornecedor` (`CdFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbproduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbproduto` (
  `CdProduto` INT(11) NOT NULL AUTO_INCREMENT,
  `NmProduto` VARCHAR(45) NOT NULL,
  `Marca` VARCHAR(45) NULL DEFAULT NULL,
  `QtdEstoque` INT(11) NOT NULL,
  `PrecoCompra` DOUBLE NOT NULL,
  `PrecoVenda` DOUBLE NOT NULL,
  PRIMARY KEY (`CdProduto`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbcompra_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbcompra_produto` (
  `CdCompra` INT(11) NOT NULL,
  `CdProduto` INT(11) NOT NULL,
  `Qtd` INT(11) NOT NULL,
  `PrecoAntigo` DOUBLE NOT NULL,
  PRIMARY KEY (`CdCompra`, `CdProduto`),
  INDEX `fk_TbCompra_has_TbProduto_TbProduto1_idx` (`CdProduto` ASC),
  INDEX `fk_TbCompra_has_TbProduto_TbCompra1_idx` (`CdCompra` ASC),
  CONSTRAINT `fk_TbCompra_has_TbProduto_TbCompra1`
    FOREIGN KEY (`CdCompra`)
    REFERENCES `bdtrabalho2`.`tbcompra` (`CdCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TbCompra_has_TbProduto_TbProduto1`
    FOREIGN KEY (`CdProduto`)
    REFERENCES `bdtrabalho2`.`tbproduto` (`CdProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbvenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbvenda` (
  `CdVenda` INT(11) NOT NULL AUTO_INCREMENT,
  `DtVenda` VARCHAR(10) NULL DEFAULT NULL,
  `ValorVenda` DOUBLE NULL DEFAULT NULL,
  `FormaPgVenda` CHAR(1) NULL DEFAULT NULL,
  `CdCliente` INT(11) NOT NULL,
  PRIMARY KEY (`CdVenda`),
  INDEX `fk_TbVenda_TbCliente_idx` (`CdCliente` ASC),
  CONSTRAINT `fk_TbVenda_TbCliente`
    FOREIGN KEY (`CdCliente`)
    REFERENCES `bdtrabalho2`.`tbcliente` (`CdCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdtrabalho2`.`tbvenda_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtrabalho2`.`tbvenda_produto` (
  `CdVenda` INT(11) NOT NULL,
  `CdProduto` INT(11) NOT NULL,
  `Qtd` INT(11) NOT NULL,
  `PrecoAntigo` DOUBLE NOT NULL,
  PRIMARY KEY (`CdVenda`, `CdProduto`),
  INDEX `fk_TbVenda_has_TbProduto_TbProduto1_idx` (`CdProduto` ASC),
  INDEX `fk_TbVenda_has_TbProduto_TbVenda1_idx` (`CdVenda` ASC),
  CONSTRAINT `fk_TbVenda_has_TbProduto_TbProduto1`
    FOREIGN KEY (`CdProduto`)
    REFERENCES `bdtrabalho2`.`tbproduto` (`CdProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TbVenda_has_TbProduto_TbVenda1`
    FOREIGN KEY (`CdVenda`)
    REFERENCES `bdtrabalho2`.`tbvenda` (`CdVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
