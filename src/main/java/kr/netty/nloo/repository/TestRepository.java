package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.Test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

	private static final String NAMESPACE = "kr.netty.nloo.repository.TestRepository";

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Test> selectAll(){
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectAll");
	}
	
}
