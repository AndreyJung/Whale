package com.soldbridge.whale.repu.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soldbridge.whale.common.common.CommandMap;
import com.soldbridge.whale.repu.service.RepuService;

@Controller
public class RepuController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "repuService")
	private RepuService repuService;
	
	@RequestMapping(value="/repu/selectRepuItem.do", produces = "application/json; charset=utf8")
	public @ResponseBody String selectRepuItem(CommandMap commandMap) throws Exception{
		
		//전달받은 파라미터 출력 
		if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
		
		ObjectMapper om = new ObjectMapper();
		List<Map<String, Object>> list = repuService.selectRepuItem(commandMap.getMap());
		
		// Map or List Object 를 JSON 문자열로 변환
		String jsonStr = om.writeValueAsString(list);
		log.info("object to json : " + jsonStr);
		
		jsonStr = "{ \"result\" : "+jsonStr+" }";
		
		return jsonStr;
	}
}
