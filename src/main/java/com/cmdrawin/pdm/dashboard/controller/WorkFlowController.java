package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmdrawin.pdm.dashboard.common.DateUtil;
import com.cmdrawin.pdm.dashboard.common.JsonConvertUtil;
import com.cmdrawin.pdm.dashboard.common.WebUtil;


@Controller
@RequestMapping(value = "/statistic")
public class WorkFlowController extends ExtJSBaseController {
		
	@RequestMapping(value = "/getFlowCountByDate")
	public void getFlowCountByDate(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		String selectIndexValue = request.getParameter("index");
		Map<String, String> parms= new HashMap<String, String>();
		String startTime="";
		String endTime="";
		if(selectIndexValue.equals("累计"))
		{
			startTime="2000-01-01";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			endTime=df.format(new Date());
		}
		if(selectIndexValue.equals("本年"))
		{
			startTime=DateUtil.getCurrentYearStartTime();
			endTime=DateUtil.getCurrentYearEndTime();
		}
		if(selectIndexValue.equals("本季度"))
		{
			startTime=DateUtil.getCurrentQuarterStartTime();
			endTime=DateUtil.getCurrentQuarterEndTime();
		}
		if(selectIndexValue.equals("本月"))
		{
			startTime=DateUtil.getTimesMonthmorning();
			endTime=DateUtil.getTimesMonthnight();
		}
		parms.put("startTime", startTime);
		parms.put("endTime", endTime);
		String result=WebUtil.doPost("http://192.168.11.207"+":"+"9080"+"/ext/static/processStatistics?",parms , 50000, 50000);
		List<Map<String,Object>> resultList=JsonConvertUtil.StringToListMap(result);
		int projectStartCount=0;//项目发起
		int projectPlanCount=0;//项目策划
		int infoCount=0;//技术评审
		int hutiCount=0;//互提资料
		int jiaoshenCount=0;//校对审核
		int chutuCount=0;//会签出图
		for(int i=0;i<resultList.size();i++)
		{
			if(resultList.get(i).get("name").toString().startsWith("项目发起"))
			{
				projectStartCount+=Integer.parseInt(resultList.get(i).get("num").toString());
			}
			if(resultList.get(i).get("name").toString().startsWith("项目策划"))
			{
				projectPlanCount+=Integer.parseInt(resultList.get(i).get("num").toString());
			}
			if(resultList.get(i).get("name").toString().startsWith("技术要点评审"))
			{
				infoCount+=Integer.parseInt(resultList.get(i).get("num").toString());
			}
			if(resultList.get(i).get("name").toString().startsWith("互提条件资料"))
			{
				hutiCount+=Integer.parseInt(resultList.get(i).get("num").toString());
			}
			if(resultList.get(i).get("name").toString().startsWith("校对审核"))
			{
				jiaoshenCount+=Integer.parseInt(resultList.get(i).get("num").toString());
			}
			if(resultList.get(i).get("name").toString().startsWith("会签出图管理"))
			{
				chutuCount+=Integer.parseInt(resultList.get(i).get("num").toString());
			}
		}
		ArrayList<Map<String, Object>> series_data = new ArrayList<Map<String, Object>>();

		if(projectStartCount!=0)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", projectStartCount);
			data.put("name", "项目发起");
			series_data.add(data);
		}
		if(projectPlanCount!=0)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", projectPlanCount);
			data.put("name", "项目策划");
			series_data.add(data);
		}
		if(infoCount!=0)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", infoCount);
			data.put("name", "技术评审");
			series_data.add(data);
		}
		if(hutiCount!=0)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", hutiCount);
			data.put("name", "互提资料");
			series_data.add(data);
		}
		if(jiaoshenCount!=0)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", jiaoshenCount);
			data.put("name", "校对审核");
			series_data.add(data);
		}
		if(chutuCount!=0)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", chutuCount);
			data.put("name", "会签出图");
			series_data.add(data);
		}
		
		Map paramsMap =new HashMap<String, String>();
		paramsMap.put("series_data", series_data);
		paramsMap.put("code", "OK");	
			
		try {
				writeJSON(response, paramsMap);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
