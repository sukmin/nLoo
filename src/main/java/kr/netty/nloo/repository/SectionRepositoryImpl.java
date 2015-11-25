package kr.netty.nloo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.netty.nloo.model.Section;
import kr.netty.nloo.model.SectionViewInfo;

@Repository
public class SectionRepositoryImpl implements SectionRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.SectionRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public SectionViewInfo selectViewInfo(Long sectionSequence) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".selectViewInfo", sectionSequence);
	}


	@Override
	public List<Section> selectAllSections() {
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectAllSections");
	}

	@Override
	public void saveSection(Section section) {
		sqlSessionTemplate.insert(NAMESPACE + ".saveSection", section);

	}

	@Override
	public void updateSection(Section section) {
		sqlSessionTemplate.update(NAMESPACE + ".updateSection", section);

	}

	@Override
	public void deleteSection(Long sequence) {
		sqlSessionTemplate.insert(NAMESPACE + ".deleteSection", sequence);

	}

}
