package kr.netty.nloo.repository;

import kr.netty.nloo.model.Building;
import kr.netty.nloo.model.BuildingViewInfo;
import kr.netty.nloo.model.User;

import java.util.List;

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

	@Override
	public List<Building> selectAllBuildings() {
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectAllBuildings");
	}

	@Override
	public void saveBuilding(Building building) {
		sqlSessionTemplate.insert(NAMESPACE + ".saveBuilding", building);

	}

	@Override
	public void updateBuilding(Building building) {
		sqlSessionTemplate.update(NAMESPACE + ".updateBuilding", building);

	}

	@Override
	public void deleteBuilding(Long sequence) {
		sqlSessionTemplate.insert(NAMESPACE + ".deleteBuilding", sequence);

	}

//
//	@Override
//	public void saveUser(Building building) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void updateUser(Building building) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteUser(Long buildingSequence) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	@Override
//	public void saveUser(User user) {
//		sqlSessionTemplate.insert(NAMESPACE + ".saveUser", user);
//
//	}
//
//	@Override
//	public void updateUser(User user) {
//		sqlSessionTemplate.update(NAMESPACE + ".updateUser", user);
//
//	}
//
//	@Override
//	public void deleteUser(int id) {
//		sqlSessionTemplate.insert(NAMESPACE + ".deleteUser", id);
//	}
//


}
