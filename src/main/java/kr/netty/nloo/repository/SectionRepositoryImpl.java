package kr.netty.nloo.repository;

import kr.netty.nloo.model.SectionViewInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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

}
