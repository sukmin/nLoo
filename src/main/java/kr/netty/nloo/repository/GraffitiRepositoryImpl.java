package kr.netty.nloo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.netty.nloo.model.Graffiti;

@Repository
public class GraffitiRepositoryImpl implements GraffitiRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.GraffitiRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;


	@Override
	public List<Graffiti> selectAllGraffitis() {
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectAllGraffitis");
	}

	@Override
	public Integer saveGraffiti(Graffiti graffiti) {
		return sqlSessionTemplate.insert(NAMESPACE + ".saveGraffiti", graffiti);

	}

	@Override
	public Integer updateGraffitiLike(Long sequence) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateGraffitiLike", sequence);

	}
	@Override
	public Integer updateGraffitiUnlike(Long sequence) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateGraffitiUnlike", sequence);
	}
	@Override
	public void updateGraffiti(Graffiti graffiti) {
		sqlSessionTemplate.update(NAMESPACE + ".updateGraffiti", graffiti);

	}

	@Override
	public void deleteGraffiti(Long sequence) {
		sqlSessionTemplate.insert(NAMESPACE + ".deleteGraffiti", sequence);

	}

}
