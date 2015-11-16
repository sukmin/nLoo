package kr.netty.nloo.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.netty.nloo.model.BuildingViewInfo;
import kr.netty.nloo.repository.BuildingRepository;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public BuildingViewInfo getViewInfo(Long buildingSequence) throws NotFoundException {
		return buildingRepository.selectViewInfo(buildingSequence);
	}

}
