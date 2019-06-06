package com.cmdrawin.pdm.dashboard.serviceImpl;

import java.util.List;
import java.util.Map;
import com.cmdrawin.pdm.dashboard.mapper.TPdmNoticeMapper;
import com.cmdrawin.pdm.dashboard.service.IPdmNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdmNoticeService implements IPdmNoticeService {

	@Autowired
	private TPdmNoticeMapper tPdmNoticeMapper;

	public String add(Map map) {
		String id = java.util.UUID.randomUUID().toString();
		map.put("id",id);
		tPdmNoticeMapper.insert(map);
		return id;
	}

	public Integer delete(Map map) {
		return tPdmNoticeMapper.delete(map);
	}

	public Integer update(Map map) {
		return tPdmNoticeMapper.update(map);
	}
	
	public Map get(Map map) {
		return tPdmNoticeMapper.get(map);
	}

	public List<Map> query(Map map) {
		return tPdmNoticeMapper.query(map);
	}

}