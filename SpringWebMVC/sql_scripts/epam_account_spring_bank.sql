
DROP TABLE IF EXISTS `account_spring_bank`;

CREATE TABLE `account_spring_bank` (
  `accountNumber` int(11) NOT NULL AUTO_INCREMENT,
  `accountBalance` int(11) DEFAULT NULL,
  `isActiveAccount` bit(1) DEFAULT NULL,
  PRIMARY KEY (`accountNumber`)
);