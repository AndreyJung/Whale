package com.soldbridge.whale.repu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.soldbridge.whale.repu.dao.RepuDAO;

@Service("repuService")
public class RepuServiceImpl implements RepuService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="repuDAO")
	private RepuDAO repuDAO;
	
	@Override
	public List<Map<String, Object>> selectRepuItem(Map<String, Object> map) throws Exception{
		return repuDAO.selectRepuItem(map);
	}
}
