package com.soldbridge.whale.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.soldbridge.whale.login.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;
	
	@Override
	public Map<String, Object> loginProcBegins(Map<String, Object> map) throws Exception{
		
		// id, pw 일치 시  Login User 정보 매핑 
		// ID 또는 패스워드를 확인해주세요 
		Map<String, Object> loginUserInfo = new HashMap<String, Object>() ;
		loginUserInfo = loginDAO.loginProc(map);
		
		// Login date , Login Status Update
		if ( loginUserInfo != null ){
			
			map.remove("LOGIN_STATUS");
			map.put("LOGIN_STATUS", "Y");
			
			log.debug("USER_ID IS " + map.get("USER_ID") +"LOGIN_STATUS" + map.get("LOGIN_STATUS"));
			
			
			
			int result = loginDAO.updateLoginInfo(map);
			loginUserInfo.put("LOGIN_SUCCESS", "Y");
			loginUserInfo.put("RETURN_MSG", "로그인이 성공하였습니다");
		} else {
			 loginUserInfo = new HashMap<String, Object>() ;
			loginUserInfo.put("LOGIN_SUCCESS", "N");
			loginUserInfo.put("RETURN_MSG", "ID 또는 패스워드가 일치하지 않습니다");
		}
		
		return loginUserInfo;
	}
	
	
	@Override
	public Map<String,Object> logoutProc(Map<String, Object> map) throws Exception{
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		
		if ( map.get("LOGIN_ID") != null ){
			// logout Status Update 
			
			map.put("LOGIN_STATUS", "N");
			
			int result = loginDAO.logoutProc(map);
			if ( result == 1 ){
				outputMap.put("LOGOUT_RESULT", "SUCCESS");
				outputMap.put("RETURN_MSG", "로그아웃 되었습니다");
			}else {
				outputMap.put("LOGOUT_RESULT", "FAIL");
				outputMap.put("RETURN_MSG", "로그아웃 중 오류가 발생하였습니다\n 잠시 후 다시 시도하여주세요");
			}
			
		} else {
			outputMap.put("LOGOUT_RESULT", "FAIL");
			outputMap.put("RETURN_MSG", "로그아웃 중 오류가 발생하였습니다\n 잠시 후 다시 시도하여주세요");
			
		}
	
		
		return outputMap;
	}
	
	
}
