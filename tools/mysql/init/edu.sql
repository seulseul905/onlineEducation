-- 학생 회원 테이블
create TABLE edu.edu_users (
  `id` BIGINT auto_increment not null comment '사용자 ID',
	`login_id` varchar(50) not null comment '사용자 계정',
	`password` varchar(500) not null comment '사용자 비밀번호',
	`name` varchar(100) not null comment '사용자 이름',
	`phone` varchar(11) not null comment '사용자 휴대전화 번호',
	`user_type` varchar(100) comment '사용자 유형',
	`use_yn` tinyint(1) default 1 not null comment '사용여부',
	`created_at` datetime(6) not null comment '생성일시',
	`updated_at` datetime(6) not null comment '수정일시',
	PRIMARY KEY (id),
	index         login_id(login_id),
	index         use_yn(use_yn),
	index         user_type(user_type),
	index         created_at(created_at),
	index         updated_at(updated_at)
)
;


// TODO : Lecture Table 다시 설계 해보기~

-- 강의 테이블
create TABLE edu.edu_lecture (
  lecture_id BIGINT auto_increment not null comment '강의ID',
	lecture_name varchar(100) not null comment '강의명',
	lecture_instructor_name varchar(100) not null comment '강의 강사명',
	lecture_student_name varchar(100) not null comment '수강생명',
	lecture_use_yn tinyint(1) default 1 not null comment '강의 사용여부',
	PRIMARY KEY (lecture_id)
)