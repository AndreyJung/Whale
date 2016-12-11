package com.soldbridge.whale.user.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.soldbridge.whale.common.common.CommandMap;

public interface MyPageService {
	Map<String, String> getUserInfo(Map<String,Object> map, HttpServletRequest request) throws Exception;
	String saveMyInfo(Map<String,Object> map, HttpServletRequest request) throws Exception;
	String saveSubInfo(Map<String,Object> map, HttpServletRequest request) throws Exception;

}
