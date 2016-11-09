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

import com.soldbridge.whale.user.service.RegisterService;

@Controller
public class RegisterController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="registerService")
    private RegisterService registerService;
    
    ObjectMapper om = new ObjectMapper(); 
     
    /*
    @RequestMapping(value="/user/registerUserJson.do")
    public ModelAndView registerUser(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("sampleBoardList");
         
        String result = registerService.insertUser(commandMap, request);
        mv.addObject("result", result);
         
        return mv;
    }
    */
    
    @RequestMapping(value="/user/userIdCheck.do" , produces = "application/json; charset=utf8")
    public @ResponseBody String userIdCheck(@RequestParam Map<String,Object> commandMap, HttpServletRequest request) throws Exception{
    	log.info("USERID"+commandMap.get("USER_ID"));
    	//JSON용 객체
    	String jsonStr = "";
    	
    	//parameter check
    	if("".equals(commandMap.get("USER_ID")) || commandMap.get("USER_ID") == null){
    		jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"아이디 입력 안하면 지옥감\"}";
    		
    	}else{
    		Map<String, Long> list = registerService.userIdCheck(commandMap, request);
    		
            log.info("RESULT IS = "+list);
            log.info("RESULT IS = "+list.get("CNT"));
            if(list.get("CNT") == 0){
            	jsonStr = "{ \"resultCd\" : \"S\" , \"msg\" : \"사용가능한 아이디입니다\"}";
            }else{
            	jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"이미 사용 중인 아이디입니다\"}";
            }

    	}
    	
    	return jsonStr;
                

    }
    
    @RequestMapping(value="/user/registerUser.do",  produces = "application/json; charset=utf8")
    public String registerUserMst(@RequestParam Map<String,Object> commandMap, HttpServletRequest request) throws Exception{
    	log.info("USERID"+commandMap.get("USER_ID"));
    	log.info("USER NAME"+commandMap.get("USER_NM"));
    	log.info("USER PASSWORD"+commandMap.get("PASSWORD"));
    	log.debug("USER SALT" + commandMap.get("SALT"));
    	
    	String jsonStr = "";
    	
    	// user master table insert
        String result = registerService.insertUser(commandMap, request);
        
        if ("1".equals(result)){
        
        	String saltResult = registerUserSalt(commandMap, request);
        	
        	if ("1".equals(saltResult)){
        		// 사용자 정보 테이블 인서트 
        		String infoResult = registerUserInfo(commandMap, request);
        		
        		if ("1".equals(infoResult)){
        			jsonStr = "{ \"resultCd\" : \"S\" , \"msg\" : \"SIGN UP COMPLETED\"}";
                	
        		} else {
        			jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"FAILING DURING INSERT INFO\"}";
                	
        		}
        	} else {
        		jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"FAILING DURING INSERT SALT\"}";
        	}
        	
        	
        
        } else {
        	jsonStr = "{ \"resultCd\" : \"F\" , \"msg\" : \"FAILING DURING INSERT MASTER\"}";
        }
        log.info("RESULT IS"+result);
        return jsonStr;
    }
    
    public String registerUserInfo(Map<String,Object> commandMap, HttpServletRequest request) throws Exception {
    	
    	String result = registerService.insertUserInfo(commandMap,request);
    	return result;
    }
    
    public String registerUserSalt(Map<String,Object> commandMap, HttpServletRequest request) throws Exception {
    	String result = registerService.insertUserSalt(commandMap, request);
    	return result;
    }
}
