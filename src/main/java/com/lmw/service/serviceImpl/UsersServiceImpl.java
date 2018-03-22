package com.lmw.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmw.dao.UsersDao;
import com.lmw.domain.Users;
import com.lmw.service.UsersService;
import com.lmw.util.BeanUtil;
import com.lmw.util.MD5;
import com.lmw.util.PageUtil;
import com.lmw.util.PagedResult;

/**
 * 
 * <p> Description: 用户管理实现类 </p>
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
public class UsersServiceImpl implements UsersService {
	//	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UsersDao usersDao;

	@Override
	public PagedResult<Users> getUsersList(Users users) {
		PageUtil.startPage(users); //分页，实体对象必须继承basebean才会有pageNumber, pageSize参数
		return BeanUtil.toPagedResult(usersDao.getUsersList(users));
	}

	@Override
	public Integer getUsersListCount(Users users) throws Exception {
		return usersDao.getUsersListCount(users);
	}

	@Override
	public String insertUserInfo(Users users) throws Exception {
		Integer result = usersDao.getUsersListCount(users);
		if (result > 0) {
			return "用户名已存在！";
		}
		users.setPassword(MD5.encryptPassword(users.getPassword()));
		usersDao.insertUserInfo(users);
		return "新增用户成功！";
	}

	@Override
	public void updateUsersInfo(Users users) throws Exception {
		users.setPassword(MD5.encryptPassword(users.getPassword()));
		usersDao.updateUsersInfo(users);
	}

	@Override
	public void deleteUserInfo(Users users) throws Exception {
		usersDao.deleteUsersInfoById(users);
	}

	@Override
	public Users getUsersInfoById(Users users) throws Exception {
		return usersDao.getUsersInfoById(users);
	}

}
