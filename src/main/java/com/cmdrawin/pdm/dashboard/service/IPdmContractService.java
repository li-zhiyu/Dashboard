package com.cmdrawin.pdm.dashboard.service;

import java.util.List;
import java.util.Map;
/**
 * @author lizhiyu
 * 
 * @date 2019-05-05 17:03:59
 */

public interface IPdmContractService{

	public String add(Map map);


	public List<Map> query(Map map);
	
	public List<Map> queryExpectedCost(Map map);

}