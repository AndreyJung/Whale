package com.soldbridge.whale.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soldbridge.whale.common.common.CommandMap;
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
    
    @RequestMapping(value="/sample/testMapArgumentResolver.do")
    public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");
         
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }
        return mv;
    }
    
    @RequestMapping(value="/sample/openBoardWrite.do")
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardWrite");
         
        return mv;
    }
    
    @RequestMapping(value="/sample/insertBoard.do")
    public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
         
        sampleService.insertBoard(commandMap.getMap());
         
        return mv;
    }
    
    @RequestMapping(value="/sample/openBoardList.do")
    public ModelAndView openBoardList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardList");
         
        List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }
    
    @RequestMapping(value="/sample/openBoardDetail.do")
    public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardDetail");
         
        Map<String,Object> map = sampleService.selectBoardDetail(commandMap.getMap());
        mv.addObject("map", map);
         
        return mv;
    }
    
    @RequestMapping(value="/sample/openBoardUpdate.do")
    public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardUpdate");
         
        Map<String,Object> map = sampleService.selectBoardDetail(commandMap.getMap());
        mv.addObject("map", map);
         
        return mv;
    }
     
    @RequestMapping(value="/sample/updateBoard.do")
    public ModelAndView updateBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail.do");
         
        sampleService.updateBoard(commandMap.getMap());
         
        mv.addObject("IDX", commandMap.get("IDX"));
        return mv;
    }
}
