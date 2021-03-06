create database admission;

use admission;

CREATE TABLE `applicants` (
  `applicantId` int(11) DEFAULT NULL,
  `NAME_LAST` varchar(30) DEFAULT NULL COMMENT 'Student last name',
  `NAME_FIRST` varchar(20) DEFAULT NULL COMMENT 'Student first name',
  `NAME_MIDDLE` varchar(20) DEFAULT NULL COMMENT 'Student middle name',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT 'Email address',
  `PERMANENT_COUNTRY` varchar(40) DEFAULT NULL COMMENT 'Permanent country of residence, blank is USA',
  `GENDER` varchar(1) DEFAULT NULL COMMENT 'Student gender',
  `CITIZEN_COUNTRY` varchar(40) DEFAULT NULL COMMENT 'Student country of citizenship, international students only',
  `GRE_VERBAL_SCORE` int(11) DEFAULT NULL COMMENT 'GRE Verbal test score',
  `GRE_QUANTITATIVE_SCORE` int(11) DEFAULT NULL COMMENT 'GRE Quantitative test score',
  `GRE_ANALYTICAL_WRITING_SCORE` float DEFAULT NULL COMMENT 'GRE Analytical Writing test score',
  `TOEFL_SCORE` int(11) DEFAULT NULL COMMENT 'TOEFL test score',
  `IELTS_SCORE` float DEFAULT NULL COMMENT 'IELTS test score',
  `DEGREE_SOUGHT_1` varchar(10) DEFAULT NULL COMMENT 'Degree desired in first program',
  `RESEARCH_INTEREST_1_1` varchar(100) DEFAULT NULL COMMENT 'First area of specialization for first program applied for',
  `STATEMENT_1` varchar(7500) DEFAULT NULL COMMENT 'Statement of purpose for first program',
  `REFERENCE_NAME_1` varchar(51) DEFAULT NULL COMMENT 'Name of first reference',
  `REFERENCE_NAME_2` varchar(51) DEFAULT NULL COMMENT 'Name of second reference',
  `REFERENCE_NAME_3` varchar(51) DEFAULT NULL COMMENT 'Name of third reference',
  `ETHNC` varchar(1) DEFAULT NULL COMMENT 'Ethnic indicator,1-Hispanic 2-American Indian 3-Asian 4-Black 5-Native Hawaiian or Pacific Islander 6-White 7-American,Indian tribal affiliation',
  PRIMARY KEY (`applicantId`)
);


CREATE TABLE `committeeRatings` (
  `id` VARCHAR(32) NOT NULL,
  `applicantId` int(11) NOT NULL,
  `totalScore` int(4) DEFAULT NULL,
  `comments` varchar(150) DEFAULT NULL,
  `ta` varchar(1) DEFAULT NULL,
  `fellowship` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `dutyAssigns` (
  `id` VARCHAR(32) NOT NULL,
  `applicantId` int(11) NOT NULL,
  `committee` int(11) DEFAULT NULL,
  `done` varchar(2) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `notes` (
  `id` VARCHAR(32) NOT NULL,
  `applicantId` int(11) NOT NULL,
  `note` varchar(150) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `decisions` (
  `id` VARCHAR(32) NOT NULL,
  `applicantId` int(11) NOT NULL,
  `admit` varchar(6) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
  `id` VARCHAR(32) NOT NULL,
  `uid` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `firstname` varchar(20) DEFAULT NULL,
  `category` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

show columns from applicants;
show columns from committeeRatings;
show columns from dutyAssigns;
show columns from notes;
show columns from decisions;
show columns from users;

INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('1', 'pavan', 'a', 'pavan@iastate.edu', 'Pavan', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('2', 'jil', 'a', 'jil@iastate.edu', 'Jim', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('3', 'chaudhur', 'a', 'chaudhur@iastate.edu', 'Soma', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('4', 'tavanapo', 'a', 'tavanapo@iastate.edu', 'Wallapak', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('5', 'gsong', 'a', 'gsong@iastate.edu', 'Guang', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('6', 'jtian', 'a', 'jtian@iastate.edu', 'Jin', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('7', 'wzhang', 'a', 'wzhang@iastate.edu', 'Wensheng', '0');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('8', 'yingcai', 'a', 'yingcai@iastate.edu', 'Ying', '1');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('9', 'wong', 'a', 'wong@iastate.edu', 'Johnny', '2');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('10', 'laurelt', 'a', 'laurelt@iastate.edu', 'Laurel', '3');
INSERT INTO `users` (`uid`, `username`, `password`, `email`, `firstname`, `category`) VALUES ('11', 'abigail2', 'a', 'abigail2@iastate.edu', 'Abigail', '3');
update users set password=password('abc123');
