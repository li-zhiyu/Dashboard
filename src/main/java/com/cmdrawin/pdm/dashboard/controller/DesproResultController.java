package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmdrawin.pdm.dashboard.common.DateUtil;
import com.cmdrawin.pdm.dashboard.serviceImpl.DesproResultService;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractProductiveService;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractService;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractTargetService;

@Controller
@RequestMapping(value = "/statistic")
public class DesproResultController extends ExtJSBaseController {
	

	
	@Autowired
	private DesproResultService desproResultService;
	
	@RequestMapping(value = "/getFileSumByMonth")
	public void getFileSumByMonth(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		
		List<Map> resultMap=desproResultService.querySumByMonth(par_in);
		
		ArrayList<String> xAxis_data = new ArrayList();
		ArrayList<Integer> series_data = new ArrayList();
		int sum=0;
		for(int i=0;i < resultMap.size();i++)
		{
			xAxis_data.add(resultMap.get(i).get("MONTH").toString());
			series_data.add(Integer.parseInt(resultMap.get(i).get("SUM").toString()));
			sum+=Integer.parseInt(resultMap.get(i).get("SUM").toString());
		}
		Collections.reverse(xAxis_data);
		Collections.reverse(series_data);
		
		
		
		paramsMap.put("xAxis_data", xAxis_data);
		paramsMap.put("series_data", series_data);
		paramsMap.put("sum", sum);
		paramsMap.put("code", "OK");
			
		try {
				writeJSON(response, paramsMap);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
