package com.action.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.action.Action;
import com.entity.Result;
import com.entity.User;
import com.service.GuestService;
import com.service.impl.GuestServiceImpl;
import com.util.UtilByLiuQing;

public class GuestAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		GuestService guestService = new GuestServiceImpl();
		String syeshu = request.getParameter("yeshu");
		if(syeshu==null || syeshu=="") { //客户进行留言
			String guestTitle = request.getParameter("guestTitle");
			String guestContent = request.getParameter("guestContent");
			
			JSONObject jdata =null;  //存放结果
			
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("User");
			if(u==null) {
				Result r = new Result(false);
				jdata =new JSONObject(r);
				return"Result:"+jdata.toString();
			}
			String userName = u.getUserName();
			
			String timeCreated = new UtilByLiuQing().TimeNow();
			
			
			boolean flag = guestService.addBook(guestTitle, guestContent,userName,timeCreated);
			if(flag==true){
				Result r = new Result(true);
				jdata =new JSONObject(r);
			}else{
				Result r = new Result(false);
				jdata =new JSONObject(r);
			}
			return "Result:"+jdata.toString();
		}else
		{ //获得客户的留言
			int yeshu = Integer.parseInt(syeshu); //获取当前页数
			JSONArray goodslist = new JSONArray(guestService.guestList(yeshu));
			return "JSONArray:" + goodslist.toString(2);
		}
		
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
