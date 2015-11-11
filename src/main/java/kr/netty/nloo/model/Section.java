package kr.netty.nloo.model;

import org.apache.ibatis.type.Alias;

@Alias("section")
public class Section {

	private Long sequence;
	private Long buildingSequence;
	private String floor;
	private String sex;
	private String nickName;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getBuildingSequence() {
		return buildingSequence;
	}

	public void setBuildingSequence(Long buildingSequence) {
		this.buildingSequence = buildingSequence;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
