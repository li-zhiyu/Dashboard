package com.cmdrawin.pdm.dashboard.service;

import java.util.List;
import java.util.Map;

public interface ISysUserTaskService {

	public String add(Map map);
	public Integer delete(Map map);
	public Integer update(Map map);
	public Map get(Map map);
	public List<Map> query(Map map);
	public int queryAll();
}
