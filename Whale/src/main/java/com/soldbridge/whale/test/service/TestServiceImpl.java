package com.soldbridge.whale.test.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.soldbridge.whale.common.common.CommandMap;
import com.soldbridge.whale.test.dao.TestDAO;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="testDAO")
	private TestDAO testDAO;
	
	@Override
	public List<Map<String, Object>> selectTestTotRepu(Map<String, Object> map) throws Exception{
		return testDAO.selectTestTotRepu(map);
	}
	
	@Override
	public List<Map<String, Object>> selectTestTotRepuParam(Map<String, Object> map) throws Exception{
		return testDAO.selectTestTotRepuParam(map);
	}
	
	@Override
	public List<Map<String, Object>> selectIFTestCompanyList(Map<String, Object> map) throws Exception{
		return testDAO.selectIFTestCompanyList(map);
	}
	
	@Override
	public List<Map<String, Object>> selectIFTestUserList(Map<String, Object> map) throws Exception{
		return testDAO.selectIFTestUserList(map);
	}
}
