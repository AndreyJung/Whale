package com.soldbridge.whale.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.common.CommandMap;
import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("testDAO")
public class TestDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectTestTotRepu(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("selectTestTotRepu",map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectTestTotRepuParam(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("selectTestTotRepuParam",map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectIFTestCompanyList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("selectIFTestCompanyList",map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectIFTestUserList(Map<String, Object> map){
		return (List<Map<String, Object>>)selectList("selectIFTestUserList",map);
	}
}



