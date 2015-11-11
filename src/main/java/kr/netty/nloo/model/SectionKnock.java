package kr.netty.nloo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("sectionKnock")
public class SectionKnock {

	private Long sequence;
	private Long sectionSequence;
	private Date regYmdt;

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

	public Date getRegYmdt() {
		return regYmdt;
	}

	public void setRegYmdt(Date regYmdt) {
		this.regYmdt = regYmdt;
	}

}
