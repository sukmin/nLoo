package kr.netty.nloo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("secretRoomUse")
public class SecretRoomUse {

	private Long sequence;
	private Long secretRoomSequene;
	private Date startRegYmdt;
	private Date endRegYmdt;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getSecretRoomSequene() {
		return secretRoomSequene;
	}

	public void setSecretRoomSequene(Long secretRoomSequene) {
		this.secretRoomSequene = secretRoomSequene;
	}

	public Date getStartRegYmdt() {
		return startRegYmdt;
	}

	public void setStartRegYmdt(Date startRegYmdt) {
		this.startRegYmdt = startRegYmdt;
	}

	public Date getEndRegYmdt() {
		return endRegYmdt;
	}

	public void setEndRegYmdt(Date endRegYmdt) {
		this.endRegYmdt = endRegYmdt;
	}

}
