package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("name");
		UserService userService = new UserServiceImpl();
		User user = userService.getUserView(userName);
		request.setAttribute("userView", user);
		return "forward:user-modify.jsp"; //转发
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
