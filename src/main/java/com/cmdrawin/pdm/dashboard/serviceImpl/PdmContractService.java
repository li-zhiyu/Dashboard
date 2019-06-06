package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TPdmContractMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdmContractService implements IPdmContractService {

	@Autowired
	private TPdmContractMapper tPdmContractMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tPdmContractMapper.insert(map);
		return id;
	}


	public List<Map> query(Map map) {
		return tPdmContractMapper.query(map);
	}

	public List<Map> queryExpectedCost(Map map) {
		return tPdmContractMapper.queryExpectedCost(map);
	}
}