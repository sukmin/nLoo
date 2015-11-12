package kr.netty.nloo.model;

public enum CommonResponseCode {

	SUCCESS("CS001", "성공하였습니다."),// 공통 성공코드
	FAIL("CF002", "실패하였습니다.");// 공통 실패코드
	
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
