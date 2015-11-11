package kr.netty.nloo.service;

public enum SecretRoomServiceResult {
	ALREADY,// 신청하려고 하였는데 이미 다른 사람이 이용중
	SUCCESS,// 수행작업을 성공
	NOT_EXIST,// 존재하지 않는 화장실칸일 경우
	NOT_USED,// 사용종료 요청을 하였는데, 이미 사용종료가 된 경우
	DB_ERROR; // 수행중 DB오류때문에 작업실패

}
