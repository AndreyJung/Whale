package com.soldbridge.whale.login.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO{
	
	
	// 사용자 로그인 정 일치 확
	@SuppressWarnings("unchecked")
	public Map<String, Object> loginProc(Map<String, Object> map){
		return (Map<String, Object>)selectOne("login.selectLoginUser", map);
	}
	
	public int updateLoginInfo(Map<String, Object> map) throws Exception{
		int result = (Integer)update("login.updateLoginUser",map);
		return result ; 
	}
	
	
	public int logoutProc(Map<String, Object> map){
		int result = (Integer)update("login.updateLogoutUser",map);
		return result ; 
	}
	
}
