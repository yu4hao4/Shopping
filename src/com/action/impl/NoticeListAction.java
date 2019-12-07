package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.NoticeService;
import com.service.impl.NoticeServiceImpl;

public class NoticeListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeService = new NoticeServiceImpl();
		JSONArray noticelist = new JSONArray(noticeService.noticeList());
		return "JSONArray:" + noticelist.toString(2);
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
