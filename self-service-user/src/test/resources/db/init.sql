
drop schema if exists `MYSCHEMA`;
create schema `MYSCHEMA`;
use `MYSCHEMA`;
DROP TABLE IF EXISTS `T_USER`;

CREATE TABLE `T_USER`
(
    `id` varchar(64),
    `name` varchar(255) NOT NULL,
    `age` int(10),
    `comment` varchar(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
