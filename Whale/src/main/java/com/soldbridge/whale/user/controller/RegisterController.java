package com.soldbridge.whale.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soldbridge.whale.user.service.RegisterService;

@Controller
public class RegisterController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="registerService")
    private RegisterService registerService;
    
    /*
    @RequestMapping(value="/user/registerUserJson.do")
    public ModelAndView registerUser(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("sampleBoardList");
         
        String result = registerService.insertUser(commandMap, request);
        mv.addObject("result", result);
         
        return mv;
    }
    */
    
    @RequestMapping(value="/user/registerUser.do")
    public String registerUserMst(@RequestParam Map<String,Object> commandMap, HttpServletRequest request) throws Exception{
    	log.info("USERID"+commandMap.get("USER_ID"));
    	log.info("USER NAME"+commandMap.get("USER_NM"));
    	log.info("USER PASSWORD"+commandMap.get("PASSWORD"));
    	
    	
        String result = registerService.insertUser(commandMap, request);
        if ("1".equals(result)){
        	String infoResult = registerUserInfo(commandMap, request);
        }
        log.info("RESULT IS"+result);
        return result;
    }
    
    public String registerUserInfo(Map<String,Object> commandMap, HttpServletRequest request) throws Exception {
    	
    	String result = registerService.insertUserInfo(commandMap,request);
    	return result;
    }
}
