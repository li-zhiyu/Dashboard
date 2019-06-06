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

import com.cmdrawin.pdm.dashboard.common.DateUtil;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractPaymentListService;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractTargetService;

@Controller
@RequestMapping(value = "/statistic")
public class PdmContractPaymentListController extends ExtJSBaseController {
	
	@Autowired
	private PdmContractPaymentListService pdmContractPaymentListService;
	
	@Autowired
	private PdmContractTargetService pdmContractTargetService;
	
	@RequestMapping(value = "/getContractPaymentByQuarter")
	public void getContractPaymentByQuarter(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		String startTime=DateUtil.getCurrentQuarterStartTime();
		String endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryAmount(par_in);
		
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractPaymentByMonth")
	public void getContractPaymentByMonth(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		String startTime=DateUtil.getTimesMonthmorning();
		String endTime=DateUtil.getTimesMonthnight();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryAmount(par_in);
		
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractPaymentByYear")
	public void getContractPaymentByYear(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		String startTime=DateUtil.getCurrentYearStartTime();
		String endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryAmount(par_in);
		
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractPaymentByLastMonth")
	public void getContractPaymentByLastMonth(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		String startTime=DateUtil.getTimesLastMonthmorning();
		String endTime=DateUtil.getTimesLastMonthnight();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryAmount(par_in);
		
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractPayment")
	public void getContractPayment(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		String startTime=DateUtil.getTimesLastMonthmorning_cmd();
		String endTime=DateUtil.getTimesLastMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryAmount(par_in);
		boolean flag1=resultMap.get(0).containsKey("AMOUNTSUM");
		allResultMap.put("lastMonth", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//上一个月
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getTimesMonthmorning_cmd();
		endTime=DateUtil.getTimesMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		resultMap=pdmContractPaymentListService.queryAmount(par_in);
		allResultMap.put("currentMonth", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//本月
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getCurrentQuarterStartTime();
		endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		resultMap=pdmContractPaymentListService.queryAmount(par_in);
		allResultMap.put("currentQuarter", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//本季度
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getCurrentYearStartTime();
		endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		resultMap=pdmContractPaymentListService.queryAmount(par_in);
		allResultMap.put("currentYear", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//本年
		
		par_in.clear();
		par_in.put("tgname", "回款额");
		Calendar cal=Calendar.getInstance();      
		int year=cal.get(Calendar.YEAR); 
		par_in.put("tgdate", String.valueOf(year));
		par_in.put("tgtype", "1");
		resultMap=pdmContractTargetService.query(par_in);
		allResultMap.put("targetYear", resultMap.get(0)!=null? resultMap.get(0).get("TGVALUE"):0);//目标值
		
		try {
				writeJSON(response, allResultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getContractRefundByQuarter")
	public void getContractRefundByQuarter(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getCurrentQuarterStartTime();
		String endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryDetail(par_in);
			
		try {
				writeJSON(response, resultMap);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getContractRefundByYear")
	public void getContractRefundByYear(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getCurrentYearStartTime();
		String endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryDetail(par_in);
			
		try {
				writeJSON(response, resultMap);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getContractRefundByMonth")
	public void getContractRefundByMonth(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getTimesMonthmorning_cmd();
		String endTime=DateUtil.getTimesMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		List<Map> resultMap=pdmContractPaymentListService.queryDetail(par_in);
			
		try {
				writeJSON(response, resultMap);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
