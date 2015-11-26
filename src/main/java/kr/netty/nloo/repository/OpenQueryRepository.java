package kr.netty.nloo.repository;

import java.util.List;
import java.util.Map;

public interface OpenQueryRepository {

	public List<Map<String, String>> selectTables();
	public List<Map<String, String>> selectTableInfo(String tableName);

}
