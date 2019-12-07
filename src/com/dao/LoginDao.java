package com.dao;

import com.entity.User;

public interface LoginDao {
	User login(String userName, String passWord);
}
