package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmdrawin.pdm.dashboard.common.DateUtil;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmNoticeService;

@Controller
@RequestMapping(value = "/statistic")
public class pdmNoticeController extends ExtJSBaseController {
	
	@Autowired
	private PdmNoticeService pdmNoticeService;
	
	@RequestMapping(value = "/createNoticeInfo", method = RequestMethod.POST)
	public void saveNoticeInfo(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String type = request.getParameter("noticeType");
		String body = request.getParameter("noticeBody");
		String topic = request.getParameter("noticeTopic");
		String level = request.getParameter("noticeLevel");
		String publisher = request.getParameter("publisher");
		String currentTime=DateUtil.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		par_in.put("publishDate", currentTime);
		par_in.put("type", type);
		par_in.put("body", body);
		par_in.put("topic", topic);
		par_in.put("level", level);
		par_in.put("publisher", publisher);
		
		String id=pdmNoticeService.add(par_in);
		if(id!=""||id!=null)
		{
			paramsMap.put("code", "OK");	
		}
	
		try {
			writeJSON(response, paramsMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value = "/getAllNotice", method = RequestMethod.POST)
	public void getAllNotice(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> pin = new HashMap<String, Object>();
		List<Map> resultList = pdmNoticeService.query(pin);

	
		try {
			writeJSON(response, resultList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delNoticeById", method = RequestMethod.POST)
	public void delNoticeById(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> pin = new HashMap<String, Object>();
		String ID = request.getParameter("ID");
		pin.put("id", ID);
		int p=pdmNoticeService.delete(pin);

	}
	
	@RequestMapping(value = "/queryNoticeById", method = RequestMethod.POST)
	public void queryNoticeById(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> pin = new HashMap<String, Object>();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String ID = request.getParameter("ID");
		pin.put("id", ID);
		List<Map> result=pdmNoticeService.query(pin);
		Object body=result.get(0).get("BODY");
		String topic=result.get(0).get("TOPIC").toString();
		String type=result.get(0).get("TYPE").toString();
		String level=result.get(0).get("LEVEL").toString();
		
		paramsMap.put("code", "OK");
		paramsMap.put("body", body);
		paramsMap.put("topic", topic);
		paramsMap.put("type", type);
		paramsMap.put("level", level);
		
		try {
			writeJSON(response, paramsMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/saveNoticeInfoById", method = RequestMethod.POST)
	public void saveNoticeInfoById(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String ID = request.getParameter("ID");
		String type = request.getParameter("noticeType");
		String body = request.getParameter("noticeBody");
		String topic = request.getParameter("noticeTopic");
		String level = request.getParameter("noticeLevel");
		String publisher = request.getParameter("publisher");
		String currentTime=DateUtil.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		par_in.put("publishDate", currentTime);
		par_in.put("type", type);
		par_in.put("body", body);
		par_in.put("topic", topic);
		par_in.put("level", level);
		par_in.put("publisher", publisher);
		par_in.put("id", ID);
		
		pdmNoticeService.update(par_in);	
	}
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model) {		
		Map<String, Object> pin = new HashMap<String, Object>();
		List<Map> resultList = pdmNoticeService.query(pin);
		List<Map> mapList=new ArrayList<Map>();
		for(int i=0;i<resultList.size();i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("BODY", resultList.get(i).get("BODY"));
			String level=resultList.get(i).get("LEVEL").toString();
			String title=new String();
			if(level.equals("一般")) title="【"+resultList.get(i).get("TYPE").toString()+"】"+"★";
			if(level.equals("重要")) title="【"+resultList.get(i).get("TYPE").toString()+"】"+"★★";
			if(level.equals("非常重要")) title="【"+resultList.get(i).get("TYPE").toString()+"】"+"★★★";
			map.put("TYPE", title);
			map.put("LEVEL", level);
			mapList.add(map);			
		}

		model.addAttribute("empList", mapList);
		
		return "notice/noticeD.html";
	}
	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String noticeManage(HttpServletRequest request, Model model) {
		String userName = request.getParameter("USERNAME");
		model.addAttribute("userName", userName);
		return "notice/noticeMaintenance.html";
	}

}
