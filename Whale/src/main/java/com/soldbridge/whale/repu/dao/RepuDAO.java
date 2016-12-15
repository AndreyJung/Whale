package com.soldbridge.whale.repu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("repuDAO")
public class RepuDAO extends AbstractDAO{
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectRepuTotItem(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("selectRepuTotItem", map);
	}
	
	// 평점 관리 테이블 데이터 존재 유무 확인 쿼리 
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectRepuItemChk(Map<String, Object> map){
		return (Map<String, Object>)selectOne("selectRepuItemChk", map);
	}
	
	public void updateRepuItem(Map<String, Object> map) throws Exception{
		update("updateRepuItem",map);
	}
	
	public void insertRepuItem(Map<String, Object> map) throws Exception{
		insert("insertRepuItem",map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> selectRepuTotItemChk(Map<String, Object> map){
		return (Map<String, Object>)selectOne("selectRepuTotItemChk",map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectRepuTypeInfo() {
		return (List<Map<String, Object>>)selectList("selectRepuTypeInfo");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectRepuStartCntByUserAndRepuType(Map<String, Object> map){
		return (Map<String, Object>) selectOne("selectRepuStartCntByUserAndRepuType", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectRepuFromUserCntByUserAndRepuType(Map<String, Object> map){
		return (Map<String, Object>) selectOne("selectRepuFromUserCntByUserAndRepuType", map);
	}
	
	public void updateRepuTotByUserAndRePuType(Map<String, Object> map) throws Exception{
		update("updateRepuTotByUserAndRePuType",map);
	}
	
	public void insertRepuTotByUserAndRepuType(Map<String, Object> map) throws Exception{
		insert("insertRepuTotByUserAndRepuType",map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectRepuItemByUser(Map<String, Object> map){
		return (List<Map<String, Object>>) selectList("selectRepuItemByUser",map);
	}
	
	//사용자 이미지 섬네일 조회
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectUserProfile(Map<String, Object> map){
		return (Map<String, Object>)selectOne("selectUserProfile",map);
	}
}
