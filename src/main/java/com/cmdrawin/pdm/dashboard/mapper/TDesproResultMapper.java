package com.cmdrawin.pdm.dashboard.mapper;

import java.util.List;
import java.util.Map;

public interface TDesproResultMapper {
    int delete(Map map);

    int insert(Map map);

    Map get(Map map);

    List<Map> query(Map map);

    int update(Map map);
    
    List<Map> querySumByMonth(Map map);
}