package kr.netty.nloo.service;

import org.apache.ibatis.javassist.NotFoundException;

import kr.netty.nloo.model.SectionInfo;
import kr.netty.nloo.model.SectionViewInfo;

public interface SectionService {

	public SectionInfo getInfo(Long sectionSequence);
	public SectionViewInfo getViewInfo(Long sectionSequence) throws NotFoundException;

}
