package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.action.Action;
import com.entity.Result;
import com.entity.User;
import com.service.LoginSerive;
import com.service.impl.LoginSeriveImpl;


public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		LoginSerive login = new LoginSeriveImpl();
		User user = login.userlogin(userName, passWord);
		
		JSONObject jdata =null;
		if(user==null) {
			Result r = new Result(false);
			jdata =new JSONObject(r);
			return "Result:"+jdata.toString();
		}else {
			//存入session
			HttpSession session = request.getSession();
			session.setAttribute("User", user);
			
			//发送的JSON对象
			jdata =new JSONObject(user);
			jdata.remove("passWord");
			return "JSONObject:"+jdata.toString();			
		}
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
