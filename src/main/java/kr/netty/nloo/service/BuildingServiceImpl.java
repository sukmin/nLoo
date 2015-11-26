package kr.netty.nloo.service;

import java.util.List;

import java.util.Objects;

import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.netty.nloo.model.Building;
import kr.netty.nloo.model.BuildingViewInfo;
import kr.netty.nloo.repository.BuildingRepository;

@Service
public class BuildingServiceImpl implements BuildingService {

	private static final Logger logger = LoggerFactory.getLogger(BuildingServiceImpl.class);

	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public BuildingViewInfo getViewInfo(Long buildingSequence) throws NotFoundException {

		BuildingViewInfo viewInfo = buildingRepository.selectViewInfo(buildingSequence);
		if(Objects.isNull(viewInfo)){
			throw new NotFoundException(buildingSequence + "는 존재하지 않는 건물입니다.");
		}
		return viewInfo;
	}

	@Override
	public List<Building> getAllBuildings() {
		return buildingRepository.selectAllBuildings();
	}

	@Override
	public void saveBuilding(Building building) {
		buildingRepository.saveBuilding(building);
	}

	@Override
	public void updateBuilding(Building building) {
		buildingRepository.updateBuilding(building);
	}

	@Override
	public void deleteBuilding(Long buildingSequence) {
		buildingRepository.deleteBuilding(buildingSequence);
	}

}
