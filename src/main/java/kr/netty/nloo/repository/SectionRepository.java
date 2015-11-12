package kr.netty.nloo.repository;

import kr.netty.nloo.model.SectionViewInfo;

public interface SectionRepository {
	
	public SectionViewInfo selectViewInfo(Long sectionSequence);

}
