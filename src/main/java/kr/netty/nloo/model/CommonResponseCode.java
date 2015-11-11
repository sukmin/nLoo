package kr.netty.nloo.model;

public enum CommonResponseCode {

	SECRET_ROOM_SUCCESS("SR001", "성공하였습니다."),
	SECRET_ROOM_ALREADY("SR002", "이미 사용중입니다."),
	SECRET_ROOM_INTERNAL_ERROR("SR003", "내부 오류로 실패하였습니다."),
	SECRET_ROOM_NOT_USED("SR004", "화장실이 사용 상태가 아닙니다."),
	SECRET_ROOM_NOT_EXIST("SR005", "존재하지 않는 화장실입니다.");

	private String code;
	private String message;

	private CommonResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
