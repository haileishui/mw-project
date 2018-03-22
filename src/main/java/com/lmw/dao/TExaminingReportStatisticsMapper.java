package com.lmw.dao;

import com.lmw.domain.TExaminingReportStatistics;

public interface TExaminingReportStatisticsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TExaminingReportStatistics record);

    int insertSelective(TExaminingReportStatistics record);

    TExaminingReportStatistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TExaminingReportStatistics record);

    int updateByPrimaryKey(TExaminingReportStatistics record);
}