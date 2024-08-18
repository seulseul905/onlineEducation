-- edu.edu_user definition

CREATE TABLE edu.edu_user (
	userId BIGINT auto_increment NOT NULL,
	userName varchar(100) NOT NULL,
	CONSTRAINT edu_user_pk PRIMARY KEY (userId)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;