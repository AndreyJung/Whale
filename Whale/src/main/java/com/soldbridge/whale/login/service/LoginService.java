package com.soldbridge.whale.login.service;

import java.util.List;
import java.util.Map;

public interface LoginService {
	Map<String, Object> loginProcBegins(Map<String, Object> commandMap) throws Exception;
	
	Map<String,Object> logoutProc(Map<String, Object> commandMap) throws Exception;
	
}
