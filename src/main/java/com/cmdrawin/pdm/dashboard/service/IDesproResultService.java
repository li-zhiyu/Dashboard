package com.cmdrawin.pdm.dashboard.service;

import java.util.List;
import java.util.Map;
/**
 * @author lizhiyu
 * 
 * @date 2019-05-15 08:57:02
 */

public interface IDesproResultService{

	public String add(Map map);

	public Integer delete(Map map);

	public Integer update(Map map);
	
	public Map get(Map map);

	public List<Map> query(Map map);
	
	public List<Map> querySumByMonth(Map map);

}