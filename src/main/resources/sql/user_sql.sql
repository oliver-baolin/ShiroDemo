DROP TABLE IF EXISTS USER_INFO; 
CREATE TABLE USER_INFO(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`user_name` VARCHAR(30) NOT NULL,
`password` VARCHAR(32) NOT NULL,
`email` VARCHAR(32) DEFAULT NULL,
`phone` VARCHAR(16) DEFAULT NULL,
`sex` VARCHAR(1) DEFAULT NULL,
`status` VARCHAR(2) NOT NULL,
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建时间',
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (`ID`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8 COMMENT='用户表'