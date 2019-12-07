package com.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.impl.GuestAction;
import com.action.impl.LoginAction;
import com.action.impl.LogoutAction;
import com.action.impl.RegisterAction;

@WebServlet({"/Login","/Logout","/Register","/guestBook"})
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求名
		String actionName = getActionName(request.getRequestURI());
		//获得分发器
		Action action = null;
		//分发操作
		if(actionName.equals("Login")) {
			action = new LoginAction();
		}else if(actionName.equals("Logout")){
			action = new LogoutAction();
		}else if(actionName.equals("Register")){
			action = new RegisterAction();
		}else if(actionName.equals("guestBook")){
			action = new GuestAction();
		}else {
			throw new IllegalArgumentException("不存在的动作");
		}
		
		//分发视图
		String url = action.execute(request, response);
		String url1=url.split(":")[0];
		String user =url.substring(url.indexOf(":")+1);
		if(url1.equals("JSONObject")) {
			send(response,user);
		}else if(url1.equals("Result")) {
			send(response,user);
		}
	}
	//分割请求名
		private String getActionName(String uri) {
			return uri.substring(uri.lastIndexOf("/")+1);
		}
		//反应消息发送给前端
		private void send(HttpServletResponse response,String user) {
			response.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/plain");
			Writer write;
			try {
				write = response.getWriter();
				write.write(user);
				write.close();
			} catch (IOException e) {
				System.out.println("UserControllerServlet出错");
				e.printStackTrace();
			}
		}

}
