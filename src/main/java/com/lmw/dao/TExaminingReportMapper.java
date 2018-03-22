package com.lmw.dao;

import java.util.List;

import com.lmw.domain.TExaminingReport;

public interface TExaminingReportMapper {
    int deleteByPrimaryKey(TExaminingReport examiningReport);

    int insert(TExaminingReport record);

    int insertSelective(TExaminingReport record);

    TExaminingReport selectByPrimaryKey(TExaminingReport examiningReport);

    int updateByPrimaryKeySelective(TExaminingReport record);

    int updateByPrimaryKey(TExaminingReport record);
    
    List<TExaminingReport> selectExaminingReportList(TExaminingReport tExaminingReport);
}