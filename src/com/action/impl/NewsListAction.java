package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.NewsService;
import com.service.impl.NewsServiceImpl;

public class NewsListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NewsService newsService = new NewsServiceImpl();
		JSONArray newslist = new JSONArray(newsService.newsList());
		return "JSONArray:" + newslist.toString(2);
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
}
