package com.cmdrawin.pdm.dashboard.mapper;

import java.util.List;
import java.util.Map;

public interface TPdmContractProductiveMapper {
    int insert(Map map);

    List<Map> query(Map map);
    
    List<Map> queryAmount(Map map);
    
    List<Map> queryInvoicevalue(Map map);
    
    List<Map> queryAmountDetail(Map map);
    
    List<Map> queryInvoicevalueDetail(Map map);
    
}