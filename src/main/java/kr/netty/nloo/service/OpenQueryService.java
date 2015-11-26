package kr.netty.nloo.service;


import java.util.List;
import java.util.Map;

public interface OpenQueryService {

	public List<Map<String, String>> getTables();
	public List<Map<String, String>> getTableInfo(String tableName);

	public Map<String, String> getModelAndQuery(String tableName);

}
