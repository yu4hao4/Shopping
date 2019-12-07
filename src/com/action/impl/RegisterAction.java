package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.action.Action;
import com.entity.Result;
import com.service.RegisterSerive;
import com.service.impl.RegisterSeriveImpl;


public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		RegisterSerive login = new RegisterSeriveImpl();
		boolean flag = login.register(userName, passWord); //成功为true 失败为false
		JSONObject jdata =null;  //存放结果
		if(flag==true){
			Result r = new Result(true);
			jdata =new JSONObject(r);
		}else{
			Result r = new Result(false);
			jdata =new JSONObject(r);
		}
		return "Result:"+jdata.toString();
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
