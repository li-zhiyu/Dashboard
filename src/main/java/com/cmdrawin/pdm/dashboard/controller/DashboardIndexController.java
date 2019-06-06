package com.cmdrawin.pdm.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/index")
public class DashboardIndexController {
	
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String notice() {
        return "notice";
    }
       
    
    @RequestMapping(value = "/noticePublish", method = RequestMethod.GET)
    public String noticePublish() {
        return "noticePublish";
    }

    @RequestMapping(value = "/ContractSignByQuarter", method = RequestMethod.GET)
    public String ContractSignByQuarter() {
        return  "contractSign/table-ContractSignByQuarter";
    }
    
    @RequestMapping(value = "/ContractSignByYear", method = RequestMethod.GET)
    public String ContractSignByYear() {
        return "contractSign/table-ContractSignByYear";
    }
    
    @RequestMapping(value = "/ContractSignByMonth", method = RequestMethod.GET)
    public String ContractSignByMonth() {
        return "contractSign/table-ContractSignByMonth";
    }
    
    @RequestMapping(value = "/ContractRefundByQuarter", method = RequestMethod.GET)
    public String ContractRefundByQuarter() {
        return "contractRefund/table-ContractRefundByQuarter";
    }
    
    @RequestMapping(value = "/ContractRefundByYear", method = RequestMethod.GET)
    public String ContractRefundByYear() {
        return "contractRefund/table-ContractRefundByYear";
    }
    
    @RequestMapping(value = "/ContractRefundByMonth", method = RequestMethod.GET)
    public String ContractRefundByMonth() {
        return "contractRefund/table-ContractRefundByMonth";
    }
    
    @RequestMapping(value = "/OVConfirmByMonth", method = RequestMethod.GET)
    public String OVConfirmByMonth() {
        return "OV-Confirm/table-OVConfirmByMonth";
    }
    
    @RequestMapping(value = "/OVConfirmByQuarter", method = RequestMethod.GET)
    public String OVConfirmByQuarter() {
        return "OV-Confirm/table-OVConfirmByQuarter";
    }
    
    @RequestMapping(value = "/OVConfirmByYear", method = RequestMethod.GET)
    public String OVConfirmByYear() {
        return "OV-Confirm/table-OVConfirmByYear";
    }
    
    @RequestMapping(value = "/OVSelfEvaByMonth", method = RequestMethod.GET)
    public String OVSelfEvaByMonth() {
        return "OV-SelfEva/table-OVSelfEvaByMonth";
    }
    
    @RequestMapping(value = "/OVSelfEvaByQuarter", method = RequestMethod.GET)
    public String OVSelfEvaByQuarter() {
        return "OV-SelfEva/table-OVSelfEvaByQuarter";
    }
    
    @RequestMapping(value = "/OVSelfEvaByYear", method = RequestMethod.GET)
    public String OVSelfEvaByYear() {
        return "OV-SelfEva/table-OVSelfEvaByYear";
    }
}
