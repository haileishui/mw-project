package com.lmw.dao;

import java.util.List;

import com.lmw.domain.TPowerSupply;

public interface TPowerSupplyMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByPid(Integer pid);
    
    int insert(TPowerSupply record);

    int insertSelective(TPowerSupply record);

    TPowerSupply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPowerSupply record);

    int updateByPrimaryKey(TPowerSupply record);

	List<TPowerSupply> selectPowerSupplyPointByPid(Integer pid);
}