package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TPdmContractPaymentListMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmContractPaymentListService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class PdmContractPaymentListService implements IPdmContractPaymentListService {

	@Autowired
	private TPdmContractPaymentListMapper tPdmContractPaymentListMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tPdmContractPaymentListMapper.insert(map);
		return id;
	}

	public List<Map> query(Map map) {
		return tPdmContractPaymentListMapper.query(map);
	}
	
	public List<Map> queryAmount(Map map) {
		return tPdmContractPaymentListMapper.queryAmount(map);
	}
	
	public List<Map> queryDetail(Map map) {
		return tPdmContractPaymentListMapper.queryDetail(map);
	}

}