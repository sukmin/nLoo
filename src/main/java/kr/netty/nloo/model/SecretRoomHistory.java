package kr.netty.nloo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("secretRoomHistory")
public class SecretRoomHistory {

	private Long sequence;
	private Long secretRoomSequence;
	private Date startYmdt;
	private Date endYmdt;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getSecretRoomSequence() {
		return secretRoomSequence;
	}

	public void setSecretRoomSequence(Long secretRoomSequence) {
		this.secretRoomSequence = secretRoomSequence;
	}

	public Date getStartYmdt() {
		return startYmdt;
	}

	public void setStartYmdt(Date startYmdt) {
		this.startYmdt = startYmdt;
	}

	public Date getEndYmdt() {
		return endYmdt;
	}

	public void setEndYmdt(Date endYmdt) {
		this.endYmdt = endYmdt;
	}

}
