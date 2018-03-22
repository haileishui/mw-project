package com.lmw.service;

import com.lmw.domain.Users;
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
public interface UsersService {

	/**
	 * 
	 * getUsersList
	 * @方法描述:获取用户列表 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月9日] 
	 * @Version V1.0 
	 * @param Users
	 * @return
	 * @since Ver 1.00
	 */
	public PagedResult<Users> getUsersList(Users users) throws Exception;

	/**
	 * 
	 * getUsersListCount
	 * @方法描述: 通过用户密码查询用户是否存在
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月9日] 
	 * @Version V1.0 
	 * @param Users
	 * @return
	 * @since Ver 1.00
	 */
	public Integer getUsersListCount(Users users) throws Exception;

	/**
	 * 
	 * inserUserInfo
	 * @方法描述: 新增用户
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月9日] 
	 * @Version V1.0 
	 * @param Users
	 * @since Ver 1.00
	 */
	public String insertUserInfo(Users users) throws Exception;

	/**
	 * 
	 * updateUsersInfo
	 * @方法描述: 修改用户信息 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月9日] 
	 * @Version V1.0 
	 * @param Users
	 * @since Ver 1.00
	 */

	public void updateUsersInfo(Users users) throws Exception;

	/**
	 * 
	 * deleteUserInfo
	 * @方法描述: 删除用户
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月17日] 
	 * @Version V1.0 
	 * @param users
	 * @since Ver 1.00
	 */
	public void deleteUserInfo(Users users) throws Exception;

	/**
	 * 
	 * getUsersInfoById
	 * @方法描述: 通过ID查询用户
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月18日] 
	 * @Version V1.0 
	 * @param users
	 * @return
	 * @since Ver 1.00
	 */
	public Users getUsersInfoById(Users users) throws Exception;

}
