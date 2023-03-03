create database online_judge;
CREATE TABLE `record`(
`record_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
`user_id` INT NOT NULL COMMENT '提交者id',
`question_id` INT NOT NULL COMMENT '问题id',
`status` INT NOT NULL COMMENT '结果',
`language` INT NOT NULL COMMENT '代码语言',
`code` TEXT NOT NULL COMMENT '提交代码',
`submit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间'
);
INSERT INTO record ( record_id, user_id, question_id, status, language, code )
VALUES
    ( 1001, 1001, 1001, 1001, 2001, 'hello world\n');
