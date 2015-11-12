package kr.netty.nloo.service;

import java.util.Objects;

import kr.netty.nloo.model.SectionInfo;
import kr.netty.nloo.model.SectionViewInfo;
import kr.netty.nloo.repository.SectionRepository;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public SectionInfo getInfo(Long sectionSequence) {
		return null;
	}

	@Override
	public SectionViewInfo getViewInfo(Long sectionSequence) throws NotFoundException {
		
		SectionViewInfo viewInfo = sectionRepository.selectViewInfo(sectionSequence);
		if(Objects.isNull(viewInfo)){
			throw new NotFoundException(sectionSequence + "는 존재하지 않는 섹션입니다.");
		}
		
		return viewInfo;
	}

}
