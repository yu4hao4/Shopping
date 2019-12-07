package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.entity.Nav;
import com.service.NavService;
import com.service.impl.NavServiceImpl;

public class NavViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		NavService navService = new NavServiceImpl();
		Nav nav = navService.getNavView(id);
		request.setAttribute("navView", nav);
		return "forward:nav-modify.jsp"; //转发
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
