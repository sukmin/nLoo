package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.Section;
import kr.netty.nloo.model.SectionViewInfo;

public interface SectionRepository {

	public SectionViewInfo selectViewInfo(Long sectionSequence);


	public List<Section> selectAllSections();

	public void saveSection(Section building);

	public void updateSection(Section building);

	public void deleteSection(Long sequence);
}
