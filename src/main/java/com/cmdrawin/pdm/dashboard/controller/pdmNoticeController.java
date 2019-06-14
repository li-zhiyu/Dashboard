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
		String reviewer = request.getParameter("reviewer");
		String reader = request.getParameter("userChoose");
		String currentTime=DateUtil.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		par_in.put("publishDate", currentTime);
		par_in.put("type", type);
		par_in.put("body", body);
		par_in.put("topic", topic);
		par_in.put("level", level);
		par_in.put("publisher", publisher);
		par_in.put("reviewer", reviewer);
		par_in.put("state", "0");
		par_in.put("reader", reader);
		
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
		pin.put("state", "1");
		List<Map> resultList = pdmNoticeService.query(pin);

	
		try {
			writeJSON(response, resultList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getAllReviewNotice", method = RequestMethod.POST)
	public void getAllReviewNotice(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> pin = new HashMap<String, Object>();
		String UserName = request.getParameter("UserName");
		pin.put("reviewer", UserName);
		pin.put("state", "0");
		List<Map> resultList = pdmNoticeService.query(pin);
	
		try {
			writeJSON(response, resultList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getAllPublishNotice", method = RequestMethod.POST)
	public void getAllPublishNotice(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> pin = new HashMap<String, Object>();
		String UserName = request.getParameter("UserName");
		pin.put("publisher", UserName);
		pin.put("state", "2");
		List<Map> resultList = pdmNoticeService.query(pin);
	
		try {
			writeJSON(response, resultList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getAllReaderNotice", method = RequestMethod.POST)
	public void getAllReaderNotice(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> pin = new HashMap<String, Object>();
		String UserName = request.getParameter("UserName");
		pin.put("reader", UserName);
		pin.put("state", "1");
		List<Map> resultList = pdmNoticeService.queryReaderByUserNm(pin);
	
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
		
		if(result.get(0).containsKey("REMARK"))
		{
			String remark=result.get(0).get("REMARK").toString();
			paramsMap.put("remark", remark);
		}
		
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
		String state = request.getParameter("STATE");
		String remark = request.getParameter("REMARK");
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
		par_in.put("state", state);
		par_in.put("remark", remark);
		
		pdmNoticeService.update(par_in);	
	}
	
	@RequestMapping(value = "/updateNoticeStateById", method = RequestMethod.POST)
	public void updateNoticeStateById(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String ID = request.getParameter("ID");
		String state = request.getParameter("STATE");
		String remark = request.getParameter("REMARK");
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		par_in.put("state", state);
		par_in.put("remark", remark);
		par_in.put("id", ID);
		
		pdmNoticeService.update(par_in);	
	}
	
	@RequestMapping(value = "/updateNoticeReaderById", method = RequestMethod.POST)
	public void updateNoticeReaderById(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String ID = request.getParameter("ID");
		String UserName = request.getParameter("UserName");		
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		par_in.put("id", ID);
		par_in.put("reader", UserName);
		
		pdmNoticeService.updateNoticeReader(par_in);	
	}
	
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model) {		
		Map<String, Object> pin = new HashMap<String, Object>();
		pin.put("state", "1");
		List<Map> resultList = pdmNoticeService.query(pin);
		List<Map> mapList=new ArrayList<Map>();
		for(int i=0;i<resultList.size();i++)
		{
			if(i<9)
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
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String noticeReview(HttpServletRequest request, Model model) {
		return "notice/noticeReview.html";
	}
	
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public String noticePublish(HttpServletRequest request, Model model) {
		String userName = request.getParameter("USERNAME");
		model.addAttribute("userName", userName);
		return "notice/noticePublish.html";
	}
	
	@RequestMapping(value = "/reviewList", method = RequestMethod.GET)
	public String noticeReviewList(HttpServletRequest request, Model model) {
		String userName = request.getParameter("USERNAME");
		model.addAttribute("userName", userName);
		return "notice/noticeReviewList.html";
	}
	
	@RequestMapping(value = "/publishList", method = RequestMethod.GET)
	public String noticePublishList(HttpServletRequest request, Model model) {
		String userName = request.getParameter("USERNAME");
		model.addAttribute("userName", userName);
		return "notice/noticePublishList.html";
	}
	
	@RequestMapping(value = "/readerList", method = RequestMethod.GET)
	public String noticeReaderList(HttpServletRequest request, Model model) {
		String userName = request.getParameter("USERNAME");
		model.addAttribute("userName", userName);
		return "notice/noticeReaderList.html";
	}

}
