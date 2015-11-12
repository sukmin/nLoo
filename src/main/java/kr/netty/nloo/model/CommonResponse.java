package kr.netty.nloo.model;

import kr.netty.nloo.service.SecretRoomService;

public class CommonResponse {

	private String code;
	private String message;

	public CommonResponse() {
	}

	public CommonResponse(CommonResponseCode commonResponseCode) {
		this.code = commonResponseCode.getCode();
		this.message = commonResponseCode.getMessage();
	}
	
	public CommonResponse(SecretRoomService.Result result){
		this.code = result.getCode();
		this.message = result.getMessage();
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