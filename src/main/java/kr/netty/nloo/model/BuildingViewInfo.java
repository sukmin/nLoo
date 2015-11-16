package kr.netty.nloo.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("buildingViewInfo")
public class BuildingViewInfo {

	private Long sequence;
	private String buildingName;
	private List<SectionWithBuildingViewInfo> sections;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public List<SectionWithBuildingViewInfo> getSections() {
		return sections;
	}

	public void setSections(List<SectionWithBuildingViewInfo> sections) {
		this.sections = sections;
	}

}
