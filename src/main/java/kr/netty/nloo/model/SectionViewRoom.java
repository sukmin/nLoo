package kr.netty.nloo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("sectionViewRoom")
public class SectionViewRoom {

	private Long secretRoomSequence;
	private String nickName;
	private Date modifyYmdt;
	private String status;

	public Long getSecretRoomSequence() {
		return secretRoomSequence;
	}

	public void setSecretRoomSequence(Long secretRoomSequence) {
		this.secretRoomSequence = secretRoomSequence;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getModifyYmdt() {
		return modifyYmdt;
	}

	public void setModifyYmdt(Date modifyYmdt) {
		this.modifyYmdt = modifyYmdt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
