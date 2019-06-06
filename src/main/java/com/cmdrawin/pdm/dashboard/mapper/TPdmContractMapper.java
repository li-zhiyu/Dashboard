package com.cmdrawin.pdm.dashboard.mapper;

import java.util.List;
import java.util.Map;

public interface TPdmContractMapper {
    int insert(Map map);

    List<Map> query(Map map);
    
    List<Map> queryExpectedCost(Map map);
}