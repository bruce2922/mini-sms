CREATE DATABASE `test_is_sms`;

-- Category
CREATE TABLE `category` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `category_UN` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Student
CREATE TABLE `student` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `student_number` varchar(100) NOT NULL,
   `birth_date` date NOT NULL,
   `gender_value` tinyint(1) NOT NULL,
   `starting_date` date DEFAULT NULL,
   `leaving_date` date DEFAULT NULL,
   `address` varchar(255) DEFAULT NULL,
   `category_id` bigint NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `student_UN` (`student_number`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Contact
CREATE TABLE `contact` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `relationship_value` tinyint(1) NOT NULL,
   `address` varchar(255) NOT NULL,
   `email` varchar(100) DEFAULT NULL,
   `phone` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Student & Contact
CREATE TABLE `student_contact` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `stu_id` bigint NOT NULL,
   `cont_id` bigint NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `student_contact_UN` (`stu_id`,`cont_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;