package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.GuestService;
import com.service.impl.GuestServiceImpl;

public class GuestListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		GuestService guestService = new GuestServiceImpl();
		JSONArray goodslist = new JSONArray(guestService.guestAllList());
		return "JSONArray:" + goodslist.toString(2);
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
