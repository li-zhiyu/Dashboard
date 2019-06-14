package com.cmdrawin.pdm.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class userChooseController extends ExtJSBaseController {

	@RequestMapping(value = "/ext/userChoose", method = RequestMethod.GET)
	public String notice1(Model model) {
		return "userSelect/userChoose.html";
	}
		
}
