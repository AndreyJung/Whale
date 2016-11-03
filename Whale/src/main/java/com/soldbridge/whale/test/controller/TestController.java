package com.soldbridge.whale.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soldbridge.whale.sample.service.SampleService;

@Controller
public class TestController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleService")
	private SampleService sampleService;
	
	//테스트 페이지 호출
	@RequestMapping(value="/test/iosIfSendPage.do")
	public ModelAndView iosIfSendPage(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/test/iosIfSendPage");
		return mv;
	}
	
	//데이터 전송 
	@RequestMapping(value="/test/selectIFTest.do")
	public ModelAndView selectIFTest(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/test/iosIfResultPage");
		ObjectMapper om = new ObjectMapper(); 
		
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		
		// Map or List Object 를 JSON 문자열로 변환
		String jsonStr = om.writeValueAsString(list);
		log.info("object to json : " + jsonStr);
		
		mv.addObject("jsonStr", jsonStr);

		return mv;
	}
	
}
