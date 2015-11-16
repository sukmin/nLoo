package kr.netty.nloo.service;

import org.apache.ibatis.javassist.NotFoundException;

import kr.netty.nloo.model.BuildingViewInfo;

public interface BuildingService {
	
	public BuildingViewInfo getViewInfo(Long buildingSequence) throws NotFoundException;

}
