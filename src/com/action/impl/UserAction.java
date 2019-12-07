package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserServiceImpl();
		JSONArray userList = new JSONArray(userService.getUserList());
		return "JSONArray:" + userList.toString(2);
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
