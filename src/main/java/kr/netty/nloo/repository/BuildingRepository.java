package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.Building;
import kr.netty.nloo.model.BuildingViewInfo;

public interface BuildingRepository {

	public BuildingViewInfo selectViewInfo(Long buildingSequence);

	public List<Building> selectAllBuildings();

	public void saveBuilding(Building building);

	public void updateBuilding(Building building);

	public void deleteBuilding(Long sequence);
}
