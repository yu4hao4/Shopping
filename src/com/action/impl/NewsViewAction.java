package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.entity.News;
import com.service.ViewService;
import com.service.impl.ViewServiceImpl;

public class NewsViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id")); //id为新闻主键ID
		ViewService newsView = new ViewServiceImpl();
		News news = newsView.newsView(id);
		request.setAttribute("news", news);
		return "forward:news-view.jsp"; //转发
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
