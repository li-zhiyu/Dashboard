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
import com.cmdrawin.pdm.dashboard.serviceImpl.SysUserTaskService;

@Controller
@RequestMapping(value = "/statistic")
public class testController extends ExtJSBaseController {

	@Autowired
	private SysUserTaskService sysUserTaskService;
	
	@Autowired
	private PdmNoticeService pdmNoticeService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testfunc(HttpServletRequest request, Model model) throws IOException {
		// String data = request.getParameter("index");
		// model.addAttribute("param",data);
		return "redirect:/statistic/index";

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String notice1(Model model) {
		Map<String, Object> pin = new HashMap<String, Object>();
		List<Map> resultList = pdmNoticeService.query(pin);

		model.addAttribute("empList", resultList);
		return "/tabletest.html";
	}
		
}
