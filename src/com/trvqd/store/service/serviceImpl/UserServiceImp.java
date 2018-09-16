package com.trvqd.store.service.serviceImpl;

import java.sql.SQLException;

import com.trvqd.store.dao.UserDao;
import com.trvqd.store.dao.daoImp.UserDaoImp;
import com.trvqd.store.domain.User;
import com.trvqd.store.service.UserService;
import com.trvqd.store.utils.MailUtils;

public class UserServiceImp implements UserService {

	@Override
	public void userRegister(User user) throws SQLException {
		//实现注册功能
		UserDao userDao = new UserDaoImp();
		userDao.userRegist(user);

	}
}
