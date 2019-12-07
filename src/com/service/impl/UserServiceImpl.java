package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> getUserList() {
		UserDao userDao =new UserDaoImpl();
		return userDao.getUserList();
	}

	//获得用户详细
	@Override
	public User getUserView(String userName) {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUserView(userName);
	}

	//修改用户
	@Override
	public Boolean modifyUser(String userName, String personName, String passWord, String sex, String date,
			String telphone, String location) {
		String u = getUserView(userName).getUserName();
		UserDao userDao = new UserDaoImpl();
		boolean flag = false;
		if(u==null) {//表示用户不存在,修改失败
			return flag;
		}else {//表示用户存在，进行修改用户
			flag = userDao.modifyUser(userName,personName,passWord,sex,date,telphone,location);
		}
		return flag;
	}

	//添加用户
	@Override
	public Boolean addUser(String userName, String personName, String passWord, String sex, String date,
			String telphone, String location) {
		String u = getUserView(userName).getUserName();
		UserDao userDao = new UserDaoImpl();
		boolean flag = false;
		if(u==null) {//表示用户不存在,进行添加
			flag = userDao.AddUser(userName,personName,passWord,sex,date,telphone,location);
		}else {//表示用户存在，添加失败
			return flag;
		}
		return flag;
	}

	//删除用户
	@Override
	public Boolean deleteUser(String userName) {
		String u = getUserView(userName).getUserName();
		UserDao userDao = new UserDaoImpl();
		boolean flag = false;
		if(u==null) {//表示用户不存在,删除错误
			return flag;
		}else {//表示用户存在，进行删除
			flag = userDao.DeleteUser(userName);
		}
		return flag;
	}

}
