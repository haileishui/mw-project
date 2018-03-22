package com.lmw.service;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lmw.baseTest.SpringTestCase;

/**
 * 
 * <p> Description: UserService单元测试 </p>
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
public class CuxolpLuSalesrepV1ServiceTest extends SpringTestCase {


	Logger logger = Logger.getLogger(CuxolpLuSalesrepV1ServiceTest.class);

	@Test
	public void selectUserByIdTest() {
		String userName = "YIANGLI";
		Integer pageNo = 1;
		Integer pageSize = 10;
//		UserAndCustomerInfo cuxolpLuSalesrepV1 = cuxolpLuSalesrepV1Service.getErpUserByUserName(userName);
//		logger.debug("查找结果" + cuxolpLuSalesrepV1);
//		PagedResult<UserAndCustomerInfo> pagedResult = cuxolpLuSalesrepV1Service.selectErpUserInfoByUserNameByPage(userName, pageNo, pageSize);
//		logger.debug("pagedResult=>" + pagedResult);
	}

}
