package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.entity.Notice;
import com.service.ViewService;
import com.service.impl.ViewServiceImpl;

public class NoticeViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id")); //id为新闻主键ID
		ViewService noticeView = new ViewServiceImpl();
		Notice notice = noticeView.noticeView(id);
		request.setAttribute("notice", notice);
		return "forward:notice-view.jsp"; //转发
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
