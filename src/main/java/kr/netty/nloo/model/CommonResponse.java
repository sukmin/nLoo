package kr.netty.nloo.model;

import kr.netty.nloo.service.GraffitiService;
import kr.netty.nloo.service.SecretRoomService;
import kr.netty.nloo.service.SectionService;

public class CommonResponse {

	private String code;
	private String message;
	private String keyMessage;

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


	public CommonResponse(SectionService.Result result, String keyMessage){
		this.code = result.getCode();
		this.message = result.getMessage();
		this.setKeyMessage(keyMessage);
	}

	public CommonResponse(SectionService.Result result){
		this.code = result.getCode();
		this.message = result.getMessage();
	}

	public CommonResponse(GraffitiService.Result result){
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

	public String getKeyMessage() {
		return keyMessage;
	}

	public void setKeyMessage(String keyMessage) {
		this.keyMessage = keyMessage;
	}

}
