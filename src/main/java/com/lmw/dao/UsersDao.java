package com.lmw.dao;

import java.util.List;

import com.lmw.domain.Users;

public interface UsersDao {

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
	List<Users> getUsersList(Users users);
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
	Users getUsersInfoByUserNamePassword(Users users);
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
	Integer getUsersListCount(Users users);
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
	void insertUserInfo(Users users);
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
	
	void updateUsersInfo(Users users);
	/**
	 * 
	 * deleteUsersInfoById
	 * @方法描述: 删除用户
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月18日] 
	 * @Version V1.0 
	 * @param users
	 * @since Ver 1.00
	 */
	void deleteUsersInfoById(Users users);
	/**
	 * 
	 * getUsersInfoById
	 * @方法描述: 通过ID查询用户信息
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2018年1月18日] 
	 * @Version V1.0 
	 * @param users
	 * @since Ver 1.00
	 */
	Users getUsersInfoById(Users users);

}
