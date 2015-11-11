package kr.netty.nloo.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

@Alias("secretRoom")
public class SecretRoom {

	public static final String STATUS_USE = "USE";
	public static final String STATUS_UNUSE = "UNUSE";
	public static final String STATUS_FIX = "FIX";

	private Long sequence;
	private Long sectionSequence;
	private String nickName;
	private Long useCount;
	private Date modifyYmdt;
	private String status;

	// select시에 현재 상태의 히스토리테이블 seq를 가져오기 위해 둠
	private Long currentHistorySequence;

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

	public Long getUseCount() {
		return useCount;
	}

	public void setUseCount(Long useCount) {
		this.useCount = useCount;
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

	public Long getCurrentHistorySequence() {
		return currentHistorySequence;
	}

	public void setCurrentHistorySequence(Long currentHistorySequence) {
		this.currentHistorySequence = currentHistorySequence;
	}

	public boolean isUsed() {
		return StringUtils.equals(STATUS_USE, getStatus());
	}

	public boolean isUnused() {
		return StringUtils.equals(STATUS_UNUSE, getStatus());
	}

}
