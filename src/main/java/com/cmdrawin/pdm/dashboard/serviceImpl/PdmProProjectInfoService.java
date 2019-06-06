package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TPdmProProjectInfoMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmProProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdmProProjectInfoService implements IPdmProProjectInfoService {

	@Autowired
	private TPdmProProjectInfoMapper tPdmProProjectInfoMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tPdmProProjectInfoMapper.insert(map);
		return id;
	}

	public Integer delete(Map map) {
		return tPdmProProjectInfoMapper.delete(map);
	}

	public Integer update(Map map) {
		return tPdmProProjectInfoMapper.update(map);
	}
	
	public Map get(Map map) {
		return tPdmProProjectInfoMapper.get(map);
	}

	public List<Map> query(Map map) {
		return tPdmProProjectInfoMapper.query(map);
	}
	
	public List<Map> querySumByDegree(Map map) {
		return tPdmProProjectInfoMapper.querySumByDegree(map);
	}

}