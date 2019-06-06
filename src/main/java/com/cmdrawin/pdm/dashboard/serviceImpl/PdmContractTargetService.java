package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TPdmContractTargetMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmContractTargetService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class PdmContractTargetService implements IPdmContractTargetService {

	@Autowired
	private TPdmContractTargetMapper tPdmContractTargetMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tPdmContractTargetMapper.insert(map);
		return id;
	}

	public Integer delete(Map map) {
		return tPdmContractTargetMapper.delete(map);
	}

	public Integer update(Map map) {
		return tPdmContractTargetMapper.update(map);
	}
	
	public Map get(Map map) {
		return tPdmContractTargetMapper.get(map);
	}

	public List<Map> query(Map map) {
		return tPdmContractTargetMapper.query(map);
	}

}