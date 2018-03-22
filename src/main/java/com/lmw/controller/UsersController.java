package com.lmw.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmw.common.HttpConstants;
import com.lmw.domain.Users;
import com.lmw.service.UsersService;
import com.lmw.util.PagedResult;

/**
 * 
 * <p> Description:用户管理Controller </p>
 * @Author LiuMingWei
 * @Date [2018年01月17日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   [2018年01月17日]   新建文件.
 * 
 * </pre> 
 */
@Controller
public class UsersController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/getUsersInfo")
	@ResponseBody
	public String getUsersInfo(Users users) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!"admin".equals(sessionUsers.getUserName())){
				return responseSuccess("非超级管理员禁止操作");
			}
			PagedResult<Users> pageResult = usersService.getUsersList(users);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/getUsersInfoById")
	@ResponseBody
	public String getUsersInfoById(Users users) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!"admin".equals(sessionUsers.getUserName())){
				return responseSuccess("非超级管理员禁止操作");
			}
			Users resultUsers = usersService.getUsersInfoById(users);
			return responseSuccess(resultUsers, "获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/addUsersInfo")
	@ResponseBody
	public String addUsersInfo(Users users) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!"admin".equals(sessionUsers.getUserName())){
				return responseSuccess("非超级管理员禁止操作");
			}
			users.setCreator(sessionUsers.getUserName());
			usersService.insertUserInfo(users);
			return responseSuccess("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/deleteUsersInfo")
	@ResponseBody
	public String deleteUsersInfo(Users users) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!"admin".equals(sessionUsers.getUserName())){
				return responseSuccess("非超级管理员禁止操作");
			}
			usersService.deleteUserInfo(users);
			return responseSuccess("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}

	@RequestMapping(value = "/updateUsersInfo")
	@ResponseBody
	public String updateUsersInfo(Users users) {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			if(!"admin".equals(sessionUsers.getUserName())){
				return responseSuccess("非超级管理员禁止操作");
			}
			usersService.updateUsersInfo(users);
			return responseSuccess("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}
	@RequestMapping(value = "/getLoginUserInfo")
	@ResponseBody
	public String getLoginUserInfo() {
		try {
			Users sessionUsers = (Users) SecurityUtils.getSubject().getPrincipal();
			if(null == sessionUsers ){
				return responseSuccess("未登录");
			}
			Users users = new Users();
			users.setName(sessionUsers.getName());
			users.setUserName(sessionUsers.getUserName());
			return responseSuccess(users);
		} catch (Exception e) {
			e.printStackTrace();
			return responseFail(HttpConstants.SYSTEM_ERROR_MSG);
		}
	}
}