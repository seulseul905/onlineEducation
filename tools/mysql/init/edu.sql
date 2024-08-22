create TABLE edu.edu_user (
  id BIGINT auto_increment NOT NULL comment 'ID',
	user_id varchar(50) not null comment '사용자 계정',
	user_name varchar(100) NOT NULL comment '사용자 이름',
	use_yn tinyint(1) default 1 not null comment '사용여부',
	PRIMARY KEY (id)
)