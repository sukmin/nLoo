CREATE TABLE test (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	message VARCHAR(1000)

);

#건물
CREATE TABLE building (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nm VARCHAR(100) NOT NULL

);

#구역(층) 구역이라고 한 것은 한층에 화장실이 여러개 있을 수 있기 때문이다.
CREATE TABLE section (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	building_seq BIGINT NOT NULL,
	floor VARCHAR(4) NOT NULL,
	sex ENUM('M','F','A') DEFAULT 'A' NOT NULL,
	nick_nm VARCHAR(100)

);

CREATE INDEX idx_building_seq ON section ( building_seq );

#화장실 한칸
CREATE TABLE secret_room (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	section_seq BIGINT NOT NULL,
	nick_nm VARCHAR(100),
	use_cnt BIGINT DEFAULT 0,
	modify_ymdt DATETIME,
	stat ENUM('USE','UNUSE','FIX') NOT NULL DEFAULT 'UNUSE'

);

CREATE INDEX idx_section_seq ON secret_room ( section_seq );

#구역 노크
CREATE TABLE section_knock (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	section_seq BIGINT NOT NULL,
	reg_ymdt DATETIME NOT NULL

);

CREATE INDEX idx_section_seq_reg_ymdt ON section_knock (section_seq , reg_ymdt)

#이용내역
CREATE TABLE secret_room_history (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	secret_room_seq BIGINT NOT NULL,
	start_ymdt DATETIME NOT NULL,
	end_ymdt DATETIME

);

CREATE INDEX idx_secret_room_seq ON secret_room_history ( secret_room_seq );\


#낙서, 가장 읽기 좋은 70자 이내
drop table graffiti cascade;
CREATE TABLE `graffiti` (
    `seq` BIGINT auto_increment,
    `section_seq` BIGINT NOT NULL,
    `comment` varchar(70) DEFAULT 'I feel very fine',
    `url_type` enum('LINK','IMG','NA') default 'NA',
    `url` varchar(70) null,
    `like_cnt` int(10) default 0,
    `unlike_cnt` int(10) default 0,
	`reg_ymdt` DATETIME default now(),
    PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;


CREATE INDEX idx_graffiti_section_seq ON graffiti ( section_seq );




#TEST sample code
CREATE TABLE `user` (
    `id` varchar(36) NOT NULL,
    `name` varchar(45) DEFAULT NULL,
    `standard` varchar(45) DEFAULT NULL,
    `age` varchar(45) DEFAULT NULL,
    `sex` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
