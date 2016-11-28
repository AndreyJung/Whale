package com.soldbridge.whale.login.controller;

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
import com.soldbridge.whale.login.service.LoginService;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "loginService")
	private LoginService loginService;

	@RequestMapping(value = "/login/login.do", produces = "application/json; charset=utf8")
	public @ResponseBody String loginProc(CommandMap commandMap) throws Exception {

		// 전달받은 파라미터 출력
		if (commandMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}

		Map<String, Object> outputMap = loginService.loginProcBegins(commandMap.getMap());

		ObjectMapper om = new ObjectMapper();
		// Map or List Object 를 JSON 문자열로 변환
		String jsonStr = om.writeValueAsString(outputMap);
		log.info("object to json : " + jsonStr);
		jsonStr = "{ \"result\" : " + jsonStr + " }";
		return jsonStr;
	}

	@RequestMapping(value = "/login/logout.do", produces = "application/json; charset=utf8")
	public @ResponseBody String logoutProc(CommandMap commandMap) throws Exception {
		// 전달받은 파라미터 출력
		if (commandMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}

		Map<String, Object> map = loginService.logoutProc(commandMap.getMap());

		ObjectMapper om = new ObjectMapper();
		// Map or List Object 를 JSON 문자열로 변환
		String jsonStr = om.writeValueAsString(map);
		log.info("object to json : " + jsonStr);
		jsonStr = "{ \"result\" : " + jsonStr + " }";
		return jsonStr;
	}
	
}
