package com.soldbridge.whale.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soldbridge.whale.user.service.MyPageService;


@Controller
public class MyPageController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="myPageService")
    private MyPageService myPageService;
    
    ObjectMapper om = new ObjectMapper(); 
     
    private static final String filePath = "/resources/images/";
    
    @RequestMapping(value="/user/getUserInfo.do" , produces = "application/json; charset=utf8")
    public @ResponseBody String getUserInfo(@RequestParam Map<String,Object> commandMap, HttpServletRequest request) throws Exception{
    	log.info("USERID"+commandMap.get("USER_ID"));
    	//JSON용 객체
    	String jsonStr = "";
    	
    	//parameter check
    	if("".equals(commandMap.get("USER_ID")) || commandMap.get("USER_ID") == null){
    		jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"로그인이 만료되었습니다 \"}";
    		
    	}else{
    		Map<String, String> list = myPageService.getUserInfo(commandMap, request);
    		
            log.info("RESULT IS = "+list);
            log.info("RESULT IS = "+list.get("CNT"));
            
            if ( !(list.size()== 0 || list == null)){
            	String image = "";
            	if(list.get("THUMBNAIL") == null || "".equals(list.get("THUMBNAIL"))){
            		image = "myPic_default.png"; // default image
            	} else {
            		image = list.get("THUMBNAIL");
            	}
            	jsonStr = "{ \"resultCd\" : \"S\" ,"
            			+ " \"msg\" : \"회원정보를 가져오는데 성공하였습니다\" ,"
            			+ " \"userName\" : \""+ list.get("USER_NM")+"\" ,"
            			+ " \"userId\" : \""+ list.get("USER_ID")+"\" ,"
                        + " \"userCompany\" : \""+ list.get("CMPY_NM")+"\" ,"
                        + " \"userTeam\" : \""+ list.get("TEAM_NM")+"\" ,"
                        + " \"imgUrl\" : \""+ filePath+ image+"\" "		
            			+ " }";
            	
            }else {
            	jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"존재하지 않는 사용자입니다\"}";
            }
          
    	}
    	
    	return jsonStr;
                

    }
    
}
