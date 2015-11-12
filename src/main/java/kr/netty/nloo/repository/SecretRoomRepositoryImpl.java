package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.SecretRoom;
import kr.netty.nloo.model.SecretRoomInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SecretRoomRepositoryImpl implements SecretRoomRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.SecretRoomRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public SecretRoom selectSecretRoom(Long secretRoomSequene) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".selectSecretRoom", secretRoomSequene);
	}

	@Override
	public Integer updateUseStats(Long secretRoomSequene) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateUseStats", secretRoomSequene);
	}

	@Override
	public Integer updateUnuseStats(Long secretRoomSequene) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateUnuseStats", secretRoomSequene);
	}

	@Override
	public List<SecretRoomInfo> selectSecretRoomInfo(Long sectionSequence) {
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectSecretRoomInfo", sectionSequence);
	}

}
