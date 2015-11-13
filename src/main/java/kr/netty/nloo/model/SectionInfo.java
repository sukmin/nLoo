package kr.netty.nloo.model;

import java.util.List;

import kr.netty.nloo.service.SectionService;

public class SectionInfo {

	private String code;
	private String message;
	private List<SecretRoomInfo> rooms;

	public SectionInfo() {

	}
	
	public SectionInfo(SectionService.Result result, List<SecretRoomInfo> rooms) {
		this.code = result.getCode();
		this.message = result.getMessage();
		this.rooms = rooms;
	}

	public SectionInfo(String code, String message, List<SecretRoomInfo> rooms) {
		this.code = code;
		this.message = message;
		this.rooms = rooms;
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

	public List<SecretRoomInfo> getRooms() {
		return rooms;
	}

	public void setRooms(List<SecretRoomInfo> rooms) {
		this.rooms = rooms;
	}

}
