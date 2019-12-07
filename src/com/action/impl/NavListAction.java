package com.action.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.NavService;
import com.service.impl.NavServiceImpl;

public class NavListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String sid = request.getParameter("id");
		NavService navService = new NavServiceImpl();
		if(sid==null || sid=="") { //如果ID为空说明是第一次遍历
			JSONArray navlist = new JSONArray(navService.navList());
			return "JSONArray:" + navlist.toString(2);
		}else {
			int id = Integer.parseInt(sid);
			JSONArray navlist = new JSONArray(navService.navFind(id));
			return "JSONArray:" + navlist.toString(2);
		}
		
		
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
