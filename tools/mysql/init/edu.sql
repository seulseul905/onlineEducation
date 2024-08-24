-- 학생 회원 테이블
create TABLE edu.edu_student (
    student_id BIGINT auto_increment not null comment '학생 사용자 ID',
	student_user_id varchar(50) not null comment '학생 사용자 계정',
	student_user_password varchar(50) not null comment '학생 사용자 비밀번호',
	student_user_name varchar(100) not null comment '학생 사용자 이름',
	student_user_phone varchar(11) not null comment '학생 사용자 휴대전화 번호',
	student_user_lecture varchar(100) comment '학생 사용자 선택 강의',
	student_user_use_yn tinyint(1) default 1 not null comment '학생 회원 사용여부',
	PRIMARY KEY (student_id)
)

-- 강사 회원 테이블
create TABLE edu.edu_instructor (
    instructor_id BIGINT auto_increment not null comment '강사 사용자 ID',
	instructor_user_id varchar(50) not null comment '강사 사용자 계정',
	instructor_user_password varchar(50) not null comment '강사 사용자 비밀번호',
	instructor_user_name varchar(100) not null comment '강사 사용자 이름',
	instructor_user_phone varchar(11) not null comment '강사 사용자 휴대전화 번호',
	instructor_user_lecture varchar(100) not null comment '강사 사용자 강의명',
	instructor_user_use_yn tinyint(1) default 1 not null comment '강사 회원 사용여부',
	PRIMARY KEY (instructor_id)
)