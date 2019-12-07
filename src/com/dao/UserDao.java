package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	List<User> getUserList();

	User getUserView(String userName);

	boolean modifyUser(String userName, String personName, String passWord, String sex, String date, String telphone,
			String location);

	boolean AddUser(String userName, String personName, String passWord, String sex, String date, String telphone,
			String location);

	boolean DeleteUser(String userName);
}
