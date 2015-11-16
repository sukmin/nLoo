package kr.netty.nloo.repository;

import kr.netty.nloo.model.BuildingViewInfo;

public interface BuildingRepository {
	
	public BuildingViewInfo selectViewInfo(Long buildingSequence);

}
