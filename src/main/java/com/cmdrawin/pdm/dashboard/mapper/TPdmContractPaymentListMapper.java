package com.cmdrawin.pdm.dashboard.mapper;

import java.util.List;
import java.util.Map;

public interface TPdmContractPaymentListMapper {
    int insert(Map map);

    List<Map> query(Map map);
    
    List<Map> queryAmount(Map map);
    
    List<Map> queryDetail(Map map);
}