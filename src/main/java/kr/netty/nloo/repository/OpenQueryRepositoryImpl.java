package kr.netty.nloo.repository;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;


@PropertySource("classpath:properties/common.properties")
@Repository
public class OpenQueryRepositoryImpl implements OpenQueryRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.OpenQueryRepository";

	@Autowired
	private Environment env;

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Map<String, String>> selectTables() {

		final String jdbcUrl = env.getProperty("jdbc.url");

		return sqlSessionTemplate.selectList(NAMESPACE + ".selectTables", getDbName(jdbcUrl));
	}

	@Override
	public List<Map<String, String>> selectTableInfo(String tableName) {
		final String jdbcUrl = env.getProperty("jdbc.url");

		return sqlSessionTemplate.selectList(NAMESPACE + ".selectTableInfo",  new HashMap<String, String>(){{
			put("dbName",getDbName(jdbcUrl)); put("tableName",tableName);}});
	}


	private String getDbName(String dbName) {
		return dbName.substring(dbName.lastIndexOf("/")+1);
	}

}
