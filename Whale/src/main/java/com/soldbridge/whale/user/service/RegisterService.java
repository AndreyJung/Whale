package com.soldbridge.whale.user.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface RegisterService {
	String insertUser(Map<String, Object> map, HttpServletRequest request) throws Exception;
	String insertUserInfo(Map<String,Object> map, HttpServletRequest request) throws Exception;
}
