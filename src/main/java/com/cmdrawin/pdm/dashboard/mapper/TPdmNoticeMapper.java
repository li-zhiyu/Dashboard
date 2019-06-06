package com.cmdrawin.pdm.dashboard.mapper;

import java.util.List;
import java.util.Map;

public interface TPdmNoticeMapper {
    int delete(Map map);

    int insert(Map map);

    Map get(Map map);

    List<Map> query(Map map);

    int update(Map map);
}