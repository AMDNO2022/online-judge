create database online_judge;
CREATE TABLE `user`(
`user_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '用户id',
`username` VARCHAR(30) NOT NULL COMMENT '用户名',
`account` VARCHAR(30) NOT NULL COMMENT '用于登录和标识的账号',
`password` VARCHAR(45) NOT NULL COMMENT '密码',
`created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间'
);
CREATE TABLE `question`(
`question_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '问题id',
`question_name` VARCHAR(60) NOT NULL COMMENT '问题名称',
`question_description` VARCHAR(1000) NOT NULL COMMENT '问题描述',
`question_input` VARCHAR(250) NOT NULL COMMENT '样例输入',
`question_output` VARCHAR(250) NOT NULL COMMENT '样例输出',
`question_test_input` VARCHAR(250) NOT NULL COMMENT '测试样例输入',
`question_test_output` VARCHAR(250) NOT NULL COMMENT '测试样例输出',
`created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间'
);
CREATE TABLE `record`(
`record_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '记录id',
`user_id` INT UNSIGNED NOT NULL COMMENT '提交者id',
`question_id` INT UNSIGNED NOT NULL COMMENT '问题id',
`status` INT UNSIGNED NOT NULL COMMENT '结果',
`language` INT UNSIGNED NOT NULL COMMENT '代码语言',
`code` TEXT NOT NULL COMMENT '提交代码',
`submit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
foreign key(`user_id`) references user(user_id),
foreign key(`question_id`) references question(question_id)
);

INSERT INTO user (user_id, username, account, password)
VALUES( 100001, 'A d nn i n', 'admin', SHA1('123456'));

INSERT INTO question ( question_id, question_name, question_description, question_input, question_output, question_test_input, question_test_output)
VALUES( 752001, '两数之和', '写一个函数，输入 a, b， 输出a+b', '1 2\n', '3\n', '12345 54321\n', '66666\n');

INSERT INTO question ( question_id, question_name, question_description, question_input, question_output, question_test_input, question_test_output)
VALUES( 752002, '两数之和2', '写一个函数，输入 a, b， 输出a+b，需要考虑大数。', '2100000000 2100000000\n', '4200000000\n', '210000000021000000002100000000 210000000021000000002100000000\n', '420000000042000000004200000000\n');

INSERT INTO question ( question_id, question_name, question_description, question_input, question_output, question_test_input, question_test_output)
VALUES( 752003, '斐波那契数列', '写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：\n\nF(0) = 0,   F(1) = 1\nF(N) = F(N - 1) + F(N - 2), 其中 N > 1.\n斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。\n\n答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。', '5\n', '5\n', '45\n', '134903163\n');

INSERT INTO record ( record_id, user_id, question_id, status, language, code )
VALUES( 8383834, 100001, 752001, 1001, 1, 'hello world\n');