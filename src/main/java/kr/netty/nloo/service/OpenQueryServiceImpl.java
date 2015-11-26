package kr.netty.nloo.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kr.netty.nloo.repository.OpenQueryRepository;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenQueryServiceImpl implements OpenQueryService {

	private static final Logger logger = LoggerFactory.getLogger(OpenQueryServiceImpl.class);

	@Autowired
	private OpenQueryRepository openQueryRepository;


	@Override
	public List<Map<String, String>> getTables() {


		return openQueryRepository.selectTables();
	}

	@Override
	public List<Map<String, String>> getTableInfo(String tableName) {


		List<Map<String, String>> result = openQueryRepository.selectTableInfo(tableName);

		StringBuffer model = new StringBuffer();
		StringBuffer query = new StringBuffer();
		String tableAlias = getTableAlias(tableName);

		model.append("package com.navercorp.tts.model;\n\n\n")
		.append("public class ")
		.append(toUpperCamelCase(tableName))
		.append(" {\n");

		query.append("\nSELECT ");

		for(int i=0; i<result.size();i++) {

			HashMap<String, String> hm = (HashMap<String, String>) result.get(i);

			String column = hm.get("COLUMN_NAME");
			String dataType = hm.get("DATA_TYPE");

			if(i>0)
				query.append("\t, ");

			query.append(tableAlias)
			.append(".")
			.append(column)
			.append(" AS ")
			.append(toLowerCamelCase(column))
			.append("\n");

			model.append("\tprivate ")
			.append(getType(dataType))
			.append(" ")
			.append(toLowerCamelCase(column))
			.append(";\n");

		}

		query.append(" FROM ")
		.append(tableName)
		.append(" ")
		.append(tableAlias)
		.append(";\n");

		model.append("\n\t/** getter setter method **/\n");
		for(int i=0; i<result.size();i++) {

			HashMap<String, String> hm = (HashMap<String, String>) result.get(i);

			String column = hm.get("COLUMN_NAME");
			String dataType = hm.get("DATA_TYPE");

			String loCol = toLowerCamelCase(column);
			String upCol = toUpperCamelCase(column);

			model.append(makeGetSetMethod(getType(dataType), loCol, upCol));
		}

		model.append("}");


		logger.debug(query.toString());
		logger.debug(model.toString());

		model.append("\n\n\n/**\n")
		.append(query.toString())
		.append("\n**/");

		makeFile(model.toString(),toUpperCamelCase(tableName)+".java");

		return result;

	}

	private String getType(String dataType) {

		HashMap<String, String> data = new HashMap<String, String>();

		data.put("CHAR", "String");
		data.put("VARCHAR", "String");
		data.put("LONGVARCHAR", "String");
		data.put("NUMERIC", "java.lang.Bignum");
		data.put("DECIMAL", "java.lang.Bignum");
		data.put("BIT", "boolean");
		data.put("TINYINT", "byte");
		data.put("SMALLINT", "short");
		data.put("INTEGER", "int");
		data.put("INT", "int");
		data.put("BIGINT", "long");
		data.put("REAL", "float");
		data.put("FLOAT", "double");
		data.put("DOUBLE", "double");
		data.put("BINARY", "byte[]");
		data.put("VARBINARY", "byte[]");
		data.put("LONGVARBINARY", "byte[]");
		data.put("DATE", "String");
		data.put("TIME", "String");
		data.put("TIMESTAMP", "String");
		data.put("DATETIME", "String");
		data.put("ENUM", "String");

		for(Entry<String, String> s : data.entrySet()) {
			if(StringUtils.equals(s.getKey(),dataType.toUpperCase())) {
				return s.getValue();
			}
		}
		return dataType;
	}


	private static String renameColumn(String word) {

		HashMap<String, String> hm = new HashMap<String, String>();

		hm.put("mod","modify");
		hm.put("reg","regist");
		hm.put("trb","trouble");
		hm.put("chg","change");
		hm.put("div","division");
		hm.put("msg","message");
		hm.put("svc","service");
		hm.put("grp","group");


		for(Entry<String, String> s : hm.entrySet()) {
			if(StringUtils.equals(s.getKey(), word.toLowerCase())) {
				return s.getValue();
			}
		}
		return word;
	}

	static String toLowerCamelCase(String s){
	   String[] parts = s.split("_");
	   String camelCaseString = "";
	   for (String part : parts){
		   part = renameColumn(part);
		   camelCaseString = camelCaseString + toProperCase(part);
	   }
	   camelCaseString = Character.toLowerCase(camelCaseString.charAt(0)) + camelCaseString.substring(1);
	   return camelCaseString;
	}

	private static String toProperCase(String s) {
	    return s.substring(0, 1).toUpperCase() +
	               s.substring(1).toLowerCase();
	}

	static String getTableAlias(String s) {
	   String[] parts = s.split("_");
	   String camelCaseString = "";
	   for (String part : parts){
			part = renameColumn(part);
			camelCaseString = camelCaseString + part.charAt(0);
	   }
	   return camelCaseString.toLowerCase();
	}
	static String toUpperCamelCase(String s) {
	   String[] parts = s.split("_");
	   String camelCaseString = "";
	   for (String part : parts){
			part = renameColumn(part);
	      camelCaseString = camelCaseString + toProperCase(part);
	   }
	   return camelCaseString;
	}

	static String makeGetSetMethod(String dataType, String loCol, String upCol) {
		 /**
		public int getAuthId() {
				return authId;
			}
			public void setAuthId(int authId) {
				this.authId = authId;
			}
			  */
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic ")
		.append(dataType)
		.append(" ")
		.append("get")
		.append(upCol)
		.append("() {\n")
		.append("\t\treturn ")
		.append(loCol)
		.append(";\n\t}\n")
		.append("\n")
		.append("\tpublic void set")
		.append(upCol)
		.append("(")
		.append(dataType)
		.append(" ")
		.append(loCol)
		.append(") {\n")
		.append("\t\t")
		.append("this.")
		.append(loCol)
		.append(" = ")
		.append(loCol)
		.append(";\n\t}\n")
		.append("\n");

		return sb.toString();
	}

	static void makeFile(String str, String fileName) {
		String path = "D:\\git_repo\\tts\\tts\\src\\main\\java\\com\\navercorp\\tts\\model\\";
        try
        {
            FileWriter fw = new FileWriter(path+fileName); // 절대주소 경로 가능
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(str);
            bw.newLine(); // 줄바꿈

            bw.close();
        }
        catch (IOException e)
        {
            System.err.println(e); // 에러가 있다면 메시지 출력
            System.exit(1);
        }
    }

	@Override
	public Map<String, String> getModelAndQuery(String tableName) {

		Map<String, String> result = new HashMap<String, String>();

		List<Map<String, String>> columnList = openQueryRepository.selectTableInfo(tableName);

		StringBuffer model = new StringBuffer();
		StringBuffer query = new StringBuffer();
		String tableAlias = getTableAlias(tableName);

		model.append("package com.navercorp.tts.model;\n\n\n")
		.append("public class ")
		.append(toUpperCamelCase(tableName))
		.append(" {\n");

		query.append("\nSELECT ");

		for(int i=0; i<columnList.size();i++) {

			HashMap<String, String> hm = (HashMap<String, String>) columnList.get(i);

			String column = hm.get("COLUMN_NAME");
			String dataType = hm.get("DATA_TYPE");

			if(i>0)
				query.append("\t, ");

			query.append(tableAlias)
			.append(".")
			.append(column)
			.append(" AS ")
			.append(toLowerCamelCase(column))
			.append("\n");

			model.append("\tprivate ")
			.append(getType(dataType))
			.append(" ")
			.append(toLowerCamelCase(column))
			.append(";\n");

		}

		query.append(" FROM ")
		.append(tableName)
		.append(" ")
		.append(tableAlias)
		.append(";\n");

		model.append("\n\t/* getter setter method */\n\n");
		for(int i=0; i<columnList.size();i++) {

			HashMap<String, String> hm = (HashMap<String, String>) columnList.get(i);

			String column = hm.get("COLUMN_NAME");
			String dataType = hm.get("DATA_TYPE");

			String loCol = toLowerCamelCase(column);
			String upCol = toUpperCamelCase(column);

			model.append(makeGetSetMethod(getType(dataType), loCol, upCol));
		}

		model.append("}");

		logger.debug(query.toString());
		logger.debug(model.toString());

		result.put("MODEL", model.toString());
		result.put("QUERY", query.toString());

		return result;
	}

}
