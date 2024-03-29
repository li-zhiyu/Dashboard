package com.cmdrawin.pdm.dashboard.service;

import java.util.List;
import java.util.Map;

public interface IPdmNoticeService {

	public String add(Map map);
	public Integer delete(Map map);
	public Integer update(Map map);
	public Map get(Map map);
	public List<Map> query(Map map);
	public Integer updateNoticeReader(Map map);
	public List<Map> queryReaderByUserNm(Map map);
}
