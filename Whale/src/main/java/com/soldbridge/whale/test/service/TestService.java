package com.soldbridge.whale.test.service;

import java.util.List;
import java.util.Map;

import com.soldbridge.whale.common.common.CommandMap;

public interface TestService {
	
	List<Map<String, Object>> selectTestTotRepu(Map<String, Object> commandMap) throws Exception;
	
	List<Map<String, Object>> selectTestTotRepuParam(Map<String, Object> commandMap) throws Exception;
	
	List<Map<String, Object>> selectIFTestCompanyList(Map<String, Object> commandMap) throws Exception;
}
