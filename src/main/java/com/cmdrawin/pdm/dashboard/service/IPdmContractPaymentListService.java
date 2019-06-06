package com.cmdrawin.pdm.dashboard.service;

import java.util.List;
import java.util.Map;
/**
 * @author lizhiyu
 * 
 * @date 2019-05-05 16:37:04
 */

public interface IPdmContractPaymentListService{

	public String add(Map map);

	public List<Map> query(Map map);
	
	public List<Map> queryAmount(Map map);
	
	public List<Map> queryDetail(Map map);

}