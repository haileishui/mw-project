package com.lmw.service;

import java.util.List;

import com.lmw.domain.TExaminingReport;
import com.lmw.util.PagedResult;


/**
 * 
 * <p> Description: 用户管理service </p>
 * @Author LiuMingWei
 * @Date [2018年1月17日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2018年1月17日   新建文件.
 * 
 * </pre>
 */
public interface ExaminingReportService {

	PagedResult<TExaminingReport> getExaminingReportList(TExaminingReport tExaminingReport);

	TExaminingReport getExaminingReportById(TExaminingReport examiningReport);

	void insertExaminingReport(TExaminingReport examiningReport);

	void updateExaminingReport(TExaminingReport examiningReport);
	
	void deleteExaminingReport(TExaminingReport examiningReport);

	TExaminingReport getExaminingReportDetail(TExaminingReport examiningReport);

	List<TExaminingReport> getExaminingReportPrintList(TExaminingReport tExaminingReport);

}
