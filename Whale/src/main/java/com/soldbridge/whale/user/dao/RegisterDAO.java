package com.soldbridge.whale.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("registerDAO")
public class RegisterDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public int insertUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int result = (Integer)insert("register.insertUserMst", map);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public int insertUserInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int result = (Integer)insert("register.insertUserInfo", map);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Long> userIdCheck(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Map<String, Long>)selectOne("register.userIdCheck", map);
	}
 
}
