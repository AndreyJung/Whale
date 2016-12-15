package com.soldbridge.whale.repu.service;

import java.util.List;
import java.util.Map;

public interface RepuService {
	List<Map<String, Object>> selectRepuTotItem(Map<String, Object> commandMap) throws Exception;
	
	Map<String,Object> saveRepu(Map<String, Object> commandMap) throws Exception;
	
	List<Map<String, Object>> selectRepuItemByUser(Map<String, Object> commandMap) throws Exception;
	
	Map<String, Object> selectUserProfile(Map<String, Object> commandMap) throws Exception;
}
