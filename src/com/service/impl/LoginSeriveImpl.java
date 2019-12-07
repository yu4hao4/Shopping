package com.service.impl;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.entity.User;
import com.service.LoginSerive;

public class LoginSeriveImpl implements LoginSerive {

	@Override
	public User userlogin(String userName, String passWord) {
		LoginDao loginDao = new LoginDaoImpl();
		User user = loginDao.login(userName,passWord);
		return user;
	}

}
