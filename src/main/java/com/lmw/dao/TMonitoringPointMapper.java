package com.lmw.dao;

import java.util.List;

import com.lmw.domain.TMonitoringPoint;

public interface TMonitoringPointMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByPid(Integer pid);

    int insert(TMonitoringPoint record);

    int insertSelective(TMonitoringPoint record);

    TMonitoringPoint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMonitoringPoint record);

    int updateByPrimaryKey(TMonitoringPoint record);

    List<TMonitoringPoint> selectMonitoringPointByPid(Integer pid);
}