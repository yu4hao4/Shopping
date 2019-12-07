package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.NavService;
import com.service.impl.NavServiceImpl;

public class NavAllListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NavService navService = new NavServiceImpl();
		JSONArray navlist = new JSONArray(navService.navAllList());
		return "JSONArray:" + navlist.toString(2);
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
