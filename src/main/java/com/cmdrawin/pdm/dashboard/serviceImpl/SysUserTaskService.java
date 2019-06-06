package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cmdrawin.pdm.dashboard.mapper.TSysUserTaskMapper;
import com.cmdrawin.pdm.dashboard.service.ISysUserTaskService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class SysUserTaskService implements ISysUserTaskService {

	@Autowired
	private TSysUserTaskMapper tSysUserTaskMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tSysUserTaskMapper.insert(map);
		return id;
	}

	public Integer delete(Map map) {
		return tSysUserTaskMapper.delete(map);
	}

	public Integer update(Map map) {
		return tSysUserTaskMapper.update(map);
	}
	
	public Map get(Map map) {
		return tSysUserTaskMapper.get(map);
	}

	public List<Map> query(Map map) {
		return tSysUserTaskMapper.query(map);
	}
	
	public int queryAll()
	{
		int count=tSysUserTaskMapper.queryAll().size();
		return count;
	}

}