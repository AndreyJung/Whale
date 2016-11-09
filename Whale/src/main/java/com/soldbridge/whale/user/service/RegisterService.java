package com.soldbridge.whale.user.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface RegisterService {
	Map<String, Long> userIdCheck(Map<String,Object> map, HttpServletRequest request) throws Exception;
	String insertUser(Map<String, Object> map, HttpServletRequest request) throws Exception;
	String insertUserInfo(Map<String,Object> map, HttpServletRequest request) throws Exception;
}
