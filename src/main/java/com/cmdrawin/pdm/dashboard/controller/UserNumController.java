package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmdrawin.pdm.dashboard.serviceImpl.SysUserTaskService;

@Controller
@RequestMapping(value = "/statistic")
public class UserNumController extends ExtJSBaseController{
	
	@Autowired
	private SysUserTaskService sysUserTaskService;
	@RequestMapping(value = "/getUserNum")
	public void getuserNum(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		int count=sysUserTaskService.queryAll();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", String.valueOf(count));
		result.put("current", "10");
		try {
			writeJSON(response, result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getUserTaskList")
	public void getUserTaskList(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		Map<String, Object> pin = new HashMap<String, Object>();
		List<Map> resultMap=sysUserTaskService.query(pin);
		try {
			writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
