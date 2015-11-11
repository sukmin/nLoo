package kr.netty.nloo.model;

import org.apache.ibatis.type.Alias;

@Alias("secretRoom")
public class SecretRoom {

	private Long sequence;
	private Long sectionSequence;
	private String nickName;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getSectionSequence() {
		return sectionSequence;
	}

	public void setSectionSequence(Long sectionSequence) {
		this.sectionSequence = sectionSequence;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
