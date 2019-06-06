package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TDesproResultMapper;
import com.cmdrawin.pdm.dashboard.service.IDesproResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesproResultService implements IDesproResultService {

	@Autowired
	private TDesproResultMapper tDesproResultMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("ID",id);
		tDesproResultMapper.insert(map);
		return id;
	}

	public Integer delete(Map map) {
		return tDesproResultMapper.delete(map);
	}

	public Integer update(Map map) {
		return tDesproResultMapper.update(map);
	}
	
	public Map get(Map map) {
		return tDesproResultMapper.get(map);
	}

	public List<Map> query(Map map) {
		return tDesproResultMapper.query(map);
	}
	
	public List<Map> querySumByMonth(Map map) {
		return tDesproResultMapper.querySumByMonth(map);
	}

}