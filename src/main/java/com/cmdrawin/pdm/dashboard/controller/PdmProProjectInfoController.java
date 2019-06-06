package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmProProjectInfoService;

@Controller
@RequestMapping(value = "/statistic")
public class PdmProProjectInfoController extends ExtJSBaseController {
	

	
	@Autowired
	private PdmProProjectInfoService pdmProProjectInfoService;
	
	@RequestMapping(value = "/getProjectSumByDegree")
	public void getProjectSumByDegree(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map paramsMap =new HashMap<String, String>();
		
		List<Map> resultMap=pdmProProjectInfoService.querySumByDegree(par_in);
		
		ArrayList series_data = new ArrayList();

		for(int i=0;i < resultMap.size();i++)
		{
			Map data = new HashMap<String, Object>();
			data.put("value", Integer.parseInt(resultMap.get(i).get("SUM").toString()));
			data.put("name", resultMap.get(i).get("TYPE").toString());
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
