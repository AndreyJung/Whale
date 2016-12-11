package com.soldbridge.whale.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("myPageDAO")
public class MyPageDAO extends AbstractDAO{
	
	
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getUserInfo(Map<String, Object> map) {
		return (Map<String, String>)selectOne("myPage.getUserInfo", map);
	}
	
	@SuppressWarnings("unchecked")
	public int updateUserMst(Map<String, Object> map) {
		
		return (Integer)update("myPage.updateUserMst", map);
	}
	
	@SuppressWarnings("unchecked")
	public int updateSubInfo(Map<String, Object> map) {
		
		return (Integer)update("myPage.updateUserSub", map);
	}
	
 
}
