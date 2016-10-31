package com.soldbridge.whale.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soldbridge.whale.sample.service.SampleService;

@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="sampleService")
    private SampleService sampleService;
     
    @RequestMapping(value="/sample/openSampleBoardList.do")
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("sampleBoardList");
         
        List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }
    
    @RequestMapping(value="/sample/getCompanyList.do")
    public ModelAndView getCompanyList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("getCompanyList");
         
        List<Map<String,Object>> list = sampleService.getCompanyList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }
}
