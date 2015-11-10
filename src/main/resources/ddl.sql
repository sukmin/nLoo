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

#화장실 한칸
CREATE TABLE secret_room (
		
	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	section_seq BIGINT NOT NULL,
	nick_nm VARCHAR(100)
	
);

#구역 대기
CREATE TABLE section_wait (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	building_seq BIGINT NOT NULL,
	reg_ymdt DATETIME NOT NULL

);

#이용
CREATE TABLE secret_room_use (

	seq BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	secret_room_seq BIGINT NOT NULL,
	start_reg_ymdt DATETIME NOT NULL,
	end_reg_ymdt DATETIME

);

