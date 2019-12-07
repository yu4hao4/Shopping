package com.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.impl.GoodsListAction;
import com.action.impl.NavListAction;

@WebServlet({"/navFind","/goods-list"})
public class SkillControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SkillControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求名
		String actionName = getActionName(request.getRequestURI());
		// 获得分发器
		Action action = null;
		// 分发操作
		if (actionName.equals("navFind")) {
			action = new NavListAction();
		}else if(actionName.equals("goods-list")){
			action =new GoodsListAction();
		}else {
			throw new IllegalArgumentException("不存在的动作");
		}

		// 分发视图
		String url = action.execute(request, response);
		String url1 = url.split(":")[0];
		String url2 = url.substring(url.indexOf(":") + 1);
		if(url1.equals("JSONArray")) {
			send(response,url2);
		}else if(url1.equals("forward")) {
			request.getRequestDispatcher(url2).forward(request, response);
		}
	}

	// 分割请求名
	private String getActionName(String uri) {
		return uri.substring(uri.lastIndexOf("/") + 1);
	}
	
	//反应消息发送给前端
	private void send(HttpServletResponse response,String goods) {
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/plain");
		Writer write;
		try {
			write = response.getWriter();
			write.write(goods);
			write.close();
		} catch (IOException e) {
			System.out.println("ConControllerServlet出错");
			e.printStackTrace();
		}
	}

}
