package com.service.impl;

import com.dao.ResgisterDao;
import com.dao.impl.ResgisterDaoImpl;
import com.service.RegisterSerive;

public class RegisterSeriveImpl implements RegisterSerive {

	@Override
	public Boolean register(String userName, String passWord) {
		ResgisterDao register = new ResgisterDaoImpl();
		Boolean flag = register.registerUser(userName,passWord);
		return flag;
	}

}
