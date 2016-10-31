package com.soldbridge.whale.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	//User 테이블에서 전체 회사 목록을 가져옴
	List<Map<String, Object>> getCompanyList(Map<String, Object> commandMap) throws Exception;
	
}