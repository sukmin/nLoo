package kr.netty.nloo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SectionKnockRepositoryImpl implements SectionKnockRepository {
	
	private static final String NAMESPACE = "kr.netty.nloo.repository.SectionKnockRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertKnock(Long sectionSequence) {
		return sqlSessionTemplate.insert(NAMESPACE + ".insertKnock", sectionSequence);
	}

}
