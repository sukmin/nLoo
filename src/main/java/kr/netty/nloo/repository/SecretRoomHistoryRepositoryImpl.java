package kr.netty.nloo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SecretRoomHistoryRepositoryImpl implements SecretRoomHistoryRepository {
	
	private static final String NAMESPACE = "kr.netty.nloo.repository.SecretRoomHistoryRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Integer insertSecretRoomHistory(Long secretRoomSequene) {
		return sqlSessionTemplate.insert(NAMESPACE + ".insertSecretRoomHistory", secretRoomSequene);
	}

	@Override
	public Integer updateEndYmdt(Long historySequence) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateEndYmdt", historySequence);
	}

}
