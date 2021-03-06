package com.soldbridge.whale.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCompanyList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("sample.getCompanyList", map);
	}
	
	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("sample.insertBoard", map);
	}
	
	public void updateHitCnt(Map<String, Object> map) throws Exception{
	    update("sample.updateHitCnt", map);
	}
	 
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
	    return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
	}
	
	public void updateBoard(Map<String, Object> map) throws Exception{
	    update("sample.updateBoard", map);
	}
 
}
