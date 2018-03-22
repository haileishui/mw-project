package com.lmw.dao;

import java.util.List;

import com.lmw.domain.TAntiThunder;

public interface TAntiThunderMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByPid(Integer pid);
    
    int insert(TAntiThunder record);

    int insertSelective(TAntiThunder record);

    TAntiThunder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TAntiThunder record);

    int updateByPrimaryKey(TAntiThunder record);

    List<TAntiThunder> selectAntiThunderByPid(Integer pid);
}