package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TPdmContractProductiveMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmContractProductiveService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class PdmContractProductiveService implements IPdmContractProductiveService {

	@Autowired
	private TPdmContractProductiveMapper tPdmContractProductiveMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tPdmContractProductiveMapper.insert(map);
		return id;
	}

	public List<Map> query(Map map) {
		return tPdmContractProductiveMapper.query(map);
	}
	
	public List<Map> queryAmount(Map map) {
		return tPdmContractProductiveMapper.queryAmount(map);
	}
	
	public List<Map> queryInvoicevalue(Map map) {
		return tPdmContractProductiveMapper.queryInvoicevalue(map);
	}
	
	public List<Map> queryAmountDetail(Map map) {
		return tPdmContractProductiveMapper.queryAmountDetail(map);
	}
	
	public List<Map> queryInvoicevalueDetail(Map map) {
		return tPdmContractProductiveMapper.queryInvoicevalueDetail(map);
	}

}