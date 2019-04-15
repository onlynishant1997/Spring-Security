
DROP TABLE IF EXISTS `user_spring_bank`;

CREATE TABLE `user_spring_bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnf3mr02mebm53niyjriwxc4e6` (`account_id`),
  CONSTRAINT `FKnf3mr02mebm53niyjriwxc4e6` FOREIGN KEY (`account_id`) REFERENCES `account_spring_bank` (`accountNumber`)
);