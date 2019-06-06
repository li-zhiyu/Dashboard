package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;

import com.cmdrawin.pdm.dashboard.mapper.TPdmProjectInfoMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmProjectInfoService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class PdmProjectInfoService implements IPdmProjectInfoService {

	@Autowired
	private TPdmProjectInfoMapper tPdmProjectInfoMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tPdmProjectInfoMapper.insert(map);
		return id;
	}

	public Integer delete(Map map) {
		return tPdmProjectInfoMapper.delete(map);
	}

	public Integer update(Map map) {
		return tPdmProjectInfoMapper.update(map);
	}
	
	public Map get(Map map) {
		return tPdmProjectInfoMapper.get(map);
	}

	public List<Map> query(Map map) {
		return tPdmProjectInfoMapper.query(map);
	}

	public List<Map> queryProjectStatus(Map map) {
		return tPdmProjectInfoMapper.queryProjectStatus(map);
	}
}