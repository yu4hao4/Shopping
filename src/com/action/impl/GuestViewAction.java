package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.entity.Guest;
import com.service.GuestService;
import com.service.impl.GuestServiceImpl;

public class GuestViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		GuestService navService = new GuestServiceImpl();
		Guest guest = navService.getGuestView(id);
		request.setAttribute("guestView", guest);
		return "forward:guestbook-modify.jsp"; //转发
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
