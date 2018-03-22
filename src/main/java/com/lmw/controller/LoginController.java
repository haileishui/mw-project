package com.lmw.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmw.domain.Users;

/**
 * 
 * <p> Description: 系统登陆Controller </p>
 * @Author LiuMingWei
 * @Date [2017年9月26日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年9月26日   新建文件.
 * 
 * </pre> 
 */
@Controller
public class LoginController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/** 
	 * 
	 * login
	 * @方法描述:登陆操作，验证用户名密码是否正确 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年9月26日] 
	 * @Version V1.0 
	 * @param request
	 * @return
	 * @since Ver 1.00
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public String doLogin(HttpServletRequest request) {
		//		String result = "login";
		String userName = request.getParameter("username");
		//取得 密码，并用MD5加密  
		String passWord = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
		Subject currentUser = SecurityUtils.getSubject();
		try {
			Users user = (Users) request.getSession().getAttribute("currentUser");
			boolean flag = currentUser.isAuthenticated();
			if (flag && user != null) {
				Users users = new Users();
				users.setName(user.getName());
				users.setUserName(user.getUserName());
				return responseSuccess(users, "认证成功！");
			}
			//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
			//每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
			//所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
			logger.info("对用户[" + userName + "]进行登录验证..验证开始");
			token.setRememberMe(true);
			currentUser.login(token);//验证角色和权限  
			if (currentUser.isAuthenticated()) {//使用shiro来验证  
				Users sessionUser = (Users) SecurityUtils.getSubject().getPrincipal();
				Users users = new Users();
				users.setName(sessionUser.getName());
				users.setUserName(sessionUser.getUserName());
				return responseSuccess(users, "认证成功！");
			} else {
				token.clear();
			}
			logger.info("对用户[" + userName + "]进行登录验证..验证通过");
		} catch (UnknownAccountException uae) {
			logger.info("对用户[" + userName + "]进行登录验证..验证未通过," + uae.getMessage());
			return responseFail(uae.getMessage());
		} catch (IncorrectCredentialsException ice) {
			logger.info("对用户[" + userName + "]进行登录验证..验证未通过," + ice.getMessage());
			return responseFail(ice.getMessage());
		} catch (LockedAccountException lae) {
			logger.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
			return responseFail("账户已锁定！");
		} catch (ExcessiveAttemptsException eae) {
			logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
			return responseFail("用户名或密码错误次数过多！");
		} catch (AuthenticationException ae) {
			logger.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			return responseFail("登陆失败，请联系管理员！");
		}
		return responseFail("登陆失败！");
	}

	/** 
	 * 
	 * logout
	 * @方法描述:用户退出 
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年9月26日] 
	 * @Version V1.0 
	 * @return
	 * @since Ver 1.00
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.removeAttribute("currentUser");
				session.removeAttribute("userAndCustomerInfo");
				session.removeAttribute("salesErpId");
			}
		}
		currentUser.logout();
		return responseSuccess("退出成功！");
	}

}