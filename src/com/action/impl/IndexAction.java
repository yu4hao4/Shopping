package com.action.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.action.Action;
import com.entity.Yeshu;
import com.service.GuestService;
import com.service.impl.GuestServiceImpl;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		GuestService guestService = new GuestServiceImpl();
		int index = guestService.getIndex();
		int yeshu = (int) Math.ceil(index/3.0); //向上取整 一页最多展示3条留言
		Yeshu r = new Yeshu(yeshu);
		JSONObject jdata =new JSONObject(r);  //存放结果
		return"Result:"+jdata.toString();
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
