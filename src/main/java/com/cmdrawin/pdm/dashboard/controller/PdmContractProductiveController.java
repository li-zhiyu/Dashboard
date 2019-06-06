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
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractProductiveService;
import com.cmdrawin.pdm.dashboard.serviceImpl.PdmContractTargetService;

@Controller
@RequestMapping(value = "/statistic")
public class PdmContractProductiveController extends ExtJSBaseController {
	
	@Autowired
	private PdmContractProductiveService pdmContractProductiveService;
	
	@Autowired
	private PdmContractTargetService pdmContractTargetService;

	@RequestMapping(value = "/getContractProductiveConfirm")
	public void getContractProductiveConfirm(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		String startTime=DateUtil.getTimesLastMonthmorning_cmd();
		String endTime=DateUtil.getTimesLastMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		List<Map> resultMap=pdmContractProductiveService.queryAmount(par_in);
		allResultMap.put("lastMonth", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//上一个月
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getTimesMonthmorning_cmd();
		endTime=DateUtil.getTimesMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		resultMap=pdmContractProductiveService.queryAmount(par_in);
		allResultMap.put("currentMonth", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//本月
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getCurrentQuarterStartTime();
		endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		resultMap=pdmContractProductiveService.queryAmount(par_in);
		allResultMap.put("currentQuarter", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//本季度
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getCurrentYearStartTime();
		endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		resultMap=pdmContractProductiveService.queryAmount(par_in);
		allResultMap.put("currentYear", resultMap.get(0)!=null? resultMap.get(0).get("AMOUNTSUM"):0);//本年
		
		par_in.clear();
		par_in.put("tgname", "营业收入");
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
	
	@RequestMapping(value = "/getContractProductiveEvaluate")
	public void getContractProductiveEvaluate(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map par_in = new HashMap<String, String>();
		Map allResultMap =new HashMap<String, String>();
		String startTime=DateUtil.getTimesLastMonthmorning_cmd();
		String endTime=DateUtil.getTimesLastMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		List<Map> resultMap=pdmContractProductiveService.queryInvoicevalue(par_in);
		allResultMap.put("lastMonth", resultMap.get(0)!=null? resultMap.get(0).get("INVOICEVALUESUM"):0);//上一个月
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getTimesMonthmorning_cmd();
		endTime=DateUtil.getTimesMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		resultMap=pdmContractProductiveService.queryInvoicevalue(par_in);
		allResultMap.put("currentMonth", resultMap.get(0)!=null? resultMap.get(0).get("INVOICEVALUESUM"):0);//本月
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getCurrentQuarterStartTime();
		endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		resultMap=pdmContractProductiveService.queryInvoicevalue(par_in);
		allResultMap.put("currentQuarter", resultMap.get(0)!=null? resultMap.get(0).get("INVOICEVALUESUM"):0);//本季度
		
		par_in.clear();
		resultMap.clear();
		startTime=DateUtil.getCurrentYearStartTime();
		endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		resultMap=pdmContractProductiveService.queryInvoicevalue(par_in);
		allResultMap.put("currentYear", resultMap.get(0)!=null? resultMap.get(0).get("INVOICEVALUESUM"):0);//本年
		
		par_in.clear();
		par_in.put("tgname", "自评收入");
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
	
	@RequestMapping(value = "/getContractProductiveConfirmByMonth")
	public void getContractProductiveConfirmByMonth(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> par_in = new HashMap<String, Object>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getTimesMonthmorning_cmd();
		String endTime=DateUtil.getTimesMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		List<Map> resultMap=pdmContractProductiveService.queryAmountDetail(par_in);
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractProductiveConfirmByQuarter")
	public void getContractProductiveConfirmByQuarter(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> par_in = new HashMap<String, Object>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getCurrentQuarterStartTime();
		String endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		List<Map> resultMap=pdmContractProductiveService.queryAmountDetail(par_in);
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractProductiveConfirmByYear")
	public void getContractProductiveConfirmByYear(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> par_in = new HashMap<String, Object>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getCurrentYearStartTime();
		String endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("invoicevalue", 0);
		List<Map> resultMap=pdmContractProductiveService.queryAmountDetail(par_in);
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractProductiveEvaluateByYear")
	public void getContractProductiveEvaluateByYear(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> par_in = new HashMap<String, Object>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getCurrentYearStartTime();
		String endTime=DateUtil.getCurrentYearEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		List<Map> resultMap=pdmContractProductiveService.queryInvoicevalueDetail(par_in);
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractProductiveEvaluateByMonth")
	public void getContractProductiveEvaluateByMonth(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> par_in = new HashMap<String, Object>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getTimesMonthmorning_cmd();
		String endTime=DateUtil.getTimesMonthnight_cmd();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		List<Map> resultMap=pdmContractProductiveService.queryInvoicevalueDetail(par_in);
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getContractProductiveEvaluateByQuarter")
	public void getContractProductiveEvaluateByQuarter(HttpServletRequest request, HttpServletResponse response)throws IOException{
		Map<String, Object> par_in = new HashMap<String, Object>();
		Map allResultMap =new HashMap<String, String>();
		
		String startTime=DateUtil.getCurrentQuarterStartTime();
		String endTime=DateUtil.getCurrentQuarterEndTime();
		par_in.put("startDate", startTime);
		par_in.put("endDate", endTime);
		par_in.put("amount", 0);
		List<Map> resultMap=pdmContractProductiveService.queryInvoicevalueDetail(par_in);
		try {
				writeJSON(response, resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
