package kr.netty.nloo.service;

import java.util.List;
import java.util.Objects;

import kr.netty.nloo.model.SecretRoomInfo;
import kr.netty.nloo.model.SectionInfo;
import kr.netty.nloo.model.SectionViewInfo;
import kr.netty.nloo.repository.SecretRoomRepository;
import kr.netty.nloo.repository.SectionKnockRepository;
import kr.netty.nloo.repository.SectionRepository;

import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionService {
	
	private static final Logger logger = LoggerFactory.getLogger(SectionServiceImpl.class);
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private SecretRoomRepository secretRoomRepository;
	
	@Autowired
	private SectionKnockRepository sectionKnockRepository;

	@Override
	public SectionInfo getInfo(Long sectionSequence) {
		List<SecretRoomInfo> rooms = secretRoomRepository.selectSecretRoomInfo(sectionSequence);
		
		// sectionSequence번 섹션에 room이 하나도 없는 경우 
		if(rooms.isEmpty()){
			logger.info("{}번 섹션에 해당하는 room이 하나도 없습니다");
			return new SectionInfo(Result.NOT_EXIST,rooms);
		}
		
		return new SectionInfo(Result.SUCCESS,rooms);
	}

	@Override
	public SectionViewInfo getViewInfo(Long sectionSequence) throws NotFoundException {
		
		SectionViewInfo viewInfo = sectionRepository.selectViewInfo(sectionSequence);
		if(Objects.isNull(viewInfo)){
			throw new NotFoundException(sectionSequence + "는 존재하지 않는 섹션입니다.");
		}
		
		return viewInfo;
	}

	@Override
	public Result knock(Long sectionSequence) {
		
		int changedLine = sectionKnockRepository.insertKnock(sectionSequence);
		if(changedLine == 1){
			return SectionService.Result.SUCCESS;
		}else{
			return SectionService.Result.NOT_EXIST;
		}
	}

}
