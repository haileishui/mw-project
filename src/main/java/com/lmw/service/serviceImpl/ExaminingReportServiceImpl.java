package com.lmw.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.lmw.dao.TAntiThunderMapper;
import com.lmw.dao.TExaminingReportMapper;
import com.lmw.dao.TMonitoringPointMapper;
import com.lmw.dao.TPowerSupplyMapper;
import com.lmw.domain.TAntiThunder;
import com.lmw.domain.TExaminingReport;
import com.lmw.domain.TMonitoringPoint;
import com.lmw.domain.TPowerSupply;
import com.lmw.service.ExaminingReportService;
import com.lmw.util.BeanUtil;
import com.lmw.util.PageUtil;
import com.lmw.util.PagedResult;

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
public class ExaminingReportServiceImpl implements ExaminingReportService {
	//	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TExaminingReportMapper tExaminingReportMapper;
	@Autowired
	TAntiThunderMapper tAntiThunderMapper;
	@Autowired
	TMonitoringPointMapper tMonitoringPointMapper;
	@Autowired
	TPowerSupplyMapper tPowerSupplyMapper;

	@Override
	public PagedResult<TExaminingReport> getExaminingReportList(TExaminingReport tExaminingReport) {
		PageUtil.startPage(tExaminingReport); //分页，实体对象必须继承basebean才会有pageNumber, pageSize参数
		List<TExaminingReport> result = tExaminingReportMapper.selectExaminingReportList(tExaminingReport);
		return BeanUtil.toPagedResult(result);
	}

	@Override
	public TExaminingReport getExaminingReportById(TExaminingReport examiningReport) {
		return tExaminingReportMapper.selectByPrimaryKey(examiningReport);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertExaminingReport(TExaminingReport examiningReport) {
		tExaminingReportMapper.insertSelective(examiningReport);
		if (null != examiningReport) {
			String monitoringPointJson = examiningReport.getMonitoringPointJson();
			if (null != monitoringPointJson) {
				List<TMonitoringPoint> monitoringPointList = JSONArray.parseArray(monitoringPointJson, TMonitoringPoint.class);
				for (TMonitoringPoint tMonitoringPoint : monitoringPointList) {
					tMonitoringPoint.setPid(examiningReport.getId());
					tMonitoringPointMapper.insertSelective(tMonitoringPoint);
				}
			}
			String antiThunderJson = examiningReport.getAntiThunderJson();
			if (null != antiThunderJson) {
				List<TAntiThunder> antiThunderList = JSONArray.parseArray(antiThunderJson, TAntiThunder.class);
				for (TAntiThunder tAntiThunder : antiThunderList) {
					tAntiThunder.setPid(examiningReport.getId());
					tAntiThunderMapper.insertSelective(tAntiThunder);
				}
			}
			String powerSupplyJson = examiningReport.getPowerSupplyJson();
			if (null != powerSupplyJson) {
				List<TPowerSupply> powerSupplyList = JSONArray.parseArray(powerSupplyJson, TPowerSupply.class);
				for (TPowerSupply tPowerSupply : powerSupplyList) {
					tPowerSupply.setPid(examiningReport.getId());
					tPowerSupplyMapper.insertSelective(tPowerSupply);
				}
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateExaminingReport(TExaminingReport examiningReport) {
		//主表信息直接更新
		tExaminingReportMapper.updateByPrimaryKeySelective(examiningReport);
		//删除原有字表数据
		tMonitoringPointMapper.deleteByPid(examiningReport.getId());
		tAntiThunderMapper.deleteByPid(examiningReport.getId());
		tPowerSupplyMapper.deleteByPid(examiningReport.getId());
		//重新插入修改后的list
		if (null != examiningReport) {
			String monitoringPointJson = examiningReport.getMonitoringPointJson();
			if (null != monitoringPointJson) {
				List<TMonitoringPoint> monitoringPointList = JSONArray.parseArray(monitoringPointJson, TMonitoringPoint.class);
				for (TMonitoringPoint tMonitoringPoint : monitoringPointList) {
					tMonitoringPoint.setPid(examiningReport.getId());
					tMonitoringPointMapper.insertSelective(tMonitoringPoint);
				}
			}
			String antiThunderJson = examiningReport.getAntiThunderJson();
			if (null != antiThunderJson) {
				List<TAntiThunder> antiThunderList = JSONArray.parseArray(antiThunderJson, TAntiThunder.class);
				for (TAntiThunder tAntiThunder : antiThunderList) {
					tAntiThunder.setPid(examiningReport.getId());
					tAntiThunderMapper.insertSelective(tAntiThunder);
				}
			}
			String powerSupplyJson = examiningReport.getPowerSupplyJson();
			if (null != powerSupplyJson) {
				List<TPowerSupply> powerSupplyList = JSONArray.parseArray(powerSupplyJson, TPowerSupply.class);
				for (TPowerSupply tPowerSupply : powerSupplyList) {
					tPowerSupply.setPid(examiningReport.getId());
					tPowerSupplyMapper.insertSelective(tPowerSupply);
				}
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteExaminingReport(TExaminingReport examiningReport) {
		if(null != examiningReport){
			tMonitoringPointMapper.deleteByPid(examiningReport.getId());
			tAntiThunderMapper.deleteByPid(examiningReport.getId());
			tPowerSupplyMapper.deleteByPid(examiningReport.getId());
			tExaminingReportMapper.deleteByPrimaryKey(examiningReport);
		}
	}

	@Override
	public TExaminingReport getExaminingReportDetail(TExaminingReport examiningReport) {
		TExaminingReport result = tExaminingReportMapper.selectByPrimaryKey(examiningReport);
		if (null != result) {
			//防直击雷
			List<TMonitoringPoint> monitoringPoint = tMonitoringPointMapper.selectMonitoringPointByPid(result.getId());
			result.setMonitoringPointList(monitoringPoint);
			//防雷电感应
			List<TAntiThunder> tAntiThunder = tAntiThunderMapper.selectAntiThunderByPid(result.getId());
			result.setAntiThunderList(tAntiThunder);
			//电源PSD检测
			List<TPowerSupply> tPowerSupply = tPowerSupplyMapper.selectPowerSupplyPointByPid(result.getId());
			result.setPowerSupplyList(tPowerSupply);
		}
		return result;
	}

	@Override
	public List<TExaminingReport> getExaminingReportPrintList(TExaminingReport tExaminingReport) {
		return tExaminingReportMapper.selectExaminingReportList(tExaminingReport);
	}

}
