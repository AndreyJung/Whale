package com.soldbridge.whale.user.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soldbridge.whale.common.utils.FileUtils;
import com.soldbridge.whale.user.dao.MyPageDAO;


@Service("myPageService")
public class MyPageServiceImpl implements MyPageService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="myPageDAO")
	private MyPageDAO myPageDAO;
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;
	
	
	@Override
	public Map<String, String> getUserInfo(Map<String, Object> map, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return myPageDAO.getUserInfo(map);
	}
	
}
