package kr.netty.nloo.repository;

import kr.netty.nloo.model.BuildingViewInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.BuildingRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public BuildingViewInfo selectViewInfo(Long buildingSequence) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".selectViewInfo", buildingSequence);
	}

}
