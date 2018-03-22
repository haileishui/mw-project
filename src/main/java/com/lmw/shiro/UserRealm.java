package com.lmw.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lmw.domain.Users;
import com.lmw.service.LoginService;
import com.lmw.util.MD5;

public class UserRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginService loginService;

	/**
	 * 用户授权认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info("======用户授权认证======");
		/*这里应该根据userName使用role和permission 的serive层来做判断，并将对应 的权限加进来，下面简化了这一步*/
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		roleNames.add("admin");//添加角色。对应到index.jsp  
		roleNames.add("lmw");
		permissions.add("user_list.html");//添加权限,对应到index.jsp  
		permissions.add("addUsersInfo.json");
		permissions.add("updateUsersInfo.json");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		//      simpleAuthorizationInfo.setRoles(null);
		return info;
	}

	/**
	 * 用户登陆认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		logger.info("======用户登陆认证======");
		String userName = authenticationToken.getPrincipal().toString();
		String password = new String((char[]) authenticationToken.getCredentials());
		if (null == userName || null == password) {
			throw new UnknownAccountException("账号或密码不能为空");
		}
		Users users = new Users();
		users.setUserName(userName);
		users.setPassword(MD5.encryptPassword(password));
		Users result = null;
		try {
			result = loginService.getUsersInfoByUserNamePassword(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 账号不存在
		if (null == result) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		// 账号锁定
		if (!"0".equals(result.getStatus())) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		this.setSession("currentUser", result);
		logger.info("Users={}", new Object[] { result });
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(result, password, getName());
		return info;
	}

	/** 
	* 将一些数据放到ShiroSession中,以便于其它地方使用 
	* @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
	*/
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	/** 
	* 清除所有用户授权信息缓存. 
	*/
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/** 
	 * 清除所有用户授权信息缓存. 
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
