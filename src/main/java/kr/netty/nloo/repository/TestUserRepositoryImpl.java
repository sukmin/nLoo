package kr.netty.nloo.repository;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.netty.nloo.model.User;

@Repository
public class TestUserRepositoryImpl implements TestUserRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.TestUserRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<User> getAllUser() {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getAllUser");
	}

	@Override
	public void saveUser(User user) {
		sqlSessionTemplate.insert(NAMESPACE + ".saveUser", user);

	}

	@Override
	public void updateUser(User user) {
		sqlSessionTemplate.update(NAMESPACE + ".updateUser", user);

	}

	@Override
	public void deleteUser(String id) {
		sqlSessionTemplate.insert(NAMESPACE + ".deleteUser", id);
	}

}
