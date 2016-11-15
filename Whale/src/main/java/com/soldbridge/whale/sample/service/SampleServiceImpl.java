package com.soldbridge.whale.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.soldbridge.whale.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectBoardList(map);
	}
	
	public List<Map<String, Object>> getCompanyList(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		return sampleDAO.getCompanyList(map);
	}
	
	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
	    sampleDAO.insertBoard(map);
	}
	
	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    sampleDAO.updateHitCnt(map);
	    Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map);
	    return resultMap;
	}
	
	@Override
	public void updateBoard(Map<String, Object> map) throws Exception{
	    sampleDAO.updateBoard(map);
	}
}
