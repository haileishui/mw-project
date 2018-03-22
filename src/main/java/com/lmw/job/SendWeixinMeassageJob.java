package com.lmw.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendWeixinMeassageJob {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/*****
	 * 格式: [秒] [分] [小时] [日] [月] [周] [年]
	    0 0 12 * * ?           每天12点触发
	    0 15 10 ? * *          每天10点15分触发
	    0 15 10 * * ?          每天10点15分触发 
	    0 15 10 * * ? *        每天10点15分触发 
	    0 15 10 * * ? 2005     2005年每天10点15分触发
	    0 * 14 * * ?           每天下午的 2点到2点59分每分触发
	    0 0/5 14 * * ?         每天下午的 2点到2点59分(整点开始，每隔5分触发) 
	    0 0/5 14,18 * * ?        每天下午的 18点到18点59分(整点开始，每隔5分触发)
	    
	    0 0-5 14 * * ?            每天下午的 2点到2点05分每分触发
	    0 10,44 14 ? 3 WED        3月分每周三下午的 2点10分和2点44分触发
	    0 15 10 ? * MON-FRI       从周一到周五每天上午的10点15分触发
	    0 15 10 15 * ?            每月15号上午10点15分触发
	    0 15 10 L * ?             每月最后一天的10点15分触发
	    0 15 10 ? * 6L            每月最后一周的星期五的10点15分触发
	    0 15 10 ? * 6L 2002-2005  从2002年到2005年每月最后一周的星期五的10点15分触发
	    
	    0 15 10 ? * 6#3           每月的第三周的星期五开始触发
	    0 0 12 1/5 * ?            每月的第一个中午开始每隔5天触发一次
	    0 11 11 11 11 ?           每年的11月11号 11点11分触发(光棍节)
	 * @throws WeixinException 
	 */
	/**
	 * 
	 * getExtendedinfoListJob
	 * @方法描述:恶性超期客户对应销售员获取，定时任务 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年11月8日] 
	 * @Version V1.0 
	 * @throws WeixinException
	 * @since Ver 1.00
	 */

	//	@Scheduled(cron = "0 0 6 * * ? ")//每天6点触发
	public void getExtendedinfoListJob() {
		logger.info("=================== getExtendedinfoListJob 恶性超期客户对应销售员获取 start =====================");
		//		malignantOvertimeService.getExtendedinfoList();
		logger.info("=================== getExtendedinfoListJob 恶性超期客户对应销售员获取 end =====================");
	}

	/**
	 * 
	 * getOverdueReceivablesJob
	 * @方法描述:超期应收回款7日提醒销售员 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年11月8日] 
	 * @Version V1.0 
	 * @throws WeixinException
	 * @since Ver 1.00
	 */
	//	@Scheduled(cron = "0 0 5 * * ? ") //每天5点触发
	public void getOverdueReceivablesJob() {
		logger.info("=================== getOverdueReceivablesList 超期应收回款7日提醒销售员  start  =====================");
		//		malignantOvertimeService.getOverdueReceivablesList();
		logger.info("=================== getOverdueReceivablesList 超期应收回款7日提醒销售员  end =====================");
	}

	/**
	 * 
	 * sendWeinXinMeassageJob
	 * @方法描述:推送微信消息定时任务 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年11月8日] 
	 * @Version V1.0 
	 * @throws WeixinException
	 * @since Ver 1.00
	 */
	//	@Scheduled(cron = "0 0 10 * * ? ") //每天10点触发
	//		@Scheduled(cron = "0/50 * *  * * ? ")
	public void sendWeinXinMeassageJob() {
		logger.info("=================== sendWeinXinMeassageJob start =================== ");
		//		malignantOvertimeService.sendWeinXinMeassage();
		logger.info("=================== sendWeinXinMeassageJob end =================== ");
	}
}