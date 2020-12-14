CREATE DATABASE `users` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `member` (
  `id` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `birth` int NOT NULL,
  `pnum` int DEFAULT NULL,
  `home` varchar(50) DEFAULT NULL,
  `member_code` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
