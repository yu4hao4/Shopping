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
import com.action.impl.GuestAction;
import com.action.impl.IndexAction;
import com.action.impl.NavListAction;
import com.action.impl.NewsListAction;
import com.action.impl.NoticeListAction;

@WebServlet({ "/newsList", "/navList", "/noticeList", "/goodsList" ,"/guestList","/guestIndex"})
public class ListControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//获取请求名
		String actionName = getActionName(request.getRequestURI());
		//获得分发器
		Action action = null;
		//分发操作
		if(actionName.equals("navList")) {
			action = new NavListAction();
		}else if(actionName.equals("newsList")){
			action = new NewsListAction();
		}else if(actionName.equals("noticeList")){
			action = new NoticeListAction();
		}else if(actionName.equals("goodsList")){
			action = new GoodsListAction();
		}else if(actionName.equals("guestList")){
			action = new GuestAction();
		}else if(actionName.equals("guestIndex")){
			action = new IndexAction();
		}else {
			throw new IllegalArgumentException("不存在的动作");
		}
		
		//分发视图
		String url =action.execute(request, response);
		String url1=url.split(":")[0];
		String goods =url.substring(url.indexOf(":")+1);
		if(url1.equals("JSONArray")) {
			send(response,goods);
		}else if(url1.equals("JSONObject")) {
			send(response,goods);
		}else if(url1.equals("Result")) {
			send(response,goods);
		}
	}

	//分割请求名
	private String getActionName(String uri) {
		return uri.substring(uri.lastIndexOf("/")+1);
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
