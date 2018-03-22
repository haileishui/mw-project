package com.lmw.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmw.common.HttpConstants;
import com.lmw.domain.TExaminingReport;
import com.lmw.domain.Users;
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
public class ExaminingReportController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final String ADMIN = "admin";
	@Autowired
	private ExaminingReportService examiningReportService;

	@RequestMapping(value = "/getExaminingReportList")
	@ResponseBody
	public String getExaminingReportList(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!ADMIN.equals(sessionUsers.getUserName())){
				examiningReport.setTitle(sessionUsers.getCompany());
			}
			PagedResult<TExaminingReport> pageResult = examiningReportService.getExaminingReportList(examiningReport);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/getExaminingReportDetail")
	@ResponseBody
	public String getExaminingReportDetail(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!ADMIN.equals(sessionUsers.getUserName())){
				examiningReport.setTitle(sessionUsers.getCompany());
			}
			TExaminingReport result = examiningReportService.getExaminingReportDetail(examiningReport);
			return responseSuccess(result);
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/getExaminingReportById")
	@ResponseBody
	public String getExaminingReportById(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!ADMIN.equals(sessionUsers.getUserName())){
				examiningReport.setTitle(sessionUsers.getCompany());
			}
			TExaminingReport result = examiningReportService.getExaminingReportById(examiningReport);
			return responseSuccess(result, "获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/insertExaminingReport")
	@ResponseBody
	public String insertExaminingReport(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
//			String title = getTitle(sessionUsers.getCompany());
			examiningReport.setTitle(sessionUsers.getCompany());
			examiningReportService.insertExaminingReport(examiningReport);
			return responseSuccess("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/deleteExaminingReport")
	@ResponseBody
	public String deleteExaminingReport(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!ADMIN.equals(sessionUsers.getUserName())){
				examiningReport.setTitle(sessionUsers.getCompany());
			}
			examiningReportService.deleteExaminingReport(examiningReport);
			return responseSuccess("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/updateExaminingReport")
	@ResponseBody
	public String updateExaminingReport(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!ADMIN.equals(sessionUsers.getUserName())){
				examiningReport.setTitle(sessionUsers.getCompany());
			}
			examiningReportService.updateExaminingReport(examiningReport);
			return responseSuccess("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}
	@RequestMapping(value = "/getExaminingReportPrintList")
	@ResponseBody
	public String getExaminingReportPrintList(TExaminingReport examiningReport) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!ADMIN.equals(sessionUsers.getUserName())){
				examiningReport.setTitle(sessionUsers.getCompany());
			}
			List<TExaminingReport> list = examiningReportService.getExaminingReportPrintList(examiningReport);
			return responseArraySuccess(list);
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}
	private String getTitle(String company) {
		String result = "枣";
		if ("市中区".equals(company)) {
			result = "枣";
		} else if ("薛城区".equals(company)) {
			result = "薛";
		} else if ("山亭区".equals(company)) {
			result = "山";
		} else if ("峄城区".equals(company)) {
			result = "峄";
		} else if ("台儿庄区".equals(company)) {
			result = "台";
		} else if ("滕州市".equals(company)) {
			result = "滕";
		}
		return result;
	}
}
