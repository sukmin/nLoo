package kr.netty.nloo.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("sectionViewInfo")
public class SectionViewInfo {

	private Long sectionSequence;
	private Long buildingSequence;
	private String buildingName;
	private String sex;
	private String floor;
	private List<SecretRoomInfo> rooms;

	public Long getSectionSequence() {
		return sectionSequence;
	}

	public void setSectionSequence(Long sectionSequence) {
		this.sectionSequence = sectionSequence;
	}

	public Long getBuildingSequence() {
		return buildingSequence;
	}

	public void setBuildingSequence(Long buildingSequence) {
		this.buildingSequence = buildingSequence;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public List<SecretRoomInfo> getRooms() {
		return rooms;
	}

	public void setRooms(List<SecretRoomInfo> rooms) {
		this.rooms = rooms;
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

}
