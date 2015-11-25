package kr.netty.nloo.service;

import java.util.List;


import org.apache.ibatis.javassist.NotFoundException;

import kr.netty.nloo.model.Building;
import kr.netty.nloo.model.BuildingViewInfo;

public interface BuildingService {

	public BuildingViewInfo getViewInfo(Long buildingSequence) throws NotFoundException;


	public List<Building> getAllBuildings();

	public void saveBuilding(Building building);

	public void updateBuilding(Building building);

	public void deleteBuilding(Long buildingSequence);
}
