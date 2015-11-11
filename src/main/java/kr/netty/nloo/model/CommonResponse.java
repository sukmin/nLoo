package kr.netty.nloo.model;

public class CommonResponse {

	private String code;
	private String message;

	public CommonResponse() {
	}

	public CommonResponse(CommonResponseCode commonResponseCode) {
		this.code = commonResponseCode.getCode();
		this.message = commonResponseCode.getMessage();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
