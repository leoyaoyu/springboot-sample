create schema IF NOT EXISTS `MYSCHEMA`;
USE `MYSCHEMA`;
CREATE TABLE IF NOT EXISTS `T_USER`
(
    `id` varchar(64),
    `name` varchar(255) NOT NULL,
    `age` int(10),
    `comment` varchar(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
