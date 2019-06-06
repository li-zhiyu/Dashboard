package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmdrawin.pdm.dashboard.serviceImpl.PdmProjectInfoService;

@Controller
@RequestMapping(value = "/statistic")
public class projectInfoController extends ExtJSBaseController {
	
	@Autowired
	private PdmProjectInfoService pdmProjectInfoService;
	
	@RequestMapping(value = "/getProjectInfo")
	public void getProjectInfo(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		
		List<Map> resultMap=pdmProjectInfoService.queryProjectStatus(par_in);
		
		ArrayList<Map<String, Object>> series_data = new ArrayList<Map<String, Object>>();

		for(int i=0;i < resultMap.size();i++)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", Integer.parseInt(resultMap.get(i).get("SUM").toString()));
			data.put("name", resultMap.get(i).get("EX_STATE").toString());
			series_data.add(data);
		}
		paramsMap.put("series_data", series_data);
		paramsMap.put("code", "OK");		

		try {
			writeJSON(response, paramsMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
