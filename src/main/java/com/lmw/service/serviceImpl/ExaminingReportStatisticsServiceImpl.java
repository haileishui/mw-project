package com.lmw.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmw.dao.TExaminingReportStatisticsMapper;
import com.lmw.service.ExaminingReportStatisticsService;

/**
 * 
 * <p> Description: 检测报告实现类 </p>
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
@Service
public class ExaminingReportStatisticsServiceImpl implements ExaminingReportStatisticsService {
	//	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	TExaminingReportStatisticsMapper tExaminingReportStatisticsMapper;



}
