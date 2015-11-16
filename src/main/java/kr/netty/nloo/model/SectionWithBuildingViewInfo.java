package kr.netty.nloo.model;

import org.apache.ibatis.type.Alias;

@Alias("sectionWithBuildingViewInfo")
public class SectionWithBuildingViewInfo {

	private Long sectionSequence;
	private String nickName;
	private String sex;
	private String floor;
	private Integer roomCount;
	private Integer useRoomCount;
	private Integer currentKnockCount;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Integer getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	public Integer getUseRoomCount() {
		return useRoomCount;
	}

	public void setUseRoomCount(Integer useRoomCount) {
		this.useRoomCount = useRoomCount;
	}

	public Integer getCurrentKnockCount() {
		return currentKnockCount;
	}

	public void setCurrentKnockCount(Integer currentKnockCount) {
		this.currentKnockCount = currentKnockCount;
	}

}
