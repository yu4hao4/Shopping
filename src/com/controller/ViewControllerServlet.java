package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.impl.GoodsViewAction;
import com.action.impl.NewsViewAction;
import com.action.impl.NoticeViewAction;

@WebServlet({"/goodsView","/news-view","/notice-view"})
public class ViewControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewControllerServlet() {
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
		if(actionName.equals("goodsView")) {
			action = new GoodsViewAction();
		}else if(actionName.equals("news-view")){
			action = new NewsViewAction();
		}else if(actionName.equals("notice-view")){
			action = new NoticeViewAction();
		}else {
			throw new IllegalArgumentException("不存在的动作");
		}
		
		//分发视图
		String url = action.execute(request, response);
		String url1=url.split(":")[0];
		String url2 =url.substring(url.indexOf(":")+1);
		if(url1.equals("forward")) {
			request.getRequestDispatcher(url2).forward(request, response);
		}
	}
	//分割请求名
		private String getActionName(String uri) {
			return uri.substring(uri.lastIndexOf("/")+1);
		}

}
