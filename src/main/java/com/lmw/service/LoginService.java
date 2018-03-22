package com.lmw.service;

import java.util.List;

import com.lmw.domain.Users;

/**
 * 
 * <p> Description:登陆接口类 </p>
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
public interface LoginService {

	/**
	 * 
	 * getUsersInfoByUserNamePassword
	 * @方法描述:登陆验证用户名密码是否正确 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月9日] 
	 * @Version V1.0 
	 * @param Users
	 * @return
	 * @since Ver 1.00
	 */
	public Users getUsersInfoByUserNamePassword(Users users) throws Exception;

}
