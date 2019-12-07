package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	List<User> getUserList();

	User getUserView(String userName);
	
	Boolean modifyUser(String userName, String personName, String passWord, String sex, String date, String telphone, String location);

	Boolean addUser(String userName, String personName, String passWord, String sex, String date, String telphone,
			String location);

	Boolean deleteUser(String userName);

}
