package com.soldbridge.whale.user.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface MyPageService {
	Map<String, String> getUserInfo(Map<String,Object> map, HttpServletRequest request) throws Exception;

}
