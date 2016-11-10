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
import com.soldbridge.whale.user.dao.RegisterDAO;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="registerDAO")
	private RegisterDAO registerDAO;
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;
	
	@Override
	public String insertUser(Map<String, Object> map, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return ""+registerDAO.insertUser(map);
	}
	
	@Override
	public Map<String, Long> userIdCheck(Map<String, Object> map, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return registerDAO.userIdCheck(map);
	}

	@Override
	public String insertUserInfo(Map<String, Object> map, HttpServletRequest request) throws Exception {
		
		   
	    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
	    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
	    MultipartFile multipartFile = null;
	    while(iterator.hasNext()){
	        multipartFile = multipartHttpServletRequest.getFile(iterator.next());
	        if(multipartFile.isEmpty() == false){
	            log.debug("------------- file start -------------");
	            log.debug("name : "+multipartFile.getName());
	            log.debug("filename : "+multipartFile.getOriginalFilename());
	            log.debug("size : "+multipartFile.getSize());
	            log.debug("-------------- file end --------------\n");
	            
	           
	        }
	    }
	    
	    
	    List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
	    int result = 0;
	    for(int i=0, size=list.size(); i<size; i++){
        	 map.put("THUMBNAIL", list.get(i).get("ORIGINAL_FILE_NAME"));
        	 log.debug("FOR USER_INFO FILE NAME IS "+list.get(i).get("ORIGINAL_FILE_NAME"));
        	
        }
	    result = registerDAO.insertUserInfo(map);
		// TODO Auto-generated method stub
		return ""+result;
	}

	@Override
	public String insertUserSalt(Map<String, Object> map, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return ""+registerDAO.insertUserSalt(map);
	}
	
}
