package com.lmw.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmw.dao.UsersDao;
import com.lmw.domain.Users;
import com.lmw.service.LoginService;

/**
 * 
 * <p> Description: 登陆实现类 </p>
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
@Service
public class LoginServiceImpl implements LoginService {
//	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UsersDao usersDao;

	@Override
	public Users getUsersInfoByUserNamePassword(Users users) throws Exception {
		return usersDao.getUsersInfoByUserNamePassword(users);
	}

}
