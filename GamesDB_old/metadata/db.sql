SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `mGamedefinition`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mGamedefinition` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `typeid` INT NOT NULL ,
  `formatid` INT NOT NULL ,
  `min_players` INT NULL DEFAULT 0 ,
  `max_players` INT NULL DEFAULT 0 ,
  `entryfee` FLOAT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gameplayer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gameplayer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `gameid` INT NOT NULL ,
  `userid` INT NOT NULL ,
  `join_time` TIMESTAMP NULL ,
  `leave_time` DATETIME NULL ,
  `winner` ENUM('0','1','2') NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dealplayer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dealplayer` (
  `id` INT NOT NULL ,
  `gameid` INT NULL ,
  `matchid` INT NULL ,
  `dealid` INT NULL ,
  `userid` INT NULL ,
  `points` INT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mGametype`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mGametype` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(256) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mFormat`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mFormat` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(256) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(256) NULL DEFAULT NULL ,
  `last_name` VARCHAR(256) NULL DEFAULT NULL ,
  `emailid` VARCHAR(256) NULL DEFAULT NULL ,
  `date_joined` TIMESTAMP NULL DEFAULT NULL ,
  `externalid` INT NULL DEFAULT NULL ,
  `extended_src_id` INT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prizeinventory`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `prizeinventory` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(256) NOT NULL ,
  `sponsor` VARCHAR(45) NOT NULL ,
  `icon` VARCHAR(256) NULL DEFAULT NULL ,
  `medium_image` VARCHAR(256) NULL DEFAULT NULL ,
  `large_image` VARCHAR(256) NULL DEFAULT NULL ,
  `logo` VARCHAR(256) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `definitionid` INT NOT NULL ,
  `prizeid` INT NOT NULL ,
  `start_time` DATETIME NULL DEFAULT NULL ,
  `end_time` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gametransaction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gametransaction` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `from` INT NULL DEFAULT NULL ,
  `gameid` INT NULL DEFAULT NULL ,
  `matchid` INT NULL DEFAULT NULL ,
  `dealid` INT NULL DEFAULT NULL ,
  `txtypeid` INT NULL DEFAULT NULL ,
  `to` INT NULL DEFAULT NULL ,
  `amount` INT NULL DEFAULT NULL ,
  `currencyid` INT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mTransactiontype`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mTransactiontype` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(256) NOT NULL ,
  `type` ENUM('credit','debit') NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mCurrency`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mCurrency` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `type` ENUM('chips','gold','cash') NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `achievements`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `achievements` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT ,
  `AchievementID` INT(11) NOT NULL ,
  `FacebookID` VARCHAR(50) NOT NULL ,
  `BadgeID` INT(11) NOT NULL DEFAULT '0' ,
  `IsCurrent` INT(1) NOT NULL ,
  `DateOfUnlock` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 1032
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `category` (
  `CategoryID` INT(10) NOT NULL AUTO_INCREMENT ,
  `CategoryName` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`CategoryID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gift`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gift` (
  `AutoGiftID` INT(20) NOT NULL AUTO_INCREMENT ,
  `CategoryID` INT(10) NOT NULL ,
  `GiftID` VARCHAR(20) NOT NULL DEFAULT '' ,
  `Name` VARCHAR(50) NOT NULL ,
  `Chips` INT(10) NOT NULL ,
  `Image` VARCHAR(50) NOT NULL ,
  `Description` VARCHAR(50) NOT NULL DEFAULT '' ,
  `Count` INT(11) NOT NULL ,
  PRIMARY KEY (`AutoGiftID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `giftexchange`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `giftexchange` (
  `GiftExchangeID` INT(11) NOT NULL AUTO_INCREMENT ,
  `GiftID` VARCHAR(20) NOT NULL ,
  `Sender` VARCHAR(40) NULL DEFAULT NULL ,
  `Receiver` VARCHAR(40) NULL DEFAULT NULL ,
  `IsAccepted` INT(11) NOT NULL DEFAULT '0' ,
  `DateOfExchange` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`GiftExchangeID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `giftinventory`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `giftinventory` (
  `InventoryID` INT(11) NOT NULL AUTO_INCREMENT ,
  `FacebookID` VARCHAR(20) NOT NULL ,
  `GiftID` VARCHAR(11) NOT NULL ,
  `Count` INT(11) NOT NULL DEFAULT '1' ,
  `DateOfUpdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`InventoryID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `inviterequests`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `inviterequests` (
  `InvitationID` INT(11) NOT NULL AUTO_INCREMENT ,
  `RequestID` VARCHAR(100) NOT NULL ,
  `SenderFBID` VARCHAR(50) NOT NULL ,
  `InvitedFBID` VARCHAR(50) NOT NULL DEFAULT '' ,
  `Status` ENUM('Pending','Accepted') NOT NULL DEFAULT 'Pending' ,
  `DateOfInvite` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`InvitationID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rummycurrency`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rummycurrency` (
  `RCID` INT(11) NOT NULL AUTO_INCREMENT ,
  `FBCredit` FLOAT(11,2) NOT NULL ,
  `CurrencyType` ENUM('EUR','INR','USD') NOT NULL DEFAULT 'USD' ,
  `Currency` FLOAT(11,2) NOT NULL ,
  `INR` FLOAT(11,2) NOT NULL ,
  `Discount` FLOAT NOT NULL ,
  `MangoGold` FLOAT(11,2) NOT NULL ,
  `RummyChips` FLOAT(11,2) NOT NULL ,
  PRIMARY KEY (`RCID`) )
ENGINE = MyISAM
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `transactiondetails`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `transactiondetails` (
  `TransactionID` INT(11) NOT NULL AUTO_INCREMENT ,
  `FBOrderID` VARCHAR(50) NOT NULL ,
  `BuyerID` VARCHAR(50) NOT NULL ,
  `Amount` INT(11) NOT NULL ,
  `RCID` INT(11) NOT NULL ,
  `Status` ENUM('Placed','Settled') NOT NULL DEFAULT 'Placed' ,
  `PurchaseDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`TransactionID`) )
ENGINE = MyISAM
AUTO_INCREMENT = 45
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
