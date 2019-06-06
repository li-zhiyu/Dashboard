package com.cmdrawin.pdm.dashboard.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractTargetService;

@Controller
@RequestMapping(value = "/statistic")
public class PdmContractTargetController extends ExtJSBaseController {
	
	@Autowired
	private PdmContractTargetService pdmContractTargetService;
	
	@RequestMapping(value = "/getContractTarget")
	public void getProjectInfo(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		par_in.put("tgname", "合同额");
		Calendar cal=Calendar.getInstance();      
		int year=cal.get(Calendar.YEAR); 
		par_in.put("tgdate", String.valueOf(year));
		par_in.put("tgtype", "1");
		List<Map> resultMap=pdmContractTargetService.query(par_in);
		
		try {
			if(resultMap.get(0)!=null&&resultMap.size()==1)
			{
				writeJSON(response, resultMap.get(0));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
