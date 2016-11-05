package com.soldbridge.whale.test.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soldbridge.whale.common.common.CommandMap;
import com.soldbridge.whale.sample.service.SampleService;
import com.soldbridge.whale.test.service.TestService;

@Controller
public class TestController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "testService")
	private TestService testService;
	
	//테스트 페이지 호출
	@RequestMapping(value="/test/iosIfSendPage.do")
	public ModelAndView iosIfSendPage(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/test/iosIfSendPage");
		return mv;
	}
	
	//데이터 전송 
	@RequestMapping(value="/test/selectIFTest.do", produces = "application/json; charset=utf8")
	public @ResponseBody String selectIFTest(Map<String, Object> commandMap) throws Exception{
		
		ObjectMapper om = new ObjectMapper(); 
		
		List<Map<String, Object>> list = testService.selectTestTotRepu(commandMap);
		
		// Map or List Object 를 JSON 문자열로 변환
		String jsonStr = om.writeValueAsString(list);
		log.info("object to json : " + jsonStr);
		
		jsonStr = "{ \"result\" : "+jsonStr+" }";
		
		return jsonStr;
	}
	
	//앱 => 서버 호출 테스트 액션(파라미터 추가)
	@RequestMapping(value="/test/selectIFTestAddParam.do", produces = "application/json; charset=utf8")
	public @ResponseBody String selectIFTestAddParam (CommandMap commandMap) throws Exception{
		
		if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
		
		ObjectMapper om = new ObjectMapper();
		List<Map<String, Object>> list = testService.selectTestTotRepuParam(commandMap.getMap());
		
		String jsonStr = om.writeValueAsString(list);
		log.info("object to json : " + jsonStr);
		
		jsonStr = "{ \"result\" : "+jsonStr+" }";
		
		return jsonStr;
	}
	
	//데이터 전송 
	@RequestMapping(value="/test/selectIFTestCompanyList.do", produces = "application/json; charset=utf8")
	public @ResponseBody String selectIFTestCompanyList(CommandMap commandMap) throws Exception{
		
		ObjectMapper om = new ObjectMapper(); 
		
		List<Map<String, Object>> list = testService.selectIFTestCompanyList(commandMap.getMap());
		
		// Map or List Object 를 JSON 문자열로 변환
		String jsonStr = om.writeValueAsString(list);
		log.info("object to json : " + jsonStr);
		
		jsonStr = "{ \"result\" : "+jsonStr+" }";
		
		return jsonStr;
	}
	
}
