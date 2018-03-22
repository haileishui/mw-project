package com.lmw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmw.common.HttpConstants;
import com.lmw.domain.TExaminingReport;
import com.lmw.service.ExaminingReportService;
import com.lmw.util.PagedResult;

/**
 * 
 * <p> Description: 现金池 </p>
 * @Author LiuMingWei
 * @Date [2017年9月21日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年9月21日   新建文件.
 * 
 * </pre>
 */
@Controller
public class ExaminingReportStatisticsController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	@Autowired
//	private ExaminingReportService examiningReportService;
//
//	@RequestMapping(value = "/getExaminingReportList")
//	@ResponseBody
//	public String getExaminingReportList(TExaminingReport tExaminingReport) {
//		try {
//			PagedResult<TExaminingReport> pageResult = examiningReportService.getExaminingReportList(tExaminingReport);
//			return responseSuccess(pageResult);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
//		}
//	}

}
